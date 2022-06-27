package lesson14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpClient {
    private Socket serverSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            serverSocket = new Socket(ip, port);
            System.out.println("Created connection");
            out = new PrintWriter(serverSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String sendMessage(String message) {
        try {
            out.println(message);
            String response = in.readLine();
            return response;
        } catch (IOException ex ) {
            return "";
        }
    }
}
