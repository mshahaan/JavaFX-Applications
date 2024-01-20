package Logout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> { 

            event.consume(); 
            logout(primaryStage);   
            
        });
        
    }

    public void logout(Stage stage) {

        /**************** Confirmation Box ******************/

        //Alert object allows a confirmation box to appear

        Alert alert = new Alert(AlertType.CONFIRMATION); //AlertType.CONFIRMATION is a constant
        alert.setTitle("Logout"); //Title of alert box
        alert.setHeaderText("You are about to Logout"); //Header Text
        alert.setContentText("Do You Want to save before exiting?: "); 

        /*****************************************************/

        /* if statement will check if answer to confirmation box was 'OK' */

        if(alert.showAndWait().get() == ButtonType.OK){

            System.out.println("Successful Logout.");

            stage.close(); //exits window & program

        }

    }
}
