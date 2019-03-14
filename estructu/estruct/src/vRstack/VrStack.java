package vRstack;


public class VrStack<E> implements IvrStack<E> {
	
	private VrNode<E> top;
	private int size;
	
	public VrStack() {
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
		VrNode<E> newElement=new VrNode<E>(element,top);
		if(empty()) 
			top=newElement;
		else {
			newElement.setNext(top);
			top=newElement;
		}
		size++;
	}
}
