
public class Admin extends User {

    public Admin(String credentials, String password) {
        super(credentials, password);
    }

    public void createDeveloper(String credentials, String password) {
        Developer developer = new Developer(credentials, password);
    }

    public void promoteDeveloper() {

    }

    public void demoteDeveloper() {

    }

    public void assignProjectManager() {

    }

    public void removeProjectManager() {

    }

}
