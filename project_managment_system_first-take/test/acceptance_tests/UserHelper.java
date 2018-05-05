package acceptance_tests;

import planner.domain.User;

public class UserHelper {
    private User user;

    public User getUser() {
        user = exampleUser();
        return user;
    }

    private User exampleUser(){
        User user = new User("nl", "12345");
        return user;
    }
}