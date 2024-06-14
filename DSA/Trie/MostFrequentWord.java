package DSA.Trie;

public class MostFrequentWord {
    public class TrieNode {
        static final int ALPHABET_SIZE = 26;

        // trie node
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word

        int frequency;
        int occurenceIndex;

        TrieNode() {
            frequency = 0;
            occurenceIndex = Integer.MAX_VALUE;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

    // Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[], int n) {
        // code here
        TrieNode root = new TrieNode();
        int max = 0;
        int maxOccurenceIndex = -1;
        String result = "";
        int arrIndex = 0;
        for(String word: arr) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.frequency++;
            node.occurenceIndex = Math.min(node.occurenceIndex, arrIndex++);
            if (max < node.frequency || (max == node.frequency && maxOccurenceIndex < node.occurenceIndex)) {
                max = node.frequency;
                maxOccurenceIndex = node.occurenceIndex;
                result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"xejdcj", "xejdcj", "lvjpb", "tmyuiu", "lvjpb", "tmyuiu", "ovoba"
        , "lvjpb", "lvjpb", "fqhyu", "fqhyu", "tmyuiu", "xejdcj", "tmyuiu", "fqhyu", "ovoba", "xejdcj"};
        new MostFrequentWord().mostFrequentWord(arr, arr.length);
    }
}
