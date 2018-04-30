package planner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * The
 *
 */
public class Planner extends Application {

    public User activeUser;
    public List<Developer> users =  new ArrayList<>();
    public List<Project> projects = new ArrayList<>();

    Stage Window;
    Scene LogIn, Dash;

//    public static void main(String[] args) {
//        launch(args);
//    }
//
//
//    @Override
//    public void start(Stage primaryStage) {
//

//
//
//    }

    @Override
    public void start(Stage primaryStage) {

        /**
         * FAKE USERS FOR TESTING
         */
        Admin admin = new Admin("admin","admin");
        Developer dev = new Developer("nn","nn");
        users.add(dev);


        // Scene setup as grid
        primaryStage.setTitle("Time planner");
        GridPane grid = new GridPane();
        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(250));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Scene title
        Text scenetitle = new Text("Planner");
        grid.add(scenetitle, 0, 0, 2, 1);

        // Credentials
        Label credentialsLabel = new Label("Credentials:");
        grid.add(credentialsLabel, 0, 1);
        TextField credentialsTextField = new TextField();
        grid.add(credentialsTextField, 1, 1);


        // Password
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);
        PasswordField passwordPasswordField = new PasswordField();
        grid.add(passwordPasswordField, 1, 2);


        // Sign in
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        actiontarget.setFill(Color.FIREBRICK);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e1) {
                try {
                    logIn(credentialsTextField.getText(),passwordPasswordField.getText());
                    actiontarget.setText("The user " + credentialsTextField.getText() + " is now logged in");
                } catch (Exception e2) {
                    actiontarget.setText("Credentials or password was wrong");
                }

            }
        });

        Scene scene = new Scene(grid,600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    /**
     * Handle the respond to the user.
     */
    private UserResponse userResponse = new UserResponse();

    /** SEND RESPONE
     *
     */

     private void showAlert(){

     }


    /**
     * Set an active user session
     * @param credentials The users credentials
     * @param password The users password
     * @throws OperationNotAllowedException If the users is logged in throw error. If the user us typed in wrong throw error.
     */
    public void logIn(String credentials, String password) throws OperationNotAllowedException{

        // Is there a user session?
        if(activeUser != null){
            throw new OperationNotAllowedException("There are already an active user on the system");
        }

        // Go through each of the registered Developers and check the password and credentials.
        // If the current one is present set that user as an active user session.
        for (Developer developer : users) {
            if (Objects.equals(developer.getCredentials(), credentials) &&
                    Objects.equals(developer.getPassword(), password)) {
                //Set the active session
                activeUser = developer;
            } else {
                throw new OperationNotAllowedException("Your credentials or password was wrong");
            }
        }
    }

    /**
     * Add a new user on the system
     * @param credentials Credentials
     * @param password Password
     * @throws Exception If the users is in the system throw error
     */
    public void createDeveloper(String credentials, String password) throws Exception{
        Developer developer = new Developer(credentials, password);

        if (users.contains(developer)) {
            throw new Exception("Developer is already registered");
        } else {
            users.add(developer);
        }

    }

    /**
     * Log the active user out of the system (remove active session)
     */
    public void logOut(){
        // Remove the active session
        activeUser = null;
    }


    /**************************
     *  Setters and getters   *
     **************************/

    /**
     * Search the users <LIST>  for a specific developer
     * @param credentials The users credentials
     * @return Returns the specific found developer
     */
    public Developer getDeveloper(String credentials) {

        //Set the initial currentDeveloper as null
        Developer currentDeveloper = null;

        for (Developer developer : users) {
            if (Objects.equals(developer.getCredentials(), credentials)){
                currentDeveloper =  developer;
            }
        }
        return currentDeveloper;
    }

    /**
     * Search the projects <LIST> for a specific project
     * @param title The project title
     * @return Returns the specific found project
     */
    public Project getProject(String title) {

        // Set the initial currentProject as null
        Project currentProject = null;

        for (Project project : projects) {
            if (Objects.equals(project.getTitle(), title)){
                currentProject =  project;
            }
        }
        return currentProject;
    }

    public List<Developer> getUsers() {
        return users;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Developer getActiveUser(Developer activeUser) {
        return activeUser;
    }

    public User getActiveUser() {
        return activeUser;
    }
}
