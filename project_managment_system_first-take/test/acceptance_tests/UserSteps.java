package acceptance_tests;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jdk.jfr.events.ExceptionThrownEvent;
import org.mockito.internal.creation.SuspendMethod;
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
    public Project project;
    private Project project2;
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
        User user =  helper.getUser();
        planner.getUsers().add(user);
        planner.userLogIn(user.getCredentials(),user.getPassword());
    }

    @Given("^a project already exist in the planner$")
    public void aProjectAlreadyExistInThePlanner() throws Exception {
        project = projectHelper.getValidProject();
        planner.createProject(project);
    }

    @Then("^I get the error message \"([^\"]*)\"$")
    public void iGetTheErrorMessage(String arg1) throws Exception {
        assertEquals(errorMessage.getErrorMessage(), arg1);
    }

    @Given("^a project with title \"([^\"]*)\" is defined$")
    public void aProjectWithTitleIsDefined(String arg1) throws Exception {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        try {
            planner.createProject(new Project(arg1, startDate, endDate));
            planner.assignUserToProject(planner.getActiveUser(), planner.getProject(arg1));
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

        assertTrue(planner.getProjects().contains(planner.getProject(arg1)));
    }

    @When("^the developer creates the project$")
    public void theDeveloperCreatesTheProject() throws Exception {
        try {
            planner.createProject(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("^the administrator is logged in$")
    public void thatTheAdministratorIsLoggedIn() throws Exception {
        planner.userLogIn("admin","admin123");
        assertTrue(planner.activeAdmin());
    }

    @When("^the manager deletes the project with title \"([^\"]*)\"$")
    public void theManagerDeletesTheProjectWithTitle(String arg1) throws Exception {
        try {
            planner.deleteProject(planner.getProject(arg1));
        } catch (OperationNotAllowedException | AuthenticationException e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("^the developer is a project manager of the project$")
    public void theDeveloperIsAProjectManagerOfTheProject() throws Exception {
        assertTrue(project.getManager().equals(planner.activeUser));
    }

    @Then("^the project with title \"([^\"]*)\" is deleted$")
    public void theProjectWithTitleIsDeleted(String arg1) throws Exception {
        assertTrue(planner.getProject(arg1) == null);
    }

    @Given("^a project with title \"([^\"]*)\" is not defined$")
    public void aProjectWithTitleIsNotDefined(String arg1) throws Exception {
        assertTrue(planner.getProject(arg1) == null);
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

    @Given("^the activity is already registered to the developer$")
    public void theActivityIsAlreadyRegisteredToTheDeveloper() throws Exception {
        planner.activeUser.addActivity(activity);
        assertTrue(planner.activeUser.getActivities().contains(activity));
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
            errorMessage.setErrorMessage(e.getMessage());
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
//        planner.getProject("Heisenberg").addUser(planner.activeUser);
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
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("^the activity is removed$")
    public void theActivityIsRemoved() throws Exception {
        assertFalse(planner.activeUser.getActivities().contains(activity));
    }

    @When("^the project manager removes the activity with title \"([^\"]*)\"$")
    public void theProjectManagerRemovesTheActivityWithTitle(String arg1) throws Exception {
        Project project = planner.getProject("Heisenberg");

        try {
            project.removeActivity(project.getActivity(arg1),planner.getActiveUser());
        } catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }

    }

    @Given("^there is a activity project with the title \"([^\"]*)\" defined$")
    public void thereIsAActivityProjectWithTheTitleDefined(String arg1) throws Exception {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2018,0,0,0,0);
        endDate.set(2018,1,0,0,0);
        activity = new Activity(startDate,endDate,arg1);
        planner.getProject("Heisenberg").addActivity(activity, planner.getActiveUser());

        assertTrue(planner.getProject("Heisenberg").getActivities().contains(activity));
    }

    @Then("^the activity with title \"([^\"]*)\" is removed from the project$")
    public void theActivityWithTitleIsRemovedFromTheProject(String arg1) throws Exception {
        assertFalse(planner.getProject("Heisenberg").getActivities().contains(planner.getProject("Heisenberg").getActivity(arg1)));
    }

    @Then("^the activity with title \"([^\"]*)\" is not removed from the project$")
    public void theActivityWithTitleIsNotRemovedFromTheProject(String arg1) throws Exception {
        assertTrue(planner.getProject("Heisenberg").getActivity(arg1) != null);
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
        planner.getProject("Heisenberg").setProjectManager(new User("nyManager","123"));
        assertFalse(planner.activeUser.equals(planner.getProject("Heisenberg").getManager()));
    }

}
