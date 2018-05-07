package planner.terminal;

import planner.app.AuthenticationException;
import planner.app.OperationNotAllowedException;
import planner.app.Planner;
import planner.domain.Activity;
import planner.domain.Project;
import planner.domain.User;
import planner.domain.WorkHours;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Terminal {

    //Terminal terminal;
    Planner planner = new Planner();
    Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.##");


    String month = "";
    String day = "";
    String hour = "";
    String minute = "";

    public static void main(String[] args){
        Terminal terminal = new Terminal();
        terminal.fakeSetup();
        terminal.startPrompt();
    }


    /***************
     *  FAKE DATA  *
     ***************/
    private void fakeSetup(){
        /**
         * FAKE data for the planner
         */

        System.out.println("Fake manager: credentials: manager, Pass: 123");
        System.out.println("----------------------------------------");
        System.out.println("Fake users: credentials: user1..5, Pass: 123");
        System.out.println("----------------------------------------");
        User managerUser = new User("manager","123");
        Project project = new Project("projekt", null,null);


        // FAKE DATA
        for (int i = 1; i <= 5; i++){
            planner.users.add(new User("user" + (i),"123"));
        }

        planner.users.add(managerUser);

        // Create project
        try {
            planner.userLogIn("manager","123");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            planner.createProject(project);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            planner.userLogOut();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /******************
     * Terminal setup *
     ******************/

    private void startPrompt() {
        System.out.println("Velkommen til SoftwareHuset A/S.");
        logIn();
    }

    private void logIn() {
        System.out.println("Log venligst ind");
        System.out.println("Indtast brugernavn:");
        String username = input.nextLine();
        System.out.println("Indtast password:");
        String password = input.nextLine();
        try {
            planner.userLogIn(username,password);

            if(planner.activeUser.isAdmin()){
                System.out.println("Velkommen til systemets kontrolpanel");
                adminFeatureScreen();
            } else {
                System.out.println("Velkommen " + planner.activeUser.getCredentials());
                userFeatureScreen();
            }

        } catch (OperationNotAllowedException | AuthenticationException e) {
            System.out.println(e.getMessage());
            startPrompt();
        }

    }

    /***********
     * Setters *
     ***********/

    private User setUser(){

        String in = input.nextLine();
        User user = planner.getUser(in);

        if(user == null){
            System.out.println("Brugeren " + "\"" + in + "\"" + " findes ikke på systemet");
            System.out.println("Prøv igen");
            return setUser();
        } else {
            return user;
        }

    }

    private Activity setProjectActivity(Project project){

        String in = input.nextLine();
        Activity activity = project.getActivity(in);

        if(activity == null){
            System.out.println("Aktiviteten " + "\"" + in + "\"" + " findes ikke på projektet " + "\"" + project.getTitle() + "\"" );
            System.out.println("Prøv igen");
            return setProjectActivity(project);
        } else {
            return activity;
        }

    }

    private Project setProject(){

        System.out.println("-1 for at gå tilbage");
        String in = input.nextLine();
        Project project = null;

        try {
            project = planner.getProject(in);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if (in.equals("-1")) {
            userFeatureScreen();
        }

        if(project == null){
            System.out.println("Projektet " + "\"" + in + "\"" + " findes ikke på systemet");
            System.out.println("Prøv igen");
            return setProject();
        } else {
            return project;
        }

    }

    /******************
     * Admin Features *
     ******************/

    private void adminFeatureScreen(){
        System.out.println("Indtast et nummer:");
        System.out.println("1: Bruger liste");
        System.out.println("2: Projekt liste");
        System.out.println("3: Registrer bruger");
        System.out.println("4: Slet bruger");
        System.out.println("5: Log ud");
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

    private void getPlannerUserList(){

        if(planner.getUsers().isEmpty()){
            System.out.println("Ingen registrerede brugere på systemt");
            adminFeatureScreen();
        }

        System.out.println("Registrerede brugere: ");
        for (User user: planner.getUsers()) {
            System.out.println("- " + user.getCredentials());
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
            System.out.println("- " + project.getTitle());
        }
        adminFeatureScreen();
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
            System.out.println("Brugeren " + "\"" + username + "\"" + " er nu registreret");
        } catch (OperationNotAllowedException | AuthenticationException e) {
            System.out.println(e.getMessage());
            registerUser();
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
            System.out.println("- " + user.getCredentials());
        }

        System.out.println("Skriv brugernavnet på den bruger du vil have slettet");
        User user = setUser();

        System.out.println("Er du sikker på du vil slette brugeren " + "\"" + user.getCredentials()+ "\"? Ja: j, Nej: n");
        String in = input.nextLine();

        if(in.equals("n")){
            adminFeatureScreen();
        }

        try {
            planner.deleteUser(user);
            System.out.println("Brugeren " + "\"" + user.getCredentials()+ "\""  + " er nu slettet fra systemet");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        adminFeatureScreen();

    }

    /*****************
     * User Features *
     *****************/

    private void userFeatureScreen() {
        System.out.println("Indtast et nummer:");
        System.out.println("1: Registrer tid");
        System.out.println("2: Se registreret tid");
        System.out.println("3: Se aktiviteter");
        System.out.println("4: Se projekter");
        System.out.println("5: Opret en aktivitet");
        System.out.println("6: Opret et projekt");
        System.out.println("7: Fjern en aktivitet");
        System.out.println("8: Manager kontrolpanel");
        System.out.println("9: Log ud");
        String in = input.nextLine();

        if (in.equals("1")){
            registerTime();
        } else if (in.equals("2")){
            getRegisteredTime();
        } else if (in.equals("3")){
            getActivities();
        } else if (in.equals("4")){
            getProjects();
        }else if (in.equals("5")) {
            createActivity();
        } else if (in.equals("6")) {
            createProject();
        } else if (in.equals("7")) {
            removeActivity();
        }else if (in.equals("8")) {
            if(planner.activeUser.getManagerProjects().isEmpty()){
                System.out.println("Du er ikke manager for nogen projekter");
                userFeatureScreen();
            } else {
                System.out.println("Dit manager panel");
                managerFeatureScreen();
            }
        } else if (in.equals("9")) {
            try {
                planner.userLogOut();
                startPrompt();
            } catch (OperationNotAllowedException e) {
                System.out.println(e.getMessage());
                userFeatureScreen();
            }
        } else {
            System.out.println("Dit input matcher ikke mulighederne");
            userFeatureScreen();
        }
    }

    private void registerTime() {

        if(planner.getActiveUser().getActivities().size() == 0){
            System.out.println("Du har igen aktiviteter og registere tid for");
            userFeatureScreen();
        }

        System.out.println("-1 for at gå tilbage");
        System.out.println("Registrer tid på en aktivitet.");
        for (Activity activity : planner.getActiveUser().getActivities()) {
            System.out.println("- " + activity.getID());
        }

        System.out.println("Indtast titlen på den aktivitet du vil registrere");

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

    private void getRegisteredTime() {

        if(planner.getActiveUser().getWorkHours().size() == 0){
            System.out.println("Du har ikke registreret tid for nogen aktiviteter");
            userFeatureScreen();
        }

        System.out.println("Du har registreret tid på følgende aktiviteter: " );
        User activeUser = planner.getActiveUser();
        for (WorkHours work: activeUser.getWorkHours()) {
            System.out.println("- Aktivitet: " + work.getActivity().getTitle() +
                               ", Tidsforbrug: " + df.format((double) work.getWorkTimeInMinutes() / 60.0) + " timer");
        }
        userFeatureScreen();
    }

    private void getActivities(){

        if(planner.getActiveUser().getActivities().size() == 0){
            System.out.println("Du har ingen aktiviteter");
            userFeatureScreen();
        }

        User activeUser = planner.getActiveUser();

        System.out.println("Du har følgende aktiviteter:  ");
        for (Activity activity: activeUser.getActivities()) {
            System.out.println("- " + activity.getTitle());
        }

        userFeatureScreen();
    }

    private void getProjects(){

        if(planner.activeUser.getProjects().size() == 0){
            System.out.println("Du er ikke tilknyttet nogen projekter");
            userFeatureScreen();
        }

        User activeUser = planner.getActiveUser();

        System.out.println("Du er tilknyttet følgende projekter:  ");
        for (Project project: activeUser.getProjects()) {
            System.out.println("- " + project.getTitle());
        }

        userFeatureScreen();
    }

    private void createProject() {
        System.out.println("-1 for at gå tilbage");
        System.out.println("Opretter projekt...");
        System.out.println("Indtast navn på projektet:");
        String titel = input.nextLine();
        if (titel.equals("-1")) {
            userFeatureScreen();
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Kendes starttidspunkt på projektet? Ja: j, Nej: n");
        String x = input.nextLine();
        if (x.equals("j")){
            setMonthAndDay();
            start.set(2018,Integer.parseInt(month),Integer.parseInt(day));
            try {
                planner.createProject(new Project(titel,start,end));
                userFeatureScreen();
            }catch (Exception e){
                System.out.println(e.getMessage());
                createProject();
            }
        } else if (x.equals("n")) {
            try {
                planner.createProject(new Project(titel,null,null));
                userFeatureScreen();
            } catch (OperationNotAllowedException | AuthenticationException e) {
                System.out.println(e.getMessage());
                createProject();
            }
        } else {
            System.out.println("Indtast 'j' for Ja og 'n' for Nej  - prøv igen");
            createProject();
        }
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
        System.out.println("Kendes start tidspunkt? Ja: j, Nej: n");
        String x = input.nextLine();
        if (x.equals("j")){
            setMonthAndDay();
            start.set(2018,Integer.parseInt(month),Integer.parseInt(day));
        } else if (x.equals("n")) {
        } else {
            System.out.println("Forkerte information - prøv igen");
            createActivity();
        }
        try {
            Activity activity = new Activity(start, end, titel);
            planner.getActiveUser().addActivity(activity);
            System.out.println("Aktiviteten " + "\"" +  activity.getTitle() + "\" er nu tilføjet til din liste");
            userFeatureScreen();
        } catch (OperationNotAllowedException e) {
            System.out.println(e.getMessage());
            createActivity();
        }
    }

    private void removeActivity() {

        if(planner.getActiveUser().getActivities().size() == 0){
            System.out.println("Du har ingen aktiviteter");
            userFeatureScreen();
        }

        User activeUser = planner.getActiveUser();

        System.out.println("Du har følgende aktiviteter:  ");
        for (Activity activity: activeUser.getActivities()) {
            System.out.println((activeUser.getActivities().indexOf(activity)+1) + ": " + activity.getTitle());
        }

        System.out.println("Indtast nummeret på den aktivitet du vil fjerne");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            removeProject();
        }

        Activity activity = null;

        try {
            activity = activeUser.getActivities().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            removeProject();
        }

        System.out.println("Er du sikker på du vil slette aktiviteten " + "\"" + activity.getTitle()+ "\"? Ja: j, Nej: n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            activeUser.removeActivity(activity);
            System.out.println("Aktiviteten " + "\"" +  activity.getTitle() + "\"" + " er nu fjernet fra dine aktiviteter" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        userFeatureScreen();
    }

    /********************
     * Manager Features *
     ********************/

    private void managerFeatureScreen(){
        System.out.println("Indtast et nummer:");
        System.out.println("1: Se dine manager projekter");
        System.out.println("2: Se brugere tilknyttet til et projekt");
        System.out.println("3: Se aktiviteter tilknyttet til et projekt");
        System.out.println("4: Se aktiviteter tilknyttet en bruger af et projekt");
        System.out.println("5: Se ledige brugere");
        System.out.println("6: Opret en aktivitet til et projekt");
        System.out.println("7: Tilføj en aktivitet til en bruger af et projekt");
        System.out.println("8: Tilføj en bruger til et projekt");
        System.out.println("9: Skift manager for et af dine projekter");
        System.out.println("10: Fjern en bruger fra et projekt");
        System.out.println("11: Fjern en aktivitet fra et projekt");
        System.out.println("12: Slet et projekt");
        System.out.println("13: Tilbage");
        String in = input.nextLine();

        if (in.equals("1")){
            getManageProjectList();
        } else if (in.equals("2")) {
            getManageProjectUserList();
        } else if (in.equals("3")) {
            getManageProjectActivityList();
        } else if (in.equals("4")) {
            getManageProjectUserActivityList();
        } else if (in.equals("5")){
            getAvailableUsers();
        } else if (in.equals("6")){
            createActivityToProject();
        } else if (in.equals("7")){
            assignUserToActivity();
        } else if (in.equals("8")){
            assignUserToProject();
        } else if (in.equals("9")){
            changeProjectManager();
        } else if (in.equals("10")){
            removeUserFromProject();
        } else if (in.equals("11")){
            removeActivityFromProject();
        } else if (in.equals("12")){
            removeProject();
        } else if(in.equals("13")){
            userFeatureScreen();
        } else {
            System.out.println("Dit input matcher ikke mulighederne");
            managerFeatureScreen();
        }
    }

    private void getManageProjectList(){

        System.out.println("Du er manager af følgende projekter:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println("- " + project.getTitle());
        }
        managerFeatureScreen();
    }

    private void getManageProjectUserList(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Vælg et af følgende projekter:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du ønsker at se tilknyttede brugere");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            getManageProjectUserList();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            getManageProjectUserList();
        }

        System.out.println("Brugerne tilknyttet til projektet " + "\"" + project.getTitle() + "\"" + " er:");
        for (User user: project.getUsers()) {
            if(project.getManager().equals(user)){
                System.out.println("- " + user.getCredentials() + " (Manager)");
            } else {
                System.out.println("- " + user.getCredentials());
            }
        }

        managerFeatureScreen();
    }

    private void getAvailableUsers(){

        System.out.println("Hvornår skal brugerne være ledige fra");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        setMonthAndDay();
        start.set(2018,Integer.parseInt(month),Integer.parseInt(day),0,0);
        System.out.println("Hvornår skal brugerne være ledige til");
        setMonthAndDay();
        end.set(2018,Integer.parseInt(month),Integer.parseInt(day),0,0);
        List<User> availableUsers = new ArrayList();

        try {
            availableUsers = planner.getAvailableUsers(start,end);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(availableUsers.isEmpty()){
            System.out.println("Der er ingen ledige brugere i dette interval");
            managerFeatureScreen();
        } else {
            System.out.println("Følgende brugere er ledige i dette interval: ");
            for (User user: availableUsers) {
                System.out.println("- " + user.getCredentials());
            }
            managerFeatureScreen();
        }


    }

    private void assignUserToProject(){
        User activeUser = planner.getActiveUser();

        System.out.println("Vælg et projekt der skal tilføjes en bruger til: ");
        for (Project project: activeUser.getManagerProjects()) {
            System.out.println((activeUser.getManagerProjects().indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du ønsker at tilføje en bruger til");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            assignUserToProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            assignUserToProject();
        }

        System.out.println("Vælg en bruger der skal tilføjes til " + "\"" + project.getTitle() + "\"");
        for (User user: planner.getUsers()) {
            if(project.getUsers().contains(user)){
            } else {
                System.out.println(("- " + user.getCredentials()));
            }
        }

        System.out.println("Skriv brugernavnet på den bruger du vil tilføje");
        User user = setUser();

        try {
            planner.assignUserToProject(user,project);
            System.out.println("Brugeren " + "\"" + user.getCredentials() + "\"" + " er blevet tilføjet til projektet " + "\"" + project.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }

    private void assignUserToActivity(){
        User activeUser = planner.getActiveUser();

        System.out.println("Vælg et af følgende projekter: ");
        for (Project project: activeUser.getManagerProjects()) {
            System.out.println((activeUser.getManagerProjects().indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt brugeren du vil tilføje en aktivitet er tilknyttet");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            assignUserToActivity();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher dette nummer");
            assignUserToActivity();
        }

        if(project.getActivities().size() == 0){
            System.out.println("Der er ingen aktiviteter tilknyttet projektet " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Vælg en aktivitet der skal tilføjes til en bruger");
        for (Activity activity: project.getActivities()) {
            System.out.println(("- " + activity.getTitle()));
        }

        System.out.println("Skriv navnet på den aktivitet du vil tilføje til en bruger");
        Activity activity = setProjectActivity(project);

        System.out.println("Vælg en bruger af projketet der skal have tilføjet denne aktivitet");
        for (User user: project.getUsers()) {
            System.out.println(("- " + user.getCredentials()));
        }

        System.out.println("Skriv brugernavnet på den bruger du vil tilføjet til");
        User user = setUser();

        try {
            user.addActivity(activity);
            System.out.println("Brugeren " + "\"" + user.getCredentials() + "\"" + " har fået tilføjet aktiviteten " + "\"" + activity.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }

    private void createActivityToProject(){
        User activeUser = planner.getActiveUser();

        System.out.println("Vælg et projekt der skal oprettes en aktivitet til: ");
        for (Project project: activeUser.getManagerProjects()) {
            System.out.println((activeUser.getManagerProjects().indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du vil oprettes en aktivitet til");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            createActivityToProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            createActivityToProject();
        }

        System.out.println("Opret den aktivitet der skal tilføjes");
        System.out.println("-1 for at gå tilbage");
        System.out.println("Opretter aktivitet...");
        System.out.println("Indtast titel:");
        String titel = input.nextLine();
        if (titel.equals("-1")) {
            userFeatureScreen();
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Kendes start tidspunkt? Ja: j, Nej: n");
        String x = input.nextLine();
        if (x.equals("j")){
            setMonthAndDay();
            start.set(2018,Integer.parseInt(month),Integer.parseInt(day));
        } else if (x.equals("n")) {
        } else {
            System.out.println("Forkerte information - prøv igen");
            createActivityToProject();
        }

        try {
            Activity activity = new Activity(start, end, titel);
            project.addActivity(activity,activeUser);
            System.out.println("Aktiviteten " + "\"" +  activity.getTitle() + "\" er nu tilføjet til projektet " + "\"" +  project.getTitle() + "\"");
            managerFeatureScreen();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            createActivityToProject();
        }

    }

    private void removeUserFromProject(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Vælg et projekt der skal fjernes en bruger fra:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du vil fjerne en bruger fra");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            removeUserFromProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            removeUserFromProject();
        }

        if(project.getUsers().size() == 1){
            System.out.println("Der er ingen brugere tilknyttet projektet " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Brugere tilknytet til projketet " + "\"" + project.getTitle() + "\"");
        for (User user: project.getUsers()) {
            if (!project.getManager().equals(user)){
                System.out.println(("- " + user.getCredentials()));
            }
        }

        System.out.println("Skriv brugernavnet på den bruger du vil fjerne fra " + "\"" + project.getTitle() + "\"");
        User user = setUser();

        System.out.println("Er du sikker på du vil slette brugeren " + "\"" + user.getCredentials()+ "\" fra projektet " + "\"" + project.getTitle() + "\"? Ja: j, Nej: n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            planner.removeUserFromProject(user,project);
            System.out.println("Brugeren " + "\"" + user.getCredentials() + "\"" + " er nu blevet fjernet fra projektet " + "\"" + project.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }


    private void removeActivityFromProject(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Vælg et projekt der skal fjernes en aktivitet fra:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du vil fjerne en aktivitet fra");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            removeActivityFromProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            removeActivityFromProject();
        }

        if(project.getActivities().size() == 0){
            System.out.println("Der er ingen aktiviteter tilknyttet projektet " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Aktiviteter tilknytet projketet " + "\"" + project.getTitle() + "\"");
        for (Activity activity: project.getActivities()) {
            System.out.println(("- " + activity.getTitle()));
        }

        System.out.println("Skriv navnet på den aktivtet du vil fjerne fra projektet " + "\"" + project.getTitle() + "\"");
        Activity activity = setProjectActivity(project);

        System.out.println("Er du sikker på du vil slette aktiviteten " + "\"" + activity.getTitle()+ "\" fra projektet " + "\"" + project.getTitle() + "\"? Ja: j, Nej: n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            project.removeActivity(activity, planner.getActiveUser());
            System.out.println("Aktiviteten " + "\"" + activity.getTitle() + "\"" + " er nu blevet fjernet fra projektet " + "\"" + project.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }

    private void removeProject(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Vælg en af følgende projekter der skal fjernes:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du vil fjerne");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            removeProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            removeProject();
        }

        System.out.println("Er du sikker på du vil slette projektet " + "\"" + project.getTitle() + "\"? Ja: j, Nej: n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            planner.deleteProject(project);
            System.out.println("Projektet " + "\"" + project.getTitle() + "\" er nu fjernet" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(planner.activeUser.getManagerProjects().isEmpty()){
            System.out.println("Du er ikke længere manager for nogen projekter");
            userFeatureScreen();
        } else {
            managerFeatureScreen();
        }

    }

    private void getManageProjectActivityList(){
        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Vælg et af følgende projekter:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du ønsker at se tilknyttede aktiviteter");

        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            getManageProjectActivityList();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            getManageProjectActivityList();
        }

        if(project.getActivities().size() == 0){
            System.out.println("Der er ingen Aktiviteter tilknyttet projektet " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Aktiviteterne tilknyttet til projektet " + "\"" + project.getTitle() + "\"" + " er:");
        for (Activity activity: project.getActivities()) {
            System.out.println("- " + activity.getTitle());
        }

        managerFeatureScreen();
    }


    private void getManageProjectUserActivityList(){
        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Vælg et af følgende projekter: ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på det projekt du ønsker at se tilknyttede aktiviteter");

        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            getManageProjectUserActivityList();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher dette nummer");
            getManageProjectUserActivityList();
        }

        if(project.getUsers().size() == 1){
            System.out.println("Der er ingen brugere tilknyttet projektet " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Brugere tilknytet til projketet" + "\"" + project.getTitle() + "\"");
        for (User user: project.getUsers()) {
            if (!project.getManager().equals(user)){
                System.out.println(("- " + user.getCredentials()));
            }
        }

        System.out.println("Skriv brugernavnet for at se aktiviteter for denne bruger");
        User user = setUser();

        if(user.getActivities().size() == 0){
            System.out.println("Denne bruger har ingen aktiviteter");
            managerFeatureScreen();
        }

        System.out.println("Aktiviteterne tilknyttet til brugeren" + "\"" + user.getCredentials() + "\"" + " er:");
        for (Activity activity: user.getActivities()) {
            System.out.println(("- " + activity.getTitle()));
        }

        managerFeatureScreen();
    }

    private void changeProjectManager(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Vælg en af dine følgende projekter:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Indtast nummeret på et projekt");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Ikke et nummer. Prøv igen.");
            changeProjectManager();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("Intet projekt matcher det nummer");
            changeProjectManager();
        }

        System.out.println("Registrerede brugere du kan skifte til: ");
        for (User user: planner.getUsers()) {
            if(planner.activeUser.equals(user)){
            } else {
                System.out.println("- " + user.getCredentials());
            }
        }

        System.out.println("Skriv brugernavnet på den bruger du vil forfremme til manager for projektet " + "\"" +project.getTitle() + "\"");
        User user = setUser();

        System.out.println("Er du sikker på du vil skifte manageren for dit projekt " + "\"" + project.getTitle() + "til " + user.getCredentials() + "\" ? Ja: 1, Nej: 2" );
        String answer = input.nextLine();

        if(answer.equals("2")){
            managerFeatureScreen();
        }

        try {
            planner.changeProjectManager(user, project);
            System.out.println("Brugeren " + "\"" + user.getCredentials() + "\"" + " er nu manager for projektet " + "\"" +project.getTitle() + "\"");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(planner.activeUser.getManagerProjects().isEmpty()){
            System.out.println("Du er ikke længere manager for nogen projekter");
            userFeatureScreen();
        } else {
            managerFeatureScreen();
        }
    }


    /*****************
     * Time handlers *
     *****************/

    private void registerTimeStepTwo(Activity activity) {
        System.out.println("Registrerer tid til aktiviteten " + activity.getID());
        System.out.println("Hvornår startede du?");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        setMonthAndDay();
        setHourAndMinute();
        start.set(2018,Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
        System.out.println("Hvornår sluttede du aktiviteten?");
        setMonthAndDay();
        setHourAndMinute();
        end.set(2018,Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
        try {
            planner.getActiveUser().registerTime(activity, start, end, planner.getActiveUser());
            userFeatureScreen();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            userFeatureScreen();
        }
    }

    private void setMonthAndDay() {
        System.out.println("Indtast måned:");
        System.out.println("Indtast -1 for at gå tilbage");
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

    public void setHourAndMinute(){
        System.out.println("Indtast time på dagen (0-23):");
        System.out.println("Indtast -1 for at gå tilbage");
        hour = input.nextLine();

        if (hour.equals("-1")) {
            userFeatureScreen();
        } else if (hour.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23")) {
            System.out.println("Hvilket minut i timen?");
            System.out.println("0 - 59");
            minute = input.nextLine();
            if (!minute.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59")) {
                System.out.println("Prøv igen");
                setHourAndMinute();
            }
        } else {
            System.out.println("Prøv igen");
            setHourAndMinute();
        }
    }

}
