package DSA.Hashing;

import java.util.Arrays;

public class QuadratingProbing {
    // Function to fill the array elements into a hash table
    // using Quadratic Probing to handle collisions.
    static void quadraticProbing(int[] map, int hashSize, int arr[], int N) {
        // Your code here
        Arrays.fill(map, -1);
        for (int i = 0; i < N; i++) {
            int key = arr[i] % hashSize;
            if (map[key] == -1) {
                map[key] = arr[i];
            } else {

                for (int j = 0; j < hashSize; j++) {
                    // Computing the new hash value
                    int t = (key + j * j) % hashSize;

                    // if already exists dont add
                    if (map[t] == arr[i])
                        break;

                    if (map[t] == -1) {

                        // Break the loop after
                        // inserting the value
                        // in the table
                        map[t] = arr[i];
                        break;
                    }
                }
            }
        }
    }
}
