package planner;

import java.util.Calendar;

/**
 * Set WorkHours
 */
public class WorkHours {

    private Activity activity;
    private Calendar startTime;
    private Calendar endTime;

    public WorkHours (Activity activity, Calendar startTime, Calendar endTime) {
        this.activity = activity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
