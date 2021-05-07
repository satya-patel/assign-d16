package com.LinkedList;

public class LinkedList<K extends Comparable<K>> {
	// node start & end 
	public Node start;
	public Node end;


	// in starting start and end are null
	public MyLinkedList() {
		this.start = null;
		this.end = null;
	}

	// adding the new node in linked list 
	public void add(Node newNode) {
		if (this.end == null) {
			this.end = newNode;
		}
		if (this.start == null) {
			this.start = newNode;
		} else {
			Node tempNode = this.start;
			this.start = newNode;
			this.start.setNext(tempNode);
		}
	}
	
	
// method to print the node 
	public void printMyNode() {
		StringBuffer myNodes = new StringBuffer("Nodes are: ");
		Node tempNode = head;
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(end))
				myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}
	
	// append the node 
	public void append(Node myNode) {
		if (this.end == null) {
			this.end = myNode;
		}
		if (this.start == null) {
			this.start = myNode;
		} else {
			this.end.setNext(myNode);
			this.end = myNode;
		}
	}
	
	// insert the node
	public void insert(Node myNode, Node newNode) {
		Node tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}
	
	// pop the node
	public Node pop() {
		Node tempNode = this.start;
		this.start = start.getNext();
		return tempNode;

	}
	
	// remove node from the last 
	public Node popLast() {
		Node tempNode = this.start;
		while (!tempNode.getNext().equals(end)) {
			tempNode = tempNode.getNext();
		}
		this.end = tempNode;
		tempNode = tempNode.getNext();
		return tempNode;
	}


// search the  node 
	public Node search(Integer key) {
		Node tempNode = this.start;
		Node found = null;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey() == key) {
				found = tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return found;
	}

// remove node from particular postition
	public void removeParticularNode(Node deleteNode) {
		Node tempNode = this.start;
		Node prev = null;
		while (tempNode != null && tempNode.getKey() != deleteNode.getKey()) {
			prev = tempNode;
			tempNode = tempNode.getNext();
		}
		prev.setNext(tempNode.getNext());
		tempNode.setNext(null);
	}

	public int size() {
		int size = 0;
		Node n = start;
		while (n != null) {
			size++;
			n = n.getNext();
		}
		return size;
	}

	public static <K extends Comparable<K>> boolean maximum(K x, K y) {
		K max = x;
		if (y.compareTo(max) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public <K extends Comparable<K>> void sortList() {
		Node<K> current = this.start;
		Node<K> index = null;
		K temp;
		if (this.start == null)
			return;
		else {
			while (current != null) {
				index = current.getNext();
				while (index != null) {
					if (maximum(index.getKey(), current.getKey())) {
						temp = current.getKey();
						current.setKey(index.getKey());
						index.setKey(temp);
					}
					index = index.getNext();
				}
				current = current.getNext();
			}
		}
	}
}