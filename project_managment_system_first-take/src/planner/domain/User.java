package planner.domain;

import cucumber.api.java.en_old.Ac;
import planner.app.OperationNotAllowedException;

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

    /**
     * Add activity to users personal activities.
     * @param activity
     */
    public void addActivity(Activity activity) throws OperationNotAllowedException {
        if(activities.contains(activity)){
            throw new OperationNotAllowedException("This activity is already add to your account");
        } else {
            activities.add(activity);
        }
    }

    /**
     * Remove a given activity from the user
     * @param activity
     */
    public void removeActivity(Activity activity) throws OperationNotAllowedException{
        if(!(activities.contains(activity))){
            throw new OperationNotAllowedException("This activity is not in your personal activities");
        } else {
            activities.remove(activity);
        }
    }

    /**
     *
     * @param activity
     * @param startTime
     * @param endTime
     */
    public void registerTime(Activity activity, Calendar startTime, Calendar endTime) {
        WorkHours workHour = new WorkHours(activity, startTime, endTime);
        workHours.add(workHour);
        activity.registerActivityTime(workHour.getWorkTimeInMinutes());
    }

    /**
     *
     * @param timeRegistration
     * @throws OperationNotAllowedException
     */
    public void removeRegistedTime(WorkHours timeRegistration) throws OperationNotAllowedException {
        if(!(workHours.contains(timeRegistration))){
            throw new OperationNotAllowedException("The time registration is not in your personal register");
        } else {
            activities.remove(timeRegistration);
        }
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
