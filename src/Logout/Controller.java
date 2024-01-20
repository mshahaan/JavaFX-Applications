package Logout;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane scenePane;

    Stage stage;

    @FXML
    public void logout(ActionEvent event) {

        /**************** Confirmation Box ******************/

        //Alert object allows a confirmation box to appear

        Alert alert = new Alert(AlertType.CONFIRMATION); //AlertType.CONFIRMATION is a constant
        alert.setTitle("Logout"); //Title of alert box
        alert.setHeaderText("You are about to Logout"); //Header Text
        alert.setContentText("Do You Want to save before exiting?: "); 

        /*****************************************************/

        /* if statement will check if answer to confirmation box was 'OK' */

        if(alert.showAndWait().get() == ButtonType.OK){

            //set stage variable to the current window
            //scenePane is current anchorPane, which is the top of the current scene's hierarchy
            //cast is necessary
            stage = (Stage) scenePane.getScene().getWindow();

            System.out.println("Successful Logout.");

            stage.close(); //exits window & program

        }

    }

}
