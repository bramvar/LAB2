package vRstack;

public interface IvrStack<E> {
	public int size();
	public boolean empty();
	public E peek();
	public E pop();
	public void push(E element);
}
