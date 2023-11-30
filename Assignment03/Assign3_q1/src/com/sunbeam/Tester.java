package com.sunbeam;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Stack st = new Stack(5);
		int choice;
		Scanner sc = new Scanner(System.in);
		int maxVal = Integer.MIN_VALUE;
		
		do {
			System.out.println("0. Exit\n1. Push\n2. Pop\n3. Peek");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				if(st.isFull())
					System.out.println("Stack is full");
				else {
					System.out.print("Enter data to be inserted : ");
					int value = sc.nextInt();
					maxVal = Math.max(maxVal, value);
					st.push(value);
				}
				break;
			case 2:
				if(st.isEmpty())
					System.out.println("Stack is empty");
				else
					st.pop();
				break;
			case 3:
				if(st.isEmpty())
					System.out.println("Stack is empty");
				else
					System.out.println("Peeked data : " + st.peek());
				break;
			}
			
		}while(choice != 0);
		
		System.out.println("Maximum element in stack = " + maxVal);
		sc.close();
	}

}
