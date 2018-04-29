package acceptance_tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit5.ApplicationTest;
import planner.Admin;
import planner.Planner;
import planner.User;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserSteps extends ApplicationTest {

    private Planner planner;
    private User user;
    private Admin admin;

    private ErrorMessageHolder errorMessage;
    public DeveloperHelper helper;


    public UserSteps(Planner planner, ErrorMessageHolder errorMessage, DeveloperHelper helper) {
        this.planner = planner;
        this.errorMessage = errorMessage;
        this.helper = helper;
    }

    /******************
     *  TEST FOR GUI  *
     ******************/

    @Override
    public void start (Stage stage) throws Exception {

    }

    @Before
    public void setUp () throws Exception {
    }

    @After
    public void tearDown () throws Exception {

    }

    @Test
    public void userLoginSuccess () {
    }


    /****************
     *  Unit tests  *
     ****************/

    @Given("^that the user is not logged in$")
    public void thatTheUserIsNotLoggedIn() throws Exception {
        assertThat(planner.activeUser,is(equalTo(null)));
    }

    @When("^the user log-in succeeds$")
    public void theUserLogInSucceeds() throws Exception {
        planner.logIn("nl","nl");
    }


    @Then("^the user is logged in$")
    public void theUserIsLoggedIn() throws Exception {
        assertThat(planner.activeUser.getCredentials(),is("nl"));
        assertThat(planner.activeUser.getPassword(),is("nl"));
    }

    @When("^the user log-in fails$")
    public void theUserLogInFails() throws Exception {
        try {
            planner.logIn("test","test");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

}
