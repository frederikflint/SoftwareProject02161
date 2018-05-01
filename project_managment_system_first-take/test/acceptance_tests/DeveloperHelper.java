package acceptance_tests;

import planner.domian.Developer;
import planner.domian.User;

public class DeveloperHelper {
    private Developer developer;

    public User getUser() {
        if (developer == null) {
            developer = exampleDevloper();
        }
        return developer;
    }

    private Developer exampleDevloper(){
        Developer developer = new Developer("nl", "12345");
        return developer;
    }
}