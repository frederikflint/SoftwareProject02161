package acceptance_tests;

import planner.domain.Project;

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
        project = new Project("Title", startDate, endDate);

        /*
        TODO:
        - Insert specifications for CREATING PROJECT
         */

        return project;
    }

    public Project getInvalidTimeProject() {
        startDate.set(2018,1,19,8,0);
        endDate.set(2018,1,1,8,0);
        project = new Project("IKKETitel", startDate, endDate);

        /*
        TODO:
        - Insert specifications for CREATING PROJECT
        - Make this project INVALID
         */


        return project;
    }
}
