// UDP Reverse Server (UDPServer.java)
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        System.out.println("UDP Server is running...");
        byte[] receiveData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket); // Wait for a packet

            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
            String reversed = new StringBuilder(sentence).reverse().toString();

            InetAddress ip = receivePacket.getAddress();
            int port = receivePacket.getPort();
            byte[] sendData = reversed.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
            serverSocket.send(sendPacket); // Send response back
        }
    }
}