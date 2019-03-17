package model;

public class Book {
	
	private int price;
	private int amount;
	private char bookShelf;

	
	public Book(int price, int amount, char bookShelf) {
		this.price = price;
		this.amount = amount;
		this.bookShelf = bookShelf;
	}
	
	public char getBookShelf() {
		return bookShelf;
	}

	public void setBookShelf(char bookShelf) {
		this.bookShelf = bookShelf;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
