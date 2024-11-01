import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        int port = 6379;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true);
            while (true){
                clientSocket = serverSocket.accept();
                BufferedReader command = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(command.readLine());
                clientSocket.getOutputStream().write("+PONG\r\n".getBytes());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }
}