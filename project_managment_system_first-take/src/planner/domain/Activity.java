package planner.domain;

import java.util.Calendar;
import java.util.List;

public class Activity {

    // List of users that are associated with this activity
    private List<User> users;

    // If there is a project associated with this activity
    private Project project = null;

    // Time estimation for the activity
    private int estimatedTimeSpent;
    private int currentTimeSpent = 0;

    // Start and end time for activity
    private Calendar startTime;
    private Calendar endTime;

    // Generated ID to identify this activity
    private String ID;

    public Activity(Calendar startTime, Calendar endTime, String ID) {
        this.ID = ID;
        setStartTime(startTime);
        setEndTime(endTime);
    }

    public void registerActivityTime(int additionalTime) {
        currentTimeSpent = currentTimeSpent + additionalTime;
    }

    /**************************
     *  Setters and getters   *
     **************************/

    public Project getProject() {
        return project;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public int getEstimatedTimeSpent() {
        return estimatedTimeSpent;
    }

    public int getCurrentTimeSpent() {
        return currentTimeSpent;
    }

    public void setEstimatedTimeSpent(int estimatedTimeSpent) {
        this.estimatedTimeSpent = estimatedTimeSpent;
    }

    public void setCurrentTimeSpent(int currentTimeSpent) {
        this.currentTimeSpent = currentTimeSpent;
    }

    public String getID() {
        return ID;
    }

    public List<User> getDevelopers() {
        return users;
    }

    public String getTitle() {
        return ID;
    }


}
