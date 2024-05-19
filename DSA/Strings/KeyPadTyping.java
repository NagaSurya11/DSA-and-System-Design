package DSA.Strings;

import java.util.HashMap;

public class KeyPadTyping {
    public static String printNumber(String s, int n) {
        HashMap<Character, String> keyPad = new HashMap<>();
        keyPad.put('a', "2");
        keyPad.put('b', "2");
        keyPad.put('c', "2");
        keyPad.put('d', "3");
        keyPad.put('e', "3");
        keyPad.put('f', "3");
        keyPad.put('g', "4");
        keyPad.put('h', "4");
        keyPad.put('i', "4");
        keyPad.put('j', "5");
        keyPad.put('k', "5");
        keyPad.put('l', "5");
        keyPad.put('m', "6");
        keyPad.put('n', "6");
        keyPad.put('o', "6");
        keyPad.put('p', "7");
        keyPad.put('q', "7");
        keyPad.put('r', "7");
        keyPad.put('s', "7");
        keyPad.put('t', "8");
        keyPad.put('u', "8");
        keyPad.put('v', "8");
        keyPad.put('w', "9");
        keyPad.put('x', "9");
        keyPad.put('y', "9");
        keyPad.put('z', "9");
        String result = "";
        for(int i = 0; i < n; i++) {
            result += keyPad.get(s.charAt(i));
        }
        return result;
    }
}
