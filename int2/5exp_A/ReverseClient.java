// Client Program (ReverseClient.java)
import java.net.*;
import java.io.*;

public class ReverseClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 65432);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter sentence to reverse: ");
        String userInput = console.readLine();
        out.println(userInput); // Send to server

        String response = in.readLine(); // Get response from server
        System.out.println("Server response: " + response);
        socket.close();
    }
}