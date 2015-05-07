package net.evdokimov.eshopSpring.repository.exceptions;


public class LoginExistException extends DbException {

    public LoginExistException(String message) {
        super(message);
    }

    public LoginExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
