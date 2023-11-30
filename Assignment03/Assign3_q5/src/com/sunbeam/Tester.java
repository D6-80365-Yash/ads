package com.sunbeam;

import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		String postfix = "40 50 60 * 30 / + 90 + 70 -";
		String[] arr = postfix.split(" ");
		
		System.out.println("Post : " + postfix);
		int result = postfixEvaluate(arr);
		System.out.println("Result : " + result);
		
		String prefix = "- + + 40 / * 50 60 30 90 70";
		String[] arr2 = prefix.split(" ");
		
		System.out.println("Pre : " + prefix);
		result = prefixEvaluate(arr2);
		System.out.println("Result : " + result);
	}
	
	
	public static int calculate(int op1, int op2, String opr) {
		switch(opr) {
		case "+": return op1 + op2;
		case "-": return op1 - op2;
		case "*": return op1 * op2;
		case "/": return op1 / op2;
		case "%": return op1 % op2;
		case "$": return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static boolean isOperator(String opr) {
		return opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/") || opr.equals("%") || opr.equals("$") || opr.equals("(") || opr.equals(")");
	}
	
	public static int postfixEvaluate(String[] arr) {
		Stack st = new Stack(10);
		for(int i = 0 ; i < arr.length ; i++) {
			String ele = arr[i];
			if(!isOperator(ele))
				st.push(Integer.parseInt(ele));
			else {
				int op2 = st.pop();	
				int op1 = st.pop();	
				int res = calculate(op1, op2, ele);
				st.push(res);
			}
		}
		if(!st.isEmpty())
			return st.pop();
		return 0;
	}
	
	public static int prefixEvaluate(String[] arr) {
		Stack st = new Stack(10);
		for(int i = arr.length-1 ; i >= 0 ; i--) {
			String ele = arr[i];
			if(!isOperator(ele))
				st.push(Integer.parseInt(ele));
			else {
				int op1 = st.pop();	
				int op2 = st.pop();	
				int res = calculate(op1, op2, ele);
				st.push(res);
			}
		}
		if(!st.isEmpty())
			return st.pop();
		return 0;
	}
}
