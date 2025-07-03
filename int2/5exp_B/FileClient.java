// File Client (FileClient.java)
import java.net.*;
import java.io.*;

public class FileClient {
    public static void main(String[] args) throws IOException {
        // Create a dummy file to send
        new PrintWriter("file_to_send.txt").append("This is a test file.").close();
        
        Socket socket = new Socket("127.0.0.1", 65432);
        File file = new File("file_to_send.txt");
        FileInputStream fIn = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fIn.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        System.out.println("File sent successfully.");
        fIn.close();
        socket.close();
    }
}