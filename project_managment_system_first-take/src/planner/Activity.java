package planner;

import java.util.List;

public class Activity {

    List<Developer> developers;
    private Project project;
    int estimatedTimeSpent;
    int currentTimeSpent;

    public Activity(Project project) {
        this.project = project;
    }

    /**
     * Get the associated the project
     * @return
     */
    public Project getProject() {
        return project;
    }

}
