package model;

import vRstack.VrStack;
import java.util.Comparator;

public class Client implements Comparable<Client>{
	
	private int id;
	private int[] isbnList;
	private VrStack<Book> collectedBooks;
	private VrStack<Book> purchasedBooks;
	private double spentMoney;
	private int time;
	private int arrivalOrder;
	
	public Client(int id,int[] isbnList, int time, int arrivalOrder) {
		this.id=id;
		this.isbnList=isbnList;
		this.time=time;
		this.arrivalOrder=arrivalOrder;
		spentMoney=0;
		collectedBooks=new VrStack<Book>();
		purchasedBooks=new VrStack<Book>();
	}
	
	public int getArrivalOrder() {
		return arrivalOrder;
	}

	public void takeBooks(BookShelf b) {
		if(isbnList!=null) {
			for(int i=0;i<isbnList.length;i++) {
				Book bo=b.searchBook(isbnList[i]);
				if(bo.getAmount()>0) {
					collectedBooks.push(bo);
					b.searchBook(isbnList[i]).reduceAmount();
					time++;
				}else System.out.println("ya no hay más ejemplares de el libro ");
				
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getIsbnList() {
		return isbnList;
	}

	public void setIsbnList(int[] isbnList) {
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

	public double getSpentMoney() {
		return spentMoney;
	}

	public void setSpentMoney(double spentMoney) {
		this.spentMoney = spentMoney;
	}

	@Override
	public int compareTo(Client c) {
		int result=0;
		if(this.time<c.time	) result=-1;
		else if(this.time>c.time) result=1;
		else {
			if(this.arrivalOrder<c.arrivalOrder) result=-1;
			else if(this.arrivalOrder>c.arrivalOrder) result=1;
		}
		return result;
	}
}
