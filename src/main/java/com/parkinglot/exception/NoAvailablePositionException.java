package com.parkinglot.exception;

public class NoAvailablePositionException extends RuntimeException {
    @Override
    public String getMessage() {
        return "No available position";
    }
}
