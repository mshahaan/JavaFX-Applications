package VideoPlayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class UIController implements Initializable{

    @FXML
    private MediaView videoPlayer;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;
    

    @FXML
    void pauseMedia(ActionEvent event) {

        //System.out.println("Pause");

        mediaPlayer.pause();

    }

    @FXML
    void playMedia(ActionEvent event) {

        //System.out.println("Play");

        mediaPlayer.play();

    }

    @FXML
    void resetMedia(ActionEvent event) {

        //System.out.println("Reset");

        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {

            mediaPlayer.seek(Duration.seconds(0.0));
            
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

        file = new File("Sample Video.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        videoPlayer.setMediaPlayer(mediaPlayer);
        
    }

}
