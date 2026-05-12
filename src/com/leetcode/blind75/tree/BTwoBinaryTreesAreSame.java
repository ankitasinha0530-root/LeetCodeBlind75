package com.leetcode.blind75.tree;

public class BTwoBinaryTreesAreSame {

    public static void main(String[] args) {

        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(7);
        p.right = new TreeNode(1);
        p.left.left = new TreeNode(9);
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(5);

        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(7);
        q.right = new TreeNode(1);
        q.left.left = new TreeNode(8);
        q.right.left = new TreeNode(4);
        q.right.right = new TreeNode(5);

        System.out.println(isTreeSame(p, q));
    }

    private static boolean isTreeSame(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return (p == q);
        }

        boolean isSame = p.val == q.val;

        boolean isLeftSame = isTreeSame(p.left, q.left);
        boolean isRightSame = isTreeSame(p.right, q.right);

        return isSame && isLeftSame && isRightSame;
    }

}
