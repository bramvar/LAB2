package model;

import vRqueue.VrQueue;
import vRstack.VrStack;

public class CashRegister implements Runnable{
	
	private Client client;
	private boolean isBusy;
	 
	public CashRegister(Client client) {
		isBusy=false;
		this.client=client;
	}

	public double calculateIndividualSale(Client client) {
		double sale=0;
		isBusy=true;
		VrStack<Book> clientsBooks=client.getCollectedBooks();
		do {
			Book b=clientsBooks.pop();
			client.getPurchasedBooks().push(b);
			sale+=b.getPrice();
			
		}while(!clientsBooks.empty());
		client.setSpentMoney(sale);
		isBusy=false;
		return sale;
	}

	@Override
	public void run() {
		double sale=0;
		VrStack<Book> clientsBooks=client.getCollectedBooks();
		do {
			Book b=clientsBooks.pop();
			client.getPurchasedBooks().push(b);
			sale+=b.getPrice();
			
		}while(!clientsBooks.empty());
		client.setSpentMoney(sale);
	}

	
}
