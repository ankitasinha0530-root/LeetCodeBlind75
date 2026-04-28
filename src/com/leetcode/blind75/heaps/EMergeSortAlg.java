package com.practice.leetcode.blind75.heaps;

public class EMergeSortAlg {

	public static void main(String[] args) {
		
		// divide the array into two halves
		// sort each half separately
		// merge the two sorted halves

		int[] arr = {9, 4, 7, 6, 3, 1, 5};
		mergeSort(arr, 0, arr.length - 1);
		
		for(int el : arr) {
			System.out.print(el + ", ");
		}
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if(low < high) {
			int middle = (low + high)/2;
			mergeSort(arr, low, middle);
			mergeSort(arr, middle+1, high);
			mergeTwoParts(arr, low, middle, high);	
		}
	}
	

	private static void mergeTwoParts(int[] arr, int low, int mid, int high) {
		int[] b = new int[arr.length];
		int k = low;
		int i = low;
		int j = mid+1;
		
		while(i <= mid && j <= high) {
			if(arr[i] < arr[j]) {
				b[k] = arr[i];
				i++;
			}else {
				b[k] = arr[j];
				j++;
			}
			k++;
		}
		if(i > mid) {
			while(j <= high) {
				b[k] = arr[j];
				j++;
				k++;
			}
		}else {
			while(i <= mid) {
				b[k] = arr[i];
				i++;
				k++;
			}
		}
		for(k = low; k <= high; k++) {
			arr[k] = b[k];
		}
	}
		
}
