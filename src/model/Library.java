package model;

import vRhashTable.VrHashTable;
import vRqueue.VrQueue;

public class Library {
	
	private BookShelf bookShelf1;
	private VrQueue<Client> clients;
	private VrQueue<Client> clientQueue;
	private VrHashTable<Book> bookShelf;
	
	private int booksAmount;
	private int cashRegisters;
	
	public Library(int booksAmount, int cashRegisters) {
		this.booksAmount=booksAmount;
		this.cashRegisters=cashRegisters;
		
	}

}
