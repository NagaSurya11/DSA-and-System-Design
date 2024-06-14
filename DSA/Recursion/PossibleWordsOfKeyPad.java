package DSA.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PossibleWordsOfKeyPad {
    static List<String> keyPad = new ArrayList<>(
        List.of(
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3, so on
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz" // 9

        )
    );
    static void backTrack(ArrayList<String> result, int[] digits,
        StringBuffer current, int i) {
            if(current.length() == digits.length) {
                result.add(current.toString());
                return;
            }
            String letters = keyPad.get(digits[i]);

            for(char letter : letters.toCharArray()) {
                current.append(letter);
                backTrack(result, digits, current, i + 1);
                current.deleteCharAt(current.length() - 1);
            }
    }
    // Function to find list of all words possible by pressing given numbers.
    static ArrayList<String> possibleWords(int a[], int N) {
        // your code here
        ArrayList<String> result = new ArrayList<>();
        backTrack(result, a, new StringBuffer(), 0);
        return result;
    }

    public static void main(String[] args) {
        int N = 3;
        int[] digits = {2, 3, 4};
        possibleWords(digits, N).forEach(word -> {
            System.out.print(word + " ");
        });
    }
}
