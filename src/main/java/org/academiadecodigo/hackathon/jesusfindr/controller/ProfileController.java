package org.academiadecodigo.hackathon.jesusfindr.controller;

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
        client.sendMessage("password#" + Security.getHash(passwordField.getText()));
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

        if (emptyFields()){
            errorLabel.setVisible(true);
            return;
        }

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
