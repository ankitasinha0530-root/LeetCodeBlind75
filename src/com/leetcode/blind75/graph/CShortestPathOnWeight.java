package com.practice.leetcode.blind75.graph;

import java.util.ArrayList;
import java.util.List;

public class CShortestPathOnWeight {
    static String sPath;
    static int spathWeight = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] graph = {{4, 3, 1},
                {3, 2, 4},
                {3},
                {4},
                {}};
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        List<List<Integer>> allPathsgraph = new ArrayList<>();

        shortestPath(graph, 0, graph.length, "0", 0);
        System.out.println(allPathsgraph);

    }

    private static void shortestPath(int[][] graph, int src, int dest, String psf, int wsf) {

        if (src == dest) {
            spathWeight = Math.min(spathWeight, wsf);
            sPath = psf;
            return;
        }

        for (int neighbour : graph[src]) {
            System.out.println(src);
            shortestPath(graph, neighbour, dest, psf + neighbour, wsf + neighbour);
        }

        psf.substring(0, psf.length() - 1);
    }

}
