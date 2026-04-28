package com.practice.leetcode.blind75.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZBinaryTreeInOrderTraversalUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			list.add(root.val);
			root = root.right;

		}
		return list;
	}

//	Question : Kth Smallest Element in a BST

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0)
				break;
			root = root.right;
		}
		return root.val;
	}

}
