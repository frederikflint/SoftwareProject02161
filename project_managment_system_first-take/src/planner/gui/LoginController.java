package planner.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController extends Main {

    @FXML
    TextField credentials;

    @FXML
    TextField password;

    @FXML
    Label error;

    @FXML
    Button login;

    @FXML
    public void login () {

        try {
           planner.userLogIn(credentials.getText(),password.getText());
            

        } catch (Exception e) {
            error.setText(e.getMessage());
        }

    }

}
