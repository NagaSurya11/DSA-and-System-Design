package DSA.SegmentedTree;

public class LCM {
    public static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    private static long getLCM(long[] st, int qs, int qe, int ss, int se, int node) {
        if (se < qs || ss > qe) {
            return 1;
        }else if(qs <= ss && qe >= se) {
            return st[node];
        }else {
            int mid = getMid(ss, se);
            long leftLCM = getLCM(st, qs, qe, ss, mid, node * 2 + 1);
            long rightLCM = getLCM(st, qs, qe, mid + 1, se, node * 2 + 2);
            return lcm(leftLCM, rightLCM);
        }
    }

    // Function to find LCM of given range.
    public static long getLCM(long st[], long arr[], int n, int qs, int qe) {
        // Your code here
        return getLCM(st, qs, qe, 0, n - 1, 0);
    }

    public static void updateValue(long st[], int ss, int se, int index, long value, int node) {
        if(ss == se) {
            st[node] = value;
        }else {
            int mid = getMid(ss, se);
            if(index <= mid) {
                updateValue(st, ss, mid, index, value, node * 2 + 1);
            }else {
                updateValue(st, mid + 1, se, index, value, node * 2 + 2);
            }
            long a = st[node * 2 + 1];
            long b = st[node * 2 + 2];
            st[node] = lcm(a, b);
        }
    }

    // Function to update a value in input array and segment tree.
    public static void updateValue(long arr[], long st[], int n, int index, long new_val) {
        // Your code here
        if(index > n - 1) return;
        arr[index] = new_val;
        updateValue(st, 0, n - 1, index, new_val, 0);
    }
}
