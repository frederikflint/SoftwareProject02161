package planner.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import planner.app.Planner;
import planner.domain.Developer;
import planner.gui.Main;


public class Controller extends Main {

    @FXML
    TextField credentials;

    @FXML
    TextField password;

    @FXML
    Label error;

    @FXML
    Button login;


    public void login () {

        try {
           planner.userLogIn(credentials.getText(),password.getText());



        } catch (Exception e) {
            error.setText(e.getMessage());
        }

    }

}
