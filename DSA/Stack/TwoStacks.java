package DSA.Stack;

public class TwoStacks {
    private int arr[];
    private int idx1;
    private int idx2;
    TwoStacks(int capacity) {
        this.arr = new int[capacity];
        this.idx2 = capacity;
        this.idx1 = -1;
    }

    public boolean push1(int n) {
        if(idx1 < idx2 - 1) {
            arr[++idx1] = n;
            return true;
        }else {
            return false;
        }
    }
    public boolean push2(int n) {
        if(idx2 > idx1 + 1) {
            arr[--idx2] = n;
            return true;
        }else {
            return false;
        }
    }

    public Integer pop1() {
        if(idx1 > -1) {
            return arr[idx1--];
        }else {
            return null;
        }
    }
    public Integer pop2() {
        if(idx2 < arr.length) {
            return arr[idx2++];
        }else {
            return null;
        }
    }

    public int size1() {
        return idx1 + 1;
    }

    public int size2() {
        return arr.length - idx2;
    }


}
