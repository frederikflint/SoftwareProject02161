package planner.domain;

import java.util.List;

public class Activity {

    List<Developer> developers;
    private Project project;
    int estimatedTimeSpent;
    int currentTimeSpent;

    public Activity(Project project) {
        this.project = project;
    }

    /**************************
     *  Setters and getters   *
     **************************/

    public Project getProject() {
        return project;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }
}
