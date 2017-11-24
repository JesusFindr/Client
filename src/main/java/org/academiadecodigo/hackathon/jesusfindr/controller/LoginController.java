package org.academiadecodigo.hackathon.jesusfindr.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class LoginController implements Controller {

    @FXML
    private GridPane gridPane;

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
        //client.sendMessage(usernameField + "$€" + passwordField);
        //if (client.authenticate()){}
        Navigation.getInstance().loadScreen("matches");
    }
}
