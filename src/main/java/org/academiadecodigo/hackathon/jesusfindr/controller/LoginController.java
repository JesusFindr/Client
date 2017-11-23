package org.academiadecodigo.hackathon.jesusfindr.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginController implements Controller {

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private Button enterButton;

    @FXML
    private Label emailLabel;

    @FXML
    private Label backButton;

    @FXML
    private Label errorLabel;

    @FXML
    void onButton(ActionEvent event) {

    }

}
