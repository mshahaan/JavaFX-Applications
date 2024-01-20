package ChoiceBoxTut;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller implements Initializable{

    @FXML
    private Label displayLabel;

    @FXML
    private ChoiceBox<String> foodMenuDropDown;

    String[] choices = {"pizza", "ramen", "sushi"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        foodMenuDropDown.getItems().addAll(choices);

        foodMenuDropDown.setOnAction(this::displayFoodItem);
        
    }

    void displayFoodItem(ActionEvent event){
        displayLabel.setText(foodMenuDropDown.getValue());
    } 

}
