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


    public void login () {

        try {
           planner.userLogIn(credentials.getText(),password.getText());

           if(planner.activeUser.isAdmin()){
               // SWITCH TO ADMIN SCENE
           } else {
               // SWITCH TO DEV SCENE
           }

        } catch (Exception e) {
            error.setText(e.getMessage());
        }

    }

}
