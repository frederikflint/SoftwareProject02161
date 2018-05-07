package planner.domain;

import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;

import javax.swing.plaf.OptionPaneUI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * This is the a user of the system.
 */
public class User {

    // User identifiers (account)
    private String credentials;
    private String password;

    // Is the user a adminHelper of the system
    protected Boolean isAdmin = false;

    // The projects the user are managing
    private List<Project> managerProjects = new ArrayList<>();

    // User activities
    private List<Activity> activities = new ArrayList<Activity>();

    // User Projects
    private List<Project> projects = new ArrayList<Project>();

    // Registered working time
    private List<WorkHours> workHours = new ArrayList<WorkHours>();


    public User (String credentials, String password) {
        setCredentials(credentials);
        setPassword(password);
    }

    /**
     * Add activity to users personal activities.
     * @param activity
     */
    public void addActivity(Activity activity) throws OperationNotAllowedException {
        if(activities.contains(activity)){
            throw new OperationNotAllowedException("The activity is already created");
        } else {
            activities.add(activity);
        }
    }

    /**
     * Remove a given activity from the user
     * @param activity
     */
    public void removeActivity(Activity activity) throws OperationNotAllowedException{
        if(!(activities.contains(activity))){
            throw new OperationNotAllowedException("This activity is not in your personal activities");
        } else {
            activities.remove(activity);
        }
    }


    /**
     * Register time used on an activity.
     * @param activity
     * @param startTime
     * @param endTime
     */

    public void registerTime(Activity activity, Calendar startTime, Calendar endTime, User user) throws
            AuthenticationException, OperationNotAllowedException  {
        if(!user.getActivities().contains(activity)) {                                            //1
            throw new AuthenticationException("You are not assigned to this activity");
        } else if(endTime.before(startTime) ||
                (endTime.get(Calendar.DAY_OF_YEAR) - startTime.get(Calendar.DAY_OF_YEAR) > 30)){  //2
            throw new OperationNotAllowedException("The input of time spent is not valid");
        } else {
            WorkHours workHour = new WorkHours(activity, startTime, endTime);
            workHours.add(workHour);
            activity.registerActivityTime(workHour.getWorkTimeInMinutes());
        }
    }

    /**
     * Remove registered time.
     * @param timeRegistration
     * @throws OperationNotAllowedException
     */
    public void removeRegistedTime(WorkHours timeRegistration) throws OperationNotAllowedException {
        if(!(workHours.contains(timeRegistration))){
            throw new OperationNotAllowedException("The time registration is not in your personal register");
        } else {
            activities.remove(timeRegistration);
        }
    }

    /**
     * Add a project to the user.
     * @param project
     * @throws OperationNotAllowedException The project is a part of the user.
     */
    public void addProject(Project project) throws OperationNotAllowedException {
        if(projects.contains(project)){
            throw new OperationNotAllowedException("The project is already in the users project list");
        } else {
            projects.add(project);
        }
    }

    public void addManageProject(Project project){
        managerProjects.add(project);
    }

    /**
     * Remove a project from the user.
     * @param project
     * @throws OperationNotAllowedException The project is not a part of the user.
     */
    public void removeProject(Project project) throws OperationNotAllowedException {
        if(!(projects.contains(project))){
            throw new OperationNotAllowedException("The project you are trying to remove is not in the project list");
        } else {
            projects.remove(project);
        }
    }

    public void removeManagerProject(Project project){
        managerProjects.remove(project);
    }

    // TODO: Skal forbedres til terminal-udgave...
    public List<Activity> showActivities() throws Exception {
        if (activities.isEmpty()) {
            throw new Exception("You are assigned to no activities");
        } else {
            return activities;
        }
    }

    /**************************
     *  Setters and getters   *
     **************************/

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Project> getManagerProjects() {
        return managerProjects;
    }

    public List<WorkHours> getWorkHours() {
        return workHours;
    }

    public Boolean isAdmin() {
        return isAdmin;
    }

}
