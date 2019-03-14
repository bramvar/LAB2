package model;

import vRhashTable.VrHashTable;

public class BookShelf {
	
	private VrHashTable<Book> books;
	private int booksAmount;
	
	public BookShelf(int booksAmount ) {
		this.booksAmount=booksAmount;
		books=new VrHashTable<Book>(booksAmount);
	}
	
	public void addBookToLibrary(int isbn, Book b) {
		books.push(isbn, b);
	}
	
	public void deleteBook(int isbn) {
		books.delete(isbn);
	}
	
	public Book searchBook(int isbn) {
		return books.search(isbn);
	}
}
 