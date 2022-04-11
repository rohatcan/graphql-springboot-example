package com.rohat.productertask.exception;

public class TeamLimitExceededException extends RuntimeException{
    public TeamLimitExceededException(String message) {
        super(message);
    }
}
