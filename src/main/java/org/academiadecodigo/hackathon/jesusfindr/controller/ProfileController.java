package org.academiadecodigo.hackathon.jesusfindr.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import org.academiadecodigo.hackathon.jesusfindr.Client;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.academiadecodigo.hackathon.jesusfindr.Security;
import org.academiadecodigo.hackathon.jesusfindr.utils.Sound;

public class ProfileController implements Controller {

    private Client client;
    private Sound sound;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField ageField;

    @FXML
    private ChoiceBox<String> sexList;

    @FXML
    private ChoiceBox<String> shoeSizeList;

    @FXML
    private ChoiceBox<String> bellyList;

    @FXML
    private TextField spiritAnimalField;

    @FXML
    private ChoiceBox<String> browsList;

    @FXML
    private RadioButton backHairYes;

    @FXML
    private RadioButton backHairNo;

    @FXML
    private Button registerButton;

    @FXML
    private ImageView errorImage;

    public void initialize() {

        client = Client.getInstance();

        populateBellyList();
        populateShoeList();
        populateSexList();
        populateBrowsList();

    }

    private void populateBrowsList() {
        browsList.getItems().add("Brows?");
        browsList.getSelectionModel().select(0);

        browsList.getItems().addAll("Split brows", "Unibrow");
    }

    private void populateSexList() {
        sexList.getItems().add("Sex?");
        sexList.getSelectionModel().select(0);

        sexList.getItems().addAll("Saint", "Once a year", "Once a week", "Once a day", "All Hackathon long!");
    }

    private void populateShoeList() {
        shoeSizeList.getItems().add("Shoe size?");
        shoeSizeList.getSelectionModel().select(0);

        shoeSizeList.getItems().addAll("Small", "Medium", "Big");
    }

    private void populateBellyList() {
        bellyList.getItems().add("Belly button?");
        bellyList.getSelectionModel().select(0);

        bellyList.getItems().addAll("Innie", "Outtie", "Other");
    }

    @FXML
    void registerUser(ActionEvent event) {

        if (emptyFields()){
            errorImage.setVisible(true);
            return;
        }

        String backHair = "True";

        if (backHairNo.isSelected()) {
            backHair = "False";
        }

        if (sexList.getSelectionModel().getSelectedIndex() != 1){
            playSound("/sounds/oh-my-god.wav");
            errorImage.setVisible(true);
            return;
        }
        //TODO get value selected from lists
        String message = "register#€" + usernameField.getText() + "#€" + (Security.getHash(passwordField.getText())) + "#€" +
                ageField.getText() + "#€" + (sexList.getSelectionModel().getSelectedIndex() - 1) + "#€" +
                (shoeSizeList.getSelectionModel().getSelectedIndex() - 1) + "#€" +
                (bellyList.getSelectionModel().getSelectedIndex() - 1) + "#€" +
                spiritAnimalField.getText() +
                "#€" + (browsList.getSelectionModel().getSelectedIndex() - 1) + "#€" + backHair;

        System.out.println(message);

        client.sendMessage(message);

//        Navigation.getInstance().loadScreen("matchscreen");
        playSound("/sounds/matchSound.wav");
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

    private void playSound(String path) {

        sound = new Sound(path);
        sound.play(false);
    }

    private void stopSound() {

        sound.stop();
        sound.close();
        System.out.println("closed sound");
    }
}
