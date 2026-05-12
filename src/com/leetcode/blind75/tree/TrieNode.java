package com.practice.leetcode.blind75.tree;

public class TrieNode {

    TrieNode[] children;
    boolean isEndWord;

    public TrieNode() {

        children = new TrieNode[26];
        isEndWord = false;
    }

}
