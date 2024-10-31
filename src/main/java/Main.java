import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        int port = 6377;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true);
//            clientSocket = serverSocket.accept();
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String redisCommand = scanner.nextLine();
                if (redisCommand.equals("PING")) {
                    System.out.println("PONG");
                }
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