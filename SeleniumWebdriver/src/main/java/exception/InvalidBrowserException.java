package exception;

public class InvalidBrowserException extends Exception {

    public InvalidBrowserException() {
    }

    public InvalidBrowserException(String message) {
        super(message);
    }

    public InvalidBrowserException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBrowserException(Throwable cause) {
        super(cause);
    }

    public InvalidBrowserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
