package acceptance_tests;

import cucumber.api.java.en_old.Ac;
import planner.domain.Activity;
import planner.domain.Project;

import java.util.Calendar;

public class ActivityHelper {

    private Calendar startDate = Calendar.getInstance();
    private Calendar endDate = Calendar.getInstance();

    private Activity activity;

    public ActivityHelper() {

    }

    public Activity getActivity() {
        if(activity == null) {
            activity = new Activity(Calendar.getInstance(), Calendar.getInstance(), "ActivityID");
        }
        return activity;
    }

    public Activity getExampleActivty(Project project, String ID){
        Activity activity = new Activity(Calendar.getInstance(), Calendar.getInstance(), ID);
        return activity;
    }

    public Activity getInvalidActivity() {
        startDate.set(2018,1,19,8,0);
        endDate.set(2018,1,1,8,0);
        activity = new Activity(startDate,endDate,"IKKETitel");

        return activity;
    }
}
