package com.practice.leetcode.blind75.graph;

public class BNumberOfIslands {
    // https://www.youtube.com/watch?v=jhQb1mkikwA
    // https://www.youtube.com/watch?v=ErPZFxugYkI&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=7
    public static void main(String[] args) {
        int[][] maze = {{1, 1, 0, 0,},
                {0, 1, 0, 0,},
                {0, 0, 1, 1,},
                {1, 0, 1, 1,}};

        int count = findNoOfIsland(maze);

        System.out.println(count);
        System.out.println();
    }

    private static int findNoOfIsland(int[][] maze) {

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int count = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1 && visited[i][j] == false) {
                    findIsland(maze, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void findIsland(int[][] maze, int i, int j, boolean[][] visited) {

        if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] == 0 || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        findIsland(maze, i - 1, j, visited);
        findIsland(maze, i, j + 1, visited);
        findIsland(maze, i, j - 1, visited);
        findIsland(maze, i + 1, j, visited);
    }

}
