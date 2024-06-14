package DSA.Hashing;

import java.util.ArrayList;

public class Chaining {
    private int hash(int element, int hash_size) {
        return element % hash_size;
    }

    // Function to insert elements of array in the hashTable avoiding collisions.
    public ArrayList<ArrayList<Integer>> separateChaining(int arr[], int n, int hashSize) {
        // Your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < hashSize; i++) {
            result.add(new ArrayList<>());
        }
        for (int i : arr) {
            int key = hash(i, hashSize);
            result.get(key).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int hashSize = 10,
                sizeOfArray = 6,
                arr[] = { 92, 4, 14, 24, 44, 91 };
        new Chaining()
            .separateChaining(arr, sizeOfArray, hashSize)
            .forEach(list -> {
                if(!list.isEmpty()) {
                    list.forEach(element -> {
                        System.out.print(element + " -> ");
                    });
                    System.out.println();
                }
            });
    }
}
