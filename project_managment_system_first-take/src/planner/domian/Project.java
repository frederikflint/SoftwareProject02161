package planner.domian;

import planner.app.OperationNotAllowedException;
import planner.app.Planner;

import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class Project {

    List<Activity> activities;
    List<Developer> projectDevelopers;
    Developer projectManager;
    private String title;
    private Calendar estimatedStartTime;
    private Calendar estimatedEndTime;
    int estimatedHours;

    public Project(String title, Calendar estimatedStartTime, Calendar estimatedEndTime) {
        setTitle(title);
        setEstimatedStartTime(estimatedStartTime);
        setEstimatedEndTime(estimatedEndTime);
    }

    /**
     *
     * @param developer
     * @throws OperationNotAllowedException If you do not have manager rights throw error
     */
    public void addDeveloper(Developer developer, Planner planner) throws OperationNotAllowedException {

        if (projectManager.equals(planner.activeUser)) {
            throw new OperationNotAllowedException("You need to have project manager rights to edit this project");
        } else {
            projectDevelopers.add(developer);
        }
    }

    /**
     *
     * @param activty
     * @throws OperationNotAllowedException If you do not have manager rights throw error
     */
    public void addActivity(Activity activty, Planner planner) throws OperationNotAllowedException {

        if (projectManager.equals(planner.activeUser)) {
            throw new OperationNotAllowedException("You need to have project manager rights to edit this project");
        } else {
            activities.add(activty);
        }
    }

    /**************************
     *  Setters and getters   *
     **************************/

    public void setProjectManager(Developer projectManager) {
        this.projectManager = projectManager;
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

    public void setEstimatedStartTime(Calendar estimatedStartTime) {
        this.estimatedStartTime = estimatedStartTime;
    }

    public Calendar getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public void setEstimatedEndTime(Calendar estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }

}
