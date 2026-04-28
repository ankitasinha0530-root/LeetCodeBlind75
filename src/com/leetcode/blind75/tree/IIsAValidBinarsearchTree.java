package com.practice.leetcode.blind75.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IIsAValidBinarsearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidBSTUsingList(TreeNode root) {
		if (root == null) return true;
		   
		List<Integer> inOrderList = new ArrayList<>();
		
		inOrderTraversal(root, inOrderList);
		
		for (int i = 1; i < inOrderList.size(); i++) {
			if(inOrderList.get(i) <= inOrderList.get(i-1)) {
				return false;
			}
		}
		return true;
		}
	
	void inOrderTraversal(TreeNode node, List<Integer> inOrderList) {
			
		if(node == null) {return;}
		inOrderTraversal(node.left, inOrderList);
		inOrderList.add(node.val);
		inOrderTraversal(node.right, inOrderList);
	}

//	Validate  Binary Search Tree Using Stack
	
	public boolean isValidBST(TreeNode root) {
	   if (root == null) return true;
	   Stack<TreeNode> stack = new Stack<>();
	   TreeNode pre = null;
	   while (root != null || !stack.isEmpty()) {
	      while (root != null) {
	         stack.push(root);
	         root = root.left;
	      }
	      root = stack.pop();
	      if(pre != null && root.val <= pre.val) return false;
	      pre = root;
	      root = root.right;
	   }
	   return true;
	}

}
