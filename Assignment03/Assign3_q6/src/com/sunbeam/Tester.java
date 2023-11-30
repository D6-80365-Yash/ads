package com.sunbeam;

public class Tester {

	public static void main(String[] args) {
		String infix = "10 $ 90 + 32 * 4 - ( 6 + 80 / 20 ) + 7";
		
		String[] arr = infix.split(" ");
		
		System.out.println("Infix : " + infix);
		String postfix = infixToPostfix(arr);
		System.out.println("Postfix : " + postfix);
		
		String prefix = infixToPrefix(arr);
		System.out.println("Prefix : " + prefix);
	}
	
	
	public static int priority(String opr) {
		switch(opr) {
		case "$": return 10;
		case "/": return 9;
		case "*": return 9;
		case "%": return 9;
		case "+": return 8;
		case "-": return 8;
		}
		return 0;
	}
	
	public static boolean isOperator(String opr) {
		return opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/") || opr.equals("%") || opr.equals("$") || opr.equals("(") || opr.equals(")");
	}
	
	public static String infixToPostfix(String[] arr) {
		Stack st = new Stack(20);
		StringBuilder postfix = new StringBuilder();
		for(int i = 0  ;i < arr.length ; i++) {
			String ele = arr[i];
			if(!isOperator(ele))
				postfix.append(ele);
			else if(ele.equals("("))
				st.push(ele);
			else if(ele.equals(")")) {
				while(!st.peek().equals("("))
					postfix.append(st.pop());
				st.pop();		
			}
			else {
				while(!st.isEmpty() && priority(st.peek()) >= priority(ele)){
					postfix.append(st.pop());
				}
				st.push(ele);
			}
		}
		while(!st.isEmpty()) {
			postfix.append(st.pop());
		}
		return postfix.toString();
	}
	
	public static String infixToPrefix(String[] arr) {
		Stack st = new Stack(20);
		StringBuilder prefix = new StringBuilder();
		for(int i = arr.length-1  ; i >= 0 ; i--) {
			String ele = arr[i];
			if(!isOperator(ele))
				prefix.append(ele);
			else if(ele.equals(")"))
				st.push(ele);
			else if(ele.equals("(")) {
				while(!st.peek().equals(")"))
					prefix.append(st.pop());
				st.pop();		
			}
			else {
				while(!st.isEmpty() && priority(st.peek()) > priority(ele)){
					prefix.append(st.pop());
				}
				st.push(ele);
			}
		}
		while(!st.isEmpty()) {
			prefix.append(st.pop());
		}
		prefix.reverse();
		return prefix.toString();
	}
}
