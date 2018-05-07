package WhiteBoxTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhiteBox_CreateUser {

    private Planner planner = new Planner();
    private User user1 = new User("u1", "123");

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws OperationNotAllowedException, AuthenticationException {
        //Given
        //Admin logged in
        planner.userLogIn("ad", "123");
        //First check
        assertTrue(planner.getUser(user1.getCredentials())==null);


        //ActionYour credentials must have a maximum of 4 characters
        planner.createUser(user1.getCredentials(),user1.getPassword());

        //Final check
        assertTrue(planner.getUser(user1.getCredentials())!=null);
    }
    @Test
    public void testInputSetB() throws OperationNotAllowedException, AuthenticationException {
        //Expected
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("Developer is already registered");

        //Given
        planner.userLogIn("ad","123");
        planner.users.add(user1);

        //First check
        assertTrue(planner.getUser(user1.getCredentials())!=null);

        //Action
        planner.createUser(user1.getCredentials(),user1.getPassword());
    }

    @Test
    public void testInputSetC() throws OperationNotAllowedException, AuthenticationException {
        //Expected
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("Your credentials must have a maximum of 4 characters");

        //Given
        planner.userLogIn("ad","123");

        //Action
        planner.createUser("userWithTooManyCredentials","123");
    }

    @Test
    public void testInputSetD() throws OperationNotAllowedException, AuthenticationException {
        //Expected
        expectedException.expect(AuthenticationException.class);
        expectedException.expectMessage("Administrator required");

        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(), user1.getPassword());

        //First check
        assertFalse(planner.activeAdmin());

        //Action
        planner.createUser("newUser", "newPassword");
    }
}
