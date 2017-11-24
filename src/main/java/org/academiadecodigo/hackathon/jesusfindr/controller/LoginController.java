package org.academiadecodigo.hackathon.jesusfindr.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import org.academiadecodigo.hackathon.jesusfindr.Client;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class LoginController implements Controller {

    private Client client;

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

        client.sendMessage(usernameField + "$€" + passwordField);
    }

    @FXML
    void onRegister(ActionEvent event) {

        Navigation.getInstance().loadScreen("createprofile");
    }

    void loadMatches() {
        Navigation.getInstance().loadScreen("matches");
    }

    boolean emptyFields() {
        return usernameField.getText().length() == 0 || passwordField.getText().length() == 0;
    }
}
