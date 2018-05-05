package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import cucumber.api.PendingException;
import cucumber.api.java.ca.Cal;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.Activity;
import planner.domain.Project;
import planner.domain.User;

import java.util.Calendar;


public class ProjectManagerSteps {

    private Planner planner;
    private User user;

    private Project project;
    private Activity activity;

    private ErrorMessageHolder errorMessage;
    public UserHelper userHelper;
    public AdminHelper adminHelper;
    public ProjectHelper projectHelper;

    public ProjectManagerSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper userHelper, ProjectHelper projectHelper, AdminHelper adminHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.userHelper = userHelper;
        this.projectHelper = projectHelper;
        this.adminHelper = adminHelper;
        planner.users.add(adminHelper.getAdmin());
    }

    @Given("^that the developer is a project manager$")
    public void thatTheDeveloperIsAProjectManager() throws Exception {
        project = projectHelper.getValidProject();

        planner.createProject(project);
        project.setProjectManager(planner.getActiveUser());
        assertTrue(project.getManager().equals(planner.getActiveUser()));
    }

    @Given("^that a developer is available$")
    public void thatADeveloperIsAvailable() throws Exception {
        user = userHelper.getUser();
        planner.users.add(user);

        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        endTime.add(Calendar.DATE, 1);

        assertTrue(planner.getAvailableUsers(startTime, endTime) != null);
    }

    @When("^the developer adds a developer to the project$")
    public void theDeveloperAddsADeveloperToTheProject() throws Exception {
        project.addUser(user);
    }

    @Then("^the developer is included in the project$")
    public void theDeveloperIsIncludedInTheProject() throws Exception {
        assertTrue(project.getUsers().contains(user));
    }

    @Given("^a developer is unavailable$")
    public void aDeveloperIsUnavailable() throws Exception {
        user = userHelper.getUser();
        planner.users.add(user);
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        startTime.set(2018, 3, 21, 12, 30);
        endTime.set(2018, 4, 21, 12, 30);

        activity = new Activity(startTime, endTime, "activity");
        user.addActivity(activity);
        planner.getActiveUser().registerTime(activity, startTime, endTime, user);

        assertTrue(planner.getAvailableUsers(startTime, endTime).contains(user));
    }


    @Given("^that the developer is not a project manager$")
    public void thatTheDeveloperIsNotAProjectManager() throws Exception {
        project = projectHelper.getValidProject();

        planner.createProject(project);
        assertFalse(project.getManager().equals(planner.getActiveUser()));
    }
}


//    @When("^the project manager retrieves the list$")
//    public void theProjectManagerRetrievesTheList() throws Exception {
//        Calendar startTime = Calendar.getInstance();
//        Calendar endTime = Calendar.getInstance();
//        endTime.add(Calendar.DATE,1);
//        planner.getAvailableUsers(startTime,endTime);
//    }
//
//    @Then("^the available developers appear on the available list$")
//    public void theAvailableDevelopersAppearOnTheAvailableList() throws Exception {
//        Calendar startTime = Calendar.getInstance();
//        Calendar endTime = Calendar.getInstance();
//        endTime.add(Calendar.DATE,1);
//        assertTrue(planner.getAvailableUsers(startTime,endTime)!=null);
//    }
//
//    @Given("^that no developer is available$")
//    public void thatNoDeveloperIsAvailable() throws Exception {
//        Calendar startTime = Calendar.getInstance();
//        Calendar endTime = Calendar.getInstance();
//        endTime.add(Calendar.DATE,1);
//    }
//
//
//
