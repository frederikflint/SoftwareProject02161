package acceptance_tests;

import planner.User;

public class UserHelper {
    private User user;

    private User exampleUser(){
        User user = new User("nl", "12345");
        return user;
    }
}