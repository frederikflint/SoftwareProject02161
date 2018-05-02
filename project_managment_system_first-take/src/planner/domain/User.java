package planner.domain;

import cucumber.api.java.en_old.Ac;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The super class Uses
 * This super class acts
 */
public class User {

    private String credentials;
    private String password;
    private Boolean isAdmin = false;

    private List<Activity> activities = new ArrayList<Activity>();
    private List<Project> projects = new ArrayList<Project>();
    private List<WorkHours> workHours = new ArrayList<WorkHours>();


    public User (String credentials, String password) {
        setCredentials(credentials);
        setPassword(password);
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public void registerTime(Activity activity, Calendar startTime, Calendar endTime) {
        WorkHours workHour = new WorkHours(activity, startTime, endTime);
        workHours.add(workHour);
        activity.registerActivityTime(workHour.getWorkTimeInMinutes());
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

    public List<Activity> getActivities() {
        return activities;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<WorkHours> getWorkHours() {
        return workHours;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }
}
