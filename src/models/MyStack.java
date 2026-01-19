package models;

public class MyStack<T> {
private Node<T> top;
	
	public T peek() {
		return this.top.getContent();
	}
	
	public void push(T content) {
		Node<T> newItem = new Node<T>(content);
		if (this.top == null) {
			this.top = newItem;
			return;
		}
		newItem.setNext(this.top);
		this.top = newItem;
	}
	
	public T pop() {
		Node<T> old;
		
		if (isEmpty())
			return null;
		old = this.top;
		top = this.top.getNext();
		top.setNext(this.top.getNext());
		old.setNext(null);
		
		return old.getContent();
	}
	
	public int size() {
		int len = 0;
		Node<T> temp;
		
		temp = this.top;
		while(temp != null) {
			len++;
			temp = temp.getNext();
		}
		
		return len;
	}
	
	public boolean isEmpty() {
		return this.top == null ? true : false;
	}
	
	@Override
	public String toString() {
		Node<T> temp;
		String str;
	
		temp = this.top;	
		str = " Stack \n";
		for (int count = 0; count < this.size(); count++) {
			str += " [Item = " + temp + "\t|\t" + temp.getContent() + "\t|\t" + temp.getNext() + " ]\n";
			temp = temp.getNext();
		}

		return str;
	}
}
