package WhiteBoxTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.Activity;
import planner.domain.Project;
import planner.domain.User;

import java.util.Calendar;

import static junit.framework.TestCase.assertTrue;

public class WhiteBox_AddActivity {

    private Planner planner = new Planner();
    private User projectMan = new User("dv","123");
    private User developer = new User("u1", "123");
    private Activity activity1 = new Activity(Calendar.getInstance(), Calendar.getInstance(), "aktivitet1");
    private Project project1 = new Project("project1", Calendar.getInstance(), Calendar.getInstance());

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws Exception {
        //Given
        planner.users.add(projectMan);
        planner.userLogIn(projectMan.getCredentials(), projectMan.getPassword());
        planner.createProject(project1);

        //First check
        assertTrue(project1.getManager().equals(projectMan));
        assertTrue(project1.getActivity(activity1.getTitle())==null);

        //Action
        project1.addActivity(activity1, projectMan);

        //Final check
        assertTrue(project1.getActivity(activity1.getTitle())!=null);
    }

    @Test
    public void testInputSetB() throws Exception, OperationNotAllowedException {
        //Expected
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("The activity is already a part of the project");

        //Given
        planner.users.add(projectMan);
        planner.userLogIn(projectMan.getCredentials(), projectMan.getPassword());
        planner.createProject(project1);
        project1.activities.add(activity1);

        //First check
        assertTrue(project1.getActivity(activity1.getTitle())!=null);

        //Action
        project1.addActivity(activity1, projectMan);
    }

    @Test
    public void testInputSetC() throws Exception, OperationNotAllowedException {
        //Expected
        expectedException.expect(AuthenticationException.class);
        expectedException.expectMessage("You need to have project manager rights to edit this project");

        //Given
        planner.users.add(developer);
        planner.userLogIn(developer.getCredentials(), developer.getPassword());
        //Add project without connection user to it
        planner.projects.add(project1);

        //First check
        assertTrue(developer.getProjects().isEmpty());
        assertTrue(project1.getUsers().isEmpty());

        //Action
        project1.addActivity(activity1, developer);
    }

}