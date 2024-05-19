package DSA.Strings;

public class ReverseWordsInString {
    String reverse(String S, int s, int e) {
        char arr[] = S.toCharArray();
        int start = s;
        int end = e;
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return new String(arr);
    }

    String reverseWords(String S) {
        // code here
        int start = 0;
        for (int end = 0; end < S.length(); end++) {
            if (S.charAt(end) == '.') {
                S = reverse(S, start, end - 1);
                start = end + 1;
            }
        }

        S = reverse(S, start, S.length() - 1);

        S = reverse(S, 0, S.length() - 1);
        return S;
    }
}
