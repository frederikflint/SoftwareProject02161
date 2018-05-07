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
    public void testInputSetA() throws OperationNotAllowedException, AuthenticationException {
        //Given
        planner.users.add(user1);
        planner.userLogIn(user1.getCredentials(),user1.getPassword());
        user1.addActivity(activity1);

        //First check
        assertFalse(user1.getActivities().isEmpty());


        //Setup
        slutTid.add(Calendar.HOUR_OF_DAY,5);

        try {
            user1.registerTime(activity1, startTid, slutTid, planner.activeUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Final check
        //Checks that 5 hours = 5_HOURS*60_MINUTES/HOUR is registered now.
        assertTrue(activity1.getCurrentTimeSpent()==5*60);

    }
}

