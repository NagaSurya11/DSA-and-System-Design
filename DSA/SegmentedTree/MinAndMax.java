package DSA.SegmentedTree;

public class MinAndMax {
    static class PII {
        public long first;
        public long second;
    }

    public static int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    public static void constructSTUtil(long arr[], int ss, int se, PII st[], int si) {
        st[si] = new PII();
        if (ss == se) {
            st[si].first = st[si].second = arr[ss];
            return;
        }
        int mid = getMid(ss, se);
        constructSTUtil(arr, ss, mid, st, si * 2 + 1);
        constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);

        st[si].first = Math.min(st[si * 2 + 1].first, st[si * 2 + 2].first);
        st[si].second = Math.max(st[si * 2 + 1].second, st[si * 2 + 2].second);

        return;

    }

    public static PII[] constructST(long arr[], int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        PII st[] = new PII[max_size];
        constructSTUtil(arr, 0, n - 1, st, 0);

        return st;
    }

    /**
     * [11, 3, 7, 5]
     */
    /**
     * --------------------------------{3, 11}
     * --------------------------------(0, 3)
     * -------------{3, 11}--------------------------------{5, 7}
     * -------------(0, 1)---------------------------------(2, 3)
     * ----{11, 11}--------{3, 3}---------------{7, 7}--------------{5, 5}
     * ----(0, 0)----------(1, 1)---------------(2, 2)--------------(3, 3)
     */

    /**
     * getMinMax{st, qs: 0, qe: 2, ss: 0, se: 3, 0}
     * ------{
     * left = 3, 11
     * right= 5, 7
     * }
     */

    public static PII getMinMax(PII st[], int qs, int qe, int ss, int se, int idx) {
        // Your code here
        PII result = new PII();
        if (se < qs || ss > qe)
            return null;
        if (qs <= ss && qe >= se) {
            result = st[idx];
        } else {
            int mid = (ss + se) / 2;
            PII left = getMinMax(st, qs, qe, ss, mid, 2 * idx + 1);
            PII right = getMinMax(st, qs, qe, mid + 1, se, 2 * idx + 2);
            if (left != null && right != null) {
                result.first = Math.min(left.first, right.first);
                result.second = Math.max(left.second, right.second);
            } else if (right == null && left != null) {
                result = left;
            } else if (right != null && left == null) {
                result = right;
            } else {
                result.first = Integer.MAX_VALUE;
                result.second = Integer.MIN_VALUE;
            }
        }
        return result;
    }

    // Function to update a value in input array and segment tree.
    public static PII getMinMax(PII st[], long arr[], int n, int qs, int qe) {
        // Your code here
        return getMinMax(st, qs, qe, 0, n - 1, 0);
    }

    public static void updateUtil(PII st[], int ss, int se, int index, long new_val, int stIndex) {
        if(ss == se) {
            st[stIndex].first = new_val;
            st[stIndex].second = new_val;
        }else {
            int mid = getMid(ss, se);
            if(index <= mid) {
                updateUtil(st, ss, mid, index, new_val, 2 * stIndex + 1);
            }else {
                updateUtil(st, mid + 1, se, index, new_val, 2 * stIndex + 2);
            }
            PII left = st[2 * stIndex + 1];
            PII right = st[2 * stIndex + 2];
            st[stIndex].first = Math.min(left.first, right.first);
            st[stIndex].second = Math.max(left.second, right.second);
        }
    }

    // Function to return minimum and maximum of elements in range from index
    // qs (quey start) to qe (query end).
    public static void updateValue(long arr[], PII st[], int n, int index, long new_val) {
        // Your code here
        updateUtil(st, 0, n - 1, index, new_val, 0);
    }

    public static void main(String[] args) {
        long arr[] = { 11, 3, 7, 5, 9, 1 };
        PII st[] = constructST(arr, arr.length);
        PII pii = getMinMax(st, arr, arr.length, 1, 2);
        System.out.println(pii.first + " " + pii.second);
        updateValue(arr, st, arr.length, 3, 17);
        pii = getMinMax(st, arr, arr.length, 0, 5);
        System.out.println(pii.first + " " + pii.second);
    }
}
