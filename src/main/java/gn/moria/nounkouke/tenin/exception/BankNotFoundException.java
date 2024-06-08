package gn.moria.nounkouke.tenin.exception;

public class BankNotFoundException extends RuntimeException{
    public BankNotFoundException(String message) {
        super(message);
    }

    public BankNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankNotFoundException(Throwable cause) {
        super(cause);
    }
}
