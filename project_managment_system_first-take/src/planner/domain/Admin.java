package planner.domain;

public class Admin extends User {

    public Admin(String credentials, String password){
        super(credentials,password);
        isAdmin = true;
    }

}
