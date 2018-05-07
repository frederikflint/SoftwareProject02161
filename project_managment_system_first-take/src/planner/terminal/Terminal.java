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

        System.out.println("Fake manager: credentials: m, Pass: 123");
        System.out.println("----------------------------------------");
        System.out.println("Fake users: credentials: user1..5, Pass: 123");
        System.out.println("----------------------------------------");
        User managerUser = new User("manager","123");
        Project project = new Project("project", null,null);


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
        System.out.println("Welcome to SoftwareHuset A/S.");
        logIn();
    }

    private void logIn() {
        System.out.println("Please log in");
        System.out.println("Username:");
        String username = input.nextLine();
        System.out.println("Password:");
        String password = input.nextLine();
        try {
            planner.userLogIn(username,password);

            if(planner.activeUser.isAdmin()){
                System.out.println("Welcome to the control-panel of the system");
                adminFeatureScreen();
            } else {
                System.out.println("Welcome " + planner.activeUser.getCredentials());
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
            System.out.println("The user " + "\"" + in + "\"" + " does not exist in the system");
            System.out.println("Try again");
            return setUser();
        } else {
            return user;
        }

    }

    private Activity setProjectActivity(Project project){

        String in = input.nextLine();
        Activity activity = project.getActivity(in);

        if(activity == null){
            System.out.println("The activity " + "\"" + in + "\"" + " does not exist in the project " + "\"" + project.getTitle() + "\"" );
            System.out.println("Try again");
            return setProjectActivity(project);
        } else {
            return activity;
        }

    }

    private Project setProject(){

        System.out.println("-1 to return");
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
            System.out.println("The project " + "\"" + in + "\"" + " does not exist in the system");
            System.out.println("Try again");
            return setProject();
        } else {
            return project;
        }

    }

    /******************
     * Admin Features *
     ******************/

    private void adminFeatureScreen(){
        System.out.println("Please enter a number:");
        System.out.println("1: List of users");
        System.out.println("2: List of projects");
        System.out.println("3: Register User");
        System.out.println("4: Delete bruger");
        System.out.println("5: Log out");
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
            System.out.println("Input does not match options");
            adminFeatureScreen();
        }

    }

    private void getPlannerUserList(){

        if(planner.getUsers().isEmpty()){
            System.out.println("No registered users in the system");
            adminFeatureScreen();
        }

        System.out.println("Registered users: ");
        for (User user: planner.getUsers()) {
            System.out.println("- " + user.getCredentials());
        }

        adminFeatureScreen();
    }

    private void getPlannerProjectList(){

        if(planner.getUsers().isEmpty()){
            System.out.println("No registered projects in the system");
            adminFeatureScreen();
        }

        System.out.println("Registered projects: ");
        for (Project project: planner.getProjects()) {
            System.out.println("- " + project.getTitle());
        }
        adminFeatureScreen();
    }

    private void registerUser() {
        System.out.println("-1 to return");
        System.out.println("Enter desired username");
        String username = input.nextLine();

        if (username.equals("-1")) {
            adminFeatureScreen();
        }

        System.out.println("Enter desired password?");
        String password = input.nextLine();

        try {
            planner.createUser(username,password);
            System.out.println("The user " + "\"" + username + "\"" + " is now registered");
        } catch (OperationNotAllowedException | AuthenticationException e) {
            System.out.println(e.getMessage());
            registerUser();
        }
        adminFeatureScreen();
    }

    private void unregisterUser(){

        if(planner.getUsers().isEmpty()){
            System.out.println("No registered users in the system");
            adminFeatureScreen();
        }

        System.out.println("-1 to return");
        System.out.println("Registered users: ");
        for (User user: planner.getUsers()) {
            System.out.println("- " + user.getCredentials());
        }

        System.out.println("Enter the username of the user you wish to delete");
        User user = setUser();

        System.out.println("Please confirm deleting the user " + "\"" + user.getCredentials()+ "\"? Yes: y, No: n");
        String in = input.nextLine();

        if(in.equals("n")){
            adminFeatureScreen();
        }

        try {
            planner.deleteUser(user);
            System.out.println("The user " + "\"" + user.getCredentials()+ "\""  + " has been deleted from the system");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        adminFeatureScreen();

    }

    /*****************
     * User Features *
     *****************/

    private void userFeatureScreen() {
        System.out.println("Enter a number:");
        System.out.println("1: Register time");
        System.out.println("2: View registered time");
        System.out.println("3: View activities");
        System.out.println("4: View Projects");
        System.out.println("5: Create activity");
        System.out.println("6: Create project");
        System.out.println("7: Delete an activity");
        System.out.println("8: Manager control panel");
        System.out.println("9: Log out");
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
                System.out.println("You are not manager of any projects");
                userFeatureScreen();
            } else {
                System.out.println("Your manager panel");
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
            System.out.println("Your input does not match any options");
            userFeatureScreen();
        }
    }

    private void registerTime() {

        if(planner.getActiveUser().getActivities().size() == 0){
            System.out.println("No activity to register time for");
            userFeatureScreen();
        }

        System.out.println("-1 to return");
        System.out.println("Register time spent on an activity.");
        for (Activity activity : planner.getActiveUser().getActivities()) {
            System.out.println("- " + activity.getID());
        }

        System.out.println("Enter title of the activity you wish to enter time spent on");

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
            System.out.println("No time registered for activities");
            userFeatureScreen();
        }

        System.out.println("Time registered on following activities: " );
        User activeUser = planner.getActiveUser();
        for (WorkHours work: activeUser.getWorkHours()) {
            System.out.println("- Activity: " + work.getActivity().getTitle() +
                    ", Time spent: " + df.format((double) work.getWorkTimeInMinutes() / 60.0) + " hours");
        }
        userFeatureScreen();
    }

    private void getActivities(){

        if(planner.getActiveUser().getActivities().size() == 0){
            System.out.println("You have no activities");
            userFeatureScreen();
        }

        User activeUser = planner.getActiveUser();

        System.out.println("You have the following activities:  ");
        for (Activity activity: activeUser.getActivities()) {
            System.out.println("- " + activity.getTitle());
        }

        userFeatureScreen();
    }

    private void getProjects(){

        if(planner.activeUser.getProjects().size() == 0){
            System.out.println("You are not part of any project");
            userFeatureScreen();
        }

        User activeUser = planner.getActiveUser();

        System.out.println("You a a part of following project(s):  ");
        for (Project project: activeUser.getProjects()) {
            System.out.println("- " + project.getTitle());
        }

        userFeatureScreen();
    }

    private void createProject() {
        System.out.println("-1 to return");
        System.out.println("Creating project...");
        System.out.println("Enter title of the project:");
        String titel = input.nextLine();
        if (titel.equals("-1")) {
            userFeatureScreen();
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Does the project have a specific start time? Yes: y, No: n");
        String x = input.nextLine();
        if (x.equals("y")){
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
            System.out.println("Enter 'y' for Yes og 'n' for No  - try again");
            createProject();
        }
    }

    private void createActivity() {
        System.out.println("-1 to return");
        System.out.println("Creating activity...");
        System.out.println("Enter title of the activity:");
        String titel = input.nextLine();
        if (titel.equals("-1")) {
            userFeatureScreen();
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Does the project have a specific start time? Yes: y, No: n");
        String x = input.nextLine();
        if (x.equals("y")){
            setMonthAndDay();
            start.set(2018,Integer.parseInt(month),Integer.parseInt(day));
        } else if (x.equals("n")) {
        } else {
            System.out.println("Invalid credentials, try again");
            createActivity();
        }
        try {
            Activity activity = new Activity(start, end, titel);
            planner.getActiveUser().addActivity(activity);
            System.out.println("The activity " + "\"" +  activity.getTitle() + "\" has been added to your list of activities");
            userFeatureScreen();
        } catch (OperationNotAllowedException e) {
            System.out.println(e.getMessage());
            createActivity();
        }
    }

    private void removeActivity() {

        if(planner.getActiveUser().getActivities().size() == 0){
            System.out.println("You have no acitivites");
            userFeatureScreen();
        }

        User activeUser = planner.getActiveUser();

        System.out.println("You have the following activities:  ");
        for (Activity activity: activeUser.getActivities()) {
            System.out.println((activeUser.getActivities().indexOf(activity)+1) + ": " + activity.getTitle());
        }

        System.out.println("Enter number of the activity you want to remove");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input, try again");
            removeProject();
        }

        Activity activity = null;

        try {
            activity = activeUser.getActivities().get(in - 1);
        }catch (Exception e){
            System.out.println("No activity match that number");
            removeProject();
        }

        System.out.println("Confirm deletion of the activity " + "\"" + activity.getTitle()+ "\"? Yes: y, No: n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            activeUser.removeActivity(activity);
            System.out.println("The activity " + "\"" +  activity.getTitle() + "\"" + " has now been removed from your activities" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        userFeatureScreen();
    }

    /********************
     * Manager Features *
     ********************/

    private void managerFeatureScreen(){
        System.out.println("Enter a number:");
        System.out.println("1: View projects you manage");
        System.out.println("2: View users on a given project");
        System.out.println("3: View activities in a project");
        System.out.println("4: View a given users activities in a project");
        System.out.println("5: See available users");
        System.out.println("6: Create activity in a project");
        System.out.println("7: Add activity to a user in a project");
        System.out.println("8: Add a user to a project");
        System.out.println("9: Change manager in a project");
        System.out.println("10: Remove a user of a project");
        System.out.println("11: Remove an activity from a project");
        System.out.println("12: Remove a project");
        System.out.println("13: Return");
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
            System.out.println("Your input does not match the options");
            managerFeatureScreen();
        }
    }

    private void getManageProjectList(){

        System.out.println("You manage the following projects:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println("- " + project.getTitle());
        }
        managerFeatureScreen();
    }

    private void getManageProjectUserList(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Choose one of following projects:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project wherein you want to see users");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            getManageProjectUserList();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            getManageProjectUserList();
        }

        System.out.println("Users in the project " + "\"" + project.getTitle() + "\"" + " are:");
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

        System.out.println("When does the user have to be available from?");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        setMonthAndDay();
        start.set(2018,Integer.parseInt(month),Integer.parseInt(day),0,0);
        System.out.println("When does the user have to be available to?");
        setMonthAndDay();
        end.set(2018,Integer.parseInt(month),Integer.parseInt(day),0,0);
        List<User> availableUsers = new ArrayList();

        try {
            availableUsers = planner.getAvailableUsers(start,end);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(availableUsers.isEmpty()){
            System.out.println("No available users in that time frame");
            managerFeatureScreen();
        } else {
            System.out.println("Following users are available in that time frame: ");
            for (User user: availableUsers) {
                System.out.println("- " + user.getCredentials());
            }
            managerFeatureScreen();
        }


    }

    private void assignUserToProject(){
        User activeUser = planner.getActiveUser();

        System.out.println("Choose project to add user(s) to: ");
        for (Project project: activeUser.getManagerProjects()) {
            System.out.println((activeUser.getManagerProjects().indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project whereto you want to add users");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            assignUserToProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number.");
            assignUserToProject();
        }

        System.out.println("Choose a user to add to " + "\"" + project.getTitle() + "\"");
        for (User user: planner.getUsers()) {
            if(project.getUsers().contains(user)){
            } else {
                System.out.println(("- " + user.getCredentials()));
            }
        }

        System.out.println("Enter the username of the user you wish to add");
        User user = setUser();

        try {
            planner.assignUserToProject(user,project);
            System.out.println("The user " + "\"" + user.getCredentials() + "\"" + " has been added to the project " + "\"" + project.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }

    private void assignUserToActivity(){
        User activeUser = planner.getActiveUser();

        System.out.println("Choose one of following projects: ");
        for (Project project: activeUser.getManagerProjects()) {
            System.out.println((activeUser.getManagerProjects().indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project containing the user, who you want to add an activity to");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            assignUserToActivity();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            assignUserToActivity();
        }

        if(project.getActivities().size() == 0){
            System.out.println("There are no activities in the project " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Choose the activity to which you want to add a user");
        for (Activity activity: project.getActivities()) {
            System.out.println(("- " + activity.getTitle()));
        }

        System.out.println("Write the name of the activity to which you want to add a user");
        Activity activity = setProjectActivity(project);

        System.out.println("Choose a user in the project who you want to add the activity to");
        for (User user: project.getUsers()) {
            System.out.println(("- " + user.getCredentials()));
        }

        System.out.println("Write the username of the user who you want to add the activity to");
        User user = setUser();

        try {
            user.addActivity(activity);
            System.out.println("The user " + "\"" + user.getCredentials() + "\"" + " has been assigned the activity " + "\"" + activity.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }

    private void createActivityToProject(){
        User activeUser = planner.getActiveUser();

        System.out.println("Choose an activity to which you want to add an activity: ");
        for (Project project: activeUser.getManagerProjects()) {
            System.out.println((activeUser.getManagerProjects().indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project to which you want to add an activity");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try agian.");
            createActivityToProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            createActivityToProject();
        }

        System.out.println("Create the activity to be added");
        System.out.println("-1 to return");
        System.out.println("Creating activity...");
        System.out.println("Enter title:");
        String titel = input.nextLine();
        if (titel.equals("-1")) {
            userFeatureScreen();
        }
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        System.out.println("Is the start time known? Yes: y, No: n");
        String x = input.nextLine();
        if (x.equals("y")){
            setMonthAndDay();
            start.set(2018,Integer.parseInt(month),Integer.parseInt(day));
        } else if (x.equals("n")) {
        } else {
            System.out.println("Invalid information. Try again.");
            createActivityToProject();
        }

        try {
            Activity activity = new Activity(start, end, titel);
            project.addActivity(activity,activeUser);
            System.out.println("The activity " + "\"" +  activity.getTitle() + "\" has been added to the project " + "\"" +  project.getTitle() + "\"");
            managerFeatureScreen();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            createActivityToProject();
        }

    }

    private void removeUserFromProject(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Choose a project from which to remove a user:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project from which to remove a user");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try agian");
            removeUserFromProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number ");
            removeUserFromProject();
        }

        if(project.getUsers().size() == 1){
            System.out.println("No users are in the project " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Users in the project " + "\"" + project.getTitle() + "\"");
        for (User user: project.getUsers()) {
            if (!project.getManager().equals(user)){
                System.out.println(("- " + user.getCredentials()));
            }
        }

        System.out.println("Enter username of the user you want to remove from project " + "\"" + project.getTitle() + "\"");
        User user = setUser();

        System.out.println("Are you sure you want to remove the user " + "\"" + user.getCredentials()+ "\" from the project " + "\"" + project.getTitle() + "\"? Yes: y, No, n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            planner.removeUserFromProject(user,project);
            System.out.println("The user " + "\"" + user.getCredentials() + "\"" + " has been removed from the project " + "\"" + project.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }


    private void removeActivityFromProject(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Choose a project from which to remove an activity:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project from which to remove an activity");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            removeActivityFromProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            removeActivityFromProject();
        }

        if(project.getActivities().size() == 0){
            System.out.println("No activities are in the project " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Activities in the project " + "\"" + project.getTitle() + "\"");
        for (Activity activity: project.getActivities()) {
            System.out.println(("- " + activity.getTitle()));
        }

        System.out.println("Enter the name of the activity which to remove from the project " + "\"" + project.getTitle() + "\"");
        Activity activity = setProjectActivity(project);

        System.out.println("Are you sure you want to remove the activity " + "\"" + activity.getTitle()+ "\" from the project " + "\"" + project.getTitle() + "\"? Yes: y, No: n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            project.removeActivity(activity, planner.getActiveUser());
            System.out.println("The activity " + "\"" + activity.getTitle() + "\"" + " has been removed from the project " + "\"" + project.getTitle() + "\"" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        managerFeatureScreen();
    }

    private void removeProject(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Choose one of the following projects to delete:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project you want to delete");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            removeProject();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            removeProject();
        }

        System.out.println("Are you sure you want to remove the project " + "\"" + project.getTitle() + "\"? Yes: y, No: n");
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            planner.deleteProject(project);
            System.out.println("The project " + "\"" + project.getTitle() + "\" has been removed" );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(planner.activeUser.getManagerProjects().isEmpty()){
            System.out.println("You are no longer project manager of any projects");
            userFeatureScreen();
        } else {
            managerFeatureScreen();
        }

    }

    private void getManageProjectActivityList(){
        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Choose one of the following projects:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project you want to see activities in");

        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            getManageProjectActivityList();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            getManageProjectActivityList();
        }

        if(project.getActivities().size() == 0){
            System.out.println("There are no activities in the project " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Activities in the project " + "\"" + project.getTitle() + "\"" + " are:");
        for (Activity activity: project.getActivities()) {
            System.out.println("- " + activity.getTitle());
        }

        managerFeatureScreen();
    }


    private void getManageProjectUserActivityList(){
        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Choose one of following projects: ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of the project wherin you want to view activities");

        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            getManageProjectUserActivityList();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            getManageProjectUserActivityList();
        }

        if(project.getUsers().size() == 1){
            System.out.println("There are no users in the project " + "\"" + project.getTitle() + "\"");
            managerFeatureScreen();
        }

        System.out.println("Users in the project" + "\"" + project.getTitle() + "\"");
        for (User user: project.getUsers()) {
            if (!project.getManager().equals(user)){
                System.out.println(("- " + user.getCredentials()));
            }
        }

        System.out.println("Enter a username to see the users list of activities");
        User user = setUser();

        if(user.getActivities().size() == 0){
            System.out.println("The user has no activities");
            managerFeatureScreen();
        }

        System.out.println("Activities of the user" + "\"" + user.getCredentials() + "\"" + " are:");
        for (Activity activity: user.getActivities()) {
            System.out.println(("- " + activity.getTitle()));
        }

        managerFeatureScreen();
    }

    private void changeProjectManager(){

        List mP = planner.activeUser.getManagerProjects();

        System.out.println("Choose on of your projects:  ");
        for (Project project: planner.activeUser.getManagerProjects()) {
            System.out.println((mP.indexOf(project)+1)+ ": " + project.getTitle());
        }

        System.out.println("Enter the number of a project");
        Integer in = null;

        try {
            in = Integer.parseInt(input.nextLine());
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            changeProjectManager();
        }

        Project project = null;

        try {
            project = planner.activeUser.getManagerProjects().get(in - 1);
        }catch (Exception e){
            System.out.println("No project match that number");
            changeProjectManager();
        }

        System.out.println("Registered users to make project manager: ");
        for (User user: planner.getUsers()) {
            if(planner.activeUser.equals(user)){
            } else {
                System.out.println("- " + user.getCredentials());
            }
        }

        System.out.println("Write the username of the user to make project manager " + "\"" +project.getTitle() + "\"");
        User user = setUser();

        System.out.println("Are you sure you want switch the project manager role from " + "\"" + project.getTitle() + " to " + user.getCredentials() + "\" ? Yes: y, No: n" );
        String answer = input.nextLine();

        if(answer.equals("n")){
            managerFeatureScreen();
        }

        try {
            planner.changeProjectManager(user, project);
            System.out.println("The user " + "\"" + user.getCredentials() + "\"" + " is now manager of the project " + "\"" +project.getTitle() + "\"");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        if(planner.activeUser.getManagerProjects().isEmpty()){
            System.out.println("You are no longer manager of any projects");
            userFeatureScreen();
        } else {
            managerFeatureScreen();
        }
    }


    /*****************
     * Time handlers *
     *****************/

    private void registerTimeStepTwo(Activity activity) {
        System.out.println("Registering time for the activity " + activity.getID());
        System.out.println("Enter start time of the activity");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        setMonthAndDay();
        setHourAndMinute();
        start.set(2018,Integer.parseInt(month),Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
        System.out.println("Enter end time of the activity");
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
        System.out.println("Enter month:");
        System.out.println("-1 to return");
        System.out.println(" 0: January \n 1: February \n 2: March \n 3: April \n 4: May \n 5: June \n 6: July \n" +
                " 7: August \n 8: September \n 9: October \n 10: November \n 11: December");
        month = input.nextLine();
        if (month.equals("-1")) {
            userFeatureScreen();
        } else if (month.matches("0|1|2|3|4|5|6|7|8|9|10|11")) {
            System.out.println("Which day of the month?");
            System.out.println("0 - 30");
            day = input.nextLine();
            if (!day.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30")) {
                System.out.println("Try again");
                setMonthAndDay();
            }
        } else {
            System.out.println("Try again");
            setMonthAndDay();
        }
    }

    public void setHourAndMinute(){
        System.out.println("Enter the hour of day (0-23):");
        System.out.println("-1 to return");
        hour = input.nextLine();

        if (hour.equals("-1")) {
            userFeatureScreen();
        } else if (hour.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23")) {
            System.out.println("What minute of the hour?");
            System.out.println("0 - 59");
            minute = input.nextLine();
            if (!minute.matches("0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59")) {
                System.out.println("Try again");
                setHourAndMinute();
            }
        } else {
            System.out.println("Try again");
            setHourAndMinute();
        }
    }

}
