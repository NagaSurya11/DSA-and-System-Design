package DSA.SegmentedTree;

public class RangeGCD {
    public static int[] constructSegmentTree(int[] arr) {
        int height = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int size = 2 * (int) Math.pow(2, height) - 1;
        int[] st = new int[size];
        constructST(arr, st, 0, arr.length - 1, 0);
        return st;
    }

    // A recursive function that constructs Segment
    // Tree for array[ss..se]. si is index of current
    // node in segment tree st
    public static int constructST(int[] arr, int st[], int ss,
            int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return st[si];
        }
        int mid = ss + (se - ss) / 2;
        st[si] = gcd(constructST(arr, st, ss, mid, si * 2 + 1),
                constructST(arr, st, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    // Function to find gcd of 2 numbers.
    private static int gcd(int a, int b) {
        if (a < b) {
            // If b greater than a swap a and b
            int temp = b;
            b = a;
            a = temp;
        }

        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    public static int findRangeGcd(int st[], int qs,
            int qe, int ss, int se, int idx) {
        if (se < qs || ss > qe)
            return 0;
        if (qs <= ss && qe >= se) {
            return st[idx];
        }
        int mid = getMid(ss, se);
        int leftGcd = findRangeGcd(st, qs, qe, ss, mid, idx * 2 + 1);
        int rightGcd = findRangeGcd(st, qs, qe, mid + 1, se, idx * 2 + 2);
        return gcd(leftGcd, rightGcd);
    }

    // Function to find gcd of given range.
    public static int findRangeGcd(int l, int r, int st[], int n) {
        // Your code here
        return findRangeGcd(st, l, r, 0, n - 1, 0);
    }

    public static void updateValue(int[] st, int ss, int se, int idx, int new_value, int stIdx) {
        if (ss == se) {
            st[stIdx] = new_value;
        } else {
            int mid = getMid(ss, se);
            if(idx <= mid) {
                updateValue(st, ss, mid, idx, new_value, stIdx * 2 + 1);
            }else {
                updateValue(st, mid + 1, se, idx, new_value, stIdx * 2 + 2);
            }

            int left = st[stIdx * 2 + 1];
            int right = st[stIdx * 2 + 2];
            st[stIdx] = gcd(left, right);
        }
    }

    // Function to update a value in input array and segment tree.
    public static void updateValue(int index, int new_val, int arr[], int st[], int n) {
        // Your code here
        updateValue(st, 0, n - 1, index, new_val, 0);
    }
}
