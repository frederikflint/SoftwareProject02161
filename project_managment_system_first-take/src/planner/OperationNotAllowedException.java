package planner;

public class OperationNotAllowedException extends Exception {

    /**
     *
     * @param errorMsg the error message
     */
    public OperationNotAllowedException(String errorMsg) {
        super(errorMsg);
    }
}
