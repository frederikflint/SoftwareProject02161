import java.util.List;

public class Planner {

    public static Developer activeUser;
    public static List<Developer> developers;
    public static List<Project> projects;

    public void logIn(String credentials, String passeword){
        System.out.print(developers);
    }

    public void logOut(){
        activeUser = null;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    // Setters and getters //

    public static void setActiveUser(Developer activeUser) {
        Planner.activeUser = activeUser;
    }
}
