package models;

public class Node<T> {
	private T content;
	private Node<T> next;
	private Node<T> prev;
	
	public Node(T content) {
		super();
		this.content = content;
	}
	
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	public Node<T> getNext() {
		return next;
	}
	
	public void setNext (Node<T> node) {
		this.next = node;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}

	/*@Override
	public String toString() {
		return "Node [content=" + content + ", next=" + next + "]";
	}*/
	
}
