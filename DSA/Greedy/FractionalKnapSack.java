package DSA.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {
    class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        Comparator<Item> comparator = (o1, o2) -> Double.compare((double) o2.value / (double) o2.weight,
                (double) o1.value / (double) o1.weight);
        Arrays.sort(arr, comparator);

        double result = 0;
        for (Item item : arr) {
            if (w >= item.weight) {
                result += item.value;
                w -= item.weight;
            } else {
                        result += ((double) w / (double) item.weight) * (double) item.value;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3,
                w = 50,
                value[] = { 60, 100, 120 },
                weight[] = { 10, 20, 30 };
        Item[] arr = new Item[n];
        FractionalKnapSack obj = new FractionalKnapSack();
        for (int i = 0; i < n; i++) {
            arr[i] = obj.new Item(value[i], weight[i]);
        }

        System.out.println(obj.fractionalKnapsack(w, arr, n));
    }
}
