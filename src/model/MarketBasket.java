package model;

public class MarketBasket<E> implements IStack<E>,IOperations<E>{
	
	private Node<E> top;
	private int size;
	
	public MarketBasket() {
		top=null;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {
		return top==null;
	}

	@Override
	public E peek() {
		if(empty())
			return null;
		else {
			E aux=top.getData();
			size--;
			return aux;
		}
	}

	@Override
	public E pop() {
		if(empty())
			return null;
		else {
			E aux=top.getData();
			top=top.getNext();
			size--;
			return aux;
		}
	}

	@Override
	public void push(E element) {
		Node<E> newElement=new Node<E>(element,top);
		if(empty()) 
			top=newElement;
		else {
			newElement.setNext(top);
			top=newElement;
		}
		size++;
	}
}
