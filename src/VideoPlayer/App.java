package VideoPlayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    /*
     * 
     * APP CURRENTLY NOT WORKING
     * 
     * CURRENT ISSUES
     * 
     * NOT WORKING DUE TO INVOCATION ERROR
     * NOT WORKING DUE TO MEDIAPLAYER NULLPOINTER EXCEPTION
     * 
     * 
     * PREVIOUS ISSUES
     * 
     * [ISSUE FIXED] NOT WORKING DUE TO VMARGS ISSUE 
     * 
     */

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub

        Parent root = FXMLLoader.load(getClass().getResource("VideoPlayerUI.fxml"));

        Scene scene = new Scene(root);

        arg0.setScene(scene);
        arg0.show();
        
    }
    
}
