import java.util.Scanner;

public class SlidingWindowProtocol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for window size
        System.out.print("Enter window size: ");
        int windowSize = scanner.nextInt();

        // Ask for number of frames to transmit
        System.out.print("Enter number of frames to transmit: ");
        int totalFrames = scanner.nextInt();

        // Create an array to hold the frames
        int[] frames = new int[totalFrames];

        // Read each frame
        System.out.println("Enter " + totalFrames + " frames:");
        for (int i = 0; i < totalFrames; i++) {
            frames[i] = scanner.nextInt();
        }

        // Show how frames will be sent using sliding window protocol
        System.out.println("\nWith sliding window protocol, the frames will be sent in the following manner (assuming no corruption of frames):");
        System.out.println("\nAfter sending " + windowSize + " frames at each stage, sender waits for acknowledgement sent by the receiver.\n");

        // Simulate sending frames in windows
        for (int i = 0; i < totalFrames; i++) {
            // Print current frame
            System.out.print(frames[i] + " ");

            // If window is full, simulate acknowledgement
            if ((i + 1) % windowSize == 0) {
                System.out.println("\nAcknowledgement of above frames sent is received by sender.\n");
            }
        }

        // If some frames are left in the last window (less than window size)
        if (totalFrames % windowSize != 0) {
            System.out.println("\nAcknowledgement of above frames sent is received by sender.");
        }

        scanner.close();
    }
}

// Enter window size: 3
// Enter number of frames to transmit: 5
// Enter 5 frames:
// 12 5 89 4 6

// With sliding window protocol, the frames will be sent in the following manner (assuming no corruption of frames):

// After sending 3 frames at each stage, sender waits for acknowledgement sent by the receiver.

// 12 5 89 
// Acknowledgement of above frames sent is received by sender.

// 4 6 
// Acknowledgement of above frames sent is received by sender.