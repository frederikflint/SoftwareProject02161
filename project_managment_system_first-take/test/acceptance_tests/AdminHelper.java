package acceptance_tests;
import planner.domain.User;

public class AdminHelper {
    private User user;

    public User getAdmin() {
        if (user == null) {
            user = exampleAdmin();
        }
        return user;
    }

    private User exampleAdmin(){
        User user = new User("admin", "admin123");
        return user;
    }

}
