package planner.domain;

import java.util.Calendar;
import java.util.List;

/**
 * The
 */
public class Developer extends User {

    public Developer (String credentials, String password) {
        super(credentials, password);
    }



    /**************************
     *  Setters and getters   *
     **************************/

    public List<Activity> getActivities() {
        return Activities;
    }

    public List<Project> getProjects() {
        return Projects;
    }

    public List<WorkHours> getWorkHours() {
        return workHours;
    }

    /**
     *
     * @return boolean.
     */
    @Override
    public boolean isAdmin() {
        return super.isAdmin();
    }

}
