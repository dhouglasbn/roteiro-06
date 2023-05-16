package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new SingleLinkedListImpl<Integer>();
		lista2 = new SingleLinkedListImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}
	
	@Test
	public void testIsEmptyRemoving() {
		lista1.remove(3);
		lista1.remove(2);
		lista1.remove(1);
		
		Assert.assertTrue(lista1.isEmpty());
	}
	
	@Test
	public void testOneElementIsntEmpty() {
		lista1.remove(3);
		lista1.remove(2);
		
		Assert.assertFalse(lista1.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}
	
	@Test
	public void testSizeAfterRemoving() {
		lista1.remove(3);
		lista1.remove(2);
		Assert.assertEquals(1, lista1.size());
	}
	
	@Test
	public void testSizeAfterInserting() {
		lista2.insert(1);
		lista2.insert(2);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testSearch() {
		Integer expected1 = 2;
		Integer expected2 = 3;
		Assert.assertEquals(expected1, lista1.search(2));
		Assert.assertEquals(expected2, lista1.search(3));
	}
	
	@Test
	public void testSearchInexistentElement() {
		Assert.assertNull(lista1.search(4));		
	}
	
	@Test
	public void testSearchAtNullList() {
		Assert.assertNull(lista2.search(2));
	}
	
	@Test
	public void testSearchNull() {
		Assert.assertNull(lista1.search(null));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}
	
	@Test
	public void testInsertFirstElement() {
		Integer expected = 10;
		Assert.assertTrue(lista2.size() == 0);
		
		lista2.insert(10);
		
		Assert.assertEquals(expected, lista2.search(10));
		Assert.assertTrue(lista2.size() == 1);
	}
	
	@Test
	public void testInsertNullElement() {
		int expected1 = 3;
		int expected2 = 0;
		
		Assert.assertEquals(expected1, lista1.size());
		lista1.insert(null);
		lista1.insert(null);
		Assert.assertEquals(expected1, lista1.size());

		Assert.assertEquals(expected2, lista2.size());
		lista2.insert(null);
		lista2.insert(null);
		Assert.assertEquals(expected2, lista2.size());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}
	
	@Test
	public void testRemoveNullElement() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(null);
		lista1.remove(null);
		Assert.assertEquals(3, lista1.size());

	}
	
	@Test
	public void testRemoveHead() {
		lista2.insert(5);
		lista2.insert(10);
		
		
		Assert.assertEquals(2, lista2.size());
		lista2.remove(5);
		Assert.assertEquals(1, lista2.size());
		lista2.remove(10);
		Assert.assertEquals(0, lista2.size());
	}
	
	@Test
	public void testRemoveInexistentElement() {
		int expected = 3;
		Assert.assertEquals(expected, lista1.size());
		lista2.remove(5);
		Assert.assertEquals(expected, lista1.size());
		lista2.remove(10);
		Assert.assertEquals(expected, lista1.size());
	}

	@Test
	public void testToArray() {
		Integer[] expected = {3, 2, 1};
		
		Assert.assertArrayEquals(expected, lista1.toArray());
	}
	
	@Test
	public void testEmptyToArray() {
		Integer[] expected = new Integer[0];
		Assert.assertArrayEquals(expected, lista2.toArray());		
	}
	
	@Test
	public void testToArray10Elements() {
		Integer[] expected = {3, 2, 1, 4, 6, 5, 9, 7, 8, 10};
		
		lista1.insert(4);
		lista1.insert(6);
		lista1.insert(5);
		lista1.insert(9);
		lista1.insert(7);
		lista1.insert(8);
		lista1.insert(10);
		
		Assert.assertArrayEquals(expected, lista1.toArray());
	}
	
	@Test
	public void testOneElementRemovingToArray() {
		Integer[] expected = {3};
		
		lista1.remove(2);
		lista1.remove(1);
		
		Assert.assertArrayEquals(expected, lista1.toArray());
	}
	
	@Test
	public void testOneElementInsertingToArray() {
		Integer[] expected = {10};
		
		lista2.insert(10);
		
		Assert.assertArrayEquals(expected, lista2.toArray());
	}
}