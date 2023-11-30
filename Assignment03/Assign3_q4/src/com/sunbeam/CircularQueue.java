package com.sunbeam;

public class CircularQueue {
	private int[] queue;
    private int front, rear, counter;
    private final int SIZE;
    
    public CircularQueue(int size) {
    	SIZE = size;
        queue = new int[SIZE];
        front = 0;
        rear = -1;
        counter = 0;
    }
    
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % SIZE;
        queue[rear] = data;
        counter++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int removedItem = queue[front];
        front = (front + 1) % SIZE;
        counter--;
        return removedItem;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }
    
    public int size() {
        return counter;
    }
    
    public boolean isEmpty() {
        return counter == 0;
    }
    
    public boolean isFull() {
        return counter == SIZE;
    }
}
