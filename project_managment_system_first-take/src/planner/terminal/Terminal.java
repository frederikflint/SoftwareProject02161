package planner.terminal;

import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.Activity;
import planner.domain.Project;
import planner.domain.User;

import java.util.Calendar;
import java.util.Scanner;

public class Terminal {

    //Terminal terminal;
    Planner planner = new Planner();
    Scanner input = new Scanner(System.in);

    String month = "";
    String day = "";
    String hour = "";
    String minute = "";

    public static void main(String[] args){
        Terminal terminal = new Terminal();
        terminal.fakeSetup();
        terminal.startPrompt();
    }

    private void fakeSetup(){
        /**
         * FAKE data for the planner
         */
        planner.users.add(new User("test","test"));
        planner.projects.add(new Project("projekt", null,null));
    }

    private void startPrompt() {
        System.out.println("Velkommen til SoftwareHuset A/S. Vælg venligst en funktion:");
        logIn();
    }

    private void logIn() {
        System.out.println("Log ind");
        System.out.println("Indtast brugernavn:");
        String username = input.nextLine();
        System.out.println("Indtast password:");
        String password = input.nextLine();
        try {
            planner.userLogIn(username,password);

            if(planner.activeUser.isAdmin()){
                adminFeatureScreen();
            } else {
                userFeatureScreen();
            }

        } catch (OperationNotAllowedException | AuthenticationException e) {
            System.out.println(e.getMessage());
            startPrompt();
        }

    }

