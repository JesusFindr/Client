package org.academiadecodigo.hackathon.jesusfindr.controller;

import org.academiadecodigo.hackathon.jesusfindr.Client;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.academiadecodigo.hackathon.jesusfindr.Security;

public class ProfileController implements Controller {

    private Client client;

    public void initialize(){

        client = Client.getInstance();
    }

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
    private RadioButton backHairNo;

    @FXML
    private Button registerButton;

    @FXML
    private Label errorLabel;

    @FXML
    void registerUser(ActionEvent event) {

        if (emptyFields()){
            errorLabel.setVisible(true);
            return;
        }

        String backHair = "yes";

        if (backHairNo.isSelected()){
            backHair = "no";
        }

        //TODO get value selected from lists
        String message = "register#€" + usernameField.getText() + "#€" + (Security.getHash(passwordField.getText())) + "#€" +
                ageField.getText() + "#€" + sexList + "#€" + shoeSizeList + "#€" + bellyList + "#€" + spiritAnimalField.getText() +
                "#€" + browsList + "#€" + backHair;

        client.sendMessage(message);

        Navigation.getInstance().loadScreen("matches");
    }

    private boolean emptyFields() {

        return usernameField.getText().length() == 0 ||
                passwordField.getText().length() == 0 ||
                ageField.getText().length() == 0 ||
                spiritAnimalField.getText().length() == 0 ||
                sexList.getSelectionModel().isSelected(0) ||
                shoeSizeList.getSelectionModel().isSelected(0) ||
                bellyList.getSelectionModel().isSelected(0) ||
                browsList.getSelectionModel().isSelected(0);
    }
}
