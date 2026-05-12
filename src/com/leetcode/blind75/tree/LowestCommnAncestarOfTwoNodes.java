package com.leetcode.blind75.tree;

public class LowestCommnAncestarOfTwoNodes {

    public static void main(String[] args) {
        // https://www.youtube.com/watch?v=cOjLyASDJcc

        //  https://www.youtube.com/watch?v=cOjLyASDJcc&t=2s

    }

    public static int lowestCommonAncestor(TreeNode root, int p, int q) {

        TreeNode currNode = root;

        while (currNode != null) {
            if (currNode.val < p && currNode.val < q) {
                currNode = currNode.right;
            } else if (currNode.val > p && currNode.val > q) {
                currNode = currNode.left;
            } else {
                return currNode.val;
            }
        }

        return -1;

    }
}
