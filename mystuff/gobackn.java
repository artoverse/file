import java.util.Scanner;

public class gobackn {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int windowSize = 0;

        // Ask user for window size
        System.out.print("Enter Window Size: ");
        windowSize = scanner.nextInt();

        int sent = 0;  // To keep track of the next frame to be sent
        int ack = 0;   // To store the last acknowledged frame

        while (true) {
            // Send frames in current window
            for (int i = 0; i < windowSize; i++) {
                System.out.println("Frame Transmitted: " + sent);
                sent++;

                // If sent reaches the end of the window, stop sending
                if (sent == windowSize) {
                    break;
                }
            }

            // Ask for the last received acknowledgment
            System.out.print("Enter last received acknowledgment: ");
            ack = scanner.nextInt();

            // If all frames are acknowledged, end transmission
            if (ack == windowSize) {
                System.out.println("All frames acknowledged. Transmission complete.");
                break;
            } else {
                // Go back to the last acknowledged frame
                sent = ack;
                System.out.println("Resending from frame " + sent + " due to missing acknowledgment.");
            }
        }

        scanner.close();
    }
}

// Enter Window Size: 8
// Frame Transmitted: 0
// Frame Transmitted: 1
// Frame Transmitted: 2
// Frame Transmitted: 3
// Frame Transmitted: 4
// Frame Transmitted: 5
// Frame Transmitted: 6
// Frame Transmitted: 7
// Enter last received acknowledgment: 2
// Resending from frame 2 due to missing acknowledgment.
// Frame Transmitted: 2
// Frame Transmitted: 3
// Frame Transmitted: 4
// Frame Transmitted: 5
// Frame Transmitted: 6
// Frame Transmitted: 7
// Enter last received acknowledgment: 8
// All frames acknowledged. Transmission complete.


