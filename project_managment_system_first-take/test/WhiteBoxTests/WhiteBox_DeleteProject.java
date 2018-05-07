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


public class WhiteBox_DeleteProject {

    private Planner planner = new Planner();
    private User projectMan = new User("pM", "123");
    private User developer = new User("dV","123");
    private Project project1 = new Project("projekt1",Calendar.getInstance(),Calendar.getInstance());
    private Project project2 = new Project("project2",Calendar.getInstance(),Calendar.getInstance());

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws OperationNotAllowedException, AuthenticationException {
        //Given
        planner.users.add(projectMan);

        planner.userLogIn(projectMan.getCredentials(),projectMan.getPassword());

        planner.createProject(project1);
        planner.createProject(project2);

        //First check
        assertTrue(planner.getProject(project1.getTitle())!=null);
        assertTrue(planner.getProject(project2.getTitle())!=null);
        assertTrue(project1.getManager().equals(projectMan));
        assertFalse(project1.getUsers().isEmpty());

        //Action
        planner.deleteProject(project1);

        //Final check
        assertFalse(planner.getProject(project1.getTitle())!=null);
        assertTrue(planner.getProject(project2.getTitle())!=null);
    }

    @Test
    public void testInputSetB() throws OperationNotAllowedException, AuthenticationException {
        //Expectations
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("No project with the given title was found");

        //Given//
        planner.users.add(projectMan);
        planner.userLogIn(projectMan.getCredentials(),projectMan.getPassword());
        //Have to create project to become manager though it will be removed
        planner.createProject(project1);
        //Here we remove the project again, to get the expected errormessage
        planner.projects.remove(project1);

        //First check
        assertTrue(planner.getProjects().isEmpty());

        //Action
        planner.deleteProject(project1);
    }

    @Test
    public void testInputSetC() throws OperationNotAllowedException, AuthenticationException {
        //Expectations
        expectedException.expect(AuthenticationException.class);
        expectedException.expectMessage("You need to have project manager rights to edit this project");

        //Given//
        planner.users.add(developer);
        planner.userLogIn(developer.getCredentials(),developer.getPassword());
        //Add project without giving the developer manager rights
        planner.projects.add(project1);

        //First check
        assertTrue(planner.getProject(project1.getTitle())!=null);

        //Action
        planner.deleteProject(project1);
    }
}
