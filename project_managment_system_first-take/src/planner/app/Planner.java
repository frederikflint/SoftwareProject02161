package planner.app;

import planner.domain.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * The main planner class.
 * This class holds all the logic associated with main system.
 */
public class Planner {

    // The admin of the system
    private Admin admin = new Admin("admin","admin123");

    // The active developer of the system
    public User activeUser;

    // All the developers on the system
    public List<User> users =  new ArrayList<>();

    // All the projects on the system
    public List<Project> projects = new ArrayList<>();

    /******************
     * Authentication *
     ******************/

    /**
     * Set an active user session for the planner.
     * @param credentials The developers credentials
     * @param password The developers password
     * @throws AuthenticationException If the developers is logged in throw error. If the user us typed in wrong throw error.
     */
    public void userLogIn(String credentials, String password) throws OperationNotAllowedException, AuthenticationException{

        // Active Admin
        if(admin.getCredentials().equals(credentials) && admin.getPassword().equals(password)){
            activeUser = admin;
            return;
        }

        // If there is no users on the system
        if(users.isEmpty()){
            throw new OperationNotAllowedException("There is no users on this planner");
        }

        // Is there a user session?
        // Before anything clear the session
        if(activeSession()){
            activeUser = null;
        }

        // Go through each of the registered Developers and check the password and credentials.
        // If the current one is present set that user as an active user session.
        for (User user : users) {
            if ((user.getCredentials().equals(credentials)) &&
                    (user.getPassword().equals(password))) {
                //Set the active session
                activeUser = user;
                return;
            }
        }

        throw new AuthenticationException("Your credentials or password was wrong");
    }

    /**
     * Is there an active user log in on the system.
     * @return boolean. Is there a ongoing session.
     */
    public boolean activeSession(){
        return activeUser != null;
    }

    /**
     * Is the active user an admin.
     * @return
     */
    public boolean activeAdmin(){
        return activeUser.isAdmin();
    }

    /**
     * Is there an active session on the system?
     * @throws AuthenticationException Throw error if there isn't an active sessions.
     */
    public void checkSession() throws AuthenticationException {
        if (!activeSession()) {
            throw new AuthenticationException("Login required");
        }
    }

    /**
     * Is there an active adminHelper session on the system?
     * @throws AuthenticationException Throw error if there isn't an active adminHelper sessions.
     */
    public void checkAdminSession() throws AuthenticationException {
        if (!activeUser.isAdmin()) {
            throw new AuthenticationException("Administrator required");
        }
    }

    /**
     *  Check if the active user haas  manager right for a given project.
     * @param project
     * @throws AuthenticationException Throw if the user haven't got manager right for this project.
     */
    public void checkManagerRights(Project project) throws AuthenticationException {
        if (project.getManager() == null) {
            throw new AuthenticationException("You need to have project manager rights to edit this project");
        }
        if(!project.getManager().equals(activeUser)){
            throw new AuthenticationException("You need to have project manager rights to edit this project");
        }
    }

    /**
     * Log the active user out of the system (remove active session)
     * @throws OperationNotAllowedException If there is not an active session on the system throw error.
     */
    public void userLogOut() throws OperationNotAllowedException {
        // Remove the active session from the system
        if (activeUser == null){
            throw new OperationNotAllowedException("There is no user logged in to the system");
        }
        activeUser = null;
    }

    /**********************
     * Planner Operations *
     **********************/

    /**
     * Add a new user to the system
     * @param credentials Credentials
     * @param password Password
     * @throws OperationNotAllowedException If the session is not a Admin session throw exception.
     *                                      If the developers is in the system throw exception.
     * @throws AuthenticationException If the user is not a adminHelper.
     */
    public void createUser(String credentials, String password) throws OperationNotAllowedException, AuthenticationException{
        checkAdminSession();

        if (getUser(credentials) != null){
            throw new OperationNotAllowedException("Developer is already registered");
        }
        users.add(new User(credentials, password));
    }

    /**
     * Delete a given user from the system.
     * @param user
     * @throws OperationNotAllowedException If the user is not on the system throw exception.
     * @throws AuthenticationException If the user is not a adminHelper.
     */
    public void deleteUser(User user)throws OperationNotAllowedException, AuthenticationException{
        checkAdminSession();

        if(!(users.contains(user))){
            throw new OperationNotAllowedException("No such user is defined in the system");
        } else {
            // Make sure the deleted user is not still in associated project.
            for (Project project : user.getProjects()) {
                // Remove the user from the associated projects.
                project.removeUser(user);
            }
            // Remove the user from the planner.
            users.remove(user);
        }
    }

    /**
     * Crete a project on the planner.
     * @param project
     * @throws OperationNotAllowedException If the project you are trying to create is on the system
     *                                      There is a project with the same title on the planner
     *                                      The time frame for the project is i
     * @throws AuthenticationException There is not a user on the system to perform this operation.
     */
    public void createProject(Project project) throws OperationNotAllowedException, AuthenticationException  {
        checkSession();

        if(projects.contains(project)){
            throw new OperationNotAllowedException("Project is already in the planner");
        } else if(getProject(project.getTitle()) != null){
            throw new OperationNotAllowedException("A project with that title is in the planner");
        } else {
            // Add the project to the planner projects list
            projects.add(project);

            // Set associations

            // Add the user to that project
            project.addUser(getActiveUser());

            // Add the manager association
            project.setProjectManager(getActiveUser());
            getActiveUser().addManageProject(project);
        }

    }

