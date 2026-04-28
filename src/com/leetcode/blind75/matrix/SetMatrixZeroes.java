package com.practice.leetcode.blind75.matrix;

public class SetMatrixZeroes {
	//Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
	// https://www.youtube.com/watch?v=dSxt3ZCbIqA

	public static void main(String[] args) {

		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		
		seMatrixWithZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				  System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static void seMatrixWithZeroes(int[][] matrix) {
		
		boolean firstRow = false;
		boolean firstCol = false;
	// mark fiest Col and First row to 0	
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					if(i == 0) {firstCol = true;}
					if(j == 0) {firstCol = true;}
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		// mark inner matrix to zero
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[0][j] == 0 || matrix[i][0] == 0 ) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// Final check and update 1st row and column to zeroes
		if(firstRow) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[0][j] = 0;
			}
		}
		
		if(firstCol) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

}
