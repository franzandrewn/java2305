package lesson14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Running server");
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            StringBuilder inputString = new StringBuilder();
            String finalString = "";
            String inputLine = in.readLine();
            String secondLine = in.readLine();
//            while (inputLine != null) {
////                inputString.append(inputLine);
//                finalString += inputLine;
//                inputLine = in.readLine();
//            }

            out.println(inputLine + " " + secondLine);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
