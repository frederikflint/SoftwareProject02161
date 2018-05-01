package planner.domain;

import java.util.Calendar;

/**
 *
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
