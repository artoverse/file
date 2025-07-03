import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        List<Socket> clients = new ArrayList<>();
        System.out.println("Server started on port 8080...");
        while (true) {
            Socket client = serverSocket.accept();
            clients.add(client);
            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Received: " + msg);
                        out.println("Echo: " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}