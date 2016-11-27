package com.personal.CDLL;

public class CDLLNode {
	private int data;
	private CDLLNode previous;
	private CDLLNode next;
	
	public CDLLNode(int data){
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public CDLLNode getPrevious() {
		return previous;
	}
	public void setPrevious(CDLLNode previous) {
		this.previous = previous;
	}
	public CDLLNode getNext() {
		return next;
	}
	public void setNext(CDLLNode next) {
		this.next = next;
	}
}
