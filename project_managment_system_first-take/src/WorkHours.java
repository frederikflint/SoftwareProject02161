package src;

import java.util.Calendar;

public class WorkHours {

    Activity activity;
    Calendar startTime;
    Calendar endTime;

    public WorkHours (Activity activity, Calendar startTime, Calendar endTime) {
        this.activity = activity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

}
