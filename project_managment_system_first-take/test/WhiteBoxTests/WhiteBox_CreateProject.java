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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhiteBox_CreateProject {

    private Planner planner = new Planner();
    private User user1 = new User("u1", "123");
    private Project project1 = new Project("project1", Calendar.getInstance(),Calendar.getInstance());
    private Project project2 = new Project("project2", Calendar.getInstance(),Calendar.getInstance());
    private Project project3 = new Project("project3", Calendar.getInstance(),Calendar.getInstance());

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws OperationNotAllowedException, AuthenticationException {
        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());

        //First check
        assertTrue(planner.projects.isEmpty());

        //action
        planner.createProject(project1);

        //Final check
        assertTrue(planner.getProject(project1.getTitle())!=null);
        }

    @Test
    public void testInputSetB() throws OperationNotAllowedException, AuthenticationException {
        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        planner.createProject(project2);
        planner.createProject(project3);

        //First check
        assertFalse(planner.getProjects().isEmpty());
        assertTrue(planner.getProject(project1.getTitle())==null);

        //action
        planner.createProject(project1);

        //assertionTest
        assertTrue(planner.getProject(project1.getTitle())!=null);
    }
    @Test
    public void testInputSetC() throws OperationNotAllowedException, AuthenticationException {
        //Expected
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("Project is already in the planner");

        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        planner.projects.add(project1);
        planner.projects.add(project2);
        planner.projects.add(project3);

        //First check
        assertTrue(planner.getProject(project1.getTitle())!=null);

        //action
        planner.createProject(project1);
    }

    @Test
    public void testInputSetD() throws OperationNotAllowedException, AuthenticationException {
        //Expected
        expectedException.expect(AuthenticationException.class);
        expectedException.expectMessage("Login required");

        //First check
        assertFalse(planner.activeSession());

        //Action
        planner.createProject(project1);
    }
}
