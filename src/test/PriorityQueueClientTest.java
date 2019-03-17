package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Client;
import vRpriorityQueue.VrPriorityQueue;
import vRqueue.IvrQueue;

class PriorityQueueClientTest {
	
	private IvrQueue<Client> pq1;
	
	public void scenario1() {
		pq1=new VrPriorityQueue<Client>(15);
		pq1.offer(new Client(15165,null,6,1));
		pq1.offer(new Client(15165,null,4,2));
		pq1.offer(new Client(15165,null,15,3));
		pq1.offer(new Client(15165,null,1,4));
		pq1.offer(new Client(15165,null,8,5));
		pq1.offer(new Client(15165,null,2,6));
		pq1.offer(new Client(15165,null,0,7));
		pq1.offer(new Client(15165,null,9,8));
		pq1.offer(new Client(15165,null,3,9));	
	}
	
	public void scenario2(){
		pq1=new VrPriorityQueue<Client>(15);
		pq1.offer(new Client(123,null,6,1));
		pq1.offer(new Client(145,null,6,2));
		pq1.offer(new Client(178,null,15,3));
		pq1.offer(new Client(199,null,1,4));
		pq1.offer(new Client(200,null,1,5));
		pq1.offer(new Client(201,null,8,6));
		pq1.offer(new Client(202,null,8,7));
	}

	@Test
	void test0() {
		scenario1();
		assertFalse(pq1.empty());
	}
	
	@Test 
	void test1() {
		scenario1();
		assertTrue(pq1.poll().getTime()==0);
		assertTrue(pq1.poll().getTime()==1);
		assertTrue(pq1.poll().getTime()==2);
		assertTrue(pq1.poll().getTime()==3);
		assertTrue(pq1.poll().getTime()==4);
		assertTrue(pq1.poll().getTime()==6);
		assertTrue(pq1.poll().getTime()==8);
		assertTrue(pq1.poll().getTime()==9);
		assertTrue(pq1.poll().getTime()==15);
		assertTrue(pq1.empty());
	}

	@Test
	void test2() {
		scenario2();
		assertTrue(pq1.peek().getTime()==1&&pq1.peek().getId()==199);
		pq1.poll();
		assertTrue(pq1.poll().getId()==200);
		assertTrue(pq1.peek().getTime()==6&&pq1.peek().getId()==123);
		pq1.poll();
		assertTrue(pq1.poll().getId()==145);
	}
}
