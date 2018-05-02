package planner.app;

public class AuthenticationException extends Exception {

    /**
     * If the user is not authenticated throw AuthenticationException.
     * @param errorMsg the error message
     */
    public AuthenticationException(String errorMsg) {
        super(errorMsg);
    }
}