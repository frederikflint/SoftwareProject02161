package planner.domain;

import java.util.List;

public class Activity {

    private List<User> users;
    private Project project;
    private int estimatedTimeSpent;
    private int currentTimeSpent = 0;
    String ID;

    public Activity(Project project, String ID) {
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
