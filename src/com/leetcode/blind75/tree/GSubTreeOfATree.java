package com.practice.leetcode.blind75.tree;

public class GSubTreeOfATree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubtreeUsingStringB(TreeNode root, TreeNode subRoot) {

		if (subRoot == null)
			return true;
		if (root == null)
			return false;

		String fullTree = preOrderTraversal(root); // extract the string in pre-order traversal for main tree
		String SubTreeTree = preOrderTraversal(root); // extract the string in pre-order traversal for target tree

		return (fullTree.contains(SubTreeTree));
	}

	private String preOrderTraversal(TreeNode node) {
		if (node == null)
			return "null";

		StringBuilder sb = new StringBuilder();
		sb.append(node.val);
		sb.append(preOrderTraversal(node.left));
		sb.append(preOrderTraversal(node.right));

		return sb.toString();
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {

		if (subRoot == null)
			return true;
		if (root == null)
			return false;
		if (helper(root, subRoot))
			return true;
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

	}
	
//	Use either helper method or DFS

	public boolean helper(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		return (root1 != null && root2 != null && root1.val == root2.val) && helper(root1.left, root2.left)
				&& helper(root1.right, root2.right);
	}

	public boolean dfs(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null)
			return true;
		if (root == null || subRoot == null)
			return false;
		if (root.val != subRoot.val)
			return false;
		return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
	}

}
