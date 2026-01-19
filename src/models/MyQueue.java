package models;

public class MyQueue<T> {
	private Node<T> init;
	private Node<T> end;
	
	public T get() {
		return this.init.getContent();
	}
	
	public void enqueue(T content) {
		Node<T> newItem = new Node<T>(content);

		if (this.init == null) {
			this.init = newItem;
			this.end = newItem;
			return;
		}
		if (this.size() == 1)
		{
			this.end = newItem;
			this.init.setNext(end);
			return;
		}
		this.end.setNext(newItem);
		this.end = newItem;
	}
	
	public T dequeue() {
		Node<T> old;
		
		if (isEmpty())
			return null;
		old = this.init;
		this.init = this.init.getNext();
		old.setNext(null);
		
		return old.getContent();
	}
	
	public int size() {
		int len = 0;
		Node<T> temp;
		
		temp = this.init;
		while(temp != null) {
			len++;
			temp = temp.getNext();
		}
		
		return len;
	}
	
	public boolean isEmpty() {
		return this.init == null ? true : false;
	}
	
	@Override
	public String toString() {
		Node<T> temp;
		String str;
	
		temp = this.init;	
		str = " MyQueue \n";
		for (int count = 0; count < this.size(); count++) {
			str += " [Item = " + temp + "\t|\t" + temp.getContent() + "\t|\t" + temp.getNext() + " ]\n";
			temp = temp.getNext();
		}

		return str;
	}
}
