// UDP Reverse Client (UDPClient.java)
import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        System.out.print("Enter sentence: ");
        String sentence = new BufferedReader(new InputStreamReader(System.in)).readLine();
        byte[] sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 9876);
        clientSocket.send(sendPacket); // Send to server

        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket); // Wait for response

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("FROM SERVER: " + response);
        clientSocket.close();
    }
}