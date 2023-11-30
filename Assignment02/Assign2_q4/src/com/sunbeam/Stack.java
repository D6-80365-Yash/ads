package com.sunbeam;

public class Stack {
	private int arr[];
	private int top;
	private final int SIZE;
	public Stack(int size) {
		SIZE = size;
		arr = new int[SIZE];
		top = SIZE;
	}
	
	public void push(int value) {
		top--;
		arr[top] = value;
	}
	
	public void pop() {
		top++;
	}
	
	public int peek() {
		return arr[top];
	}
	
	public boolean isEmpty() {
		return top == SIZE;
	}
	
	public boolean isFull() {
		return top == 0;
	}
}
