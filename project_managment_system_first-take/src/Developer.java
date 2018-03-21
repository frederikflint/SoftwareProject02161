import java.util.List;

public class Developer extends User {

    List<Activity> devActivities;
    List<Project> devProjects;
    List<WorkHours> workHours;

    public Developer (String credentials, String password) {
        super(credentials, password);
    }

    public void registerTime() {

    }

    public void createProject() {

    }

}
