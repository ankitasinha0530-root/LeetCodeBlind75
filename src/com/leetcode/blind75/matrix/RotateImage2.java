package com.practice.leetcode.blind75.matrix;

public class RotateImage2 {

	public static void main(String[] args) {
	int[][] matrix = {{5, 1, 9, 11},
					  {2, 4, 8, 10},
					  {13,3, 6, 7 },
					  {15,14,12,16}};
	rotate(matrix);
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
			  System.out.print(matrix[i][j] + " ");
		}
		System.out.println();
	}
	}
	
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int temp;
		
	//	TransPose
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	// Reverse	
		for (int i = 0; i < matrix.length; i++) {
			
			int left = 0;
			int right = matrix.length-1;
			
			while(left < right) {
				temp = matrix[i][right];
				matrix[i][right] = matrix[i][left];
				matrix[i][left] = temp;
				left++;
				right--;
			}
		}
	}

}
