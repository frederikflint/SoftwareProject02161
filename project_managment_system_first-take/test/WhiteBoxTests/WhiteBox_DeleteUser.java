package WhiteBoxTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.Project;
import planner.domain.User;

import java.util.Calendar;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WhiteBox_DeleteUser {

    private Planner planner = new Planner();
    private User notAdmin = new User("notAdmin","123");
    private User user1 = new User("user1", "123");
    private Project projekt1 = new Project("projekt1",Calendar.getInstance(),Calendar.getInstance());

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws OperationNotAllowedException, AuthenticationException {
        //Given
        planner.userLogIn("admin","admin123");
        planner.users.add(user1);
        planner.projects.add(projekt1);
        projekt1.addUser(user1);
        user1.addProject(projekt1);

        //First check
        assertFalse(planner.getUser(user1.getCredentials())==null);
        assertFalse(planner.getProject(projekt1.getTitle())==null);
        assertFalse(projekt1.getUser(user1.getCredentials())==null);
        assertFalse(user1.getProjects().isEmpty());

        //Action
        planner.deleteUser(user1);

        //Final check
        assertTrue(planner.getUser(user1.getCredentials())==null);
        assertFalse(planner.getProject(projekt1.getTitle())==null);
        assertTrue(projekt1.getUser(user1.getCredentials())==null);
    }

    @Test
    public void testInputSetB()throws  OperationNotAllowedException, AuthenticationException{
        //Expectations
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("No such user is defined in the system");
        //Given
        planner.userLogIn("admin","admin123");

        //First check
        assertTrue(planner.getUser(user1.getCredentials())==null);

        //Action
        planner.deleteUser(user1);

    }

    @Test
    public void testInputSetC()throws  OperationNotAllowedException, AuthenticationException{
        //Expectations
        expectedException.expect(AuthenticationException.class);
        expectedException.expectMessage("Administrator required");

        //Given
        planner.users.add(notAdmin);
        planner.userLogIn(notAdmin.getCredentials(),notAdmin.getPassword());
        planner.users.add(user1);

        //First check
        assertTrue(planner.getUser(user1.getCredentials())!=null);

        //Action
        planner.deleteUser(user1);
    }
}
