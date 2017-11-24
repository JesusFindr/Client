package org.academiadecodigo.hackathon.jesusfindr.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class MatchController implements Controller{

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
        void startChat(ActionEvent event) {

        }

        @FXML
        void initialize() {

        }
    }


