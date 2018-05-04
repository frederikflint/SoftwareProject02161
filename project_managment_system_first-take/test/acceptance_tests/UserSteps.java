package acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.Planner;
import planner.domain.Project;
import planner.domain.User;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserSteps {

    private Planner planner;
    private User user;
    private Project project;

    private ErrorMessageHolder errorMessage;
    public UserHelper helper;
    public ProjectHelper projectHelper;


    public UserSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper helper, ProjectHelper projectHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.helper = helper;
        this.projectHelper = projectHelper;
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

    @Given("^that a developer is logged in$")
    public void thatADeveloperIsLoggedIn() throws Exception {
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

    @Given("^a project already exist in the planner$")
    public void aProjectAlreadyExistInThePlanner() throws Exception {
        project = projectHelper.getValidProject();
        planner.createProject(project);
    }

    @Then("^I get the error message \"([^\"]*)\"$")
    public void iGetTheErrorMessage(String arg1) throws Exception {
        assertThat(errorMessage.getErrorMessage(),is(equalTo(arg1)));
    }

    @Given("^the developer enters a project with the same name as another project$")
    public void theDeveloperEntersAProjectWithTheSameNameAsAnotherProject() throws Exception {
        //project =
        assertTrue(planner.getProjects().get(planner.getProjects().indexOf(project)).getTitle().equals(project.getTitle()));
    }

}
