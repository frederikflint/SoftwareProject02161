package planner.domain;

import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class Developer extends User {

    List<Activity> Activities;
    List<Project> Projects;
    List<WorkHours> workHours;

    public Developer (String credentials, String password) {
        super(credentials, password);
    }

    @Override
    public boolean isAdmin() {
        return super.isAdmin();
    }

    public void registerTime(Activity activity, Calendar startTime, Calendar endTime) {
        this.workHours.add(new WorkHours(activity, startTime, endTime));
    }

}
