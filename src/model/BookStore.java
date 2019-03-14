package model;

import vRhashTable.VrHashTable;
import vRqueue.VrQueue;

public class BookStore {
	
	private BookShelf bookShelf1;
	private VrQueue<Client> clients;
	private VrQueue<Client> clientQueue;
	private VrHashTable<Book> bookShelf;
	
	private int booksAmount;
	private int cashRegisters;
	
	public BookStore(int booksAmount, int cashRegisters) {
		this.booksAmount=booksAmount;
		this.cashRegisters=cashRegisters;
	}
	
	public void registerClient(int id, int[] isbnList) {
		clients.offer(new Client(id,isbnList));
	}
	
	

}
