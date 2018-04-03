import java.util.List;

public class Admin extends User {

    String isAdmin;

    public Admin(String credentials, String password) {
        super(credentials, password);
    }

    public void createDeveloper(String credentials, String password) {
        Developer developer = new Developer(credentials, password);
    }

    public List<Project> getProjects(){
        return Planner.projects;
    }

    public void assignProjectManager() {
    }

    public void removeProjectManager() {

    }

}
