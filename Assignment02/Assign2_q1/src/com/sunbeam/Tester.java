package com.sunbeam;

import java.util.Arrays;

public class Tester {
	public static void main(String[] args) {
		int arr[] = {55, 44, 22, 66, 11, 33};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		insertionSort(arr, arr.length);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}
	
	public static void insertionSort(int[] arr, int n) {
		int cmp1=0, cmp2=0;
		for(int i=1; i<n; i++) {
			cmp1++;
			int temp = arr[i];
			int j;
			for(j=i-1; j>=0 && arr[j]>temp; j--) {
				cmp2++;
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
		
		System.out.println("Total comparision = " + (cmp1 + cmp2));
	}
}
