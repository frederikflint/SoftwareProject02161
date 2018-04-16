package planner;

import java.util.List;

public class Admin extends User {

    String isAdmin;

    public Admin(String credentials, String password) {
        super(credentials, password);
    }

    /**
     *
     * @param credentials
     * @param password
     */
    public void createDeveloper(String credentials, String password) {
        Developer developer = new Developer(credentials, password);
    }

    /**
     *
     * @return
     */
    public List<Project> getProjects(){
        return Planner.projects;
    }

    /**
     * Set the project manager by fetching developer and project
     * @param credentials
     * @param title
     */
    public void assignProjectManager(String credentials, String title) {
        // Get the developer and  project.
        Developer currentDeveloper = Planner.getDeveloper(credentials);
        Project currentProject = Planner.getProject(title);
        // Add the returned developer to the the returned project as manager.
        currentProject.setProjectManager(currentDeveloper);
    }

    /**
     *
     * @param title
     */
    public void removeProjectManager(String title) {
        Project currentProject = Planner.getProject(title);
        currentProject.setProjectManager(null);

    }

}
