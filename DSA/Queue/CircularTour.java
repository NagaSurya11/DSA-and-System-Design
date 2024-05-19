package DSA.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]) {
        // Your code here
        int capacity = 0;
        int defecit = 0;
        int start = 0;
        int n = petrol.length;
        for (int i = 0; i < n; i++) {
            capacity += petrol[i] - distance[i];
            if (capacity < 0) {
                start = i + 1;
                defecit += capacity;
                capacity = 0;
            }
        }
        return capacity + defecit >= 0 ? start : -1;
    }
}
