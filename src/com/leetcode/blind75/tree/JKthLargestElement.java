package com.practice.leetcode.blind75.tree;

public class JKthLargestElement {

    int count = 0;
    int res = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void kthSmallestV2(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallestV2(root.right, k);
        count++;
        if (k == count) {
            res = root.val;
            return;
        }
        kthSmallestV2(root.left, k);
    }

}
