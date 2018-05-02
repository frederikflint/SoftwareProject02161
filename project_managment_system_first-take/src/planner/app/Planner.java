package planner.app;

import planner.domain.Project;
import planner.domain.User;
import java.util.ArrayList;
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
     * Throw error if there isn't a active sessions
     * @throws OperationNotAllowedException
     */
    public void checkSession() throws OperationNotAllowedException {
        if (!activeSession()) {
            throw new OperationNotAllowedException("Administrator login required");
        }
    }

    /**
     * Log the active user out of the system (remove active session)
     */
    public void userLogOut(){
        // Remove the active session from the system
        activeUser = null;
    }

    /**
     * Add a new user on the system
     * @param credentials Credentials
     * @param password Password
     * @throws Exception If the developers is in the system throw error
     */
    public void createUser(String credentials, String password) throws Exception{
        if (getUser(credentials) != null){
            throw new Exception("Developer is registered");
        }
        users.add(new User(credentials, password));
    }

    /**
     *
     * @param project
     * @throws Exception
     */
    public void createProject(Project project) throws Exception {
        /*
        Check if project has valid information
         */

        if(project.getTitle() == "Titel"){
            projects.add(project);
        } else {
            throw new Exception("Invalid project credentials");
        }

    }

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
