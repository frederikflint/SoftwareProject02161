package acceptance_tests;

import cucumber.api.java.en.Given;
import planner.app.Planner;
import planner.domain.Activity;
import planner.domain.Project;
import planner.domain.User;

import static org.junit.Assert.assertTrue;

public class ManagerSteps {
    private Planner planner;
    private User user;
    private Admin admin;
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
        planner.users.add(adminHelper.getAdmin());
    }

    @Given("^that the administrator is logged in$")
    public void thatTheAdministratorIsLoggedIn() throws Exception {
        planner.userLogIn(adminHelper.getAdmin().getCredentials(), adminHelper.getAdmin().getPassword());
        assertTrue(planner.activeAdmin());
    }

    @Given("^that a project has no project manager$")
    public void thatAProjectHasNoProjectManager() throws Exception {

    }

}
