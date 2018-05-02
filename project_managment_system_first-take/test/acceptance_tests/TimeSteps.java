package acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.Planner;
import planner.domain.*;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class TimeSteps {

    private Planner planner;
    private User user;
    private Admin admin;
    private Project project;
    private Activity activity;

    private ErrorMessageHolder errorMessage;
    public UserHelper helper;
    public ProjectHelper projectHelper;


    public TimeSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper helper, ProjectHelper projectHelper) {
        this.planner = planner;
        this.helper = helper;
        this.errorMessage = errorMessage;
        this.projectHelper = projectHelper;
    }

    @Given("^the developer is assigned to an activity$")
    public void theDeveloperIsAssignedToAnActivity() throws Exception {
        activity = new Activity(new Project("titel",Calendar.getInstance(),Calendar.getInstance()),"Activity");
        planner.getActiveUser().addActivity(activity);
    }

    @When("^the developer registers time spent on an activity$")
    public void theDeveloperRegistersTimeSpentOnAnActivity() throws Exception {
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        startTime.set(2018,1,2,8,0);
        endTime.set(2018,1,2,16,0);
        planner.getActiveUser().registerTime(activity,startTime,endTime);
    }

    @Then("^the registered time is registered to the activity$")
    public void theRegisteredTimeIsRegisteredToTheActivity() throws Exception {
        assertFalse(activity.getCurrentTimeSpent() == 0);
        //
    }

    @Then("^the registered time is registered to the developer$")
    public void theRegisteredTimeIsRegisteredToTheDeveloper() throws Exception {
        assertFalse(planner.getActiveUser().getWorkHours().isEmpty());
    }



}