package com.practice.leetcode.blind75.array;

public class MaxSumSubArray {

	public static void main(String[] args) {

		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		
		int[] arr1 = {5,4,-1,7,8};
		
		System.out.println(maxSubArray(arr));
		System.out.println(maxSubArray(arr1));

	}
	//Best Solution
	private static int maxSubArray(int[] arr) {

		int currmax = arr[0];
		int maxSoFar = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			currmax = Math.max(arr[i], currmax + arr[i]);
			maxSoFar = Math.max(maxSoFar, currmax);
			
		}
		return maxSoFar;
	}
	
	// 2nd best solution
	 public int maxSubArrayV2(int[] nums) {
	        int currmax = nums[0];
			int maxSoFar = nums[0];
			
			for (int i = 1; i < nums.length; i++) {
				currmax += nums[i];
	            if(currmax < nums[i]){
	                currmax = nums[i];
	            }
				if(maxSoFar < currmax){
	                maxSoFar = currmax;
	            }
			}
			return maxSoFar;
	    }
	
	// not optimal solution
	private static int maxSubArrayV3(int[] nums) {

		 if(nums.length ==1){
	            return nums[0];
	        }
		 int maxSum = Integer.MIN_VALUE;
	     int currSum = 0;
		
		for (int i = 1; i < nums.length; i++) {
			currSum = Math.max(currSum + nums[i], nums[i]);
			maxSum = Math.max(currSum, maxSum);
			
		}
		return maxSum;
	}

}

