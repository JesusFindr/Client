package org.academiadecodigo.hackathon.jesusfindr;

import javafx.application.Platform;
import org.academiadecodigo.hackathon.jesusfindr.controller.ChatController;
import org.academiadecodigo.hackathon.jesusfindr.controller.Controller;
import org.academiadecodigo.hackathon.jesusfindr.controller.LoginController;
import org.academiadecodigo.hackathon.jesusfindr.controller.MatchController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public final class Client {

    public static Client client = null;
    private PrintWriter out;
    private Controller controller;
    private Socket clientSocket;

    private Client() {
    }

    public static Client getInstance() {

        if (client == null) {

            client = new Client();
        }
        return client;
    }

    public void start() {

        String hostName = "192.168.1.18";

        int portNumber = 9090;

        try {

            clientSocket = new Socket(hostName, portNumber);

            out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread thread = new Thread(new IncomeMessageHandler(in));

            thread.start();

        } catch (IOException e) {
        }
    }

    public void sendMessage(String string) {

        out.println(string);
        out.flush();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void shutdown() {
        try {
            clientSocket.shutdownInput();
            clientSocket.close();
        } catch (IOException e) {
            // socket closed
        }
    }

    private class IncomeMessageHandler implements Runnable {

        private BufferedReader in;

        public IncomeMessageHandler(BufferedReader in) {

            this.in = in;
        }

        @Override
        public void run() {


            String receivedString = null;
            try {
                while (true) {
                    receivedString = in.readLine();

                    if (receivedString == null) {

                        break;
                    }
                    messageHandler(receivedString);
                }

            } catch (IOException e) {
                System.out.println("socket closed");
            } finally {
                shutdown();
            }
        }
    }

    public void messageHandler(String string) {

        if (!string.contains("#€") && controller instanceof ChatController){
            Platform.runLater(() -> {
                ((ChatController) controller).getChatWindow().appendText(string + "\n");
            });
        }

        String[] strings = string.split("#€");

        if (strings[0].equals("login") && strings[1].equals("success")) {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Navigation.getInstance().loadScreen("matchscreen");
                }
            });
        }

        if (strings[0].equals("register") && strings[1].equals("success")) {

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Navigation.getInstance().loadScreen("matchscreen");
                }
            });
        }

        if (strings[0].equals("profile")) {
            if (controller instanceof MatchController) {
                Platform.runLater(() -> ((MatchController) controller).populateProfile(strings));
            } else if (controller instanceof ChatController) {
                Platform.runLater(() -> ((ChatController) controller).populateProfile(strings));
            }
        }
    }
}
