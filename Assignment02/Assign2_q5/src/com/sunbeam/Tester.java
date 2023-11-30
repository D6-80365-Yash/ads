package com.sunbeam;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter operator: ");
		String opr = sc.next();
		
		System.out.println("The priority of given operator is = " + priority(opr.charAt(0)));
	}
	
	public static int priority(char opr) {
		switch (opr) {
		case '$': return 10;
			
		case '/': return 9;
		
		case '*': return 9;
		
		case '%': return 9;
		
		case '+': return 8;
		
		case '-': return 8;
			
		default:
			break;
		}
		return 0;
	}
}
