package planner.domian;


/**
 * The super class Uses
 */
public class User {

    private String credentials;
    private String password;

    public User (String credentials, String password) {
        setCredentials(credentials);
        setPassword(password);
    }

    /**************************
     *  Setters and getters   *
     **************************/

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
