package acceptance_tests;

import planner.domain.Activity;
import planner.domain.Project;

import java.util.Calendar;

public class ActivityHelper {

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

}
