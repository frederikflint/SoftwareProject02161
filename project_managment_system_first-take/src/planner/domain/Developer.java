package planner.domain;

import java.util.Calendar;
import java.util.List;

/**
 * The
 */
public class Developer extends User {

    List<Activity> Activities;
    List<Project> Projects;
    List<WorkHours> workHours;

    public Developer (String credentials, String password) {
        super(credentials, password);
    }

    public void registerTime(Activity activity, Calendar startTime, Calendar endTime) {
        this.workHours.add(new WorkHours(activity, startTime, endTime));
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
