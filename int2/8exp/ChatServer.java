// Chat Server (ChatServer.java)
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9876);
        System.out.println("Chat server is running...");
        while (true) {
            new Handler(serverSocket.accept()).start();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private PrintWriter out;

        public Handler(Socket socket) { this.socket = socket; }

        public void run() {
            try {
                System.out.println("Client connected: " + socket);
                out = new PrintWriter(socket.getOutputStream(), true);
                clientWriters.add(out);

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                for (String line; (line = in.readLine()) != null;) {
                    for (PrintWriter writer : clientWriters) {
                        writer.println("MESSAGE: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                if (out != null) clientWriters.remove(out);
                System.out.println("Client disconnected: " + socket);
            }
        }
    }
}