package DSA.SegmentedTree;

public class GetSumAndUpdate {

    private int arr[];
    private int tree[];

    GetSumAndUpdate(int arr[]) {
        tree = new int[4 * arr.length];
        this.arr = arr;
        constructST(0, arr.length - 1, 0);
    }

    private int constructST(int start, int end, int treeIndex) {
        if (start == end) {
            tree[treeIndex] = arr[start];
        } else {
            int mid = (start + end) / 2;
            tree[treeIndex] = constructST(start, mid, (2 * treeIndex) + 1)
                    + constructST(mid + 1, end, (2 * treeIndex) + 2);
        }
        return tree[treeIndex];
    }

    private int getSum(int queryStart, int queryEnd, int treeStart, int treeEnd, int treeIndex) {
        if (treeEnd < queryStart || treeStart > queryEnd) {
            return 0;
        } else if (queryStart <= treeStart && queryEnd >= treeEnd) {
            return tree[treeIndex];
        } else {
            int mid = (treeStart + treeEnd) / 2;
            return getSum(queryStart, queryEnd, treeStart, mid, (2 * treeIndex) + 1) +
                    getSum(queryStart, queryEnd, mid + 1, treeEnd, (2 * treeIndex) + 2);
        }
    }

    int getSum(int start, int end) {
        return getSum(start, end, 0, arr.length - 1, 0);
    }

    private void update(int start, int end, int treeIndex, int index, int diff) {
        // if index not in range don't update
        if(start > index || end < index) {
            return;
        } else {
            tree[treeIndex]+= diff;
            if (start < end) {
                int mid = ( start + end ) / 2;
                update(start, mid, (2 * treeIndex) + 1, index, diff);
                update(mid + 1, end, (2 * treeIndex) + 2, index, diff);
            }
        }
    }
    void update(int index, int value) {
        int difference = value - arr[index];
        update(0, arr.length - 1, 0, index, difference);
    }

    private void _printTree() {
        for (int i : tree) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40 };
        GetSumAndUpdate obj = new GetSumAndUpdate(arr);
        System.out.println(obj.getSum(0, 1));
        obj.update(0, 20);
        System.out.println(obj.getSum(0, 1));
    }
}
