package org.academiadecodigo.hackathon.jesusfindr.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class InitalScreenController implements Controller {

    @FXML
    private Pane welcomeView;

    @FXML
    private Button loginButton;

    public void onLogin() {

        Navigation.getInstance().loadScreen("loginscreen");
    }
}

