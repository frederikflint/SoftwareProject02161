package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.app.AuthenticationException;
import planner.app.Planner;
import planner.domain.Project;
import planner.domain.User;

public class CRUD {

    private Planner planner;
    private User user;
    private Project project;

    private ActivityHelper activityHelper;
    private ErrorMessageHolder errorMessage;
    public UserHelper helper;
    public ProjectHelper projectHelper;

    public CRUD(Planner planner, ErrorMessageHolder errorMessage, UserHelper helper, ProjectHelper projectHelper, ActivityHelper activityHelper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.helper = helper;
        this.projectHelper = projectHelper;
        this.activityHelper = activityHelper;
    }

    @Given("^a developer with credentials \"([^\"]*)\" and password \"([^\"]*)\" is defined$")
    public void aDeveloperWithCredentialsAndPasswordIsDefined(String arg1, String arg2) throws Exception {
        planner.users.add(new User(arg1,arg2));
        assertTrue(planner.getUser(arg1).getCredentials().equals(arg1));
    }

    @When("^the administrator deletes the developer with credentials \"([^\"]*)\" from the system$")
    public void theAdministratorDeletesTheDeveloperWithCredentialsFromTheSystem(String arg1) throws Exception {
        planner.deleteUser(planner.getUser(arg1));
    }

    @Then("^the developer with credentials \"([^\"]*)\" is removed from the system$")
    public void theDeveloperWithCredentialsIsRemovedFromTheSystem(String arg1) throws Exception {
        assertFalse(planner.users.contains(planner.getUser(arg1)));
    }

    @When("^the administrator tries to delete the developer with credentials \"([^\"]*)\"$")
    public void theAdministratorTriesToDeleteTheDeveloperWithCredentials(String arg1) throws Exception {
        try {
            planner.deleteUser(planner.getUser(arg1));
        }
        catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Given("^that the administrator is not logged in$")
    public void thatTheAdministratorIsNotLoggedIn() throws Exception {
        try {
            planner.checkAdminSession();
        } catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("^the administrator deletes a developer with credentials \"([^\"]*)\" from the system$")
    public void theAdministratorDeletesADeveloperWithCredentialsFromTheSystem(String arg1) throws Exception {
       try {
           planner.deleteUser(planner.getUser(arg1));
       } catch (Exception e){
           errorMessage.setErrorMessage(e.getMessage());
       }
    }

    @Given("^a developer with credentials \"([^\"]*)\" is not defined$")
    public void aDeveloperWithCredentialsIsNotDefined(String arg1) throws Exception {
        assertFalse(planner.getUser(arg1)!=null);
    }

    @When("^the administrator creates the developer with credentials \"([^\"]*)\" and password \"([^\"]*)\" from the system$")
    public void theAdministratorCreatesTheDeveloperWithCredentialsAndPasswordFromTheSystem(String arg1, String arg2) throws Exception {
        planner.createUser(arg1,arg2);
    }

    @Then("^the developer with credentials \"([^\"]*)\" is added to the system$")
    public void theDeveloperWithCredentialsIsAddedToTheSystem(String arg1) throws Exception {
        assertTrue(planner.getUser(arg1)!=null);
    }

    @Given("^a developer with credentials \"([^\"]*)\" is defined in the system$")
    public void aDeveloperWithCredentialsIsDefinedInTheSystem(String arg1) throws Exception {
        planner.createUser(arg1,"1234");
        assertTrue(planner.getUser(arg1)!=null);
    }

    @When("^the administrator creates the developer with credentials \"([^\"]*)\" and password \"([^\"]*)\" to the system$")
    public void theAdministratorCreatesTheDeveloperWithCredentialsAndPasswordToTheSystem(String arg1, String arg2) throws Exception {
        try {
            planner.createUser(arg1,arg2);
        } catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("^the user creates the developer with credentials \"([^\"]*)\" and password \"([^\"]*)\" from the system$")
    public void theUserCreatesTheDeveloperWithCredentialsAndPasswordFromTheSystem(String arg1, String arg2) throws Exception {
        try {
            planner.createUser(arg1,arg2);
        } catch(Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

}
