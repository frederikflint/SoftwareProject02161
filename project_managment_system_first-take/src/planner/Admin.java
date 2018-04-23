package planner;

import java.util.List;

public class Admin extends User {

    String isAdmin;

    public Admin(String credentials, String password) {
        super(credentials, password);
    }

    /**
     * Add a new user on the system
     * @param credentials
     * @param password
     */
    public void createDeveloper(String credentials, String password, Planner planner) {
        Developer developer = new Developer(credentials, password);
        planner.developers.add(developer);
    }

    /**
     *
     * @return
     */
    public List<Project> getProjects(Planner planner){
        return planner.projects;
    }

    /**
     * Set the project manager by fetching developer and project
     * @param credentials
     * @param title
     */
    public void assignProjectManager(String credentials, String title, Planner planner) {

        // Get the developer and  project.
        Developer currentDeveloper = planner.getDeveloper(credentials);
        Project currentProject = planner.getProject(title);

        // Add the returned developer to the the returned project as manager.
        currentProject.setProjectManager(currentDeveloper);
    }

    /**
     *
     * @param title
     */
    public void removeProjectManager(String title, Planner planner) {
        Project currentProject = planner.getProject(title);
        currentProject.setProjectManager(null);

    }

}
