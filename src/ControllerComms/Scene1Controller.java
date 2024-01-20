package ControllerComms;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button loginButton;

    @FXML
    private TextField textField;

    @FXML
    void login(ActionEvent event) throws IOException {

        String username = textField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        root = loader.load();

        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName(username);

        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));

        stage = (Stage) (((Node) event.getSource()).getScene().getWindow());

        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

}
