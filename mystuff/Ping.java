import java.io.*;

public class Ping {
    public static void main(String[] args) throws Exception {
        String host = "google.com";
        String os = System.getProperty("os.name").toLowerCase();
        String[] cmd = os.contains("win") ? new String[]{"ping", "-n", "1", host}
                                          : new String[]{"ping", "-c", "1", host};

        while (true) {
            Process process = new ProcessBuilder(cmd).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            Thread.sleep(1000); // Wait 1 second before next ping
        }
    }
}

