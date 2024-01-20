package ControllerComms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        Parent root;

        try {

            root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        
    }
    
}
