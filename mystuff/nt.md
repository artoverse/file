crc : 

```
    // enter number of data bits : 8
    // enter data : 1 0 1 1 1 0 1 1
    // enter size of generator : 5
    // enter generator : 1 1 0 0 1
    // the generator matrix : 101110110000       
    // the crc is : 0011
    // transmitter code for crc is : 101110110011

```

sliding windows


```
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

```
gobackn:

```
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
```

