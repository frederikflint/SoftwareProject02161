package planner.domain;

public class Admin extends User {

    boolean isAdmin = true;

    public Admin(String credentials, String password){
        super(credentials,password);
    }

    @Override
    public boolean isAdmin() {
        return isAdmin;
    }
}
