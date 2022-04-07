package by.company.phonebook.exception;

public class StopApplicationException extends Exception {

    public StopApplicationException() {
    }

    public StopApplicationException(String message) {
        super(message);
    }

    public StopApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public StopApplicationException(Throwable cause) {
        super(cause);
    }
}