    /**
     * Remove a project from the planner.
     * @param project
     * @throws OperationNotAllowedException The project you are trying to remove is not on the system.
     * @throws AuthenticationException The user is not a adminHelper.
     */
    public void deleteProject(Project project) throws OperationNotAllowedException, AuthenticationException{
        checkAdminSession();

        // Remove the project from
        if(!(projects.contains(project))){
            throw new OperationNotAllowedException("No project with the given title was found");
        } else if(users.isEmpty()) {
            // Get the users associated to this project
            // and remove the project from the user.
            for (User user : project.getUsers()) {
                user.removeProject(project);
            }
        }
        // Remove the actual project from the planner
        projects.remove(project);
    }

    /**
     * Assign a user to to a project.
     * Furthermore, add the given project to the user.
     * @param user
     * @param project
     * @throws OperationNotAllowedException
     * @throws AuthenticationException
     */
    public void assignUserToProject(User user, Project project) throws OperationNotAllowedException, AuthenticationException {
        checkSession();
        checkManagerRights(project);

        // Add the user to the project.
        try {
            project.addUser(user);
        } catch (OperationNotAllowedException e){
            throw new OperationNotAllowedException(e.getMessage());
        }

        // Add the project to the user.
        user.addProject(project);
    }

    /**
     * Remove a user from a given project.
     * Furthermore, remove the the project from the user.
     * @param user
     * @param project
     * @throws OperationNotAllowedException
     * @throws AuthenticationException
     */
    public void removeUserFromProject(User user, Project project) throws  OperationNotAllowedException, AuthenticationException{
        checkSession();
        checkManagerRights(project);

        // Remove the user from the project.
        try {
            project.removeUser(user);
        } catch (OperationNotAllowedException e){
            throw new OperationNotAllowedException(e.getMessage());
        }

        // Remove the project from the user.
        user.removeProject(project);

    }

    /**
     * Assign project manager status to a user for a given project.
     * @param user A user
     * @param project
     * @throws OperationNotAllowedException the user you are trying to promote is not a part of the system.
     * @throws AuthenticationException If the session is not a Admin session throw exception.
     */
    public void changeProjectManager(User user, Project project) throws OperationNotAllowedException, AuthenticationException{
        checkAdminSession();

        if(!(users.contains(user))){
            throw new OperationNotAllowedException("The user you are trying to promote is not a part of the planner");
        }

        // Admin has the rights to just add the user
        if(!user.getProjects().contains(project)){
            project.addUser(user);
        } else if (!user.getProjects().contains(project)){
            user.addProject(project);
        }

        // Set the manager association
        project.setProjectManager(user);
        project.getManager().addManageProject(project);

    }

    /***********************
     * Setters and getters *
     ***********************/

    /**
     * Search the developers <LIST>  for a specific developer
     * @param credentials The developers credentials
     * @return Returns the specific found developer
     */
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

    /**
     * Get users that are available for work
     * @param activityStartTime
     * @param activityEndTime
     * @return The available users
     * @throws Exception There are no users available.
     */
    public List<User> getAvailableUsers(Calendar activityStartTime, Calendar activityEndTime) throws AuthenticationException {
        checkSession();

        List<User> availableUsers = new ArrayList<>();

        // Check if a given user is available
        for (User user : users) {
            if(user.getWorkHours().isEmpty()){
                availableUsers.add(user);
                break;
            }
            for (WorkHours workHour : user.getWorkHours()) {
                if (!(workHour.getStartTime().after(activityStartTime)) && !(workHour.getEndTime().before(activityEndTime))) {
                    if (!(workHour.getStartTime().equals(activityStartTime)) && !(workHour.getEndTime().equals(activityEndTime))) {
                        availableUsers.add(user);
                    }
                }
            }
        }


        return availableUsers;
    }

    /**
     * Is there any available users on the planner
     * @param activityStartTime
     * @param activityEndTime
     * @throws Exception
     */
    public void isThereAvailableUsers(Calendar activityStartTime, Calendar activityEndTime) throws Exception {
        if(getAvailableUsers(activityStartTime,activityEndTime).isEmpty()){
            throw new Exception("There are no available users");
        }
    }

    /**
     *
     * @param activity
     * @param user
     * @return
     * @throws Exception
     */
    public int getTimeSpent(Activity activity, User user) throws Exception {
        int timeSpentOnActivity = 0;
        for (WorkHours WH : user.getWorkHours()) {
            if(WH.getActivity().equals(activity)) {
                timeSpentOnActivity = timeSpentOnActivity + WH.getWorkTimeInMinutes();
            }
        }
        if(timeSpentOnActivity == 0) {
            throw new Exception("No registered time spent");
        }
        return timeSpentOnActivity;
    }

    /**
     * Search the projects <LIST> for a specific project
     * @param title The project title
     * @return Returns the specific found project
     */
    public Project getProject(String title) throws OperationNotAllowedException {

        // Set the initial currentProject as null.
        Project currentProject = null;

        for (Project project : projects) {

            // Does the search params match.
            if (Objects.equals(project.getTitle(), title)){
                currentProject =  project;
            }
        }
        return currentProject;
    }

    public Activity getActivity(String title) throws OperationNotAllowedException {

        // Set the initial currentProject as null.
        Activity currentActivity = null;

        for (Activity activity : getActiveUser().getActivities()) {

            // Does the search params match.
            if (activity.getID().equals(title)){
                currentActivity =  activity;
            }
        }
        if (currentActivity == null) {
            throw new OperationNotAllowedException("Activity doesnt exist");
        }
        return currentActivity;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public User getActiveUser() {
        return activeUser;
    }

}
