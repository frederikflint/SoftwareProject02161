package acceptance_tests;

import cucumber.api.java.en.Given;
import planner.app.Planner;
import planner.domain.Project;
import planner.domain.User;

import static org.junit.Assert.assertFalse;

public class BaseSetUp {

    private Planner planner;
    private User user;
    private User admin;
    private Project project;

    private ErrorMessageHolder errorMessage;
    public UserHelper userHelper;
    public AdminHelper adminHelper;
    public ProjectHelper projectHelper;

    public BaseSetUp(Planner planner, ErrorMessageHolder errorMessage, UserHelper userHelper, ProjectHelper projectHelper, AdminHelper adminHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.userHelper = userHelper;
        this.projectHelper = projectHelper;
        this.adminHelper = adminHelper;
    }

    @Given("^a developer is defined$")
    public void aDeveloperIsDefined() throws Exception {
        user = userHelper.getUser();
        planner.users.add(user);
        assertFalse(planner.getUsers().isEmpty());
    }

    @Given("^a project is defined$")
    public void aProjectIsDefined() throws Exception {
        project = projectHelper.getValidProject();
        planner.projects.add(project);
    }

}
