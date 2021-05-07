package com.LinkedList;

public class SetGetNode<K> implements SetGetNode<K> {
	
	
	// variables 
	private K data;
	private Node next;

	// constructor
	public SetGetNode(K data) {
		this.data = data;
		this.next = null;
	}

	// get set methods 
	public SetGetNode getNext() {
		return next;
	}

	public void setNext(SetGetNode next) {
		this.next = next;
	}

	// overide methods 
	@Override
	public K getData() {
		return data;
	}

	@Override
	public void setKey(K data) {
		this.data = data;
	}
}