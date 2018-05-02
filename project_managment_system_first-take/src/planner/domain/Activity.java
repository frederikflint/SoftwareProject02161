package planner.domain;

import java.util.List;

public class Activity {

    // List of users that are associated with this activity
    private List<User> users;

    // If there is a project associated with this activity
    private Project project;

    // Time estimation for the activity
    private int estimatedTimeSpent;
    private int currentTimeSpent = 0;
    //TODO: Skal vi tilføje start og slut tid for en aktivitet, så vi kan se om "users" kan tage den?

    // Generated ID to identify this activity
    private String ID;

    public Activity(Project project, String ID) {
        //TODO: Er det altid et project der "associated" med?
        this.project = project;
        this.ID = ID;
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

    public int getEstimatedTimeSpent() {
        return estimatedTimeSpent;
    }

    public int getCurrentTimeSpent() {
        return currentTimeSpent;
    }

    public String getID() {
        return ID;
    }

    public List<User> getDevelopers() {
        return users;
    }

}
