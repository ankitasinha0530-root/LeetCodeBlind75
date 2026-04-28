package com.practice.leetcode.blind75.matrix;

public class RotateImage {
	
//	You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//	You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
//	DO NOT allocate another 2D matrix and do the rotation.

	//	https://www.youtube.com/watch?v=Ux058jpRB9Y
	public static void main(String[] args) {
		int[][] matrix = {{5, 1, 9, 11},
				  		  {2, 4, 8, 10},
				          {13,3, 6, 7},
				          {15,14,12,16}};
		
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				  System.out.print(matrix[i][j] + " ");}System.out.println();}
	}
	
	// Using 4 way swap
	 public static void rotate(int[][] matrix) {
		 int n = matrix.length;
		 int temp = 0;
		 
		 for (int i = 0; i < (n+1)/2; i++) {
			for (int j = 0; j < n/2; j++) {
	//	start 4 way swap
	//	temp = bootom left 
				int row = n-1-j , col = i; // row = 3 // col = 0
				temp = matrix[n-1-j][i];
	
	//	bottom left = bottom right
				matrix[n-1-j][i] = matrix[n-1-i][n-j-1];
	
	// bottom right = top right
				matrix[n-1-i][n-j-1] = matrix[j][n-1-i];
	
	//	top right = top left
				matrix[j][n-1-i] = matrix[i][j];
	
	//	top left = temp
				matrix[i][j] = temp;
				
			}
		}
				 
	 }
}
