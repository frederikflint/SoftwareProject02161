package planner.app;

import planner.domain.Admin;
import planner.domain.Developer;
import planner.domain.Project;
import planner.domain.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * The main planner
 */
public class Planner {

    // The system admin
    public final Admin admin = new Admin("admin","admin123");

    public User activeUser;
    public List<Developer> developers =  new ArrayList<>();
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

        // If the user has admin rights.
        // Specific admin scenario
        if(credentials.equals(admin.getCredentials()) && password.equals(admin.getPassword())){
            activeUser = admin;
            return;
        }

        // Go through each of the registered Developers and check the password and credentials.
        // If the current one is present set that user as an active user session.
        for (Developer developer : developers) {
            if (Objects.equals(developer.getCredentials(), credentials) &&
                    Objects.equals(developer.getPassword(), password)) {
                //Set the active session
                activeUser = developer;
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
     * Log the active user out of the system (remove active session)
     */
    public void userLogOut(){
        // Remove the active session from the system
        activeUser = null;
    }

    /**
     * For admin operations
     * @throws OperationNotAllowedException
     */
    public void checkSession() throws OperationNotAllowedException {
        if (activeSession()) {
            throw new OperationNotAllowedException("Administrator login required");
        }
    }

    /**
     * Add a new user on the system
     * @param credentials Credentials
     * @param password Password
     * @throws Exception If the developers is in the system throw error
     */
    public void createDeveloper(String credentials, String password) throws Exception{
        if (getDeveloper(credentials) != null){
            throw new Exception("Developer is registered");
        }
        developers.add(new Developer(credentials, password));
    }

    /**
     * Add a new project to the system
     * @param title
     * @param estimatedStartTime
     * @param estimatedEndTime
     * @throws Exception
     */
    public void createProject(String title, Calendar estimatedStartTime, Calendar estimatedEndTime) throws Exception {

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
    public Developer getDeveloper(String credentials) {

        // Set the initial currentDeveloper as null
        Developer currentDeveloper = null;

        for (Developer developer : developers) {
            if (Objects.equals(developer.getCredentials(), credentials)){
                currentDeveloper =  developer;
            }
        }
        return currentDeveloper;
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

    public List<Developer> getDevelopers() {
        return developers;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Developer getActiveUser(Developer activeUser) {
        return activeUser;
    }

    public User getActiveUser() {
        return activeUser;
    }
}
