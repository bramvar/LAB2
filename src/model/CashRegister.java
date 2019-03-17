package model;

import vRqueue.VrQueue;
import vRstack.VrStack;

public class CashRegister {
	
	private boolean isBusy;
	 
	public CashRegister() {
		isBusy=false;
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

	
}
