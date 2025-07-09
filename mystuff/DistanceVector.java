// Experiment 4: Distance Vector Routing
public class DistanceVector {
    public static void main(String[] args) {
        // 1. Define the network
        int nodes = 4;
        int infinity = 999;
        // Cost matrix: cost from node i to node j
        int[][] costMatrix = {
            {0, 2, 5, infinity},
            {2, 0, 1, 6},
            {5, 1, 0, 2},
            {infinity, 6, 2, 0}
        };

        // 2. Initialize routing tables
        int[][] distance = new int[nodes][nodes];
        int[][] nextHop = new int[nodes][nodes];

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                distance[i][j] = costMatrix[i][j]; // Initial distance is the direct cost
                if (costMatrix[i][j] != infinity) {
                    nextHop[i][j] = j; // The first hop is the destination itself
                }
            }
        }

        // 3. Iteratively update tables
        for (int i = 0; i < nodes; i++) {       // For each destination 'i'
            for (int j = 0; j < nodes; j++) {   // Each node 'j' sends its table to neighbors
                for (int k = 0; k < nodes; k++) { // Check if path via neighbor 'k' is shorter
                    if (distance[j][i] > distance[j][k] + distance[k][i]) {
                        distance[j][i] = distance[j][k] + distance[k][i];
                        nextHop[j][i] = k;
                    }
                }
            }
        }

        // 4. Print final routing tables
        for (int i = 0; i < nodes; i++) {
            System.out.println("Routing table for Node " + i + ":");
            System.out.println("Dest\tNext Hop\tCost");
            for (int j = 0; j < nodes; j++) {
                System.out.println(j + "\t" + nextHop[i][j] + "\t\t" + distance[i][j]);
            }
            System.out.println();
        }
    }
}


