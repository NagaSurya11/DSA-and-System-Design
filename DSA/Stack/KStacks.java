package DSA.Stack;

import java.util.Stack;

public class KStacks {
    int arr[];
    int n;
    int k;
    int next[];
    int top[];
    int free = 0;

    KStacks(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        next = new int[n];
        top = new int[k];
        for(int i = 0; i < k; i++) {
            top[i] = -1;
        }
        for(int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    void push(int stackNo, int element) {
        int idx = free;
        free = next[idx];
        next[idx] = top[stackNo - 1];
        top[stackNo - 1] = idx;
        arr[idx] = element;
    }

    int pop(int stackNo) {
        int i = top[stackNo - 1];
        top[stackNo - 1] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }

    public static void main(String[] args) {
        KStacks kStacks = new KStacks(6, 2);
        kStacks.push(1, 1);
        kStacks.push(2, 10);
        kStacks.push(2, 12);
        kStacks.push(1, 11);
        kStacks.pop(2);
        kStacks.pop(2);
        kStacks.push(1, 11);
    }
}
