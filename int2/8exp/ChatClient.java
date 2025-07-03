// Chat Client (ChatClient.java)
import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9876);
        System.out.println("Connected to chat server. Start typing.");
        
        // Thread to read messages from server
        new Thread(() -> {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String serverMsg;
                while ((serverMsg = in.readLine()) != null) {
                    System.out.println(serverMsg);
                }
            } catch (IOException e) { /* ignore */ }
        }).start();

        // Main thread to send messages to server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = console.readLine()) != null) {
            out.println(userInput);
        }
    }
}
