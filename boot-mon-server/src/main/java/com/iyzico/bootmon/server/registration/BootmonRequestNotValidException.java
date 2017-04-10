package com.iyzico.bootmon.server.registration;

public class BootmonRequestNotValidException extends RuntimeException {

    public BootmonRequestNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public BootmonRequestNotValidException(String message) {
        super(message);
    }
}