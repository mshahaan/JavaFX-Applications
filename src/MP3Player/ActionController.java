package MP3Player;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ActionController implements Initializable{

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button nextButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button previousButton;

    @FXML
    private Button resetButton;

    @FXML
    private ProgressBar trackProgressBar;

    @FXML
    private ComboBox<String> trackSpeedSelector;

    @FXML
    private Label trackname;

    @FXML
    private Slider volumeSlider;

    private File directory;
    private File[] files;
    private ArrayList<File> songs;

    private int songNumber;

    private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};

    private Timer timer;
    private TimerTask task;

    private boolean running;

    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    void nextMedia() {

        trackSpeedSelector.valueProperty().set("100%");

        volumeSlider.setValue(50);

        if (songNumber < songs.size() - 1) {

            songNumber++;

            mediaPlayer.stop();

            if (running) endTimer();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            trackname.setText(songs.get(songNumber).getName());

            playMedia();
            
        }
        else {

            songNumber = 0;

            mediaPlayer.stop();

            if (running) endTimer();

            trackProgressBar.setProgress(0);

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            trackname.setText(songs.get(songNumber).getName());

        }

    }

    @FXML
    void pauseMedia() {

        endTimer();

        mediaPlayer.pause();

    }

    @FXML
    void playMedia() {

        beginTimer();

        mediaPlayer.play();

    }

    @FXML
    void previousMedia() {

        if (songNumber > 0) {

            trackSpeedSelector.valueProperty().set("100%");

            volumeSlider.setValue(50);

            songNumber--;

            mediaPlayer.stop();

            if (running) endTimer();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            trackname.setText(songs.get(songNumber).getName());

            playMedia();
            
        }
        else {

            resetMedia();

            mediaPlayer.stop();

            if (running) endTimer();

        }

    }

    @FXML
    void resetMedia() {

        trackProgressBar.setProgress(0);

        mediaPlayer.seek(Duration.seconds(0.0));

    }

    @FXML
    void selectSpeed(ActionEvent event) {

        String s = trackSpeedSelector.getValue().substring(0, trackSpeedSelector.getValue().length()-1);
        
        mediaPlayer.setRate(Integer.parseInt(s) * 0.01);

    }

    void beginTimer() {

        timer = new Timer();

        task = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                running = true;

                double currentTime = mediaPlayer.getCurrentTime().toSeconds();
                double endTime = media.getDuration().toSeconds();
                System.out.println(currentTime / endTime);

                trackProgressBar.setProgress(currentTime / endTime);

                if (currentTime / endTime == 1) {

                    endTimer();
                    
                }
                
            }
            
        };

        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    void endTimer() {

        running = false;

        timer.cancel();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
        songs = new ArrayList<File>();

        directory = new File("music");

        files = directory.listFiles();

        if (files != null) {

            for (File file : files) {

                songs.add(file);
                System.out.println(file);
                
            }
            
        }

        songNumber = 0;

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        trackname.setText(songs.get(songNumber).getName());

        for (int i = 0; i < speeds.length; i++) {

            trackSpeedSelector.getItems().add(Integer.toString(speeds[i]) + "%");
            
        }

        trackSpeedSelector.setOnAction(this::selectSpeed);

        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                // TODO Auto-generated method stub

                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
                
            }
            
        });

    }

}
