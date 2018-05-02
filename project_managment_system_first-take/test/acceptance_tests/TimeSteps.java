package acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.Planner;
import planner.domain.*;
import planner.domain.Admin;

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
    public DeveloperHelper helper;
    public ProjectHelper projectHelper;


    public TimeSteps(Planner planner,ErrorMessageHolder errorMessage,DeveloperHelper helper,ProjectHelper projectHelper) {
        this.planner = planner;
        this.helper = helper;
        this.errorMessage = errorMessage;
        this.projectHelper = projectHelper;

    }

    @Given("^the developer is assigned to an activity$")
    public void theDeveloperIsAssignedToAnActivity() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
        activity = new Activity(new Project("titel",Calendar.getInstance(),Calendar.getInstance()),"Activity");

        //TODO:
        // assign active user to activity.
        //

    }

    @When("^the developer registers time spent on an activity$")
    public void theDeveloperRegistersTimeSpentOnAnActivity() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        startTime.set(2018,1,2,8,0);
        endTime.set(2018,1,2,16,0);

        // planner.getActiveUser().registerTime(activity,startTime,endTime);
    }

    @Then("^the registered time is registered to the activity$")
    public void theRegisteredTimeIsRegisteredToTheActivity() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        assertFalse(activity.getCurrentTimeSpent() != 0);
        //
    }

    @Then("^the registered time is registered to the developer$")
    public void theRegisteredTimeIsRegisteredToTheDeveloper() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //assertThat(planner.activeUser.);
    }



}