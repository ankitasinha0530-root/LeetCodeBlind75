package com.leetcode.blind75.tree;

import java.util.ArrayList;
import java.util.List;


//Refer Video - main - https://www.youtube.com/watch?v=o5pVtHqiOdE&t=541s
// refer video = https://www.youtube.com/watch?v=Vam9gldRapY
//Refer Video = https://www.youtube.com/watch?v=ojxo9QjPKvA
// refer video = https://www.youtube.com/watch?v=HyNczj2pEEY
public class IAllPathsForASumFromAnyNode {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);

        List<List<Integer>> result = IAllPathsForASumFromAnyNode.allPathsForASumFromAnyNode(root, 9);
        System.out.println("All Paths = " + result);
    }

    private static List<List<Integer>> allPathsForASumFromAnyNode(TreeNode root, int sum) {
        // we will move through the tree and after reaching end we will proceed ahead
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sumPath;
        List<Integer> currPath = new ArrayList<>();
        allPaths(root, sum, currPath, result);
        return result;
    }

    private static void allPaths(TreeNode currNode, int target, List<Integer> currPath, List<List<Integer>> result) {
        if (currNode == null) {
            return;
        }

        // add all nodes in preorder to the path
        currPath.add(currNode.val);

        allPaths(currNode.left, target, currPath, result);
        allPaths(currNode.right, target, currPath, result);

        int sum = 0; // create a new sum variable
        // in post order loop though the currpath from last of the arraylist
        for (int i = currPath.size() - 1; i >= 0; i--) {

            sum = sum + currPath.get(i); // keep on adding to the sum

            if (sum == target) { // when sum of elements equals target sum
                List<Integer> sumPath = new ArrayList<>(); // create a new arraylist

                for (int j = i; j <= currPath.size() - 1; j++) { // loop from last to i and add to the new list
                    sumPath.add(currPath.get(j));
                }
                result.add(sumPath);    // add to the result list
            }
        }
        currPath.remove(currPath.size() - 1); //while backtracking remove elements from the last
    }


}

