package com.leetcode.blind75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GraphNode {
    int val;
    List<GraphNode> neighbours;

    public GraphNode(int val) {
        this.val = val;
        neighbours = new ArrayList<>();
    }
}

public class ACloneGraph {

    public static void main(String[] args) {

        GraphNode root = new GraphNode(1);
        root.neighbours.add(new GraphNode(2));
        root.neighbours.add(new GraphNode(3));
        root.neighbours.add(new GraphNode(4));
        root.neighbours.add(new GraphNode(4));

        //	List<List<Integer>> adjList = [2,4],[1,3],[2,4],[1,3]]
        cloneGraph(root, new HashMap<GraphNode, GraphNode>());
    }

    private static GraphNode cloneGraph(GraphNode node, HashMap<GraphNode, GraphNode> nodeMap) {

        if (node == null) {
            return null;
        }

        // if the node is present in key, means that the node has already been visited
        // simply return the node, no further processing required
        if (nodeMap.containsKey(node)) {
            return node;
        }

        // If not present in map then create a new node and add the original node and new Node in Map
        GraphNode newNode = new GraphNode(node.val);
        nodeMap.put(node, newNode);        // add new Node which is root for cloned graph in Map.
        for (GraphNode neighbour : node.neighbours) {
            newNode.neighbours.add(cloneGraph(neighbour, nodeMap)); // copy of all the neighbour nodes using same steps
        }
        return newNode; // return the root of cloned grpah
    }

}
