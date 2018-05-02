package planner.domain;

import java.util.Calendar;

/**
 *
 */
public class WorkHours {

    private Activity activity;
    private Calendar startTime;
    private Calendar endTime;
    private int workTimeInMinutes;

    public WorkHours (Activity activity, Calendar startTime, Calendar endTime) {
        this.activity = activity;
        this.startTime = startTime;
        this.endTime = endTime;
        workTimeInMinutes = endTime.get(Calendar.HOUR_OF_DAY) - startTime.get(Calendar.HOUR_OF_DAY);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getWorkTimeInMinutes() {
        return workTimeInMinutes;
    }

    public void setWorkTimeInMinutes(int workTimeInMinutes) {
        this.workTimeInMinutes = workTimeInMinutes;
    }

}
