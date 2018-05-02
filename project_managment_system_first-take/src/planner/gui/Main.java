package planner.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import planner.app.Planner;
import planner.domain.Developer;

public class Main extends Application {

    Stage primaryStage;
    Parent root;

    protected static Planner planner = new Planner();
    private Developer dev = new Developer("test","test");

    @Override
    public void start(Stage primaryStage) throws Exception {

        /**
         *  ADD FAKE USERS
         */
        planner.developers.add(dev);

        /**
         *  Create initial scene
         */
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void setUpDevDash() throws Exception {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
