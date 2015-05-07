package net.evdokimov.eshopSpring.repository.exceptions;


public class NotSuchElementException extends DbException {

    public NotSuchElementException(String message) {
        super(message);
    }

    public NotSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }
}
