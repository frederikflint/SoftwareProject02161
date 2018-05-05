package acceptance_tests;

import cucumber.api.PendingException;
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
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserSteps {

    private Planner planner;
    private User user;
    private Project project;
    private Activity activity;

    private ActivityHelper activityHelper;
    private ErrorMessageHolder errorMessage;
    public UserHelper helper;
    public ProjectHelper projectHelper;



    public UserSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper helper, ProjectHelper projectHelper, ActivityHelper activityHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.helper = helper;
        this.projectHelper = projectHelper;
        this.activityHelper = activityHelper;
    }

    @Given("^that the user is not logged in$")
    public void thatTheUserIsNotLoggedIn() throws Exception {
        assertThat(planner.activeUser,is(equalTo(null)));
    }

    @When("^the user log-in succeeds$")
    public void theUserLogInSucceeds() throws Exception {
        planner.userLogIn("nl","nl");
    }


    @Then("^the user is logged in$")
    public void theUserIsLoggedIn() throws Exception {
        assertThat(planner.activeUser.getCredentials(),is("nl"));
        assertThat(planner.activeUser.getPassword(),is("nl"));
    }

    @When("^the user log-in fails$")
    public void theUserLogInFails() throws Exception {
        try {
            planner.userLogIn("test","test");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("^that the developer is logged in$")
    public void thatTheDeveloperIsLoggedIn() throws Exception {
        if(planner.getActiveUser() == null){
            planner.activeUser = helper.getUser();
        }

    }

    @When("^the developer creates the project$")
    public void theDeveloperCreatesTheProject() throws Exception {
        try {
            planner.createProject(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("^the developer enters a valid project$")
    public void theDeveloperEntersAValidProjectNumberNameDescriptionStartAndEndDate() throws Exception {
        project = projectHelper.getValidProject();
    }


    @Then("^the project is created$")
    public void theProjectWithThatProjectNumberNameDescriptionAndStartAndEndDateIsCreated() throws Exception {
        assertTrue(planner.projects.contains(project));
    }

    @Given("^the developer enters a project with an invalid time consumption$")
    public void theDeveloperEntersAnInvalidProjectNumberNameDescriptionStartOrEndDate() throws Exception {
        project = projectHelper.getInvalidTimeProject();
    }

    @Given("^the developer enters a project with an invalid start date$")
    public void theDeveloperEntersAProjectWithAnInvalidStartDate() throws Exception {
        project = projectHelper.getInvalidTimeProject();
    }

    @Given("^a project already exist in the planner$")
    public void aProjectAlreadyExistInThePlanner() throws Exception {
        project = projectHelper.getValidProject();
        planner.createProject(project);
    }

    @Then("^I get the error message \"([^\"]*)\"$")
    public void iGetTheErrorMessage(String arg1) throws Exception {
        try {

        } catch (Exception e){
            assertThat(e.getMessage(), is(equalTo(arg1)));
        }
    }

    @Given("^a project with title \"([^\"]*)\" is defined$")
    public void aProjectWithTitleIsDefined(String arg1) throws Exception {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(1,1);
        endDate.set(2,1);
        planner.createProject(new Project(arg1,startDate,endDate));
        assertTrue(planner.getProjects().contains(planner.getProject(arg1)));
    }

    @When("^the administrator deletes the project with title \"([^\"]*)\"$")
    public void theAdministratorDeletesTheProjectWithTitle(String arg1) throws Exception {
        try {
            planner.deleteProject(planner.getProject(arg1));
        } catch (OperationNotAllowedException | AuthenticationException e){
            e.getMessage();
        }
    }

    @Then("^the project with title \"([^\"]*)\" is deleted$")
    public void theProjectWithTitleIsDeleted(String arg1) throws Exception {
        assertEquals(planner.getProject(arg1),null);
    }

    @Given("^a project with title \"([^\"]*)\" is not defined$")
    public void aProjectWithTitleIsNotDefined(String arg1) throws Exception {
        assertEquals(planner.getProject(arg1),null);
    }

    @Given("^the developer enters a project with the same name as another project$")
    public void theDeveloperEntersAProjectWithTheSameNameAsAnotherProject() throws Exception {
        assertTrue(planner.getProjects().get(planner.getProjects().indexOf(project)).getTitle().equals(project.getTitle()));
    }

    @Given("^the developer has a non-empty list of activities$")
    public void the_developer_has_a_non_empty_list_of_activities() throws Exception {
        planner.getActiveUser().addActivity(activityHelper.getActivity());
        assertFalse(planner.getActiveUser().getActivities().isEmpty());
    }

    @When("^the developer wants the list of his activities$")
    public void theDeveloperWantsTheListOfHisActivities() throws Exception {
        try {
            planner.getActiveUser().showActivities();
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("^the developer gets the list of his activities$")
    public void theDeveloperGetsTheListOfHisActivities() throws Exception {
        planner.getActiveUser().showActivities();

    }

    @Given("^the developer has no activities in his list of activities$")
    public void the_developer_has_no_activities_in_his_list_of_activities() throws Exception {
        assertEquals(planner.getActiveUser().getActivities().isEmpty(), true);

    }

    @Given("^the developer enters a valid activity$")
    public void theDeveloperEntersAValidActivity() throws Exception {
        activity = activityHelper.getActivity();
    }

    @When("^the developer creates the activity$")
    public void theDeveloperCreatesTheActivity() throws Exception {
        try {
            planner.activeUser.addActivity(activity);
        } catch (OperationNotAllowedException e){
            e.getMessage();
        }
    }

    @Then("^the activity is created$")
    public void theActivityIsCreated() throws Exception {
        planner.activeUser.getActivities().contains(activity);
    }

    @Given("^the developer enters an activity with an invalid start date$")
    public void theDeveloperEntersAnActivityWithAnInvalidStartDate() throws Exception {
        activity = activityHelper.getInvalidActivity();
    }

    @Given("^the developer is a part of the project$")
    public void theDeveloperIsAPartOfTheProject() throws Exception {
        planner.getProject("Heisenberg").setProjectManager(planner.activeUser);
        planner.getProject("Heisenberg").addUser(planner.activeUser);
    }


    @When("^the project manager creates the project activity$")
    public void theProjectManagerCreatesTheProjectActivity() throws Exception {
        planner.getProject("Heisenberg").addActivity(activity,planner.activeUser);
    }

    @Then("^the activity is added to the project$")
    public void theActivityIsAddedToTheProject() throws Exception {
        assertTrue(planner.getProject("Heisenberg").getActivities().contains(activity));
    }

    @Given("^there is a activity with the title \"([^\"]*)\" defined$")
    public void thereIsAActivityWithTheTitleDefined(String arg1) throws Exception {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2018,0,0,0,0);
        endDate.set(2018,1,0,0,0);
        activity = new Activity(startDate,endDate,arg1);
        planner.activeUser.addActivity(activity);

        assertTrue(planner.activeUser.getActivities().contains(activity));
    }

    @When("^the developer removes the activity$")
    public void theDeveloperRemovesTheActivity() throws Exception {
        try {
            planner.activeUser.removeActivity(activity);
        } catch (OperationNotAllowedException e){
            e.getMessage();
        }
    }

    @Then("^the activity is removed$")
    public void theActivityIsRemoved() throws Exception {
        assertFalse(planner.activeUser.getActivities().contains(activity));
    }

    @When("^the project manager removes the activity with title \"([^\"]*)\"$")
    public void theProjectManagerRemovesTheActivityWithTitle(String arg1) throws Exception {
        try{
            planner.getProject("Heisenberg").removeActivity(planner.getProject("Heisenberg").getActivity(arg1),planner.activeUser);
        } catch (OperationNotAllowedException e){
            e.getMessage();
        }
    }

    @Then("^the activity with title \"([^\"]*)\" is removed from the project$")
    public void theActivityWithTitleIsRemovedFromTheProject(String arg1) throws Exception {
        assertFalse(planner.getProject("Heisenberg").getActivities().contains(planner.getProject("Heisenberg").getActivity(arg1)));
    }

    @Given("^there is not an activity with the title \"([^\"]*)\" defined$")
    public void thereIsNotAnActivityWithTheTitleDefined(String arg1) throws Exception {
        assertFalse(planner.getProject("Heisenberg").getActivities().contains(planner.getProject("Heisenberg").getActivity(arg1)));

    }

    @Given("^there is a activity with the title \"([^\"]*)\" is not defined$")
    public void thereIsAActivityWithTheTitleIsNotDefined(String arg1) throws Exception {
        assertFalse(planner.activeUser.getActivities().contains(activity));
    }

    @Given("^the developer is not project manager$")
    public void theDeveloperIsNotProjectManager() throws Exception {
        assertFalse(planner.activeUser.equals(planner.getProject("Heisenberg").getManager()));
    }

}
