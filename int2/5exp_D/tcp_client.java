import java.io.*;
import java.net.Socket;

public class tcp_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("Connected to Server");

        while (true) {
            System.out.print("Text: ");
            String line = in.readLine();
            if (line == null || line.equalsIgnoreCase("exit")) break;

            writer.write(line);
            writer.newLine();
            writer.flush();

            String reply = reader.readLine();
            if (reply == null) break;
            System.out.println("Reply: " + reply);
        }

        socket.close();
        System.out.println("Disconnected");
    }
}
