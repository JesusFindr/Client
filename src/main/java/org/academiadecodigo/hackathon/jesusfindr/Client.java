package org.academiadecodigo.hackathon.jesusfindr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    PrintWriter out;

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
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(receivedString);
            }
        }
    }
}
