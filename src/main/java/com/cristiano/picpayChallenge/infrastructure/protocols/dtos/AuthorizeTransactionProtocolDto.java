package com.cristiano.picpayChallenge.infrastructure.protocols.dtos;

public class AuthorizeTransactionProtocolDto {
    public String status;

    public Data data;

    public static class Data {
        public Boolean authorization;
    }
}
