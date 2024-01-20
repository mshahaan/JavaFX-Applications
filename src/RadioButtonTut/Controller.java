package RadioButtonTut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {

    @FXML
    private Label displayLabel;

    @FXML
    private ToggleGroup foodItems;

    @FXML
    private RadioButton hotdogButton;

    @FXML
    private RadioButton pizzaButton;

    @FXML
    private RadioButton sushiButton;

    @FXML
    void getFood(ActionEvent event) {

        if (hotdogButton.isSelected()) {

            displayLabel.setText(hotdogButton.getText());
            
        } else if (pizzaButton.isSelected()) {

            displayLabel.setText(pizzaButton.getText());
            
        } else if (sushiButton.isSelected()) {

            displayLabel.setText(sushiButton.getText());
            
        }

    }

}
