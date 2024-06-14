package DSA.Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllWords {
    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;
        List<String> words;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
            words = new ArrayList<>();
        }

    }

    static void insert(TrieNode root, String key) {
        // Your code here
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (!temp.children.containsKey(ch)) {
                temp.children.put(ch, new TrieNode());
            }
            temp = temp.children.get(ch);
            if (Character.isUpperCase(ch)) {
                temp.words.add(temp.words.size(), key);
            }
        }
    }

    static TrieNode getMatchedRoot(TrieNode node, char ch) {
        for (Map.Entry<Character, TrieNode> set : node.children.entrySet()) {
            if (set.getKey() == ch) {
                return set.getValue();
            } else {
                TrieNode temp = getMatchedRoot(set.getValue(), ch);
                if(temp != null) {
                    return temp;
                }
            }
        }
        return null;
    }

    static List<String> searchPattern(TrieNode root, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            TrieNode temp = getMatchedRoot(root, ch);
            if (temp != null) {
                root = temp;
            } else {
                return new ArrayList<>();
            }
        }
        Comparator<String> comparator = (o1, o2) -> {
            StringBuffer s1 = new StringBuffer("");
            StringBuffer s2 = new StringBuffer("");
            for(char ch: o1.toCharArray()) {
                if(Character.isUpperCase(ch)) {
                    s1.append(ch);
                }
            }
            for(char ch: o2.toCharArray()) {
                if(Character.isUpperCase(ch)) {
                    s2.append(ch);
                }
            }
            if(s1.toString().equals(s2.toString())) {
                return o1.compareTo(o2);
            }
            return s1.compareTo(s2);
        };
        root.words.sort(comparator);
        return root.words;
    }

    // Function to print all words in the CamelCase dictionary
    // that matches with a given pattern.
    static void findAllWords(String[] dict, String pattern) {
        // Your code here
        TrieNode root = new TrieNode();
        for (String word : dict) {
            insert(root, word);
        }
        List<String> result = searchPattern(root, pattern);
        if (result.size() == 0) {
            System.out.print("No match found");
        } else {
            result.forEach(word -> {
                System.out.print(word + " ");
            });
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String dict[] = { "Hi", "Hello", "HelloWorld", "HiTech",
                "HiGeek", "HiTechWorld", "HiTechCity", "HiTechLab" };
        String pattern = "H";
        findAllWords(dict, pattern);
    }
}
