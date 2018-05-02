package planner.app;


public class AuthenticationException extends Exception {

    /**
     *
     * @param errorMsg the error message
     */
    public AuthenticationException(String errorMsg) {
        super(errorMsg);
    }
}