package model;

import vRstack.VrStack;

public class Client {
	
	private int id;
	private String[] isbnList;
	private VrStack<Book> collectedBooks;
	private VrStack<Book> purchasedBooks;
	private int spentMoney;
	private int time;

	
	public Client(int id,String[] isbnList) {
		this.id=id;
		this.isbnList=isbnList;
		time=0;
		spentMoney=0;
		collectedBooks=new VrStack<Book>();
		purchasedBooks=new VrStack<Book>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getIsbnList() {
		return isbnList;
	}

	public void setIsbnList(String isbnList[]) {
		this.isbnList = isbnList;
	}
	
	public void addTime(int i) {
		time+=i;
	}
	
	public int getTime() {
		return time;
	}

	public VrStack<Book> getCollectedBooks() {
		return collectedBooks;
	}

	public void setCollectedBooks(VrStack<Book> collectedBooks) {
		this.collectedBooks = collectedBooks;
	}

	public VrStack<Book> getPurchasedBooks() {
		return purchasedBooks;
	}

	public void setPurchasedBooks(VrStack<Book> purchasedBooks) {
		this.purchasedBooks = purchasedBooks;
	}

	public int getSpentMoney() {
		return spentMoney;
	}

	public void setSpentMoney(int spentMoney) {
		this.spentMoney = spentMoney;
	}
	
	

}
