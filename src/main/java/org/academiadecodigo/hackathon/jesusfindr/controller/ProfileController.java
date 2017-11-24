package org.academiadecodigo.hackathon.jesusfindr.controller;

import org.academiadecodigo.hackathon.jesusfindr.Navigation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ProfileController implements Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField ageField;

    @FXML
    private ChoiceBox<?> sexList;

    @FXML
    private ChoiceBox<?> shoeSizeList;

    @FXML
    private ChoiceBox<?> bellyList;

    @FXML
    private TextField spiritAnimalField;

    @FXML
    private ChoiceBox<?> browsList;

    @FXML
    private RadioButton backHairYes;

    @FXML
    private ToggleGroup Backhair;

    @FXML
    private RadioButton backHairNo;

    @FXML
    private Label infoLabel;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    @FXML
    void registerUser(ActionEvent event) {
        //client.sendMessage("");
        //client.sendMessage();
        //client.sendMessage();
        //client.sendMessage();
    }
}
