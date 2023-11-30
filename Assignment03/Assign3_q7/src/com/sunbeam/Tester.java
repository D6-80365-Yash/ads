package com.sunbeam;

public class Tester {

	public static void main(String[] args) {
		String infix = "K+L-M*N+(O^P)*W/U/V*T+Q(A+B)*C-(D-E)*(F+G)";
		
		System.out.println("Infix : " + infix);
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix : " + postfix);
		
		String prefix = infixToPrefix(infix);
		System.out.println("Prefix : " + prefix);
	}
	
	
	public static int priority(char opr) {
		switch(opr) {
		case '$': return 10;
		case '/': return 9;
		case '*': return 9;
		case '%': return 9;
		case '+': return 8;
		case '-': return 8;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix) {
		Stack st = new Stack(30);
		StringBuilder postfix = new StringBuilder();
		for(int i = 0  ;i < infix.length() ; i++) {
			char ele = infix.charAt(i);
			if(Character.isDigit(ele))
				postfix.append(ele);
			else if(ele == '(')
				st.push(ele);
			else if(ele == ')') {
				while(st.peek() != '(')
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
	
	public static String infixToPrefix(String infix) {
		Stack st = new Stack(30);
		StringBuilder postfix = new StringBuilder();
		for(int i = infix.length()-1  ; i >= 0 ; i--) {
			char ele = infix.charAt(i);
			if(Character.isDigit(ele))
				postfix.append(ele);
			else if(ele == ')')
				st.push(ele);
			else if(ele == '(') {
				while(st.peek() != ')')
					postfix.append(st.pop());
				st.pop();		
			}
			else {
				while(!st.isEmpty() && priority(st.peek()) > priority(ele)){
					postfix.append(st.pop());
				}
				st.push(ele);
			}
		}
		while(!st.isEmpty()) {
			postfix.append(st.pop());
		}
		postfix.reverse();
		return postfix.toString();
	}
}
