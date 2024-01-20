package WebBrowser;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class BrowserController implements Initializable{

    @FXML
    private TextField siteEntryField;

    @FXML
    private WebView viewWindow;

    private WebEngine engine;
    private WebHistory webHistory;
    
    private String homePage;

    private double zoomLevel;

    @FXML
    void loadPage() {

        //engine.load("http://www.google.com");

        engine.load("http://"+siteEntryField.getText());

    }

    @FXML
    void refreshPage() {

        engine.reload();

    }

    @FXML
    void zoomIn() {

        zoomLevel += 0.25;

        viewWindow.setZoom(zoomLevel);

    }

    @FXML
    void zoomOut() {

        if (zoomLevel > 0.25) {
            zoomLevel -= 0.25;
        }

        viewWindow.setZoom(zoomLevel);

    }

    @FXML
    void displayHistory(){

        webHistory = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        for (WebHistory.Entry entry : entries) {

            //System.out.println(entry);

            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
            
        }

    }

    @FXML
    void previousPage() {

        webHistory = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        try {
            webHistory.go(-1);
        } catch (IndexOutOfBoundsException e) {
            
            // DO NOTHING

        }

        siteEntryField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());

    }

    @FXML
    void nextPage() {

        webHistory = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();

        try {
            webHistory.go(1);
        } catch (IndexOutOfBoundsException e) {
            
            // DO NOTHING

        }

        siteEntryField.setText(entries.get(webHistory.getCurrentIndex()).getUrl());

    }

    @FXML
    void executeJS() {

        engine.executeScript("window.location = \"https://www.youtube.com\";");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method 
        
        engine = viewWindow.getEngine();
        homePage = "www.google.com";

        zoomLevel = 1;

        siteEntryField.setText(homePage);

        loadPage();
        
    }

}