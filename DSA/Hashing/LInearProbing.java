package DSA.Hashing;

import java.util.Arrays;

public class LInearProbing {

    // Function to fill the array elements into a hash table
    // using Linear Probing to handle collisions.
    static int[] linearProbing(int hashSize, int arr[], int sizeOfArray) {
        // Your code here
        // Your code here
        int[] map = new int[hashSize];
        Arrays.fill(map, -1);
        for (int i = 0; i < sizeOfArray; i++) {
            int key = arr[i] % hashSize;
            if (map[key] == -1) {
                map[key] = arr[i];
            } else {
                int counter = 0;
                boolean isExists = false;
                while(counter < hashSize && map[key] != -1) {
                    if(map[key] == arr[i]) {
                        isExists = true;
                        break;
                    }
                    key = ( key + 1 ) % hashSize;
                    counter++;
                }
                if(!isExists && counter < hashSize) {
                    map[key] = arr[i];
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int hashSize = 10,
                sizeOfArray = 4,
                Array[] = { 9, 99, 999, 9999 };
        for(int i: linearProbing(hashSize, Array, sizeOfArray)) {
            System.out.print(i + " ");
        }
    }
}
