package com.practice.leetcode.blind75.tree;

public class OWordDictionaryUsingTrie {

    TrieNode root;

    public OWordDictionaryUsingTrie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
//		WordDictionary wordDictionary = new WordDictionary();
//		wordDictionary.addWord("bad");
//		wordDictionary.addWord("dad");
//		wordDictionary.addWord("mad");
//		wordDictionary.search("pad"); // return False
//		wordDictionary.search("bad"); // return True
//		wordDictionary.search(".ad"); // return True
//		wordDictionary.search("b.."); // return True

    }

    public void addWord(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEndWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;

        return searchWord(word, node, 0);
    }

    private boolean searchWord(String word, TrieNode node, int index) {

        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if (c == '.') {   // check for all the children of this node where the subsequent word lies
            for (int j = 0; j < 26; j++) {
                if (searchWord(word, node.children[j], index + 1)) {
                    return true;
                }
            }
        } else { // find the children of the character
            if (searchWord(word, node.children[c - 'a'], index + 1)) {
                return true;
            }
        }

        return false;
    }


}
