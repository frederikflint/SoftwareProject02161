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
        user = new User("pm","1234");
        project = projectHelper.getValidProject();

        planner.createProject(project);
        project.setProjectManager(user);
        assertTrue(project.getManager().equals(user));
    }

    @Given("^a developer is available$")
    public void aDeveloperIsAvailable() throws Exception {
        user = userHelper.getUser();

        planner.users.add(user);
        System.out.println(user);

        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        endTime.add(Calendar.DATE,1);

        assertTrue(planner.getAvailableUsers(startTime,endTime) != null);

    }

    @When("^the project manager adds the developer to the project$")
    public void theProjectManagerAddsTheDeveloperToTheProject() throws Exception {
        user = new User("ny","1234");
        Calendar startTime = Calendar.getInstance();
        Calendar endTime = Calendar.getInstance();
        endTime.add(Calendar.DATE,1);
        project = new Project("nyt projekt", startTime, endTime);

        planner.createProject(project);
        System.out.println(project+ "\n" + user);
        project.addUser(user);
    }

    @Then("^the developer is included in the project$")
    public void theDeveloperIsIncludedInTheProject() throws Exception {
    }
}
