package planner.domian;

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

    public void registerTime(Activity activity, Calendar startTime, Calendar endTime) {
        this.workHours.add(new WorkHours(activity, startTime, endTime));
    }

}
