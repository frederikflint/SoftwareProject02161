package planner.domain;

import planner.app.OperationNotAllowedException;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class Project {

    private List<Activity> activities;
    private List<User> users;
    private User manager;
    private String title;
    private Calendar estimatedStartTime;
    private Calendar estimatedEndTime;
    private int estimatedHours;

    public Project(String title, Calendar estimatedStartTime, Calendar estimatedEndTime) {
        setTitle(title);
        setEstimatedStartTime(estimatedStartTime);
        setEstimatedEndTime(estimatedEndTime);
    }

    /**
     *
     * @param user
     * @throws OperationNotAllowedException If you do not have manager rights throw error
     */
    public void addDeveloper(User user, User activeUser) throws OperationNotAllowedException {
        if (manager.equals(activeUser)) {
            users.add(user);
        } else {
            throw new OperationNotAllowedException("You need to have project manager rights to edit this project");
        }
    }

    /**
     *
     * @param activty
     * @throws OperationNotAllowedException If you do not have manager rights throw error
     */
    public void addActivity(Activity activty, User activeUser) throws OperationNotAllowedException {

        if (users.contains(activeUser)) {
            activities.add(activty);
        } else {
            throw new OperationNotAllowedException("You are not a part of this project");
        }
    }


    /**************************
     *  Setters and getters   *
     **************************/

    public void setEstimatedStartTime(Calendar estimatedStartTime) {
        this.estimatedStartTime = estimatedStartTime;
    }

    public void setProjectManager(User projectManager ) {
        this.manager = projectManager;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getEstimatedStartTime() {
        return estimatedStartTime;
    }

    public Calendar getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public void setEstimatedEndTime(Calendar estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }

}
