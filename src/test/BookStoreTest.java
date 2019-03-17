package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Book;
import model.BookStore;
import model.Client;
import vRpriorityQueue.VrPriorityQueue;
import vRqueue.IvrQueue;
import vRstack.VrStack;

class BookStoreTest {
	
	private BookStore bs;
	
	public void scenario1() {
		Book b0=new Book(0,3,'A');
		Book b1=new Book(0,2,'B');
		Book b2=new Book(0,1,'C');
		Book b3=new Book(0,3,'A');
		Book b4=new Book(0,4,'A');
	
		bs=new BookStore(10,3);
		
		bs.addBookToLibrary(1456, b1);
		bs.addBookToLibrary(156, b2);
		bs.addBookToLibrary(1457, b3);
		bs.addBookToLibrary(1458, b4);
	}
	
	public void scenario2() {
		Book b0=new Book(3,3,'A');
		Book b1=new Book(2,2,'B');
		Book b2=new Book(4,4,'C');
		Book b3=new Book(1,3,'A');
		Book b4=new Book(5,5,'A');
	
		bs=new BookStore(10,3);
		
		bs.addBookToLibrary(1451, b0);
		bs.addBookToLibrary(1456, b1);
		bs.addBookToLibrary(156, b2);
		bs.addBookToLibrary(1457, b3);
		bs.addBookToLibrary(1458, b4);
		
		String[] a={"156","54","1458","1451"};
		String[] b={"1456","1457","1458"};
		String[] c={"156","54","1451","1458"};
		String[] d={"156"};
		
		bs.registerClient(123,a);
		bs.registerClient(124,b);
		bs.registerClient(125,c);
		bs.registerClient(126,d);
	}
	
	@Test
	void takeBooksProcess() {
		scenario2();
		bs.takeBooksProcess();
		IvrQueue<Client> q=bs.getClients();
		
		assertTrue(q.peek().getId()==123&&q.peek().getTime()==4);
		assertFalse(q.peek().getCollectedBooks().empty());
	
		assertTrue(q.peek().getCollectedBooks().pop().getPrice()==4);
		assertTrue(q.peek().getCollectedBooks().pop().getPrice()==3);
		assertTrue(q.peek().getCollectedBooks().pop().getPrice()==5);
		assertTrue(q.peek().getCollectedBooks().empty());
		q.poll();
		assertTrue(q.peek().getId()==124&&q.peek().getTime()==5);
		q.poll();
		assertTrue(q.peek().getId()==126&&q.peek().getTime()==5);
		q.poll();
		assertTrue(q.peek().getId()==125&&q.peek().getTime()==6);
		q.poll();
		assertTrue(q.empty());
	}
	
	
	

	@Test
	void registerClientTest1() {
		scenario1();
		
		String[] a={"156","54","1458"};
		String[] b={"1456","1457","1458"};
		String[] c={"156","54","1458"};
		String[] d={"156","54","1458"};
		
		bs.registerClient(123,a);
		bs.registerClient(124,b);
		bs.registerClient(125,c);
		bs.registerClient(126,d);
		
		assertFalse(bs.getClients().empty());
		assertTrue(bs.getClients().peek().getId()==123&&bs.getClients().peek().getTime()==1&&bs.getClients().peek().getArrivalOrder()==1);
		bs.getClients().poll();
		assertTrue(bs.getClients().peek().getId()==124&&bs.getClients().peek().getTime()==2&&bs.getClients().peek().getArrivalOrder()==2);
		bs.getClients().poll();
		assertTrue(bs.getClients().peek().getId()==125&&bs.getClients().peek().getTime()==3&&bs.getClients().peek().getArrivalOrder()==3);
		bs.getClients().poll();
		assertTrue(bs.getClients().peek().getId()==126&&bs.getClients().peek().getTime()==4&&bs.getClients().peek().getArrivalOrder()==4);
		
	}
	
	@Test
	void sortClientsListTest() {
		scenario1();
		int[] a= {1458,45,156,2,1457,1456};
		int[] sort=bs.sortClientsList(a);
		int[] exp= {1458,1457,1456,156};
		for(int i=0;i<sort.length;i++) {
			//System.out.println(sort[i]);
			assertTrue(exp[i]==sort[i]);
		}
		
	}
	
	@Test
	void checKBookList() {
		scenario1();
		int[] a= {1458,45,156,2,1457};
		int[] exp= {1458,156,1457};
		int[] sort=bs.checkBookList(a);
		for(int i=0;i<sort.length-1;i++) {
			//System.out.println(sort[i]);
			assertTrue(exp[i]==sort[i]);
		}
		
		
		
	}

}
