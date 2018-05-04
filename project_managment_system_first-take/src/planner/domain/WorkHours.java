package planner.domain;

import java.util.Calendar;

/**
 * The time registration of a user.
 */
public class WorkHours {

    // The activity that is associated with the project
    private Activity activity;

    // The time of your registration
    private Calendar startTime;
    private Calendar endTime;

    // The total work time
    private int workTimeInMinutes;

    public WorkHours (Activity activity, Calendar startTime, Calendar endTime) {
        this.activity = activity;
        this.startTime = startTime;
        this.endTime = endTime;
        workTimeInMinutes = (endTime.get(Calendar.HOUR_OF_DAY)*60 + endTime.get(Calendar.MINUTE)) -
                (startTime.get(Calendar.HOUR_OF_DAY)*60 + startTime.get(Calendar.MINUTE));
    }

    /**************************
     *  Setters and getters   *
     **************************/

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getWorkTimeInMinutes() {
        return workTimeInMinutes;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }
}
