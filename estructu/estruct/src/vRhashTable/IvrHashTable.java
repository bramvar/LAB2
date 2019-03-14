package vRhashTable;

public interface IvrHashTable<T> {
	public int function(int key);
	public void push(int key,T element);
	public T search(int key);
	public void delete(int key);
	public ElementHash<T> getElementHash(int i);
}
