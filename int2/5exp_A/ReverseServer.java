// Server Program (ReverseServer.java)
import java.net.*;
import java.io.*;

public class ReverseServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(65432);
        System.out.println("Server is listening on port 65432...");
        Socket clientSocket = serverSocket.accept(); // Wait for a client
        System.out.println("Client connected.");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = in.readLine(); // Read sentence from client
        String reversed = new StringBuilder(inputLine).reverse().toString();
        out.println(reversed); // Send reversed sentence back

        System.out.println("Processed one client. Shutting down.");
        serverSocket.close();
    }
}
