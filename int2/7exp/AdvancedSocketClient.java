import java.net.*;
import java.io.*;

public class AdvancedSocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to server.");

        // Get socket options (getsockopt)
        System.out.println("\n[Client] Socket Options:");
        System.out.println("TCP No Delay: " + socket.getTcpNoDelay());

        // Set socket options (setsockopt)
        socket.setSendBufferSize(8192); // Increase send buffer
        System.out.println("Set Send Buffer: 8192 bytes");

        // Get local and remote addresses (getsockname/getpeername)
        System.out.println("\n[Client] Address Info:");
        System.out.println("Local (getsockname): " + socket.getLocalSocketAddress());
        System.out.println("Remote (getpeername): " + socket.getRemoteSocketAddress());

        // Send data to server (simulate writev)
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello from Client!");

        // Read data from server (simulate readv)
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("\n[Client] Received: " + in.readLine());

        socket.close();
    }
}