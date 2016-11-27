package com.personal.DLL;

public class DLList {
	private DLLNode head;
	
	public DLLNode insertData(DLLNode nodeToInsert, int position){
		if(head == null){
			head = nodeToInsert;
			return nodeToInsert;
		}
		int size = getDllSize();
		if(size < 1 || size+1 > position){
			System.out.println("Position to insert data is invalid : "+position);
			return head;
		}
		if(position == 1 ){
			nodeToInsert.setNext(head);
			head.setPrevious(nodeToInsert);
			head = nodeToInsert;
		}else{
			DLLNode temp = head;
			int count =1;
			while(count++ < position-1){
				temp = temp.getNext();
			}
			DLLNode currentNode = temp.getNext();
			nodeToInsert.setNext(currentNode);
			if(currentNode != null) {
				currentNode.setPrevious(nodeToInsert);
			}
			temp.setNext(nodeToInsert);
			nodeToInsert.setPrevious(temp);
		}
		return head;
	}
	public DLLNode deleteNode(int position){
		int size = getDllSize();
		if(size < position || position < 1){
			System.out.println("Invalid position passed for delete : "+position);
			return head;
		}
		DLLNode temp = head;
		if(position == 1){
			head = head.getNext();
			head.setPrevious(null);
			temp = null;
		}else{
			int count = 1;
			while(count++ < position-1){
				temp = temp.getNext();
			}
			DLLNode current = temp.getNext();
			DLLNode later = current.getNext();
			temp.setNext(later);
			if(later != null){
				later.setPrevious(temp);;
			}
			current = null;
		}
		return head;
	}
	public int getDllSize(){
		DLLNode temp = head;
		int size=0;
		while(temp != null){
			temp = temp.getNext();
			size++;
		}
		return size;
	}
	public void printList(){
		DLLNode temp = head;
		while(temp != null){
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	public static void main(String[] args){
		System.out.println("Hello DLL");
		DLList list = new DLList();
		list.insertData(new DLLNode(1),1);
		list.insertData(new DLLNode(2),2);
		list.insertData(new DLLNode(3),3);
		list.printList();
		list.deleteNode(4);
		list.printList();
	}
}
