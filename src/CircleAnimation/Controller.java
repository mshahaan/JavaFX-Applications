package CircleAnimation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class Controller implements Initializable{

    @FXML
    private Ellipse earth;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        //translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(earth);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(250);
        translate.setByY(-250);
        translate.setAutoReverse(true);
        translate.play();

        //rotate
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(earth);
        rotate.setDuration(Duration.millis(500));
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
        rotate.play();

        //fade
        FadeTransition fade = new FadeTransition();
        fade.setNode(earth);
        fade.setDuration(Duration.millis(1000));
        //fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        //scale
        ScaleTransition scale  = new ScaleTransition();
        scale.setNode(earth);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(2);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(2.0);
        scale.setByY(2.0);
        scale.setAutoReverse(true);
        scale.play();
        
    }

}
