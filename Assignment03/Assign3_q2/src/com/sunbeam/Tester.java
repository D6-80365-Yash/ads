package com.sunbeam;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		int[] arr = {2, 6, 1, 4, 5};
		Stack st = new Stack(arr.length);
		
		System.out.println("Before reverse: " + Arrays.toString(arr));
		
		for(int i=0; i<arr.length; i++) {
			st.push(arr[i]);
		}
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = st.peek();
			st.pop();
		}
		
		System.out.println("After reverse: " + Arrays.toString(arr));
	}

}
