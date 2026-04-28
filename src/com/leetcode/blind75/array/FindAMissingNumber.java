package com.practice.leetcode.blind75.array;

import java.util.Arrays;

public class FindAMissingNumber {

	public static void main(String[] args) {

		int[] arr= {1, 2, 5, 6, 3, 7, 8};
		
		System.out.println("missing number = " + missingNumber(arr));
		
		System.out.println("missing number V2 = " + missingNumberV2(arr));
	}

	private static int missingNumber(int[] arr) {
			
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] + 1 != arr[i+1]) {
				return arr[i] +1;
			}
		}
		
		return 0;
	}
	private static int missingNumberV2(int[] arr) { // o(n)
		
		 int sum = 0;
	       int N = arr.length;
	        for(int i=0;i<arr.length-1;i++){
	            sum = sum + arr[i];
	        }
	        return ((N * (N+1))/2 - sum);
	}
	
	private static int missingNumberV3(int[] a) { // o(n)
			int n = a.length-1;
		 int x1 = a[0];
	        int x2 = 1;

	        // For xor of all the elements in array
	        for (int i = 1; i < n; i++)
	            x1 = x1 ^ a[i];

	        // For xor of all the elements from 1 to n+1
	        for (int i = 2; i <= n + 1; i++)
	            x2 = x2 ^ i;

	        return (x1 ^ x2); // return x1^X2 all the elements will have 0 bits except for the missing element
	}

	
}
