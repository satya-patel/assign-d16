package com.LinkedList;

public interface Node<K> {
	
	K getData();
	void setKey(K data);
	
	Node getNext();
	void setNext(Node next);
}