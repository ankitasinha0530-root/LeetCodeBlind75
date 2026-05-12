package com.leetcode.blind75.matrix;

public class YFloodFillPath {

    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0}};

        int[][] maze = {{0, 1, 0, 0,},
                {0, 1, 0, 1,},
                {0, 0, 0, 0,},
                {0, 0, 1, 0,},
                {0, 0, 0, 0,}};

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean[][] visitedMaze = new boolean[maze.length][maze[0].length];

        floodFillPath(maze, 0, 0, "", visitedMaze);

        System.out.println();
        floodFillPath(matrix, 0, 0, "", visited);
    }

    private static void floodFillPath(int[][] matrix, int row, int col, String ans, boolean[][] visited) {

        //  make sure to this condition matrix[row][col] == 1 at last otherwise we will get exception
        // make sure that the base condition is smart
        if (row < 0 || col < 0 || row == matrix.length || col == matrix[0].length || matrix[row][col] == 1 || visited[row][col]) {
            return;
        }

        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            System.out.println(ans);
            return;
        }
        visited[row][col] = true;  // as soon we visit the cell mark it true

        floodFillPath(matrix, row - 1, col, ans + 't', visited);
        floodFillPath(matrix, row, col - 1, ans + 'l', visited);
        floodFillPath(matrix, row + 1, col, ans + 'd', visited);
        floodFillPath(matrix, row, col + 1, ans + 'r', visited);

        // while coming back from the path mark it false so that the cell is available for calculating next path
        // this is called backtracking
        visited[row][col] = false;
    }


//	Incorrect Solution below please remember

//	private static void floodFillPathV2(int[][] matrix, int row, int col, String ans, boolean[][] vertices) {
//
//		if(row == matrix.length - 1 && col == matrix[0].length - 1) {
//			System.out.println(ans);
//			return;
//		}
//		
//		if(row > 0 && col > 0 && row < matrix.length - 1 && col < matrix[0].length - 1 && matrix[row][col] != 1 && !vertices[row][col] ) {
//			
//			vertices[row][col] = true;
//			floodFillPathV2(matrix, row - 1, col, ans + 't', vertices);
//			floodFillPathV2(matrix, row, col - 1, ans + 'l', vertices);
//			floodFillPathV2(matrix, row + 1, col, ans + 'd', vertices);
//			floodFillPathV2(matrix, row, col + 1, ans + 'r', vertices);
//		}
//		
//		vertices[row][col] = false;
//	}
}
