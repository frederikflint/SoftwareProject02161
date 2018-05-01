package acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.Planner;

public class LoginLogoutSteps {

    private Planner planner;

    public LoginLogoutSteps(Planner planner) {
        this.planner = planner;
    }

    @Given("^that there is no active user$")
    public void thatThereIsNoActiveUser() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^the credentials is \"([^\"]*)\" and the password is \"([^\"]*)\"$")
    public void theCredentialsIsAndThePasswordIs(String arg1, String arg2) throws Exception {

    }

    @When("^the admin login succeeds$")
    public void theAdminLoginSucceeds() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the admin is logged in$")
    public void theAdminIsLoggedIn() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    }


}
