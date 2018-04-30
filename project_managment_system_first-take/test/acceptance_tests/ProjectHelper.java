package acceptance_tests;

import planner.Project;

public class ProjectHelper {

    private Project project;

    public ProjectHelper(){

    }

    public Project getValidProject() {
        project = new Project();


        return project;
    }

    public Project getInvalidProject() {
        project = new Project();


        return project;
    }
}
