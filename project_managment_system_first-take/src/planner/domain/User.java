package planner.domain;

import java.util.Calendar;
import java.util.List;

/**
 * The super class Uses
 * This super class acts
 */
public class User {

    private String credentials;
    private String password;

    List<Activity> Activities;
    List<Project> Projects;
    List<WorkHours> workHours;


    public User (String credentials, String password) {
        setCredentials(credentials);
        setPassword(password);
    }

    public void addActivity(){
    }

    public void registerTime(Activity activity, Calendar startTime, Calendar endTime) {
        this.workHours.add(new WorkHours(activity, startTime, endTime));
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
