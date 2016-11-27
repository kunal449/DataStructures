package com.personal.CDLL;

public class CDLList {
	private CDLLNode head;
	
	public CDLLNode insertData(CDLLNode nodeToInsert, int position){
		if(head == null){
			head = nodeToInsert;
			head.setNext(head);
			head.setPrevious(head);
			return head;
		}
		int size = getCDllSize();
		if(position < 1 || size+1 < position){
			System.out.println("Position to insert data is invalid : "+position);
			return head;
		}
		if(position == 1 ){
			CDLLNode lastNode = head.getPrevious();
			nodeToInsert.setNext(head);
			nodeToInsert.setPrevious(lastNode);
			lastNode.setNext(nodeToInsert);
			head.setPrevious(nodeToInsert);
			head = nodeToInsert;
		}else{
			CDLLNode temp = head;
			int count =1;
			while(count++ < position-1){
				temp = temp.getNext();
			}
			CDLLNode currentNode = temp.getNext();
			nodeToInsert.setNext(currentNode);
			if(currentNode != null) {
				currentNode.setPrevious(nodeToInsert);
			}
			temp.setNext(nodeToInsert);
			nodeToInsert.setPrevious(temp);
		}
		return head;
	}
	public CDLLNode deleteNode(int position){
		int size = getCDllSize();
		if(size < position || position < 1){
			System.out.println("Invalid position passed for delete : "+position);
			return head;
		}
		CDLLNode temp = head;
		if(position == 1){
			CDLLNode previousNode = head.getPrevious();
			CDLLNode nextNode = head.getNext();
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
			head = head.getNext();
			temp = null;
		}else{
			int count = 1;
			while(count++ < position-1){
				temp = temp.getNext();
			}
			CDLLNode current = temp.getNext();
			CDLLNode later = current.getNext();
			temp.setNext(later);
			if(later != null){
				later.setPrevious(temp);;
			}
			current = null;
		}
		return head;
	}
	public int getCDllSize(){
		CDLLNode temp = head;
		int size=1;
		while(temp.getNext() != head){
			temp = temp.getNext();
			size++;
		}
		//System.out.println("CDLL size : "+size);
		return size;
	}
	public void printList(){
		CDLLNode temp = head;
		while(temp.getNext() != head){
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.print(temp.getData()+" -> null");
		System.out.println();
	}
	public static void main(String[] args){
		//System.out.println("Hello DLL");
		CDLList list = new CDLList();
		list.insertData(new CDLLNode(1),1);
		list.insertData(new CDLLNode(2),2);
		list.insertData(new CDLLNode(3),1);
		list.printList();
		list.deleteNode(2);
		list.printList();
	}
}
