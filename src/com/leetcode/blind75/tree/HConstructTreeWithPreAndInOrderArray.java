package com.leetcode.blind75.tree;

import java.util.HashMap;
import java.util.Map;

public class HConstructTreeWithPreAndInOrderArray {

    // 	https://www.youtube.com/watch?v=PbPS460rbMo&t=328s

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};

        buildTreeV1(preorder, inorder);

        buildTreeV2(preorder, inorder);

    }

    //	This is Version 1
    public static TreeNode buildTreeV1(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i; // Correcting the assignment
                break; // Exiting the loop once the value is found
            }
        }
        // now construct the left and right subtree
        root.left = helper(preStart + 1, inStart, rootIndex - 1, preorder, inorder);
        root.right = helper(preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, preorder, inorder);

        return root;
    }

    // This is version 2
    public static TreeNode buildTreeV2(int[] P, int[] I) {
        Map<Integer, Integer> M = new HashMap<>();
        for (int i = 0; i < I.length; i++)
            M.put(I[i], i);
        return splitTree(P, M, 0, 0, I.length - 1);
    }

    private static TreeNode splitTree(int[] P, Map<Integer, Integer> M, int pix, int ileft, int iright) {

        int rval = P[pix], imid = M.get(rval);
        TreeNode root = new TreeNode(rval);

        //	Now construct the left and right subtree
        if (imid > ileft)
            root.left = splitTree(P, M, pix + 1, ileft, imid - 1);
        if (imid < iright)
            root.right = splitTree(P, M, pix + imid - ileft + 1, imid + 1, iright);
        return root;
    }
}
