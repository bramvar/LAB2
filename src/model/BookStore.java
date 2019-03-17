package model;

import vRhashTable.VrHashTable;
import vRqueue.VrQueue;

public class BookStore {
	
	private VrQueue<Client> clients;
	private VrQueue<Client> clientQueue;
	//private VrHashTable<Book> bookShelf;
	private BookShelf bookShelf;
	
	private int clientInitialTime;
	private int booksAmount;
	private int cashRegisters;
	
	public BookStore(int booksAmount, int cashRegisters) {
		this.booksAmount=booksAmount;
		this.cashRegisters=cashRegisters;
		//bookShelf=new VrHashTable<Book>(booksAmount);
		bookShelf=new BookShelf(booksAmount);
		clients=new VrQueue<Client>();
		clientQueue=new VrQueue<Client>();
		clientInitialTime=1;
	}
	
	public void startSimulation() {
		
	}
	
	public void registerClient(int id, String[] isbnList) {
		int[] isbnLO=sortClientsList(convertArray(isbnList));
		clients.offer(new Client(id,isbnLO,clientInitialTime));
		clientInitialTime++;
	}
	
	public void addBookToLibrary(int isbn, Book b) {
		bookShelf.addBookToLibrary(isbn, b);
	}
	
	public void deleteBook(int isbn) {
		bookShelf.deleteBook(isbn);
	}
	
	public Book searchBook(int isbn) {
		return bookShelf.searchBook(isbn);
	}
	
	public void sortClients() {
		
	}
	
	public int[] sortClientsList(int[] isbn) {
		int [] isbnLO = isbn.clone();
		for (int i = 0; i < isbnLO.length -1; i++) {
			int menor = isbnLO[i];
			int cual = i;
			for (int j = i + 1; j < isbnLO.length; j++  ) {
				if (searchBook(isbnLO[j]).getBookShelf() < searchBook(menor).getBookShelf()) {
					menor = isbnLO [ j ];
					cual = j;
				}
			}
			int temp = isbnLO [ i ];
			isbnLO[ i ] = menor;
			isbnLO[ cual ] = temp;
		}
		return isbnLO;
		
	}
	
	public int[] convertArray(String[] a) {
	    try
	    {
	    	int[] array=new int[a.length];
	    	for(int i=0;i<a.length;i++) {
	    		array[i]=Integer.parseInt(a[i]);
	    	}
	    	return array;
	    }
	    catch (NumberFormatException nfe)
	    {
	        return null;
	    }
	}

}
