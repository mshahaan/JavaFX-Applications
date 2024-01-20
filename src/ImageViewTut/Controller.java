package ImageViewTut;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controller {
    
    //ImageView is a Node used for painting images loaded with Images

    //Image = Photograph

    //ImageView = Picture Frame for Photograph

    @FXML
    private Button imageSwitcherButton;

    @FXML
    private ImageView myImageView;

    Image myImage = new Image(getClass().getResourceAsStream("London, England.jpg"));

    public void displayImage() {
        myImageView.setImage(myImage);
    }
}
