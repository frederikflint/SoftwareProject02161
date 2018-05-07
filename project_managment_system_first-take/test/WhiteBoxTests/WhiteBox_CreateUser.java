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
    private User user1 = new User("user1", "123");

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws OperationNotAllowedException, AuthenticationException {
        planner.userLogIn("admin", "admin123");
        planner.createUser(user1.getCredentials(),user1.getPassword());

        assertTrue(planner.getUser(user1.getCredentials())!=null);
    }
    @Test
    public void testInputSetB() throws OperationNotAllowedException, AuthenticationException {
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("Developer is already registered");
        planner.users.add(user1);
        planner.userLogIn("admin","admin123");
        planner.createUser(user1.getCredentials(),user1.getPassword());
    }
    @Test
    public void testInputSetC() throws OperationNotAllowedException, AuthenticationException {
        expectedException.expect(AuthenticationException.class);
        expectedException.expectMessage("Administrator required");
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(), user1.getPassword());
        planner.createUser("newUser", "newPassword");
    }
}
