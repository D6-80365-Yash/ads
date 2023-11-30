package com.sunbeam;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		Employee[] arr = new Employee[5];
		
		arr[0] = new Employee(2, "e2", 30000);
		arr[1] = new Employee(3, "e3", 10000);
		arr[2] = new Employee(1, "e1", 40000);
		arr[3] = new Employee(5, "e5", 50000);
		arr[4] = new Employee(4, "e4", 20000);
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		insertionSort(arr, arr.length);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}
	
	public static void insertionSort(Employee[] arr, int n) {
		int cmp1=0, cmp2=0;
		for(int i=1; i<n; i++) {
			cmp1++;
			Employee temp = arr[i];
			int j;
			for(j=i-1; j>=0 && arr[j].salary>temp.salary; j--) {
				cmp2++;
				arr[j+1] = arr[j];
			}
			arr[j+1] = temp;
		}
		
		System.out.println("Total comparision = " + (cmp1 + cmp2));
	}

}
