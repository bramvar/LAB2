package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import vRstack.IvrStack;
import vRstack.VrStack;;

public class VrStackTest {
	
	private IvrStack<Integer> stack1;

	public void scenario1() {
		stack1=new VrStack<Integer>();
		stack1.push(4);
		stack1.push(200);
		stack1.push(-1);
		stack1.push(0);
		stack1.push(5);
		stack1.push(99);
		stack1.push(4);
		stack1.push(14);
		stack1.push(7);
		stack1.push(510);
		stack1.push(1);
	}
	
	@Test
	void test0() {
		scenario1();
		assertFalse(stack1.empty());
	}
	
	@Test
	void test1() {
		scenario1();
		assertTrue(stack1.pop()==1);
		assertTrue(stack1.pop()==510);
		assertTrue(stack1.pop()==7);
		assertTrue(stack1.pop()==14);
		assertTrue(stack1.pop()==4);
		assertTrue(stack1.pop()==99);
		assertTrue(stack1.pop()==5);
		assertTrue(stack1.pop()==0);
		assertTrue(stack1.pop()==-1);
		assertTrue(stack1.pop()==200);
		assertTrue(stack1.pop()==4);
		assertTrue(stack1.empty());
	}
	
	@Test
	void test2() {
		scenario1();
		assertTrue(stack1.peek()==1);
		stack1.pop();
		assertTrue(stack1.peek()==510);
		stack1.pop();
		stack1.pop();
		assertTrue(stack1.peek()==14);
		stack1.pop();
		stack1.pop();
		stack1.pop();
		assertTrue(stack1.peek()==5);
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		assertTrue(stack1.peek()==4);
		assertTrue(stack1.pop()==4);
		assertTrue(stack1.empty());
	}
	
	@Test
	void test3() {
		scenario1();
		assertFalse(stack1.empty());
		assertTrue(stack1.pop()==1);
		assertTrue(stack1.pop()==510);
		assertTrue(stack1.pop()==7);
		assertTrue(stack1.pop()==14);
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		assertTrue(stack1.peek()==4);
		stack1.pop();
		assertTrue(stack1.empty());
		stack1.push(0);
		stack1.push(64);
		stack1.push(201);
		stack1.pop();
		assertTrue(stack1.peek()==64);
		
	}

}
