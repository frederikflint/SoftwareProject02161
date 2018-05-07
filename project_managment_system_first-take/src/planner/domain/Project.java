package planner.domain;

import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import java.util.UUID;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * A project of the planner
 */
public class Project {

    // List of project activities
    public List<Activity> activities = new ArrayList<>();

    // List of project users
    private List<User> users = new ArrayList<>();

    // Project manager
    private User manager;

    // Project title
    // and unique identifier
    private String title;

    // Estimated project time
    private Calendar estimatedStartTime;
    private Calendar estimatedEndTime;
    private int estimatedHours;

    public Project(String title, Calendar estimatedStartTime, Calendar estimatedEndTime) {
        setTitle(title);
        setEstimatedStartTime(estimatedStartTime);
        setEstimatedEndTime(estimatedEndTime);
    }

    /**
     * Add a given user to the project
     * @param user
     * @throws OperationNotAllowedException If you do not have manager rights throw error.
     *                                      The user is a part of the project.
     */
    public void addUser(User user) throws OperationNotAllowedException {

        // Add the user to the project
        if (users.contains(user)){
            throw new OperationNotAllowedException("This user is already a part of the project");
        } else {
            users.add(user);
        }

    }

    /**
     * Remove a given user from the project.
     * @param user
     * @throws OperationNotAllowedException If you do not have manager rights throw error.
     *                                      The user is not a part of the project.
     */
    public void removeUser(User user) throws OperationNotAllowedException {
        if (!(users.contains(user))){
            throw new OperationNotAllowedException("The given user is not a part og this project");
        } else {
            users.remove(user);
        }
    }

    /**
     * Add an activity to the project.
     * @param activty
     * @param activeUser The active user session
     * @throws OperationNotAllowedException The active user is not a part og the project.
     *                                      The activity is already a part og the project.
     */
    public void addActivity(Activity activty, User activeUser) throws OperationNotAllowedException, AuthenticationException {

        if(!activeUser.equals(getManager())){
            throw new AuthenticationException("You need to have project manager rights to edit this project");
        }

        if (!(users.contains(activeUser))) {
            throw new OperationNotAllowedException("You are not a part of this project");
        } else if (activities.contains(activty)) {
            throw new OperationNotAllowedException("The activity is already a part of the project");
        } else {
            activities.add(activty);
        }
    }

    public List<Activity> getActivities(){
        return activities;
    }

    public Activity getActivity(String title){
        // Set the initial currentProject as null.
        Activity currentActivity = null;

        for (Activity activity : activities) {

            // Does the search params match.
            if (Objects.equals(activity.getTitle(), title)){
                currentActivity =  activity;
            }
        }
        return currentActivity;
    }


    /**
     * Remove a given activity form the project
     * @param activty
     * @param activeUser The active user session.
     * @throws OperationNotAllowedException If you do not have manager rights throw error.
     *                                      You can't remove an activity that is not a part of the project.
     */
    public void removeActivity(Activity activty, User activeUser) throws OperationNotAllowedException, AuthenticationException{

        if(!activeUser.equals(getManager())){
            throw new AuthenticationException("You need to have project manager rights to edit this project");
        }

        if (!(users.contains(activeUser))) {
            throw new OperationNotAllowedException("You are not a part of this project");
        } else if(!(activities.contains(activty))){
            throw new OperationNotAllowedException("The activity you are trying to remove is not in this project");
        } else {
            activities.remove(activty);
        }
    }

    /**
     * Add a given activity to a user from the project.
     * @param activity
     * @param activeUser
     * @param user
     * @throws OperationNotAllowedException If you do not have manager rights throw error.
     *                                      The user has to be a part of the project to add activity.
     *                                      The activity has to be a part of the project to add it.
     */
    public void addActivityToProjectUser(Activity activity, User activeUser, User user) throws OperationNotAllowedException, AuthenticationException {

        if(!activeUser.equals(getManager())){
            throw new AuthenticationException("You need to have project manager rights to edit this project");
        }

        if(!(manager.equals(activeUser))){
            throw new OperationNotAllowedException("You need to have project manager rights to edit this project");
        } else if (!(users.contains(user))) {
            throw new OperationNotAllowedException("The user is not a part og this project");
        } else if(!(activities.contains(activity))) {
            throw new OperationNotAllowedException("This activity is not a part of this project");
        } else {
            try {
                user.addActivity(activity);
            }catch ( OperationNotAllowedException e){
                throw new OperationNotAllowedException(e.getMessage());
            }
        }
    }

    /**
     * Remove a given activity from a user of the project.
     * @param activity
     * @param activeUser
     * @param user
     * @throws OperationNotAllowedException If you do not have manager rights throw error.
     *                                      The user has to be a part of the project to add activity.
     *                                      The activity has to be a part of the project to remove it.
     */
    public void removeActivityFromProjectUser(Activity activity, User activeUser, User user) throws OperationNotAllowedException {
        if(!(manager.equals(activeUser))){
            throw new OperationNotAllowedException("You need to have project manager rights to edit this project");
        } else if (!(users.contains(user))){
            throw new OperationNotAllowedException("The user is not a part of this project");
        } else if(!(activities.contains(activity))){
            throw new OperationNotAllowedException("This activity is not a part of this project");
        } else {
            try {
                user.removeActivity(activity);
            }catch ( OperationNotAllowedException e){
                throw new OperationNotAllowedException(e.getMessage());
            }
        }
    }


    /***********************
     * Setters and getters *
     ***********************/

    public void setProjectManager(User projectManager ){
        this.manager = projectManager;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEstimatedEndTime(Calendar estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }

    public void setEstimatedStartTime(Calendar estimatedStartTime) {
        this.estimatedStartTime = estimatedStartTime;
    }

    public Calendar getEstimatedStartTime() {
        return estimatedStartTime;
    }

    public Calendar getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getManager() {
        return manager;
    }

    public User getUser(String credentials) {

        // Set the initial currentDeveloper as null
        User foundUser = null;

        for (User user : users) {

            // Does the search params match.
            if (Objects.equals(user.getCredentials(), credentials)){
                foundUser =  user;
            }
        }

        return foundUser;
    }
}
