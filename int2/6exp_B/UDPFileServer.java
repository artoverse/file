// UDP File Server (UDPFileServer.java)
import java.net.*;
import java.io.*;

public class UDPFileServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        FileOutputStream fOut = new FileOutputStream("received_via_udp.txt");
        System.out.println("UDP File Server is waiting...");
        byte[] buffer = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(receivePacket);
            String received = new String(receivePacket.getData(), 0, receivePacket.getLength());

            if (received.equals("EOF")) { // Check for End of File signal
                System.out.println("File transfer complete.");
                break;
            }
            fOut.write(receivePacket.getData(), 0, receivePacket.getLength());
        }
        fOut.close();
        serverSocket.close();
    }
}