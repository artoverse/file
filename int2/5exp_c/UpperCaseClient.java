import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UpperCaseClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String msg = sc.nextLine();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Server response: " + in.readLine());
        socket.close();
    }
}