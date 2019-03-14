package vRhashTable;

public class ElementHash<T> {

	private int key;
	private T element;
	private ElementHash<T> nextElement;
	private ElementHash<T> prevElement;
	
	public ElementHash(int key,T element) {
		this.key=key;
		this.element=element;
		nextElement=null;
		prevElement=null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public ElementHash<T> getNextElement() {
		return nextElement;
	}

	public void setNextElement(ElementHash<T> nextElement) {
		this.nextElement = nextElement;
	}

	public ElementHash<T> getPrevElement() {
		return prevElement;
	}

	public void setPrevElement(ElementHash<T> prevElement) {
		this.prevElement = prevElement;
	}
	
	
}
