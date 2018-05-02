package planner.app;


import acceptance_tests.Developer;
import planner.domain.Activity;
import planner.domain.Project;
import planner.domain.User;
import planner.domain.WorkHours;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * The main planner
 */
public class Planner {


    // The active developer of the system
    public User activeUser;

    // All the developers on the system
    public List<User> users =  new ArrayList<>();

    // All the projects on the system
    public List<Project> projects = new ArrayList<>();

    /********************
     *  Authentication  *
     *******************/

    /**
     * Set an active user session
     * @param credentials The developers credentials
     * @param password The developers password
     * @throws OperationNotAllowedException If the developers is logged in throw error. If the user us typed in wrong throw error.
     */
    public void userLogIn(String credentials, String password) throws AuthenticationException{

        // Is there a user session?
        // Before anything clear the session
        if(activeSession()){
            activeUser = null;
        }

        // Go through each of the registered Developers and check the password and credentials.
        // If the current one is present set that user as an active user session.
        for (User user : users) {
            if (Objects.equals(user.getCredentials(), credentials) &&
                    Objects.equals(user.getPassword(), password)) {
                //Set the active session
                activeUser = user;
            } else {
                throw new AuthenticationException("Your credentials or password was wrong");
            }
        }

    }

    /**
     * Is there a active session on the system
     * @return boolean. Is there a ongoing session.
     */
    public boolean activeSession(){
        return activeUser != null;
    }

    /**
     * Throw error if there isn't an active sessions
     * @throws OperationNotAllowedException
     */
    public void checkSession() throws OperationNotAllowedException {
        if (!activeSession()) {
            throw new OperationNotAllowedException("Login required");
        }
    }

    /**
     * Throw error if there isn't an active admin sessions
     * @throws OperationNotAllowedException
     */
    public void checkAdminSession() throws OperationNotAllowedException {
        if (activeUser.isAdmin()) {
            throw new OperationNotAllowedException("Administrator required");
        }
    }

    /**
     * Log the active user out of the system (remove active session)
     */
    public void userLogOut(){
        // Remove the active session from the system
        activeUser = null;
    }

    /********************
     *  TITLE  *
     *******************/

    /**
     * Add a new user on the system
     * @param credentials Credentials
     * @param password Password
     * @throws Exception If the developers is in the system throw error
     */
    public void createUser(String credentials, String password) throws Exception{
        checkAdminSession();

        if (getUser(credentials) != null){
            throw new Exception("Developer is registered");
        }
        users.add(new User(credentials, password));
    }

    /**
     *
     * @param credentials
     * @throws Exception
     */
    public void deleteUser(String credentials)throws Exception{
        checkAdminSession();

        User foundUser = getUser(credentials);

        if(foundUser == null){
            throw new Exception("No project with the given name found");
        } else {
            users.remove(foundUser);
        }
    }

    /**
     *
     * @param project
     * @throws Exception
     */
    public void createProject(Project project) throws Exception {
        checkSession();

        if(getProject(project.getTitle()) != null
                || project.getEstimatedEndTime().before(project.getEstimatedStartTime())
                ){
            throw new Exception("Invalid project credentials");
        } else {
            projects.add(project);
        }
    }

    /**
     *
     * @param title
     * @throws Exception
     */
    public void deleteProject(String title) throws  Exception{
        checkAdminSession();

        Project foundProject = getProject(title);

        if(foundProject == null){
            throw new Exception("No project with the given name found");
        } else {
            projects.remove(foundProject);
        }
    }

    /**
     *
     * @param user
     * @param project
     * @throws Exception
     */
    public void assignProjectManager(User user, Project project) throws Exception{
        checkAdminSession();
        project.setProjectManager(user);
    }

    /**
     *
     * @param project
     * @throws Exception
     */
    public void removeProjectManager(Project project) throws Exception{
        checkAdminSession();
        project.setProjectManager(null);
    }
    
    /*****************
     *  Responders   *
     ****************/

    /**
     * Handle the respond to the user.
     */
    private UserResponse userResponse = new UserResponse();


    /** SEND RESPONE
     *
     */

    private void showAlert(){

    }

    /**************************
     *  Setters and getters   *
     **************************/

    /**
     * Search the developers <LIST>  for a specific developer
     * @param credentials The developers credentials
     * @return Returns the specific found developer
     */
    public User getUser(String credentials) {

        // Set the initial currentDeveloper as null
        User foundUser = null;

        for (User user : users) {
            if (Objects.equals(user.getCredentials(), credentials)){
                foundUser =  user;
            }
        }
        return foundUser;
    }


    /**
     *
     * @param activityStartTime
     * @param activityEndTime
     * @return
     */
    public List<User> getAvailableUsers(Calendar activityStartTime, Calendar activityEndTime) throws Exception {
        checkSession();

        List<User> availableUsers = new ArrayList<>();

        // Check if a given user is available
        for (User user : users) {
            for (WorkHours workHour : user.getWorkHours()) {

                if(user.getWorkHours() == null){
                    availableUsers.add(user);
                }

                if (!(workHour.getStartTime().after(activityStartTime)) && !(workHour.getEndTime().before(activityEndTime))) {
                    if (!(workHour.getStartTime().equals(activityStartTime)) && !(workHour.getEndTime().equals(activityEndTime))) {
                        availableUsers.add(user);
                    }
                } else {
                    break;
                }
            }
        }

        if(availableUsers.isEmpty()){
            return null;
        }

        return availableUsers;
    }

    /**
     * Search the projects <LIST> for a specific project
     * @param title The project title
     * @return Returns the specific found project
     */
    public Project getProject(String title) {

        // Set the initial currentProject as null
        Project currentProject = null;

        for (Project project : projects) {
            if (Objects.equals(project.getTitle(), title)){
                currentProject =  project;
            }
        }
        return currentProject;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public User getActiveUser(User activeUser) {
        return activeUser;
    }

    public User getActiveUser() {
        return activeUser;
    }
}
