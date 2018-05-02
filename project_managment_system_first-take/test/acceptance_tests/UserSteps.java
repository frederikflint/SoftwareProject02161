package acceptance_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.Planner;
import planner.domain.Admin;
import planner.domain.Project;
import planner.domain.User;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserSteps {

    private Planner planner;
    private User user;
    private Admin admin;
    private Project project;

    private ErrorMessageHolder errorMessage;
    public DeveloperHelper helper;
    public ProjectHelper projectHelper;


    public UserSteps(Planner planner, ErrorMessageHolder errorMessage, DeveloperHelper helper, ProjectHelper projectHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.helper = helper;
        this.projectHelper = projectHelper;
    }


    @Given("^that the user is not logged in$")
    public void thatTheUserIsNotLoggedIn() throws Exception {
        assertThat(planner.activeDeveloper,is(equalTo(null)));
    }

    @When("^the user log-in succeeds$")
    public void theUserLogInSucceeds() throws Exception {
        planner.userLogIn("nl","nl");
    }


    @Then("^the user is logged in$")
    public void theUserIsLoggedIn() throws Exception {
        assertThat(planner.activeDeveloper.getCredentials(),is("nl"));
        assertThat(planner.activeDeveloper.getPassword(),is("nl"));
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
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        if(planner.getActiveDeveloper() == null){
            planner.activeDeveloper = helper.getUser();
        }

    }

    @When("^the developer creates the project$")
    public void theDeveloperCreatesTheProject() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
//        try {
//            planner.createProject(project);
//        } catch (Exception e) {
//            errorMessage.setErrorMessage(e.getMessage());
//        }
    }

    @Given("^the developer enters a valid project number, name, description, start and end date$")
    public void theDeveloperEntersAValidProjectNumberNameDescriptionStartAndEndDate() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        project = projectHelper.getValidProject();
    }


    @Then("^the project with that project number, name, description and start and end date is created$")
    public void theProjectWithThatProjectNumberNameDescriptionAndStartAndEndDateIsCreated() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        assertThat(planner.projects.contains(project), is(true));
    }

    @Given("^the developer enters an invalid project number, name, description, start or end date$")
    public void theDeveloperEntersAnInvalidProjectNumberNameDescriptionStartOrEndDate() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        project = projectHelper.getInvalidProject();
    }



    @Then("^I get the error message \"([^\"]*)\"$")
    public void iGetTheErrorMessage(String arg1) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        assertThat(errorMessage.getErrorMessage(),is(equalTo(arg1)));
    }

}
