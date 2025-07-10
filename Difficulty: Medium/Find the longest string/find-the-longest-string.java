import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class Solution {
    public String longestString(String[] arr) {
        Arrays.sort(arr); // Lexicographical order
        TrieNode root = new TrieNode();
        String result = "";

        for (String word : arr) {
            if (insert(word, root)) {
                if (word.length() > result.length() || 
                    (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }

    // Inserts the word only if all prefixes already exist
    private boolean insert(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                if (i != word.length() - 1) return false; // intermediate prefix missing
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            if (i < word.length() - 1 && !node.isEnd) return false; // missing earlier prefix
        }
        node.isEnd = true;
        return true;
    }
}
