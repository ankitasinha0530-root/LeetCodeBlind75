package com.practice.leetcode.blind75.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AllNodesAtKdistanceFromTargetNode {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left;
        int k = 2;
        System.out.println(allNodesAtKdistanceFromTargetNode(root, target, k));
    }

    private static Object allNodesAtKdistanceFromTargetNode(TreeNode root, TreeNode target, int k) {

        Map<Integer, TreeNode> parent = createchildParentMap(root);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> mq = new LinkedList<>();

        mq.add(target);

        while (!mq.isEmpty() && k > 0) {
            int size = mq.size();
            k--;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = mq.poll();
                visited.put(currNode, true); // add the visited to booleAN MAP
                System.out.println(currNode.val);

                if (parent.get(currNode.val) != null && !visited.containsKey(parent.get(currNode.val))) {
                    mq.add(parent.get(currNode.val));
                }
                if (currNode.left != null && !visited.containsKey(currNode.left)) {
                    mq.add(currNode.left);
                }
                if (currNode.right != null && !visited.containsKey(currNode.right)) {
                    mq.add(currNode.right);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!mq.isEmpty()) {
            result.add(mq.poll().val);
        }
        System.out.println(result);
        return result;
    }

    private static Map<Integer, TreeNode> createchildParentMap(TreeNode root) {

        Map<Integer, TreeNode> childParent = new HashMap<>();
        Queue<TreeNode> mq = new LinkedList<>();
        childParent.put(root.val, null);

        mq.add(root);

        while (!mq.isEmpty()) {
            TreeNode currLevel = mq.poll();

            if (currLevel.left != null) {
                mq.add(currLevel.left);
                childParent.put(currLevel.left.val, currLevel);
            }

            if (currLevel.right != null) {
                mq.add(currLevel.right);
                childParent.put(currLevel.right.val, currLevel);
            }
        }
        System.out.println(childParent);
        return childParent;
    }

}
