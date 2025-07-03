import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PingWebsite {

    public static void commands(ArrayList<String> command) {
        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            System.out.println("Output:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));

            while ((line = errorReader.readLine()) != null) {
                System.err.println("Error: " + line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with code: " + exitCode);
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        ArrayList<String> cmd = new ArrayList<>();
        cmd.add("ping");
        cmd.add("www.google.com");

        commands(cmd);
    }
}