package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vRpriorityQueue.VrPriorityQueue;
import vRqueue.IvrQueue;

class VrPriorityQueueTest {
	
	private IvrQueue<Integer> q1;
	
	public void scenario1() {
		q1=new VrPriorityQueue<Integer>(15);
		
		q1.offer(5);
		q1.offer(3);
		q1.offer(10);
		q1.offer(1);
		q1.offer(8);
		q1.offer(9);
		q1.offer(3);
		q1.offer(15);
		q1.offer(0);
		q1.offer(6);
	}

	@Test
	void test0() {
		scenario1();
		assertFalse(q1.empty());
	}
	
	@Test
	void test1() {
		scenario1();
		assertTrue(q1.poll()==0);
		assertTrue(q1.poll()==1);
		assertTrue(q1.poll()==3);
		assertTrue(q1.poll()==3);
		q1.poll();
		assertTrue(q1.poll()==6);
		q1.poll();
		q1.poll();
		assertTrue(q1.poll()==10);
		assertTrue(q1.poll()==15);
		assertTrue(q1.empty());
	}
	
	@Test
	void test2() {
		scenario1();
		assertTrue(q1.peek()==0);
		q1.poll();
		assertTrue(q1.peek()==1);
		q1.poll();
		q1.poll();
		assertTrue(q1.peek()==3);
		q1.poll();
		q1.poll();
		q1.poll();
		assertTrue(q1.peek()==8);
		q1.poll();
		q1.poll();
		q1.poll();
		q1.poll();
		assertTrue(q1.empty());
		
		
	}

}
