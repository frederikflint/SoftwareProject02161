package planner.domain;

import planner.app.Planner;

import java.util.List;

public class Admin extends User {

    public Admin(String credentials, String password) {
        super(credentials, password);
    }

    /**
     * Set the project manager by fetching developer and project
     * @param credentials
     * @param title
     */
    public void assignProjectManager(String credentials, String title, Planner planner) {

        // Get the developer and project.
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

    /**
     *  I
     * @return boolean.
     */
    @Override
    public boolean isAdmin() {
        return true;
    }

}
