package ds;

public class Node<T> implements Comparable<Node<T>> {
	private T data;
	private int priority;
	
	public Node(T data, int priority) {
		this.data = data;
		this.priority = priority;
	}
	
	public String toString() {
		return data + " "  + priority;
	}
	
	@Override
	public int compareTo(Node other) {
		return this.priority - other.priority;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
