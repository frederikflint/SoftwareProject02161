package acceptance_tests;

import cucumber.api.java.ca.Cal;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.Planner;
import planner.domain.*;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class TimeSteps {

    private Planner planner;
    private User user;
    private Admin admin;
    private Project project;
    private Activity activity;

    private ErrorMessageHolder errorMessage;
    public UserHelper helper;
    public ProjectHelper projectHelper;
    public ActivityHelper activityHelper;

    private int helperInt;

    Calendar startTime = Calendar.getInstance();
    Calendar endTime = Calendar.getInstance();


    public TimeSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper helper, ProjectHelper projectHelper, ActivityHelper activityHelper) {
        this.planner = planner;
        this.helper = helper;
        this.errorMessage = errorMessage;
        this.projectHelper = projectHelper;
        this.activityHelper = activityHelper;
    }

    @Given("^the developer is assigned to an activity$")
    public void theDeveloperIsAssignedToAnActivity() throws Exception {
        activity = activityHelper.getActivity();
        planner.getActiveUser().addActivity(activity);
    }

    @When("^the developer registers time spent on the activity$")
    public void theDeveloperRegistersTimeSpentOnAnActivity() throws Exception {
        if(activity == null) {
            activity = activityHelper.getActivity();
        }
        startTime.set(2018,1,2,8,0);
        endTime.set(2018,1,2,16,0);
        try {
            planner.getActiveUser().registerTime(activity, startTime, endTime, planner.getActiveUser());
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("^the registered time is registered to the activity$")
    public void theRegisteredTimeIsRegisteredToTheActivity() throws Exception {
        assertFalse(activity.getCurrentTimeSpent() == 0);
        // TODO: Måske mere test
    }

    @Then("^the registered time is registered to the developer$")
    public void theRegisteredTimeIsRegisteredToTheDeveloper() throws Exception {
        assertFalse(planner.getActiveUser().getWorkHours().isEmpty());
        // TODO: Måske mere test
    }

    @Given("^the developer is not assigned to the activity$")
    public void theDeveloperIsNotAssignedToTheActivity() throws Exception {
        assertFalse(planner.getActiveUser().getActivities().contains(activity));
    }

    @Then("^the developer gets the error message: \"([^\"]*)\"$")
    public void theDeveloperGetsTheErrorMessage(String arg1) throws Exception {
        assertTrue(errorMessage.getErrorMessage().equals(arg1));
    }

    @When("^the developer registers an invalid amount of time$")
    public void theDeveloperRegistersAnInvalidAmountOfTime() throws Exception {
        startTime.set(2018,1,2,16,0);
        endTime.set(2018,1,2,8,0);
        try {
            planner.getActiveUser().registerTime(activity, startTime, endTime, planner.getActiveUser());
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("^the developer has time registered to an activity$")
    public void theDeveloperHasTimeRegisteredToAnActivity() throws Exception {
        activity = activityHelper.getActivity();
        planner.getActiveUser().addActivity(activity);
        startTime.set(2018,3,5,8,0);
        endTime.set(2018, 3,5,16,0);
        planner.getActiveUser().registerTime(activity, startTime, endTime,planner.getActiveUser());
        helperInt = (endTime.get(Calendar.HOUR_OF_DAY)*60 + endTime.get(Calendar.MINUTE)) - (startTime.get(Calendar.HOUR_OF_DAY)*60 + startTime.get(Calendar.MINUTE));
        startTime.set(2018, 3,7,8,10);
        endTime.set(2018,3,7,10,0);
        planner.getActiveUser().registerTime(activity,startTime,endTime,planner.getActiveUser());
        helperInt = helperInt + planner.getActiveUser().getWorkHours().get(1).getWorkTimeInMinutes();
    }

    @When("^the developer checks time spent$")
    public void theDeveloperChecksTimeSpent() throws Exception {
        //planner.getTimeSpent(activity, planner.getActiveUser());

        try {
            planner.getTimeSpent(activity,planner.getActiveUser());
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

        // TODO: Her skal nok findes ud af hvad vi skal gøre omkring >visning af tidsforbrug< !
    }

    @Then("^the time spent registered by the developer is displayed$")
    public void theTimeSpentRegisteredByTheDeveloperIsDisplayed() throws Exception {
        assertThat(helperInt, is(equalTo(planner.getTimeSpent(activity,planner.getActiveUser()))));
    }

    @Given("^the developer has no time registered to an activity$")
    public void theDeveloperHasNoTimeRegisteredToAnActivity() throws Exception {
        assertThat(planner.getActiveUser().getWorkHours().isEmpty(), is(true));
    }

}