package com.cristiano.picpayChallenge.implementation.Services;

import com.cristiano.picpayChallenge.domain.entities.Transaction;
import com.cristiano.picpayChallenge.domain.entities.User;
import com.cristiano.picpayChallenge.domain.entities.UserType;
import com.cristiano.picpayChallenge.domain.exceptions.InsufficientBalanceException;
import com.cristiano.picpayChallenge.domain.exceptions.MerchantTransactionException;
import com.cristiano.picpayChallenge.domain.exceptions.TransactionRefusedException;
import com.cristiano.picpayChallenge.domain.services.TransactionService;
import com.cristiano.picpayChallenge.domain.services.UserService;
import com.cristiano.picpayChallenge.domain.services.dtos.CreateTransactionDto;
import com.cristiano.picpayChallenge.implementation.Services.protocols.AuthorizeTransaction;
import com.cristiano.picpayChallenge.implementation.Services.protocols.NotificationSender;
import com.cristiano.picpayChallenge.infrastructure.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private UserService userService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AuthorizeTransaction authorizeTransaction;
    @Autowired
    private NotificationSender notificationSender;


    @Override
    public void validateTransaction(User sender, BigDecimal value) {
        if(sender.getUserType().equals(UserType.MERCHANT)) {
            throw new MerchantTransactionException();
        }

        if(sender.getBalance().compareTo(value) < 0) {
            throw new InsufficientBalanceException();
        }


    }

    @Override
    public void createTransaction(CreateTransactionDto createTransactionDto) {
        User sender = this.userService.findUserById(createTransactionDto.senderId());
        User receiver = this.userService.findUserById(createTransactionDto.receiverId());

        this.validateTransaction(sender, createTransactionDto.value());

        if(!this.authorizeTransaction.isAuthorized(sender, createTransactionDto.value(), receiver)) {
            throw new TransactionRefusedException();
        }

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(createTransactionDto.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimeStamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(createTransactionDto.value()));
        receiver.setBalance(receiver.getBalance().add(createTransactionDto.value()));

        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);
        this.transactionRepository.save(newTransaction);

        this.sendNotificationTransaction(receiver, sender, createTransactionDto.value());
    }

    public void sendNotificationTransaction(User receiver,User sender , BigDecimal value) {
        String messageReceiver = String.format(
                "Olá, você acaba de receber uma transferência no valor de %.2f do usuário: %s.",
                value, sender.getFullName()
        );
        notificationSender.send(receiver, messageReceiver);

        String messageSender = String.format(
                "Olá, você acaba de realizar uma transferência no valor de %.2f para usuário: %s.",
                value, receiver.getFullName()
        );
        notificationSender.send(sender, messageSender);
    }
}
