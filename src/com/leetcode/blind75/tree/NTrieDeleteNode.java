package com.practice.leetcode.blind75.tree;

public class NTrieDeleteNode {

    public TrieNode delete(TrieNode root, String word, int i) {
        if (root == null) { // if root = null return null
            return null;
        }
        if (i == word.length()) {  // if we have reached to the end of the word then remove the last word
            root.isEndWord = false;
            if (isEmpty(root)) {
                root = null;
            }
            return root;
        }
        char c = word.charAt(i);
        root.children[c - 'a'] = delete(root.children[c - 'a'], word, i + 1);

        if (isEmpty(root) && root.isEndWord == false) {
            root = null;
        }
        return root;
    }

    private boolean isEmpty(TrieNode root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // -- delete trie node - https://www.youtube.com/watch?v=fzGVMOmBQWo

    }


}
