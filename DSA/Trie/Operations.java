package DSA.Trie;

public class Operations {
    // Function to insert string into TRIE.
    static TrieNode root = new TrieNode();

    static void insert(String key) {
        // Your code here
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
    }

    // Function to use TRIE data structure and search the given string.
    static boolean search(String key) {
        // Your code here
        TrieNode temp = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
        }
        return temp.isEndOfWord;
    }

    // Returns true if root has no children
    // else false
    static boolean hasNoChild(TrieNode currentNode) {
        for (int level = 0; level < currentNode.children.length; level++) {
            if (currentNode.children[level] != null) {
                return false;
            }
        }

        return true;
    }

    static boolean removeUtil(TrieNode currentNode, String key,
            int level, int length) {
        // If tree is empty
        if (currentNode == null) {
            System.out.println("Does not exist");
            return false;
        }

        // If last character of key is being processed
        if (level == length) {

            // This node is no more end of word after
            // removal of given key
            currentNode.isEndOfWord = false;

            // If given is not prefix of any other word
            if (hasNoChild(currentNode)) {
                return true;
            } else {
                return false;
            }
        } else {

            // If not last character, recur for the child
            // obtained using ASCII value
            TrieNode childNode = currentNode.children[key.charAt(level) - 'a'];

            boolean childDeleted = removeUtil(childNode, key, level + 1, length);

            if (childDeleted) {
                // If root does not have any child
                // (its only child got
                // deleted), and it is not end of another word.
                return (currentNode.isEndOfWord
                        && hasNoChild(currentNode));
            }
        }

        return false;
    }

    // Recursive function to delete a key
    // from given Trie
    static void remove(String key) {
        int length = key.length();

        if (length > 0) {
            removeUtil(root, key, 0, length);
        }
    }

    public static void main(String[] args) {
        String[] words = { "the", "a", "there", "answer", "any", "by", "bye",
                "their" };
        String[] Queries = { "the", "an", "any" };

        for (String word : words) {
            insert(word);
        }

        for (String key : Queries) {
            System.out.println(search(key));
        }
    }
}
