package model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import vRhashTable.VrHashTable;
import vRpriorityQueue.VrPriorityQueue;
import vRqueue.IvrQueue;
import vRqueue.VrQueue;

public class BookStore {
	
	private IvrQueue<Client> clients;
	private VrQueue<Client> clientQueue;
	//private VrHashTable<Book> bookShelf;
	private BookShelf bookShelf;
	
	public IvrQueue<Client> getClients() {
		return clients;
	}
	
	public VrQueue<Client> getClientQueue() {
		return clientQueue;
	}

	public void setClients(IvrQueue<Client> clients) {
		this.clients = clients;
	}

	public BookShelf getBookShelf() {
		return bookShelf;
	}

	public void setBookShelf(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}

	public int getCashRegisters() {
		return cashRegisters;
	}

	public void setCashRegisters(int cashRegisters) {
		this.cashRegisters = cashRegisters;
	}

	private int clientInitialTime;
	private int booksAmount;
	private int cashRegisters;
	private int clientOrderArrival;
	
	public BookStore(int booksAmount, int cashRegisters) {
		this.booksAmount=booksAmount;
		this.cashRegisters=cashRegisters;
		//bookShelf=new VrHashTable<Book>(booksAmount);
		bookShelf=new BookShelf(booksAmount);
		clients=new VrPriorityQueue<Client>(15);
		clientQueue=new VrQueue<Client>();
		clientInitialTime=1;
		clientOrderArrival=1;
	}
	
	public void startSimulation() {
		takeBooksProcess();
		ExecutorService executor = Executors.newFixedThreadPool(cashRegisters);
		IvrQueue<Client> aux=clients;
		while(!aux.empty()) {
			Client c=aux.poll();
			Runnable cashRegister=new CashRegister(c);
			executor.execute(cashRegister);
			clientQueue.offer(c);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
        	// Espero a que terminen de ejecutarse todos los procesos 
        	// para pasar a las siguientes instrucciones 
        }
		
	}
	
	public void takeBooksProcess() {
		IvrQueue<Client> aux=clients;
		IvrQueue<Client> newQueue=new VrPriorityQueue<Client>(15);
		while(!aux.empty()) {
			Client c=aux.poll();
			c.takeBooks(this.bookShelf);
			newQueue.offer(c);
		}
		clients=newQueue;
	}
	
	public void registerClient(int id, String[] isbnList) {
		int[] isbnLO=sortClientsList(convertArray(isbnList));
		clients.offer(new Client(id,isbnLO,clientInitialTime,clientOrderArrival));
		clientInitialTime++;
		clientOrderArrival++;
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
		int [] isbnLO = checkBookList(isbn.clone());
		for (int i = 0; i < isbnLO.length -1; i++) {
			if(searchBook(isbnLO[i])!=null) {
				int menor = isbnLO[i];
				int cual = i;
				for (int j = i + 1; j < isbnLO.length; j++  ) {
					if(searchBook(isbnLO[j])!=null) {
						if (searchBook(isbnLO[j]).getBookShelf() < searchBook(menor).getBookShelf()) {
							menor = isbnLO [ j ];
							cual = j;
						}
					}
					
				}
				int temp = isbnLO [ i ];
				isbnLO[ i ] = menor;
				isbnLO[ cual ] = temp;
			}
		}
		return isbnLO;
		
	}
	
	public int[] checkBookList(int[] list) {
		int[] auxL=new int[list.length+1];
		int cont=0;
		for(int i=0;i<list.length;i++) {	
			if(searchBook(list[i])==null) {
				auxL[i]=0;
			}
			else {
				auxL[i]=list[i];
				cont++;
			}
		}
		auxL[list.length]=cont;
		auxL=cleanList(auxL);
		
		return auxL;
	}
	
	public int[] cleanList(int[] list) {
		int[] auxL=list.clone();
		int[] auxCL=new int[auxL[list.length-1]];
		int cont=0;
		for(int i=0; i<auxL.length-1;i++) {
			if(auxL[i]!=0) {
				auxCL[cont]=auxL[i];
				cont++;
			}
		}
		return auxCL;
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
