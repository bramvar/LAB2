package vRstack;

public class VrNode<E> {
	
	private E data;
	private VrNode<E> next;
	
	VrNode(E data){
		this(data,null);
	}
	
	VrNode(E data, VrNode<E> next){
		this.data=data;
		this.next=next;		
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public VrNode<E> getNext() {
		return next;
	}

	public void setNext(VrNode<E> next) {
		this.next = next;
	}
}
