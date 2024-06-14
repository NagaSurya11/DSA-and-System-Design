package DSA.BinaryIndexedTree;

public class Sum {
    int[] arr;
    int[] bTree;
    Sum(int arr[]) {
        this.arr = arr;
        this.bTree = new int[arr.length + 1];
        constructBIT();
    }
    int getSum(int index) {
        index++;
        int result = 0;
        while (index > 0) {
            result += bTree[index];
            index = index - (index & -index);
        }

        return result;
    }

    void update(int index, int val) {
        int difference = val - arr[index];
        arr[index] = val;
        index ++;
        while (index < bTree.length) {
            bTree[index] += difference;
            index += (index & -index);
        }
    }

    void constructBIT() {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int index = i + 1;
            while (index <= n) {
                bTree[index] += arr[i];
                index += (index & -index);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
    }
}
