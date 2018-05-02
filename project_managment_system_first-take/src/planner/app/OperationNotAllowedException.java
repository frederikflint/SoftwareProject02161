package planner.app;

public class OperationNotAllowedException extends Exception {

    /**
     * If the operation is not allowed throw this error.
     * @param errorMsg the error message
     */
    public OperationNotAllowedException(String errorMsg) {
        super(errorMsg);
    }
}
