package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import planner.app.Planner;
import planner.domain.Activity;
import planner.domain.Project;
import planner.domain.User;

public class ManagerSteps {
    private Planner planner;
    private User user;
    private User admin;
    private Project project;

    private ErrorMessageHolder errorMessage;
    public UserHelper userHelper;
    public ProjectHelper projectHelper;

    public ManagerSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper userHelper, ProjectHelper projectHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.userHelper = userHelper;
        this.projectHelper = projectHelper;
    }

    @Given("^that the administrator is logged in$")
    public void thatTheAdministratorIsLoggedIn() throws Exception {
        planner.userLogIn("admin","admin123");
        assertTrue(planner.activeAdmin());
    }


    @Given("^that the project has no project manager$")
    public void thatTheProjectHasNoProjectManager() throws Exception {
        System.out.println(project);
        assertEquals(project.getManager(), null);
    }

    @When("^the admin assigns user to project manager$")
    public void theAdminAssignsUserToProjectManager() throws Exception {
        try {
            planner.assignProjectManager(user, planner.getProjects().get(0));
            planner.userLogOut();
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


}
