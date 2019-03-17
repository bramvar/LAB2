package vRpriorityQueue;

import vRqueue.IvrQueue;

public class VrPriorityQueue<T extends Comparable<T>> implements IvrQueue<T>{
	
	private MinHeap<T> heap;

	public VrPriorityQueue(int maxsize) {
		heap = new MinHeap<T>(maxsize);
	}

	public T poll() {
		if (heap.getSize() <= 0)
			return null;
		else {
			T minVal = heap.get(1);
			heap.set(1, heap.get(heap.getSize()));  
			heap.remove(1);
			return minVal;
		}
	}

	@Override
	public void offer(T element) {
		heap.insert(element); 
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean empty() {
		return heap.getSize() == 0;
	}

	@Override
	public T peek() {
		if (heap.getSize() <= 0)
			return null;
		else
			return heap.get(1);
	}

}
