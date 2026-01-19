package models;

public class DoublyLinkedList<T> extends List<T>{
	
	public DoublyLinkedList() {
		super();
		this.head = null;
	}
	
	public void add(T content) {
		Node<T> newNode = new Node<T>(content);
		Node<T> temp;
		
		if (this.isEmpty()) {
			this.head = newNode;
			
		} else {	
			temp = this.head;	
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			
			temp.setNext(newNode);
			newNode.setPrev(temp);
		}
	}
	
	public T removeById(int index) {
		Node<T> temp;
		Node<T> temp2;
		
		temp = this.getNode(index);
		if (index == 0) {
			this.head = temp.getNext();
			
		 	return temp.getContent();
		}	
		temp2 = this.getNode(index - 1);
		temp2.setNext(temp.getNext());
		temp.getNext().setPrev(temp2);
		temp.setPrev(null);
		temp.setNext(null);
		
		return temp.getContent(); 
	}
	
	@Override
	public String toString() {
		Node<T> temp;
		String str;
	
		temp = this.head;	
		str = "  List \n";
		for (int count = 0; count < this.size(); count++) {
			str += " [Node = " + temp.getPrev();
			
			str += temp.getPrev() == null ? "\t\t\t|\t" :  "\t|\t";
			
			str += temp + "\t|\t" + temp.getContent() + "\t|\t" + temp.getNext() + " ]\n";
			temp = temp.getNext();
		}

		return str;
	}
}
