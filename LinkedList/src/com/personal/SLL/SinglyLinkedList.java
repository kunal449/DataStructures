package com.personal.SLL;

public class SinglyLinkedList {

	SLLNode head;
	int length = 0;
	
	public SLLNode insert(int data){
		length++;
		return insertNodeAt(new SLLNode(data), length);
	}
	
	public SLLNode insertNodeAt(SLLNode nodeToInsert, int position){
		int size = getLinkedListLength(head);
		if(size+1 < position || position < 1 ){
			System.out.println("Position of node to insert is invalid : "+position);
			return head;
		}
		if(position == 1){
			nodeToInsert.setNext(head);
			head = nodeToInsert;
		}else{
			SLLNode currentNode = head;
			int count =1;
			while(count < position-1){
				currentNode = currentNode.getNext();
				count++;
			}
			nodeToInsert.setNext(currentNode.getNext());
			currentNode.setNext(nodeToInsert);
		}
		return head;
	}
	public SLLNode deleteNodeFrom(int position){
		int size = getLinkedListLength(head);
		if(size < position || position < 1){
			System.out.println("Invalid position passed to delete the list : "+position);
			return head;
		}
		if(position == 1){
			SLLNode temp = head;
			head = head.getNext();
			temp = null;
		}else{
			SLLNode temp = head;
			int count = 1;
			while(count < position-1){
				temp = temp.getNext();
				count++;
			}
			SLLNode temp1 = temp.getNext();
			temp.setNext(temp1.getNext());
			temp1 = null;
		}
		length--;
		return head;
	}
	public void printList(){
		SLLNode temp = head;
		while(temp != null){
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	private int getLinkedListLength(SLLNode head){
		int size = 0 ;
		while(head != null){
			size++;
			head = head.getNext();
		}
		return size;
	}
	public SLLNode reverseInPairIterator(){
		SLLNode tempHead = head, temp1=null, temp2 =null;
		while(tempHead != null && tempHead.getNext() != null){
			SLLNode temp = tempHead.getNext();
			tempHead.setNext(temp.getNext());
			temp.setNext(tempHead);
			tempHead=tempHead.getNext();
			if(temp2 == null){
				temp2 = temp;  head= temp2;
			}
			if(temp1 != null){
				temp1.setNext(temp);
			}
			temp1 = temp.getNext();
		}
		return temp2;
	}
	public SLLNode reverseInPairRecursive(SLLNode tempHead){
		if(tempHead ==null || tempHead.getNext() == null)
				return tempHead;
		SLLNode temp = tempHead.getNext();
		tempHead.setNext(temp.getNext());
		temp.setNext(tempHead);
		tempHead.setNext(reverseInPairRecursive(tempHead.getNext()));
		System.out.print(tempHead.getData()+" -> "+temp.getData()+"->");
		return temp;
	}
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		SLLNode head = list.insert(1);
		list.insert(2);
		list.insert(3);
		list.printList();
		//list.deleteNodeFrom(0);
		//list.printList();
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.printList();
		//list.reverseInPairIterator();
		System.out.println("Head : "+list.head.getData());
		list.reverseInPairRecursive(list.head);
		System.out.println("Reversing the list");
		list.printList();
	}
}
