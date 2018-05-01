package planner.app;

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

    public User activeUser;
    public List<Developer> developers =  new ArrayList<>();
    public List<Project> projects = new ArrayList<>();

    /**
     * Set an active user session
     * @param credentials The developers credentials
     * @param passeword The developers password
     * @throws OperationNotAllowedException If the developers is logged in throw error. If the user us typed in wrong throw error.
     */
    public void userLogIn(String credentials, String passeword) throws OperationNotAllowedException{

        // Is there a user session?
        if(activeUser != null){
            throw new OperationNotAllowedException("There is already an active user on the system");
        }

        // Is there any developers on the system.
        if(developers.isEmpty()){
            throw new OperationNotAllowedException("No developers registered with the planner");
        }

        // Go through each of the registered Developers and check the password and credentials.
        // If the current one is present set that user as an active user session.
        for (Developer user : developers) {
            if (Objects.equals(user.getCredentials(), credentials) &&
                    Objects.equals(user.getPassword(), passeword)) {
                //Set the active session
                activeUser = user;
            } else {
                throw new OperationNotAllowedException("Your credentials or password was wrong");
            }
        }
    }

    /**
     * Log the active user out of the system (remove active session)
     */
    public void userLogOut(){
        // Remove the active session
        activeUser = null;
    }

    /**
     * Add a new user on the system
     * @param credentials Credentials
     * @param password Password
     * @throws Exception If the developers is in the system throw error
     */
    public void createDeveloper(String credentials, String password) throws Exception{
        if (developers.contains(new Developer(credentials, password))) {
            throw new Exception("Developer is already registered");
        } else {
            developers.add(new Developer(credentials, password));
        }
    }

    public void createProject(Project project) throws Exception {
        /*
        Check if project has valid information
         */

        if(true){

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
    public Developer getDeveloper(String credentials) {

        //Set the initial currentDeveloper as null
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
