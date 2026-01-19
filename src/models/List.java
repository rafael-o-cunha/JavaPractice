package models;

public class List<T> {
	
	protected Node<T> head;
	
	public List() {
		this.head = null;
	}
	
	public boolean isEmpty() {
		return this.head == null ? true : false;
	}
	
	public int size() {
		int size = 0;	
		Node<T> temp;
		
		temp = this.head;	
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}

		return size;
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
		}
	}
	
	protected void IndexValidation(int index) {
		if (index > this.size()) {
			throw new IndexOutOfBoundsException("segfault...");
		}
	}
	
	protected Node<T> getNode(int index) {
		int count = 0;
		Node<T> temp;
		
		IndexValidation(index);
		
		temp = this.head;
		while (count != index) {
			count++;
			temp = temp.getNext();
		}

		return temp;
	}
	
	
	public T get(int index)	{
		return getNode(index).getContent();
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
		temp.setNext(null);
		
		return temp.getContent(); 
	}

	@Override
	public String toString() {
		Node<T> temp;
		String str;
	
		temp = this.head;	
		str = "List \n";
		for (int count = 0; count < this.size(); count++) {
			str += " [Node = " + temp + "\t|\t" + temp.getContent() + "\t|\t" + temp.getNext() + " ]\n";
			temp = temp.getNext();
		}

		return str;
	}
}
