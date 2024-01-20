package ControllerComms;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {

    @FXML
    private Label greetingLabel;

    public void displayName(String username){
        greetingLabel.setText("Hello " + username);
    }
    
}
