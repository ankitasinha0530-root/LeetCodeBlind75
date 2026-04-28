package com.practice.leetcode.blind75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	// https://www.youtube.com/watch?v=aqVW8IuXUF0

	public static void main(String[] args) {

		int[][] matrix = {{1, 2, 3},
						  {4, 5, 6},
						  {7, 8, 9}};
		
		List<Integer> spiralMatrix = returnSpiralMatrix(matrix);
		System.out.println(spiralMatrix);
	}

	private static List<Integer> returnSpiralMatrix(int[][] matrix) {

		List<Integer> spiralMatrix =  new ArrayList<>();
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;
		
		while(rowBegin <= rowEnd && colBegin <= colEnd) {
	// Traverse right in 1st row at rowBegin			
			for (int j = colBegin; j <= colEnd; j++) {
				spiralMatrix.add(matrix[rowBegin][j]);
			}
	// 1st row traversal is done 
			rowBegin++;
	// Traverse down in last column colEnd
			for (int i = rowBegin; i <= rowEnd; i++) {
				spiralMatrix.add(matrix[i][colEnd]);
			}
	// last row traversal is done 
			colEnd--;
	// Traverse to left in last row rowEnd
			if(rowBegin <= rowEnd) {
				for (int j = colEnd; j >= colBegin; j--) {
					spiralMatrix.add(matrix[rowEnd][j]);
				}
			}
	// last row traversal is done
			rowEnd--;
	// Traverse to up in 1st col colBegin
			if(colBegin <= colEnd) {
				for (int i = rowEnd; i >= rowBegin; i--) {
					spiralMatrix.add(matrix[i][colBegin]);
				}
			}
	// last row traversal is done
			colBegin++;
		}
		
		return spiralMatrix;
		
	}

}
