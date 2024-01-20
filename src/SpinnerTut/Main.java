package SpinnerTut;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub

        Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));

        Scene scene = new Scene(root);

        arg0.setScene(scene);
        arg0.show();
        
    }
    
}
