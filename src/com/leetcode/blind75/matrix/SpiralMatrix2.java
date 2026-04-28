package com.practice.leetcode.blind75.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix2 {

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
			System.out.println("rowBegin = " + rowBegin + ", ");
			
			for (int j = colBegin; j <= colEnd; j++) {
				System.out.print("j = " + j + ", ");
				spiralMatrix.add(matrix[rowBegin][j]);
			}
	// 1st row traversal is done 
			rowBegin++;
	// Traverse down in last column colEnd
			System.out.println();
			System.out.println("colEnd = " + colEnd + ", ");
			
			for (int i = rowBegin; i <= rowEnd; i++) {
				System.out.print("i = " + i + ", ");
				spiralMatrix.add(matrix[i][colEnd]);
			}
	// last row traversal is done 
			colEnd--;
	// Traverse to left in last row rowEnd
			System.out.println();
			System.out.println("rowEnd = " + rowEnd + ", ");
			
			if(rowBegin <= rowEnd) {
				for (int j = colEnd; j >= colBegin; j--) {
					System.out.print("j = " + j + ", ");
					spiralMatrix.add(matrix[rowEnd][j]);
				}
			}
	// last row traversal is done
			rowEnd--;
	// Traverse to up in 1st col colBegin
			System.out.println();
			System.out.println("colBegin = " + colBegin + ", ");
			
			if(colBegin <= colEnd) {
				for (int i = rowEnd; i >= rowBegin; i--) {
					System.out.print("i= " + i + ", ");
					spiralMatrix.add(matrix[i][colBegin]);
				}
			}
	// last row traversal is done
			colBegin++;
		}
		
		return spiralMatrix;
		
	}

}
