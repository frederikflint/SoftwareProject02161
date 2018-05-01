package acceptance_tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit5.ApplicationTest;
import planner.app.Planner;
import planner.domain.Admin;
import planner.domain.Developer;
import planner.domain.Project;
import planner.domain.User;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TimeSteps {

    private Planner planner;
    private User user;
    private Admin admin;
    private Project project;

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
        //throw new PendingException();
        //assertThat(planner.getDeveloper(planner.getActiveUser().getCredentials()).getActivities().contains(),is(true));

    }

    @When("^the developer registers time spent on an activity$")
    public void theDeveloperRegistersTimeSpentOnAnActivity() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //planner.get
    }

    @Then("^the registered time is registered to the activity$")
    public void theRegisteredTimeIsRegisteredToTheActivity() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //
    }

    @Then("^the registered time is registered to the developer$")
    public void theRegisteredTimeIsRegisteredToTheDeveloper() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        //
    }



}