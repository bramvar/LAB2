package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import vRqueue.IvrQueue;
import vRqueue.VrQueue;

public class VrQueueTest {
	
	private IvrQueue<Integer> queue1;
	//private IvrQueue<String> queue2;
	
	public void scenario1() {
		
		queue1=new VrQueue<Integer>();
		queue1.offer(1);
		queue1.offer(10);
		queue1.offer(5);
		queue1.offer(-3);
		queue1.offer(100);
		queue1.offer(11);
		queue1.offer(2);
		queue1.offer(0);
		queue1.offer(4);
	}
	
	@Test
	void test0() {
		scenario1();
		assertFalse(queue1.empty()); 
	}

	@Test
	void test1() {
		scenario1();
		assertTrue(queue1.poll()==1);
		assertTrue(queue1.poll()==10);
		assertTrue(queue1.poll()==5);
		assertTrue(queue1.poll()==-3);
		assertTrue(queue1.poll()==100);
		assertTrue(queue1.poll()==11);
		assertTrue(queue1.poll()==2);
		assertTrue(queue1.poll()==0);
		assertTrue(queue1.poll()==4);
		assertTrue(queue1.empty());
	}
	
	@Test
	void test2() {
		boolean t=true;
		scenario1();
		assertTrue(queue1.peek()==1);
		queue1.poll();
		assertTrue(queue1.peek()==10);
		queue1.poll();
		queue1.poll();
		assertTrue(queue1.peek()==-3);
		queue1.poll();
		queue1.poll();
		queue1.poll();
		assertTrue(queue1.peek()==2);
		queue1.poll();
		assertTrue(queue1.poll()==0);
		assertTrue(queue1.poll()==4);
		assertTrue(t);
	}

}
