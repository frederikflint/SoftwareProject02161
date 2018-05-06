package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import cucumber.api.PendingException;
import cucumber.api.java.ca.Cal;
import cucumber.api.java.cy_gb.A;
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

    private Calendar startTime = Calendar.getInstance();
    private Calendar endTime = Calendar.getInstance();

    private ErrorMessageHolder errorMessage;
    public UserHelper userHelper;
    public ProjectHelper projectHelper;

    public ProjectManagerSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper userHelper, ProjectHelper projectHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.userHelper = userHelper;
        this.projectHelper = projectHelper;
    }

    @Given("^that the developer is a project manager$")
    public void thatTheDeveloperIsAProjectManager() throws Exception {
        planner.createProject(project);
        project.setProjectManager(planner.getActiveUser());
        assertTrue(project.getManager().equals(planner.getActiveUser()));
    }

    @Given("^that a developer is available$")
    public void thatADeveloperIsAvailable() throws Exception {
        user = userHelper.getUser();
        planner.users.add(user);

        startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        startTime.set(2018, 5, 21, 12, 30);
        endTime.set(2018, 6, 21, 12, 30);

        assertTrue(planner.getAvailableUsers(startTime, endTime) != null);
    }

    @When("^the developer adds a developer to the project$")
    public void theDeveloperAddsADeveloperToTheProject() throws Exception {
        try {
            planner.assignUserToProject(user,project);
        } catch (OperationNotAllowedException | AuthenticationException e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("^the developer is added to the project$")
    public void theDeveloperIsIncludedInTheProject() throws Exception {
        assertTrue(project.getUsers().contains(user));
    }

    @Given("^the developer is unavailable$")
    public void theDeveloperIsUnavailable() throws Exception {
        user = userHelper.getUser();
        planner.users.add(user);
        startTime = Calendar.getInstance();
        endTime = Calendar.getInstance();
        startTime.set(2018, 3, 21, 12, 30);
        endTime.set(2018, 4, 21, 12, 30);

        activity = new Activity(startTime, endTime, "activity");
        user.addActivity(activity);
        planner.getActiveUser().registerTime(activity, startTime, endTime, user);

        assertTrue(planner.getAvailableUsers(startTime, endTime).contains(user));
    }

    @Given("^a valid project is defined$")
    public void aValidProjectIsDefined() throws Exception {
        project = projectHelper.getValidProject();
    }

    @Given("^the developer is not a project manager$")
    public void theDeveloperIsNotAProjectManager() throws Exception {
        assertFalse(planner.activeUser.equals(project.getManager()));
    }


    @Then("^the developer is not added to the project$")
    public void theDeveloperIsNotIncludedInTheProject() throws Exception {
        assertFalse(project.getUsers().equals(user));
    }

    @Given("^that the developer is part of the project$")
    public void thatTheDeveloperIsPartOfTheProject() throws Exception {
        project.addUser(planner.getActiveUser());
    }

    @When("^the project manager asks for a list$")
    public void theProjectManagerAsksForAList() throws Exception {
        try{
            planner.getAvailableUsers(startTime,endTime);
        } catch (Exception e){
            e.getMessage();
        }

    }

    @Then("^the project manager gets a list of available developers$")
    public void theProjectManagerGetsAListOfAvailableDevelopers() throws Exception {
        try {
            planner.getAvailableUsers(startTime, endTime);
        } catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }


    @Given("^that no developer is available$")
    public void thatNoDeveloperIsAvailable() throws Exception {
        assertTrue(planner.getAvailableUsers(startTime,endTime).isEmpty());
    }


    @Given("^that the administrator is logged in$")
    public void thatTheAdministratorIsLoggedIn() throws Exception {
        planner.userLogIn("admin","admin123");
        assertTrue(planner.activeAdmin());
    }


    @Given("^that the project has no project manager$")
    public void thatTheProjectHasNoProjectManager() throws Exception {
        assertTrue(project.getManager() == null);
        assertEquals(project.getManager(), null);
    }

    @Given("^a developer is defined$")
    public void aDeveloperIsDefined() throws Exception {
        user = userHelper.getUser();
        planner.users.add(user);
    }

    @When("^the admin assigns user to project manager$")
    public void theAdminAssignsUserToProjectManager() throws Exception {
        try {
            planner.assignProjectManager(user, project);
            // TODO: Hvorfor log ud ???
            //planner.userLogOut();
        }catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("^the user is project manager$")
    public void theUserIsProjectManager() throws Exception {
        assertEquals(project.getManager(),user);
    }

    @Given("^a project has a project manager$")
    public void aProjectHasAProjectManager() throws Exception {
        project.setProjectManager(user);
        assertFalse(project.getManager().equals(null));
    }

    @When("^the administrator removes the project manager status from the user$")
    public void theAdministratorRemovesTheProjectManagerStatusFromTheUser() throws Exception {
        planner.removeProjectManager(project);
    }

    @Then("^the developer is no longer project manager$")
    public void theDeveloperIsNoLongerProjectManager() throws Exception {
        assertEquals(project.getManager(), null);
    }


//    @Given("^that the developer is not a project manager$")
//    public void thatTheDeveloperIsNotAProjectManager() throws Exception {
//        project = projectHelper.getValidProject();
//
//        planner.createProject(project);
//        assertFalse(project.getManager().equals(planner.getActiveUser()));
//    }
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
