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

public class WhiteBox_AddProjectActivity {

    private Planner planner = new Planner();
    private User user1 = new User("u1", "123");
    private Activity activity1 = new Activity(Calendar.getInstance(), Calendar.getInstance(), "aktivitet1");
    private Project projekt1 = new Project("projekt1", Calendar.getInstance(), Calendar.getInstance());

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws Exception {
        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        planner.createProject(projekt1);

        //First check
        assertTrue(projekt1.getManager().equals(user1));
        assertTrue(projekt1.getActivities().isEmpty());

        //Action
        projekt1.addActivity(activity1,user1);

        //Final check
        assertTrue(projekt1.getActivity(activity1.getTitle())!=null);
    }

    @Test
    public void testInputSetB() throws Exception, OperationNotAllowedException {
        //Expected
        expectedException.expect(OperationNotAllowedException.class);
        expectedException.expectMessage("The activity is already a part of the project");

        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        planner.createProject(projekt1);
        projekt1.activities.add(activity1);

        //First check
        assertTrue(projekt1.getActivity(activity1.getTitle())!=null);

        //Action
        projekt1.addActivity(activity1,user1);
    }

    @Test
    public void testInputSetC() throws Exception, OperationNotAllowedException {
        //Expected
        expectedException.expect(AuthenticationException.class);
        expectedException.expectMessage("You need to have project manager rights to edit this project");

        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        //Add project without connection user to it
        planner.projects.add(projekt1);

        //First check
        assertTrue(user1.getProjects().isEmpty());
        assertTrue(projekt1.getUsers().isEmpty());

        //Action
        projekt1.addActivity(activity1,user1);
    }

}