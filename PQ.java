package ds;

import java.util.Iterator;

public class PQ<T extends Comparable<T>> implements Iterable<T> {
	
	private int size;
	private T[] elements;
	
	public PQ() {
		this(10);
	}
	
	@SuppressWarnings("unchecked")
	public PQ(int initialCapacity) {
		elements = (T[]) new Comparable[initialCapacity + 1];
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void resize(int capacity) {
		T[] newElements = (T[]) new Object[capacity];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		elements = newElements;
	}
	
	public void swim(int position) {
		int parent;
		while((parent = position/2) > 0 && elements[position].compareTo(elements[parent]) > 0) {
			swap(parent, position);
			position = parent;
		}
	}
	
	public void insert(T t) {
		if (size == elements.length - 1) {
			resize(2 * elements.length);
		}
		size += 1;
		elements[size] = t;
		swim(size);
	}
	
	public void sink(int position) {
		int left;
		while ((left = 2 * position) <= size) {
			int right = 2 * position + 1;
			T currentNode = elements[position];
			int bigger = left;
			T leftNode = elements[left];
			T biggerNode = leftNode;
			if (right < size) {
				T rightNode = elements[right];
				if (rightNode.compareTo(leftNode) > 0) {
					bigger = right;
					biggerNode = rightNode;
				}
			}
			if (currentNode.compareTo(biggerNode) > 0) return;
			else {
				swap(position, bigger);
				position = bigger;
			}
		}
	}
	
	public T delMax() {
		swap(1, size);
		T max = elements[size];
		size -= 1;
		sink(1);
		elements[size + 1] = null;
		return max;
	}
	
	private void swap(int apos, int bpos) {
		T a = elements[apos];
		elements[apos] = elements[bpos];
		elements[bpos] = a;
	}
	
	public boolean isMaxHeap(int currentPosition) {
		if (currentPosition > size) return true;
		int left = 2 * currentPosition;
		int right = 2 * currentPosition + 1;
		T currentNode = elements[currentPosition];
		if (! (currentNode.compareTo(elements[left]) > 0 && currentNode.compareTo(elements[right]) > 0)) return false; 
		return isMaxHeap(left) && isMaxHeap(right);
	}
	

	@Override
	public Iterator<T> iterator() {
		return new PQIterator();
	}
	
	private class PQIterator implements Iterator<T> {

		@Override
		public boolean hasNext() {
			return ! PQ.this.isEmpty();
		}

		@Override
		public T next() {
			return PQ.this.delMax();
		}
		
	}
	
}
