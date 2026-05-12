package com.leetcode.blind75.tree;

public class DPathWithMaxSumFromRootToLeaf {

    //Refer Video = https://www.youtube.com/watch?v=ElKcXGkYldA
    //Refer Vodeo = https://www.youtube.com/watch?v=WszrfSwMz58&t=889s

    //Find the path with the maximum sum in a given binary tree.
    //Write a function that returns the maximum sum.
    //A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        int result = pathWithMaxSumFromRootToLeaf(root);
        System.out.println("Level Order Traversal = " + result);


    }

    private static int pathWithMaxSumFromRootToLeaf(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null & root.right == null) {
            return root.val;
        }

        int leftSum = pathWithMaxSumFromRootToLeaf(root.left);
        int rightSum = pathWithMaxSumFromRootToLeaf(root.right);

        return root.val + Math.max(leftSum, rightSum);
    }

}
