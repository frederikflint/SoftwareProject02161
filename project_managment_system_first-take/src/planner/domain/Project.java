package planner.domain;

import planner.app.OperationNotAllowedException;
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
    public void addDeveloper(Developer developer, Developer activeDeveloper) throws OperationNotAllowedException {
        if (projectManager.equals(activeDeveloper)) {
            projectDevelopers.add(developer);
        } else {
            throw new OperationNotAllowedException("You need to have project manager rights to edit this project");
        }
    }

    /**
     *
     * @param activty
     * @throws OperationNotAllowedException If you do not have manager rights throw error
     */
    public void addActivity(Activity activty, Developer activeDeveloper) throws OperationNotAllowedException {

        if (projectDevelopers.contains(activeDeveloper)) {
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

    public void setProjectManager(Developer projectManager ) {
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

    public Calendar getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public void setEstimatedEndTime(Calendar estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }

}
