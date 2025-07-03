import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.print("Enter message: ");
        String msg = sc.nextLine();
        out.println(msg);
        System.out.println(in.readLine());
        socket.close();
    }
}