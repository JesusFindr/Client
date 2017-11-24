package org.academiadecodigo.hackathon.jesusfindr.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import org.academiadecodigo.hackathon.jesusfindr.Client;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class LoginController implements Controller {

    private Client client;

    public LoginController(){
        client = new Client();
    }

    @FXML
    private Hyperlink register;

    @FXML
    private Label errorImage;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    void onButton(ActionEvent event) {

        if (emptyFields()){
            errorImage.setVisible(true);
            return;
        }

        client.sendMessage(usernameField + "$€" + passwordField);
    }

    void authenticate(){
        Navigation.getInstance().loadScreen("matches");
    }

    boolean emptyFields(){
        return usernameField.getText().length() == 0 || passwordField.getText().length() == 0;
    }
}
