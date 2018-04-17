package acceptance_tests;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import planner.Planner;
import planner.User;
import planner.Admin;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThat;

public class UsersSteps {

    private Planner planner;
    private User user;
    private Admin admin;
    public UserHelper helper;

    public UsersSteps(Planner planner, UserHelper helper) {
        this.planner = planner;
        this.helper = helper;
    }

    @Given("^that the user is not logged in$")
    public void thatTheUserIsNotLoggedIn() throws Exception {
        assertEquals(Planner.activeUser,null);
        throw new PendingException();
    }

    @Given("^the password is entered correctly$")
    public void thePasswordIsEnteredCorrectly() throws Exception {
        System.out.print(planner.getDevelopers());
    }

//    @When("^the user log-in succeeds$")
//    public void theUserLogInSucceeds() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^the user is logged in$")
//    public void theUserIsLoggedIn() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Given("^the password entered is wrong$")
//    public void thePasswordEnteredIsWrong() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^the user log-in fails$")
//    public void theUserLogInFails() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("^I get the error message \"([^\"]*)\"$")
//    public void iGetTheErrorMessage(String arg1) throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

}
