package com.practice.leetcode.blind75.tree;

public class BinaryTreeLongestConsecutivePath {

	public static void main(String[] args) {
		// https://www.youtube.com/watch?v=uIckKXYhZsY
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(7);
		root.right.left = new TreeNode(0);
		root.right.right= new TreeNode(8);
		
		System.out.println(longestConsecutive(root));

	}
	
	public static int longestConsecutive(TreeNode root) {
       
		if(root == null) {
			return 0;
		}
		int[] max = {Integer.MIN_VALUE};
		longestConsecutivePath(root, max);
        return max[0];
    }

	private static int longestConsecutivePath(TreeNode root, int[] max) {

		if(root == null) {
			return 0;
		}
		
		int left = longestConsecutivePath(root.left, max);
		int right = longestConsecutivePath(root.right, max);
		
		if(root.left != null && root.left.val == root.val + 1){
			left += 1;
		}else {
			left = 1;
		}
		if(root.right != null && root.right.val == root.val+1){
			right += 1;
		}else {
			right = 1;
		}
		
		max[0] = Math.max(max[0], Math.max(left, right));
		return Math.max(left, right);
		
	}

}
