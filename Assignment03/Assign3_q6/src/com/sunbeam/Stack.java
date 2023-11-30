package com.sunbeam;

public class Stack {
	private String arr[];
	private int top;
	private final int SIZE;
	public Stack(int size) {
		SIZE = size;
		arr = new String[SIZE];
		top = -1;
	}
	
	public void push(String value) {
		//a. reposition top
		top++;
		//b. add value at top index
		arr[top] = value;
	}
	
	public String pop() {
		//a. reposition top
		return arr[top--];
	}
	
	public String peek() {
		//a. read/return value of top index
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == SIZE-1;
	}
}
