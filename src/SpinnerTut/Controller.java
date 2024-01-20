package SpinnerTut;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class Controller implements Initializable{

    @FXML
    private Label displayLabel;

    @FXML
    private Spinner<Integer> spinner;

    int displayedValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        valueFactory.setValue(1);

        spinner.setValueFactory(valueFactory);

        displayedValue = spinner.getValue();

        displayLabel.setText(Integer.toString(displayedValue));

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
                // TODO Auto-generated method stub

                displayedValue = spinner.getValue();

                displayLabel.setText(Integer.toString(displayedValue));
                
            }
            
        });
        
    }

}
