import java.net.*;
import java.io.*;

public class AdvancedSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started. Waiting for client...");

        Socket client = server.accept();
        System.out.println("Client connected.");

        // Get socket options (getsockopt)
        System.out.println("\n[Server] Socket Options:");
        System.out.println("Receive Buffer Size: " + client.getReceiveBufferSize());
        System.out.println("Send Buffer Size: " + client.getSendBufferSize());

        // Set socket options (setsockopt)
        client.setSoTimeout(3000); // Timeout after 3 seconds
        System.out.println("Set timeout: 3000ms");

        // Get local and remote addresses (getsockname/getpeername)
        System.out.println("\n[Server] Address Info:");
        System.out.println("Local (getsockname): " + client.getLocalSocketAddress());
        System.out.println("Remote (getpeername): " + client.getRemoteSocketAddress());

        // Read data from client (simulate readv)
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println("\n[Server] Received: " + in.readLine());

        // Send data to client (simulate writev)
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("Hello from Server!");

        client.close();
        server.close();
    }
}