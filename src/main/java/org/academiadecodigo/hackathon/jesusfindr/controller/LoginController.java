package org.academiadecodigo.hackathon.jesusfindr.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import org.academiadecodigo.hackathon.jesusfindr.Client;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;
import org.academiadecodigo.hackathon.jesusfindr.Security;
import org.academiadecodigo.hackathon.jesusfindr.utils.Sound;

public class LoginController implements Controller {

    private Client client;
    private Sound sound;

    public void initialize() {

        client = Client.getInstance();
    }

    @FXML
    private ImageView errorLogo;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    void onLogin(ActionEvent event) {

        if (emptyFields()) {
            errorLogo.setVisible(true);
            return;
        }
        client.sendMessage("login#€" + usernameField.getText() + "#€" + Security.getHash(passwordField.getText()));
        client.setController(this);
    }

    @FXML
    void onRegister(ActionEvent event) {

        Navigation.getInstance().loadScreen("createprofile");
    }

    public void loadMatches() {


        Navigation.getInstance().loadScreen("matchscreen");

    }

    boolean emptyFields() {
        return usernameField.getText().length() == 0 || passwordField.getText().length() == 0;
    }

    private void playSound(String path){

        sound = new Sound(path);
        sound.play(false);
    }

    private void stopSound(){

        sound.stop();
        sound.close();
        System.out.println("closed sound");
    }
}
