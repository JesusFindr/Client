package org.academiadecodigo.hackathon.jesusfindr.controller;

import org.academiadecodigo.hackathon.jesusfindr.Navigation;

public class InitialScreenController implements Controller {

    public void onLogin() {
        Navigation.getInstance().loadScreen("loginscreen");
    }

    public void onRegister(){
        Navigation.getInstance().loadScreen("createprofile");
    }
}