    private void adminFeatureScreen(){
        System.out.println("Indtast et nummer:");
        System.out.println("1: Bruger liste");
        System.out.println("2: Projekt liste");
        System.out.println("3: Registrer bruger");
        System.out.println("4: Slet bruger");
        System.out.println("5: Forfrem bruger til projekt manager");
        System.out.println("6: Fjern projekt manager titel");
        System.out.println("7: Log ud");
        String in = input.nextLine();

        if (in.equals("1")){
            getPlannerUserList();
        } else if (in.equals("2")) {
            getPlannerProjectList();
        }else if (in.equals("3")){
            registerUser();
        } else if (in.equals("4")) {
            unregisterUser();
        } else if (in.equals("5")) {
            assignProjectManager();
        } else if (in.equals("6")) {
            removeProjectManager();
        } else if (in.equals("7")) {
            try {
                planner.userLogOut();
                startPrompt();
            }catch (OperationNotAllowedException e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Dit input matcher ikke mulighederne");
            adminFeatureScreen();
        }

    }

    private void userFeatureScreen() {
        System.out.println("Indtast et nummer:");
        System.out.println("1: Registrer tid");
        System.out.println("2: Opret projekt");
        System.out.println("3: Opret aktivitet");
        System.out.println("4: Log ud");
        String in = input.nextLine();

        if (in.equals("1")){
            registerTime();
        } else if (in.equals("2")) {
            createProject();
        } else if (in.equals("3")) {
            createActivity();
        } else if (in.equals("4")) {
            try {
                planner.userLogOut();
                startPrompt();
            } catch (OperationNotAllowedException e) {
                System.out.println(e.getMessage());
                userFeatureScreen();
            }
        } else {
            System.out.println("Ikke godt nok");
            userFeatureScreen();
        }
    }

    private void registerUser() {
        System.out.println("-1 for at gå tilbage");
        System.out.println("Hvad skal dit brugernavn være?");
        String username = input.nextLine();

        if (username.equals("-1")) {
            adminFeatureScreen();
        }

        System.out.println("Hvad skal dit password være?");
        String password = input.nextLine();

        try {
            planner.createUser(username,password);
            System.out.println("Brugeren " + username + " er nu registeret");
        } catch (OperationNotAllowedException | AuthenticationException e) {
            System.out.println(e.getMessage());
            registerUser();
        }
        adminFeatureScreen();
    }

    private void getPlannerUserList(){

        if(planner.getUsers().isEmpty()){
            System.out.println("Ingen registrerede brugere på systemt");
            adminFeatureScreen();
        }

        System.out.println("Registrerede brugere: ");
        for (User user: planner.getUsers()) {
            System.out.println(user.getCredentials());
        }

        adminFeatureScreen();
    }

    private void getPlannerProjectList(){
        if(planner.getUsers().isEmpty()){
            System.out.println("Ingen registrerede projekter på systemt");
            adminFeatureScreen();
        }

        System.out.println("Registrerede projekter: ");
        for (Project project: planner.getProjects()) {
            System.out.println(project.getTitle());
        }

        adminFeatureScreen();
    }

    private void unregisterUser(){

        if(planner.getUsers().isEmpty()){
            System.out.println("Ingen registrerede brugere på systemt");
            adminFeatureScreen();
        }

        System.out.println("-1 for at gå tilbage");
        System.out.println("Registrerede brugere: ");
        for (User user: planner.getUsers()) {
            System.out.println(user.getCredentials());
        }
        System.out.println("Skriv brugernavnet på den bruger du vil have slettet");

        User user = setUser();

        try {
            planner.deleteUser(user);
            System.out.println("Brugeren " + user.getCredentials() + " er nu slettet fra systemet");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        adminFeatureScreen();

    }

    private User setUser(){

        String in = input.nextLine();
        User user = planner.getUser(in);

        System.out.println("-1 for at gå tilbage");
        if (in.equals("-1")) {
            userFeatureScreen();
        }

        if(user == null){
            System.out.println("Brugeren " + in + " findes ikke på systemet");
            System.out.println("Prøv igen");
            return setUser();
        } else {
            return user;
        }

    }

    private Project setProject(){

        String in = input.nextLine();
        Project project = null;

        try {
            project = planner.getProject(in);
        }catch (Exception e){

        }

        System.out.println("-1 for at gå tilbage");
        if (in.equals("-1")) {
            userFeatureScreen();
        }

        if(project == null){
            System.out.println("Brugeren " + in + " findes ikke på systemet");
            System.out.println("Prøv igen");
            return setProject();
        } else {
            return project;
        }

    }

    private void assignProjectManager(){
        if(planner.getUsers().isEmpty()){
            System.out.println("Ingen registrerede brugere på systemt");
            adminFeatureScreen();
        }

        if(planner.getProjects().isEmpty()){
            System.out.println("Ingen registrerede projekter på systemt");
            adminFeatureScreen();
        }

        System.out.println("Registrerede brugere: ");
        for (User user: planner.getUsers()) {
            System.out.println(user.getCredentials());
        }
        System.out.println("Skriv brugernavnet på den bruger du vil have forfremmet");
        User user = setUser();

        System.out.println("Registrerede projekter: ");
        for (Project project: planner.getProjects()) {
            System.out.println(project.getTitle());
        }

        System.out.println("Skriv navnet på det projekt du vil have " + user.getCredentials() + " forfremmet i");
        Project project = setProject();

        try {
            planner.assignProjectManager(user, project);
            System.out.println("Brugeren " + user.getCredentials() + " er nu manager for projektet " + project.getTitle());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        adminFeatureScreen();
    }

    private void removeProjectManager(){
        if(planner.getProjects().isEmpty()){
            System.out.println("Ingen registrerede projekter på systemt");
            adminFeatureScreen();
        }

        System.out.println("Registrerede projekter: ");
        for (Project project: planner.getProjects()) {
            System.out.println(project.getTitle());
        }

        System.out.println("Skriv navnet på det projekt hvor du vil fjerne manageren");
        Project project = setProject();

        try {
            planner.removeProjectManager(project);
            System.out.println("Manageren fra " + project.getTitle() + " er nu fjernet");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        adminFeatureScreen();
    }

    private void createActivity() {
        System.out.println("-1 for at gå tilbage");
        System.out.println("Opretter aktivitet...");
        System.out.println("Indtast titel:");
        String titel = input.nextLine();
        if (titel.equals("-1")) {
            userFeatureScreen();
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Kendes start tidspunkt? Ja: 1, Nej: 2");
        String x = input.nextLine();
        if (x.equals("1")){
            setMonthAndDay();
            start.set(2018,Integer.parseInt(month),Integer.parseInt(day));
        } else if (x.equals("2")) {
            //TODO: Create activity i planner ????
            try {
                planner.getActiveUser().addActivity(new Activity(start, end, titel));
            } catch (OperationNotAllowedException e) {
                System.out.println(e.getMessage());
                createActivity();
            }
        } else {
            System.out.println("Forkerte information - prøv igen");
            createActivity();
        }
    }

    private void setMonthAndDay() {
        System.out.println("Indtast måned:");
        //System.out.println("Indtast -1 for at gå tilbage");
        System.out.println(" 0: Januar \n 1: Februar \n 2: Marts \n 3: April \n 4: Maj \n 5: Juni \n 6: Juli \n" +
                " 7: August \n 8: September \n 9: Oktober \n 10: November \n 11: December");
        month = input.nextLine();
        if (month.equals("-1")) {
            userFeatureScreen();
        } else if (month.matches("0|1|2|3|4|5|6|7|8|9|10|11")) {
            System.out.println("Hvilken dag i måneden?");
            System.out.println("0 - 30");
            day = input.nextLine();
            if (!day.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30")) {
                System.out.println("Prøv igen");
                setMonthAndDay();
            }
        } else {
            System.out.println("Prøv igen");
            setMonthAndDay();
        }

    }

    private void createProject() {
        System.out.println("-1 for at gå tilbage");
        System.out.println("Opretter projekt...");
        System.out.println("Indtast titel:");
        String titel = input.nextLine();
        if (titel.equals("-1")) {
            userFeatureScreen();
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Kendes start tidspunkt? Ja: 1, Nej: 2");
        String x = input.nextLine();
        if (x.equals("1")){
            setMonthAndDay();
            start.set(2018,Integer.parseInt(month),Integer.parseInt(day));
            try {
                planner.createProject(new Project(titel,start,end));
                userFeatureScreen();
            }catch (Exception e){
                System.out.println(e.getMessage());
                createProject();
            }
        } else if (x.equals("2")) {
            try {
                planner.createProject(new Project(titel,start,end));
                userFeatureScreen();
            } catch (OperationNotAllowedException | AuthenticationException e) {
                System.out.println(e.getMessage());
                createProject();
            }
        } else {
            System.out.println("Forkerte information - prøv igen");
            createProject();
        }

    }

    private void registerTime() {
        System.out.println("-1 for at gå tilbage");
        System.out.println("Registrer tid på en aktivitet. Indtast et titel på aktiviteten:");
        for (Activity activity : planner.getActiveUser().getActivities()) {
            System.out.println(activity.getID());
        }
        String ID = input.nextLine();
        if (ID.equals("-1")) {
            userFeatureScreen();
        }
        Activity activity;
        try {
            activity = planner.getActivity(ID);
            registerTimeStepTwo(activity);
        } catch (OperationNotAllowedException e) {
            System.out.println(e.getMessage());
            registerTime();
        }
    }

    private void registerTimeStepTwo(Activity activity) {
        System.out.println("Registrerer tid til aktiviteten " + activity.getID());
        System.out.println("Hvornår startede du?");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        setMonthAndDay();
        start.set(2018,Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
        System.out.println("Hvornår sluttede du aktiviteten?");
        setMonthAndDay();
        setHourAndMinute();
        end.set(2018,Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
        try {
            planner.getActiveUser().registerTime(activity, start, end, planner.getActiveUser());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }

    public void setHourAndMinute(){
        System.out.println("Indtast time på dagen (0-23):");
        System.out.println("Indtast -1 for at gå tilbage");
        hour = input.nextLine();

        if (hour.equals("-1")) {
            userFeatureScreen();
        } else if (hour.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23")) {
            System.out.println("Hvilket minut i timen?");
            System.out.println("0 - 59");
            day = input.nextLine();
            if (!day.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59")) {
                System.out.println("Prøv igen");
                setHourAndMinute();
            }
        } else {
            System.out.println("Prøv igen");
            setHourAndMinute();
        }
    }

}
