package MP3Player;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub

        Parent root = FXMLLoader.load(getClass().getResource("PlayerUI.fxml"));

        Scene scene = new Scene(root);

        arg0.setScene(scene);
        arg0.show();

        arg0.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                // TODO Auto-generated method stub

                Platform.exit();
                System.exit(0);
                
            }
            
        });
        
    }
    
}
