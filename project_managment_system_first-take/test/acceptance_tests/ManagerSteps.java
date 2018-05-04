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
    private Activity activity;

    private ErrorMessageHolder errorMessage;
    public UserHelper userHelper;
    public AdminHelper adminHelper;
    public ProjectHelper projectHelper;

    public ManagerSteps(Planner planner, ErrorMessageHolder errorMessage, UserHelper userHelper, ProjectHelper projectHelper, AdminHelper adminHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.userHelper = userHelper;
        this.projectHelper = projectHelper;
        this.adminHelper = adminHelper;
    }

    @Given("^that the administrator is logged in$")
    public void thatTheAdministratorIsLoggedIn() throws Exception {
        admin = adminHelper.getAdmin();
        planner.users.add(admin);
        planner.userLogIn(admin.getCredentials(),admin.getPassword());
        assertTrue(planner.activeAdmin());
    }

    @Given("^a project is defind$")
    public void aProjectIsDefind() throws Exception {
        project = projectHelper.getValidProject();
        planner.projects.add(project);
    }

    @Given("^that a project has no project manager$")
    public void thatAProjectHasNoProjectManager() throws Exception {
        assertEquals(project.getManager(), null);
    }

    @Given("^a developer is defined$")
    public void aDeveloperIsDefined() throws Exception {
        user = userHelper.getUser();
        planner.users.add(user);
        assertFalse(planner.getUsers().isEmpty());
    }

    @When("^the admin assigns user to project manager$")
    public void theAdminAssignsUserToProjectManager() throws Exception {
        planner.assignProjectManager(user, planner.getProjects().get(0));
        planner.userLogOut();
    }

    @Then("^the user is project manager$")
    public void theUserIsProjectManager() throws Exception {
        assertEquals(project.getManager(),user);
    }

}
