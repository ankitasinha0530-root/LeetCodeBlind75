package com.leetcode.blind75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BGetAllPathOfGraph {

    public static void main(String[] args) {

        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        List<List<Integer>> allPathsgraph = new ArrayList<>();

        printAllValidPath(graph, 0, graph.length - 1, currPath, allPathsgraph);
        System.out.println(allPathsgraph);
    }

    private static void printAllValidPath(int[][] graph, int source, int dest, List<Integer> currPath,
                                          List<List<Integer>> allPathsgraph) {
        if (source == dest) {
            allPathsgraph.add(new ArrayList<>(currPath));
            return;
        }
        int[] edge = graph[source];

        for (int neighbour : edge) {
            currPath.add(neighbour);
            printAllValidPath(graph, neighbour, graph.length - 1, currPath, allPathsgraph);
            currPath.remove(currPath.size() - 1); // remove from Last while going back
        }
    }

}
