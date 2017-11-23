package org.academiadecodigo.hackathon.jesusfindr.controller;

import org.academiadecodigo.hackathon.jesusfindr.Navigation;

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
        /*
        client.sendMessage("username#" + usernameField);
        client.sendMessage("password#" + passwordField);
        client.sendMessage("age#" + ageField);
        client.sendMessage("sex#" + sexList);
        client.sendMessage("shoe_size#" + shoeSizeList);
        client.sendMessage("bellybutton#" + bellyList);
        client.sendMessage("spirit_animal#" + spiritAnimalField);
        client.sendMessage("brows_type#" + browsList);
        if (backHairYes.isSelected()) {

            client.sendMessage("back_hair#yes");
        } else {
            client.sendMessage("back_hair#no");
        }
        */

        Navigation.getInstance().loadScreen("matches");
    }
}
