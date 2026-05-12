package com.practice.leetcode.blind75.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EBinaryTreeLevelOrder {

    // Refer Video =
    // Step 1 : push the root node.
    // Step 2 : Remove from queue, print/add to result, check if left/right is present then add in the queue.

    static class TreeNode {
        int val = 0;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
//		root.left = new TreeNode(7);
//		root.left = new TreeNode(7);

        List<List<Integer>> result = traverse(root);
        System.out.println("Level Order Traversal = " + result);
    }

    private static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) return result;

        Queue<TreeNode> mq = new LinkedList<>();
        mq.add(root);
//		while(mq.size() > 0) {    // this condition is also true
        while (!mq.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = mq.size();  // calculate size of queue before running for loop

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = mq.remove();
                currentLevel.add(currNode.val);

                if (currNode.left != null) {
                    mq.add(currNode.left);
                }
                if (currNode.right != null) {
                    mq.add(currNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
