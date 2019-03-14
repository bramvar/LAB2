package vRhashTable;

import java.util.NoSuchElementException;

public class VrHashTable<T> implements IvrHashTable<T>{

	private int size;
	private ElementHash<T>[] elementHash;
	
	public VrHashTable(int size) {
		this.size=size;
		elementHash=new ElementHash[size];
	}
	
	@Override
	public int function(int key) {
		return key%size;
	}
	
	@Override
	public void push(int key, T element) {
		int hashPosition = function(key);
		if(elementHash[hashPosition] == null) {
			elementHash[hashPosition] = new ElementHash<T>(key, element);
		} else {
			ElementHash<T> newE=new ElementHash<T>(key, element);
			ElementHash<T> hashItemCurrent = elementHash[hashPosition];
			while(hashItemCurrent.getNextElement() != null) {
				hashItemCurrent = hashItemCurrent.getNextElement();
			}
			hashItemCurrent.setNextElement(newE);
			newE.setPrevElement(hashItemCurrent);
		}
	
	}

	@Override
	public T search(int key) {
		int hashPosition = function(key);
		ElementHash<T> hashItemCurrent = elementHash[hashPosition];
		while(hashItemCurrent != null && hashItemCurrent.getKey() != key) {
			hashItemCurrent = hashItemCurrent.getNextElement();
		}
		if(hashItemCurrent == null) {
			return null;
		} else {
			return hashItemCurrent.getElement();
		}
	}
	
	@Override
	public void delete(int key) {
		int hashPosition = function(key);
		
		if(elementHash[hashPosition] == null) {
			throw new NoSuchElementException();
		} 
		else if(elementHash[hashPosition].getKey()==key)
			elementHash[hashPosition]=elementHash[hashPosition].getNextElement();
		else {
			ElementHash<T> hashItemCurrent = elementHash[hashPosition].getNextElement();
			
			while((hashItemCurrent != null) && (hashItemCurrent.getKey() != key))
				hashItemCurrent = hashItemCurrent.getNextElement();
			
			if(hashItemCurrent.getNextElement()==null) {
				ElementHash<T> aux=hashItemCurrent.getPrevElement();
				hashItemCurrent=hashItemCurrent.getPrevElement();
				hashItemCurrent.setNextElement(null);
			}else {
				ElementHash<T> aux=hashItemCurrent.getPrevElement();
				hashItemCurrent=hashItemCurrent.getNextElement();
				aux.setNextElement(hashItemCurrent);
				hashItemCurrent.setPrevElement(aux);
		}
		
		}
	}

	public ElementHash<T> getElementHash(int i) {
		return elementHash[i];
	}

	
	/*
	@Override
	public void delete(int key) {
		int hashPosition = function(key);
		while(elementHash[hashPosition] != null && elementHash[hashPosition].getNextElement().getKey() != key) {
			elementHash[hashPosition] = elementHash[hashPosition].getNextElement();
		}
		if(elementHash[hashPosition] == null) {
			throw new NoSuchElementException();
		} else {
			elementHash[hashPosition].setNextElement(elementHash[hashPosition].getNextElement().getNextElement());
		}
	}*/
}
