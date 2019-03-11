package model;

public interface IQueue<E> {
	
	public void offer(E element);
	public E poll();
}
