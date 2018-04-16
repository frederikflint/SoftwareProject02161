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
     * You should be able to get associated the project
     * @return
     */
    public Project getProject() {
        return project;
    }

}
