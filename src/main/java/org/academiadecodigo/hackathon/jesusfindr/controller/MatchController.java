package org.academiadecodigo.hackathon.jesusfindr.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.hackathon.jesusfindr.Client;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class MatchController implements Controller {

    private Client client;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView avatarLoader;

    @FXML
    private Label usernameShow;

    @FXML
    private Label ageShow;

    @FXML
    private Label sexShow;

    @FXML
    private Label shoeSizeShow;

    @FXML
    private Label bellyButtonShow;

    @FXML
    private Label spiritAnimalShow;

    @FXML
    private Label eyebrowShow;

    @FXML
    private Label backHairShow;

    @FXML
    private Button chatButton;

    @FXML
    private GridPane profile;

    @FXML
    private ImageView matchFound;

    @FXML
    void startChat(ActionEvent event) {

        Navigation.getInstance().loadScreen("chatscreen");
    }

    @FXML
    void initialize() {

        client = Client.getInstance();
        client.sendMessage("match#€");
        client.setController(this);

    }

    public void populateProfile(String[] profile) {
        matchFound.setVisible(true);
        usernameShow.setText(profile[1]);
        ageShow.setText(profile[2]);
        sexShow.setText(profile[3]);
        avatarLoader.setImage(new Image("/avatars/" + profile[4] + ".png"));
        shoeSizeShow.setText(profile[5]);
        bellyButtonShow.setText(profile[6]);
        spiritAnimalShow.setText(profile[7]);
        eyebrowShow.setText(profile[8]);
        backHairShow.setText(profile[9]);
        this.profile.setVisible(true);
    }
}


