package org.academiadecodigo.hackathon.jesusfindr.controller;

import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class ChatController implements Controller {

    void logout(){
        Navigation.getInstance().loadScreen("logout");
    }
}
