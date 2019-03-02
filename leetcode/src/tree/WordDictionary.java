package tree;

/**
 * @Author: Usher
 * @Date: 2019/3/2/0002
 * @Description:
 */
public class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    /**
     * Initialize your data structure here.
     */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c =word.charAt(i);
            if (ws.children[c - 'a'] == null) {
                ws.children[c - 'a'] = new TrieNode();
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(word, root, 0);
    }

    boolean searchWord(String word, TrieNode ws, int i) {
        if (i == word.length())
            return ws.isWord;

        if (word.charAt(i) == '.') {
            for (TrieNode trieNode : ws.children) {
                if (trieNode == null && searchWord(word, trieNode, i + 1)) {
                    return true;
                }

            }
            return false;
        } else {
            return ws.children[word.charAt(i) - 'a'] != null  && searchWord(word, ws.children[word.charAt(i) - 'a'], i + 1);
        }
    }
}
