package com.LinkedList;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {
	@Test
	public void given3Numbers_WhenAdded_ShouldBeAddedToTop() {
		MyNode<Integer> myFirstNode = new MyNode<>(70);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(56);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.add(mySecondNode);
		myLinkedList.add(myThirdNode);
		System.out.println("Adding: ");
		myLinkedList.printMyNode();
		boolean result = myLinkedList.head.equals(myThirdNode) && 
						 myLinkedList.head.getNext().equals(mySecondNode) && 
						 myLinkedList.tail.equals(myFirstNode);
		assertTrue(result);
	}

	@Test
	public void given3Numbers_WhenAppended_ShouldBeAddedToLast() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myThirdNode);
		System.out.println("Appending: ");
		myLinkedList.printMyNode();
		boolean result = myLinkedList.head.equals(myFirstNode) && 
						 myLinkedList.head.getNext().equals(mySecondNode) && 
						 myLinkedList.tail.equals(myThirdNode);
		assertTrue(result);
	}
	
	@Test
	public void given3Numbers_InsertSecondInBetween_ShouldPassTest() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.insert(myFirstNode, mySecondNode);
		System.out.println("\nAdding element between 2 nodes: ");
		myLinkedList.printMyNode();
		boolean result = myLinkedList.head.equals(myFirstNode) && 
				 		 myLinkedList.head.getNext().equals(mySecondNode) && 	 	 
				 		 myLinkedList.tail.equals(myThirdNode);
		assertTrue(result);
	}
	
	@Test
	public void givenFirstElement_WhenDeleted_ShouldPassTest() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myThirdNode);
		INode deleteNode = myLinkedList.pop();
		System.out.println("\nDeleting first element: ");
		myLinkedList.printMyNode();
		boolean result = myLinkedList.head.equals(mySecondNode) && 
						 myLinkedList.head.getNext().equals(myThirdNode) && 
						 myLinkedList.tail.equals(myThirdNode);
		assertTrue(result);
	}
	
	@Test
	public void givenThirdElement_WhenDeleted_ShouldPassTest() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myThirdNode);
		INode deleteNode = myLinkedList.popLast();
		myLinkedList.removeParticularNode(deleteNode);
		System.out.println("\nDeleting last element: ");
		myLinkedList.printMyNode();
		boolean result = myLinkedList.head.equals(myFirstNode) && 
						 myLinkedList.head.getNext().equals(mySecondNode) && 
						 myLinkedList.tail.equals(mySecondNode);
		assertTrue(result);
	}
	
	@Test
	public void givenElement_WhenSearch_ShouldPassTest() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myThirdNode);
		INode found = myLinkedList.search(mySecondNode.getKey());
		boolean result = myLinkedList.head.equals(found) || 
						 myLinkedList.head.getNext().equals(found) || 
						 myLinkedList.tail.equals(found);
		assertTrue(result);
	}
	
	@Test
	public void givenElement_WhenInsertedafterSomeNode_ShouldPassTest() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(40);
		MyNode<Integer> myFourthNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myFourthNode);
		INode found = myLinkedList.search(mySecondNode.getKey());
		myLinkedList.insert(found, myThirdNode);
		System.out.println("\nInsert element between 2 element: ");
		myLinkedList.printMyNode();
		boolean result = myLinkedList.head.equals(myFirstNode) &&
						 myFirstNode.getNext().equals(mySecondNode) && 
						 mySecondNode.getNext().equals(myThirdNode) &&
						 myLinkedList.tail.equals(myFourthNode);
		assertTrue(result);
	}
	
	@Test
	public void givenElement_WhenDeletedAfterSearch_ShouldPassTest() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(40);
		MyNode<Integer> myFourthNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.append(myFourthNode);
		System.out.println("\nBefore Deleting: ");
		myLinkedList.printMyNode();
		INode found = myLinkedList.search(myThirdNode.getKey());
		myLinkedList.removeParticularNode(found);
		System.out.println("\nAfter Deleting the specific node: ");
		myLinkedList.printMyNode();
		int size = myLinkedList.size();
		System.out.print("\nSize of Linked List: " + size);
	}
	
	@Test
	public void givenAllElements_GetSortedList() {
		MyNode<Integer> myFirstNode = new MyNode<>(56);
		MyNode<Integer> mySecondNode = new MyNode<>(30);
		MyNode<Integer> myThirdNode = new MyNode<>(40);
		MyNode<Integer> myFourthNode = new MyNode<>(70);
		MyLinkedList myLinkedList = new MyLinkedList();
		myLinkedList.add(myFirstNode);
		myLinkedList.append(mySecondNode);
		myLinkedList.append(myThirdNode);
		myLinkedList.append(myFourthNode);
		System.out.println("\nBefore Sorting: ");
		myLinkedList.printMyNode();
		myLinkedList.sortList();
		System.out.println("\nAfter Sorting: ");
		myLinkedList.printMyNode();
		boolean result = myLinkedList.head.equals(myFirstNode) && 
						 myFirstNode.getNext().equals(mySecondNode) &&
						 mySecondNode.getNext().equals(myThirdNode) &&
						 myLinkedList.tail.equals(myFourthNode);
		assertTrue(result);
	}
}