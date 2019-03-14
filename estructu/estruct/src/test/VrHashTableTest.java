package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import vRhashTable.ElementHash;
import vRhashTable.IvrHashTable;
import vRhashTable.VrHashTable;

class VrHashTableTest {
	
	private IvrHashTable<Integer> hash1;
	
	public void scenario1() {
		hash1=new VrHashTable<Integer>(15);
		hash1.push(122, 5);
		hash1.push(12, 3);
		hash1.push(542, 1);
		hash1.push(788, 2);
		hash1.push(321, 4);
		hash1.push(254, 6);
		hash1.push(311, 7);
		hash1.push(451, 8);
		hash1.push(39, 9);
		
	}

	@Test
	void test0() {
		scenario1();
		assertTrue(hash1.search(542)==1);
		assertTrue(hash1.getElementHash(2).getElement()==5);
		assertTrue(hash1.getElementHash(2).getNextElement().getElement()==1);
		hash1.delete(122);
		assertTrue(hash1.getElementHash(2).getElement()==1);
		hash1.delete(542);
		assertTrue(hash1.getElementHash(2)==null);
		//assertTrue(hash1.search(122)==5);
		hash1.delete(311);
		assertTrue(hash1.search(311)==null);
	}
	
	
	void test1() {
		
	}

}
