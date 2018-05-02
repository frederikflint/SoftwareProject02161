//package planner.gui;
//
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import planner.app.Planner;
//import planner.domain.Developer;
//
//public class MainScreen extends Application {
//
//    Planner planner = new Planner();
//
//    Stage window;
//    Scene LogIn, Dash;
//
//    /**
//     *
//     * @param primaryStage .
//     */
//    @Override
//    public void start(Stage primaryStage) {
//
//        window = primaryStage;
//
//        /**
//         * FAKE USERS FOR TESTING
//         */
//        Developer dev = new Developer("test","test");
//        planner.developers.add(dev);
//
//        try {
//            planner.userLogIn("test","test");
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
////
////        try {
////            planner.createDeveloper("tester","tester");
////        }catch (Exception e){
////            System.out.println(e.getMessage());
////        }
//
//        // Scene setup as grid
//        window.setTitle("Time planner");
//        GridPane grid = new GridPane();
//        grid.getColumnConstraints().add(new ColumnConstraints(100));
//        grid.getColumnConstraints().add(new ColumnConstraints(250));
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//
//        // Scene title
//        Text scenetitle = new Text("Planner");
//        grid.add(scenetitle, 0, 0, 2, 1);
//
//        // Credentials
//        Label credentialsLabel = new Label("Credentials:");
//        grid.add(credentialsLabel, 0, 1);
//        TextField credentialsTextField = new TextField();
//        grid.add(credentialsTextField, 1, 1);
//
//        // Password
//        Label passwordLabel = new Label("Password:");
//        grid.add(passwordLabel, 0, 2);
//        PasswordField passwordPasswordField = new PasswordField();
//        grid.add(passwordPasswordField, 1, 2);
//
//        // Sign in
//        Button btn = new Button("Sign in");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 4);
//
//        final Text actiontarget = new Text();
//        grid.add(actiontarget, 1, 6);
//        actiontarget.setFill(Color.FIREBRICK);
//
//        btn.setOnAction(e1 -> {
//            try {
//
//                planner.userLogIn(credentialsTextField.getText(),passwordPasswordField.getText());
//
//                GridPane dasboardGrid = new GridPane();
//                Text scenetitle1 = new Text("DashboardController");
//                dasboardGrid.setAlignment(Pos.CENTER);
//                dasboardGrid.add(scenetitle1, 0, 0, 2, 1);
//                Scene dashboard = new Scene(dasboardGrid,800,600);
//
//                System.out.print(planner.getDeveloper("test"));
//
//                window.setScene(dashboard);
//
//            } catch (Exception e2) {
//                actiontarget.setText(e2.getMessage());
//            }
//
//        });
//
//        Scene scene = new Scene(grid,800,600);
//        window.setScene(scene);
//        window.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//}
