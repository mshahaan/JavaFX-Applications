package CheckBoxTut;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label currentStateDisplayLabel;

    @FXML
    private CheckBox onOffSwitch;

    @FXML
    void switchState(ActionEvent event) {

        if(onOffSwitch.isSelected()){
            currentStateDisplayLabel.setText("ON");
        }else{
            currentStateDisplayLabel.setText("OFF");
        }

    }

}
