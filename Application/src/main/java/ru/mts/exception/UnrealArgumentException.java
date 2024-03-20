package ru.mts.exception;

public class UnrealArgumentException extends Exception {

    public UnrealArgumentException() {
    }

    public UnrealArgumentException(String message) {
        super(message);
    }

    public UnrealArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnrealArgumentException(Throwable cause) {
        super(cause);
    }
}