
import java.util.Calendar;
import java.util.List;


public class Project {

    List<Activity> activities;
    List<Developer> projectDevelopers;
    Developer projectManager;
    private String title;
    private Calendar estimatedStartTime;
    private Calendar estimatedEndTime;
    int estimatedHours;

    public Project(String title, Calendar estimatedStartTime, Calendar estimatedEndTime) {
        setTitle(title);
        setEstimatedStartTime(estimatedStartTime);
        setEstimatedEndTime(estimatedEndTime);
    }

    /**
     *
     * @param developer
     * @throws OperationNotAllowedException
     */
    public void addDeveloper(Developer developer) throws OperationNotAllowedException {

        if (projectManager.equals(Planner.activeUser)) {
            throw new OperationNotAllowedException("You need to have project manager rights");
        } else {
            projectDevelopers.add(developer);
        }

    }

    /**
     *
     * @param activty
     * @throws OperationNotAllowedException
     */
    public void addActivity(Activity activty) throws OperationNotAllowedException {

        if (projectManager.equals(Planner.activeUser)) {
            throw new OperationNotAllowedException("You need to have project manager rights");
        } else {
            activities.add(activty);
        }

    }

    /**
     *
     */
    public void assignManager(){

    }

    // Setters and Getters //


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getEstimatedStartTime() {
        return estimatedStartTime;
    }

    public void setEstimatedStartTime(Calendar estimatedStartTime) {
        this.estimatedStartTime = estimatedStartTime;
    }

    public Calendar getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public void setEstimatedEndTime(Calendar estimatedEndTime) {
        this.estimatedEndTime = estimatedEndTime;
    }

}
