package tree;

import java.util.HashMap;

/**
 * @Author: Usher
 * @Description:
 */
public class Trie {
    /*   *//** Initialize your data structure here. *//*

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    *//** Inserts a word into the trie. *//*
    public void insert(String word) {
        char[] s = word.toCharArray();

        TrieNode p = root;
        int i = 0, n = s.length;
        while (i < n) {
            TrieNode next = p.nexts.get(s[i]);
            if (next != null) {
                p = next;
                i++;
            } else {
                break;
            }
        }

        while (i < n) {
            TrieNode newTrie = new TrieNode();
            p.nexts.put(s[i], newTrie);
            p = newTrie;
            i++;
        }

        p.isWord = true;
    }

    *//** Returns if the word is in the trie. *//*
    public boolean search(String word) {

        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = p.nexts.get(word.charAt(i));
            if (child == null) {
                return false;
            }

            p = child;
        }
        return p.isWord;
    }

    */

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     *//*
    public boolean startsWith(String prefix) {
        TrieNode p = root;

        for (int i = 0; i < prefix.length(); i++) {
            TrieNode child = p.nexts.get(prefix.charAt(i));

            if (child == null) {
                return false;
            }
            p = child;
        }
        return true;
    }
}
class TrieNode{
    boolean isWord;
    HashMap<Character,TrieNode> nexts;

    TrieNode() {
        nexts = new HashMap<>();
    }
}*/

    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
    }


    /**
     * Initialize your data structure here.
     */
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null)
                ws.children[c - 'a'] = new TrieNode();
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (ws.children[c - 'a'] == null)
                return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}