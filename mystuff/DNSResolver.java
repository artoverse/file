// DNS Resolver (DNSResolver.java)
import java.net.*;
import java.util.Scanner;

public class DNSResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter domain name (e.g., www.google.com): ");
        String domain = scanner.nextLine();

        try {
            InetAddress[] addresses = InetAddress.getAllByName(domain);
            System.out.println("IP Addresses for " + domain + ":");
            for (InetAddress addr : addresses) {
                System.out.println("-> " + addr.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("Could not find host: " + domain);
        }
        scanner.close();
    }
}




