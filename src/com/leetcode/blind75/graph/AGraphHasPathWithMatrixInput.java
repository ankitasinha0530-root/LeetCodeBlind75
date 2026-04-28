package com.practice.leetcode.blind75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AGraphHasPathWithMatrixInput {
	
	public static void main(String[] args) {

		int[][]	edges1 = {{0,1},{1,2},{2,0}}; // input is in Matrix form
		System.out.println(validPath(3, edges1, 0, 2));
		
		int[][]	edges = {{0,1},{1,2},{2,0},{2, 3}, {3, 5}, {3, 6}}; // input is in Matrix form
		System.out.println(validPath(6, edges, 0, 6));
	}
	
	 public static boolean validPath(int n, int[][] edges, int source, int destination) {
	        
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        for(int[] edge : edges){
	            int u = edge[0];
	            int v = edge[1];
	            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
	            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
	        }

	        Set<Integer> visited = new HashSet<>();
	        return checkPath(graph, visited, source, destination);
	    }

	    public static boolean checkPath(Map<Integer, List<Integer>> graph, Set<Integer> visited,
	                                                                    int source, int destination) {
	        if(source == destination){
	            return true;
	        }
	        visited.add(source);
	        for(int neighbour : graph.getOrDefault(source, new ArrayList<>())){
	            if(!visited.contains(neighbour)){
	                boolean hasNbrPath = checkPath(graph, visited, neighbour, destination);
	                if(hasNbrPath){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

}
