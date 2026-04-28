package com.practice.leetcode.blind75.array;

public class MaxProductSubArray {

	public static void main(String[] args) {

		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		
		int[] arr1 = {5,4,-1,7,8};
		
		int[] arr2 = {-2,0,-1};
		
		int[] arr3 = {2,3,-2,4};
		
		System.out.println(maxSubArray(arr));
		System.out.println(maxSubArray(arr1));
		System.out.println(maxSubArray(arr2));
		System.out.println(maxSubArray(arr3));

	}

	private static int maxSubArray(int[] arr) {

		int currmax = arr[0];
		int maxSoFar = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			currmax = Math.max(arr[i], currmax * arr[i]);
			
			maxSoFar = Math.max(maxSoFar, currmax);
			
		}
		return maxSoFar;
	}

}
