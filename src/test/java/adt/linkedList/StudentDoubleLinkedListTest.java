package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista5;
	private DoubleLinkedList<Integer> lista6;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista iterativa double com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);
		
		// Lista recursiva simples com 3 elementos
		lista3.insert(3);
		lista3.insert(2);
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new DoubleLinkedListImpl<Integer>();
		lista3 = new RecursiveSingleLinkedListImpl<Integer>();
		lista4 = new RecursiveSingleLinkedListImpl<Integer>();
		lista5 = new RecursiveDoubleLinkedListImpl<Integer>();
		lista6 = new RecursiveDoubleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(7);
		Assert.assertArrayEquals(new Integer[] { 7, 4, 3, 2, 1 }, lista1.toArray());
	}
	
	
	@Test
	public void testInsertFirstInEmptyList() {
		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).insertFirst(7);
		Assert.assertArrayEquals(new Integer[] { 7, 4 }, lista2.toArray());
	}
	
	@Test
	public void testInsertNullElement() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(null);
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(null);
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}
	
	@Test
	public void testInsertNullElementInEmptyList() {
		((DoubleLinkedList<Integer>) lista2).insertFirst(null);
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).insertFirst(null);
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
	}
	
	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista1.toArray());
	}
	
	@Test
	public void testRemoveFirstInEmptyList() {
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
	}
	
	@Test
	public void testRemoveFirstInSingleElementList() {
		((DoubleLinkedList<Integer>) lista2).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3 }, lista1.toArray());
	}
	
	@Test
	public void testRemoveLastInEmptyList() {
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
	}
	
	@Test
	public void testRemoveLastInSingleElementList() {
		((DoubleLinkedList<Integer>) lista2).insert(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista2.toArray());
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
	}
}