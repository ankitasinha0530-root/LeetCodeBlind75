package com.leetcode.blind75.tree;

public class CInvertAtreeORMirrorImage {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(7);
        p.right = new TreeNode(1);
        p.left.left = new TreeNode(9);
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(5);

        TreeNode root = invertTree(p);

        while (root != null) {
            System.out.print(root.val + ", ");
            if (root.left != null)
                root = root.left;

            if (root.right != null)
                root = root.right;
        }
    }

    private static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode leftToRoot = invertTree(root.left);
        TreeNode rightToRoot = invertTree(root.right);

        root.left = rightToRoot;
        root.right = leftToRoot;

        return root;
    }

}
