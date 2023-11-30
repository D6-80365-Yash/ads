package com.sunbeam;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularQueue cq = new CircularQueue(5);
		int choice;
		while((choice = menu()) != 0) {
			switch (choice) {
			case 1:
				System.out.print("Enter value: ");
				int val = sc.nextInt();
				cq.enqueue(val);
				break;
				
			case 2:
				int popped = cq.dequeue();
				if(popped != -1) {
					System.out.println("popped val: " + popped);
				}
				break;
				
			case 3:
				int peeked = cq.peek();
				if(peeked != -1) {
					System.out.println("peeked val: " + peeked);
				}
				break;
				
			case 4:
				System.out.println("Size of circular queue = " + cq.size());
				break;

			default:
				System.out.println("Please enter correct choice...");
				break;
			}
		}
	}
	
	public static int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("0. Exit");
		System.out.println("1. Enqueue");
		System.out.println("2. Dequeue");
		System.out.println("3. Peek");
		System.out.println("4. Size");
		System.out.print("Enter choice: ");
		int choice = sc.nextInt();
		return choice;
	}
}
