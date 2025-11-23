package com.tca.util;

public class MyLinkedList {

	private ListNode headNode;
	private Integer length;
	
	public MyLinkedList() {
		length = 0;
	}
	
	public synchronized Integer getLength() {
		return length;
	}
	
	public synchronized ListNode getHead() {
		return headNode;
	}
	
	public synchronized Object getHeadValue() {
		if(headNode == null)
			return null;
		return headNode.getData();
	}	
	
	public synchronized void insertAtBegin(Object data) {
		ListNode node = new ListNode(data);
		node.setNext(node);
		headNode = node;
		length++;
	}
	
	public synchronized void insertAtEnd(Object data) {
		ListNode node = new ListNode(data);
		if(headNode == null)
			headNode = node;
		else {
			ListNode p = null,c = headNode;
			for(p = headNode; (c = p.getNext()) != null; p = c );
			p.setNext(node);
		}
		length++;
	}
	
	public synchronized void insert(Object data, int pos) {
		// fixing position
		if(pos < 0) pos = 0;
		else if( pos > length ) pos = length;
		
		if(headNode == null) {
			headNode = new ListNode(data);
		}
		else if(pos == 0) {
			ListNode node = new ListNode(data);
			node.setNext(headNode);
			headNode = node;
		}
		else {
			ListNode node = new ListNode(data);
			ListNode current = headNode;
			for(int i = 1; i < pos; ++i)
				current = current.getNext();
			node.setNext(current.getNext());
			current.setNext(node);
		}
		length++;
	}
	
	public synchronized Object removeFromBegin() {
		ListNode node = headNode;
		if(node != null) {
			headNode.setData(node.getNext());
			node.setNext(null);
			length--;
			return node.getData();
		}
		return null;
	}
	
	public synchronized Object removeFromEnd() {
		if(headNode == null) 
			return null;
		
		ListNode p = headNode, q = null, next = headNode.getNext();
		Object data;
		
		if(next == null) {
			data = headNode.getData();
			headNode = null;
			return data;
		}
		else {
			while( (next = p.getNext()) != null) {
				q = p;
				p = next;
			}
			q.setNext(null);
			data = p.getData();
		}
		length--;
		return data;
	}
	
	
	public synchronized Object get(int pos) {
		if(pos < 0) pos = 0;
		else if(pos > length) pos = length;
		
		ListNode current= headNode;
		if(current == null)
			return null;
		
		for(int i = 1; i < pos; ++i) 
			current = current.getNext();
		
		return current.getData();
	}
}
