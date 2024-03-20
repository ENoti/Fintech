package ru.mts.exception;

public class NotEnoughSizeException extends IllegalArgumentException {
    public NotEnoughSizeException() {
    }

    public NotEnoughSizeException(String message) {
        super(message);
    }

    public NotEnoughSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughSizeException(Throwable cause) {
        super(cause);
    }
}
