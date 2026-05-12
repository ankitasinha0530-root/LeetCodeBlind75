package com.practice.leetcode.blind75.tree;

public class AMaxmHeightOrDepthOfATree {

    //Given a binary tree, find the length of its diameter.
    //The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
    //The diameter of a tree may or may not pass through the root.

    // If the diameter passes through root then Diameter = leftHeight + RightHeight + 2

    // In order to find the diameter we need to find the height of left and right as well

    // refer video = https://www.youtube.com/watch?v=S0Bwgtn32uI
    // refer video = https://www.youtube.com/watch?v=zM9N_x_v_24

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);

        System.out.println(" Max height of a tree = " + maxHeight(root));

    }

    // Here we are extracting both maximum height
    private static int maxHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = maxHeight(root.left);
        int rh = maxHeight(root.right);

        int ht = Math.max(lh, rh) + 1;

        return ht;
    }


}
