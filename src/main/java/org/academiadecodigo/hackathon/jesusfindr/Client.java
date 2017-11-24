package org.academiadecodigo.hackathon.jesusfindr;

import org.academiadecodigo.hackathon.jesusfindr.controller.Controller;
import org.academiadecodigo.hackathon.jesusfindr.controller.LoginController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public final class Client {

    public static Client client = null;
    private PrintWriter out;
    private Controller controller;

    private Client() {
    }

    public static Client getInstance() {

        if (client == null) {

            client = new Client();
        }
        return client;
    }

    public void start() {

        String hostName = "localhost";

        int portNumber = 9090;

        try {

            Socket clientSocket = new Socket(hostName, portNumber);

            out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread thread = new Thread(new IncomeMessageHandler(in));

            thread.start();

        } catch (IOException e) {
            System.out.println("Server is not available, try again later.");
        }
    }

    public void sendMessage(String string) {

        out.write(string + '\n');
        out.flush();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private class IncomeMessageHandler implements Runnable {

        private BufferedReader in;

        public IncomeMessageHandler(BufferedReader in) {

            this.in = in;
        }

        @Override
        public void run() {

            while (true) {

                String receivedString = null;
                try {
                    receivedString = in.readLine();

                    if (receivedString != null) {

                        messageHandler(receivedString);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(receivedString);
            }
        }
    }

    public void messageHandler(String string) {

        String[] strings = string.split("#€");

        System.out.println(string);

        if (strings[0].equals("login") && strings[1].equals("success")) {

            System.out.println("About to change view");

            ((LoginController) controller).loadMatches();
        }
    }
}
