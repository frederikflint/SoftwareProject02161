package WhiteBoxTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.Activity;
import planner.domain.User;

import java.util.Calendar;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WhiteBox_RegisterTime {

    private Planner planner = new Planner();
    private User developer = new User("u1", "123");
    private Calendar startTime = Calendar.getInstance();
    private Calendar endTime = Calendar.getInstance();
    private Activity activity1 = new Activity(Calendar.getInstance(),Calendar.getInstance(),"aktivitet1");

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testInputSetA() throws Exception {
        //Given
        planner.users.add(developer);
        planner.userLogIn(developer.getCredentials(), developer.getPassword());
        developer.addActivity(activity1);

        //First check
        assertFalse(developer.getActivities().isEmpty());


        //Setup
        endTime.add(Calendar.HOUR_OF_DAY,5);

        developer.registerTime(activity1, startTime, endTime, developer);

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
        planner.users.add(developer);
        planner.userLogIn(developer.getCredentials(), developer.getPassword());
        developer.addActivity(activity1);

        //First check
        assertFalse(developer.getActivities().isEmpty());

        //Setup
        startTime.add(Calendar.HOUR_OF_DAY,5);

        developer.registerTime(activity1, startTime, endTime, developer);
    }

    @Test
    public void testInputSetC() throws AuthenticationException, OperationNotAllowedException {
        //Expected
        expectedException.expect(Exception.class);
        expectedException.expectMessage("You are not assigned to this activity");

        //Given
        planner.users.add(developer);
        planner.userLogIn(developer.getCredentials(), developer.getPassword());

        //First check
        assertTrue(developer.getActivities().isEmpty());

        //Setup
        endTime.add(Calendar.HOUR_OF_DAY,5);

        //Action
        developer.registerTime(activity1, startTime, endTime, developer);

    }
}

