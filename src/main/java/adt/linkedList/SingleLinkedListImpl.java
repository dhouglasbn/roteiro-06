package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> node = this.head;
		while (!node.isNIL()) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = this.getHead();
		while (!auxHead.isNIL() && auxHead.getData() != element) {
			auxHead = auxHead.getNext();
		}
		return auxHead.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxHead = this.head;
			if (this.head.isNIL()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, this.head);
				this.head = newHead;
			} else {
				while(!auxHead.getNext().isNIL()) {
					auxHead = auxHead.getNext();
				}
				
				SingleLinkedListNode<T> nil = new SingleLinkedListNode<T>();
				auxHead.setNext(new SingleLinkedListNode<T>(element, nil));
			}			
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (head.getData() == element) {
				this.head = this.head.getNext();
			} else {
				SingleLinkedListNode<T> aux = this.head;
				while (!aux.isNIL() && aux.getData() != element) {
					aux = aux.getNext();
				}
				
				if (!aux.isNIL()) {					
					aux.data = aux.next.getData();
					aux.next = aux.next.getNext();
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = this.head;
		
		for (int i = 0; i < this.size(); i++) {
			result[i] = aux.getData();
			aux = aux.getNext();			
		}
		
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return this.head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
