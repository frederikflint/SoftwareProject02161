package acceptance_tests;

import planner.Project;

import java.util.Calendar;

public class ProjectHelper {

    private Project project;
    private Calendar startDate = Calendar.getInstance();
    private Calendar endDate = Calendar.getInstance();

    public ProjectHelper(){

    }

    public Project getValidProject() {
        startDate.set(1,1);
        endDate.set(2,1);
        project = new Project("Projekt", startDate, endDate);

        /*
        TODO:
        - Insert specifications for CREATING PROJECT
         */

        return project;
    }

    public Project getInvalidProject() {
        startDate.set(1,1);
        endDate.set(2,1);
        project = new Project("Projekt", startDate, endDate);

        /*
        TODO:
        - Insert specifications for CREATING PROJECT
        - Make this project INVALID
         */


        return project;
    }
}
