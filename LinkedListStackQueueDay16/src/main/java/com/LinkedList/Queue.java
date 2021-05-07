package com.StacksAndQueues;

public class Queue<K extends Comparable<K>> {
	private final MyLinkedList<K> myLinkedList;
	public Queue() {
		myLinkedList = new MyLinkedList<>();
	}
	public void enqueu(INode<K> element) {
		myLinkedList.append(element);
	}
	public INode<K> dequeue() {
		return myLinkedList.pop();
	}
	public INode<K> peak() {
		return myLinkedList.head;
	}
	public void printQueue() {
		myLinkedList.printMyNode();
	}
}