package com.practice.leetcode.blind75.tree;

public class JKthSmallestNodeValue {

    int count = 0;
    int res = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

//	public int kthSmallest(TreeNode root, int k) {
//		
//        return recur(root, k);
//    }

    private int kthSmallest(TreeNode node, int k) {

        if (node.left != null) {
            kthSmallest(node.left, k);
        }
        count++;
        if (count == k) {
            res = node.val;
            return res;
        }
        if (node.right != null) {
            kthSmallest(node.right, k);
        }
        return -1;
    }

    public void kthSmallestV2(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallestV2(root.left, k);
        count++;
        if (k == count) {
            res = root.val;
            return;
        }
        kthSmallestV2(root.right, k);
    }
}
