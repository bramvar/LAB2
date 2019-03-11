package model;

public class Queue<E> implements IQueue<E>,IOperations<E>{
	
	private Node<E> first;
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {	
		return first==null;
	}

	@Override
	public E peek() {
		if(empty())
			return null;
		else {
			E aux=first.getData();
			size--;
			return aux;
		}
	}

	@Override
	public void offer(E element) {
		Node<E> newElement=new Node<E>(element);
		if(empty())
			first=newElement;
		else {
			Node<E> aux=first;
			while(aux.getNext()!=null)
				aux=aux.getNext();
			aux.setNext(newElement);
		}
		size++;
	}

	@Override
	public E poll() {
		if(empty())
			return null;
		else {
			E aux=first.getData();
			first=first.getNext();
			size--;
			return aux;
		}
	}
	
	

}
