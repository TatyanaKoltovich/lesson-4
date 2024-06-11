package MakeMoneyTransferApp.exception;

public class ProcessingExceptions extends Exception{
    public ProcessingExceptions() {
    }

    public ProcessingExceptions(String message) {
        super(message);
    }

    public ProcessingExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessingExceptions(Throwable cause) {
        super(cause);
    }
}
