package planner.domain;

/**
 * The super class Uses
 * This super class acts
 */
public class User {

    private String credentials;
    private String password;

    public User (String credentials, String password) {
        setCredentials(credentials);
        setPassword(password);
    }

    /**
     *  Is the user a admin
     * @return
     */
    public boolean isAdmin(){
        return false;
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
