// UDP File Client (UDPFileClient.java)
import java.net.*;
import java.io.*;

public class UDPFileClient {
    public static void main(String[] args) throws Exception {
        // Create a dummy file to send
        new PrintWriter("file_to_send_udp.txt").append("UDP File Transfer Test").close();

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        FileInputStream fIn = new FileInputStream("file_to_send_udp.txt");
        byte[] buffer = new byte[1024];
        
        System.out.println("Sending file...");
        int bytesRead;
        while ((bytesRead = fIn.read(buffer)) != -1) {
            DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, ip, 9876);
            clientSocket.send(sendPacket);
        }

        // Send End of File signal
        byte[] eof = "EOF".getBytes();
        DatagramPacket eofPacket = new DatagramPacket(eof, eof.length, ip, 9876);
        clientSocket.send(eofPacket);

        System.out.println("File sent.");
        fIn.close();
        clientSocket.close();
    }
}