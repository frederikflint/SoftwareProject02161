package planner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class Planner {

    public static Developer activeUser;
    public static List<Developer> developers =  new ArrayList<Developer>();
    public static List<Project> projects;

    /**
     * Set an active user session
     * @param credentials The users credentials
     * @param passeword The users password
     */
    public void logIn(String credentials, String passeword) throws OperationNotAllowedException{

        // Is there a user session?
        if(activeUser != null){
            throw new OperationNotAllowedException("There are already an active user on the system");
        }

        // Go through each of the registered Developers and check the password and credentials.
        // If the current one is present set that user as an active user session.
        for (Developer developer : developers) {
            if (Objects.equals(developer.getCredentials(), credentials) &&
                    Objects.equals(developer.getPassword(), passeword)) {
                //Set the active session
                activeUser = developer;
            } else {
                throw new OperationNotAllowedException("Your credentials or password was wrong");
            }
        }
    }

    /**
     * Log the active user out of the system (remove session)
     */
    public void logOut(){
         // Remove the active session
        activeUser = null;
    }

    /**************************
     *  Setters and getters   *
     **************************/

    /**
     * Search the developers <LIST>  for a specific developer
     * @param credentials The developers credentials
     * @return Returns the specific found developer
     */
    public static Developer getDeveloper(String credentials) {

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
    public static Project getProject(String title) {

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
}
