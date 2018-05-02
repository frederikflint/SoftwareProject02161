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

    private List<Activity> Activities;
    private List<Project> Projects;
    private List<WorkHours> workHours;


    public User (String credentials, String password) {
        setCredentials(credentials);
        setPassword(password);
    }

    public void addActivity(){
    }

    public void registerTime(Activity activity, Calendar startTime, Calendar endTime) {
        System.out.println(activity.getID());
        System.out.println(startTime.get(Calendar.HOUR_OF_DAY));
        System.out.println(endTime.get(Calendar.HOUR_OF_DAY));
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
        return Activities;
    }

    public List<Project> getProjects() {
        return Projects;
    }

    public List<WorkHours> getWorkHours() {
        return workHours;
    }
}
