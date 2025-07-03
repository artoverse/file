// File Server (FileServer.java)
import java.net.*;
import java.io.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(65432);
        System.out.println("Server waiting for file...");
        Socket client = serverSocket.accept();

        InputStream in = client.getInputStream();
        FileOutputStream fOut = new FileOutputStream("received_file.txt");

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            fOut.write(buffer, 0, bytesRead);
        }

        System.out.println("File received successfully.");
        fOut.close();
        serverSocket.close();
    }
}