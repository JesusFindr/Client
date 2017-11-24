package org.academiadecodigo.hackathon.jesusfindr;

/**
 * Created by codecadet on 24/11/17.
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("initialscreen");
        Client.getInstance().start();

    }

    @Override
    public void stop() throws Exception {
        Client.getInstance().shutdown();
    }
}
