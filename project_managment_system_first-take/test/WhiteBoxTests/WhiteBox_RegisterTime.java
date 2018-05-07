package WhiteBoxTests;

import cucumber.api.java.ca.Cal;
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

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WhiteBox_RegisterTime {

    private Planner planner = new Planner();
    private User notAdmin = new User("notAdmin", "123");
    private User user1 = new User("user1", "123");
    private Calendar startTid = Calendar.getInstance();
    private Calendar slutTid = Calendar.getInstance();
    private Activity activity1 = new Activity(Calendar.getInstance(),Calendar.getInstance(),"aktivitet1");
    private Project projekt1 = new Project("projekt1", Calendar.getInstance(), Calendar.getInstance());

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws Exception {
        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        user1.addActivity(activity1);

        //First check
        assertFalse(user1.getActivities().isEmpty());


        //Setup
        slutTid.add(Calendar.HOUR_OF_DAY,5);

        user1.registerTime(activity1, startTid, slutTid, user1);

        //Final check
        //Checks that 5 hours = 5_HOURS*60_MINUTES/HOUR is registered now.
        assertTrue(activity1.getCurrentTimeSpent()==5*60);
    }

    @Test
    public void testInputSetB() throws AuthenticationException, OperationNotAllowedException{
        //Expected
        expectedException.expect(Exception.class);
        expectedException.expectMessage("The input of time spent is not valid");

        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        user1.addActivity(activity1);

        //First check
        assertFalse(user1.getActivities().isEmpty());

        //Setup
        startTid.add(Calendar.HOUR_OF_DAY,5);

        user1.registerTime(activity1, startTid, slutTid, user1);
    }

    @Test
    public void testInputSetC() throws AuthenticationException, OperationNotAllowedException {
        //Expected
        expectedException.expect(Exception.class);
        expectedException.expectMessage("You are not assigned to this activity");

        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());

        //First check
        assertTrue(user1.getActivities().isEmpty());

        //Setup
        slutTid.add(Calendar.HOUR_OF_DAY,5);

        //Action
        user1.registerTime(activity1,startTid,slutTid,user1);

    }
}

