package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		super();
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}
	
	@Override
	public int size() {
		int size = 0;
		DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) this.head;
		while (!node.isNIL()) {
			size++;
			node = (DoubleLinkedListNode<T>) node.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
		DoubleLinkedListNode<T> auxLast = this.last;
		while (auxHead.getData() != auxLast.getData() &&
				auxHead.getNext().getData() != auxLast.getData() &&
				auxHead.getData() != element &&
				auxLast.getData() != element) {
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
		}
		if (auxHead.getData() == element) {
			result = auxHead.getData();
		}
		if (auxLast.getData() == element) {
			result = auxLast.getData();
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, nil, this.last);
			this.last.next = newLast;
			if (this.last.isNIL()) {
				this.head = newLast;
			}
			this.last = newLast;
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (head.getData() == element) {
				this.head = (DoubleLinkedListNode<T>) this.head.getNext();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
				while (!aux.isNIL() && aux.getData() != element) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				
				if (!aux.isNIL()) {					
					DoubleLinkedListNode<T> next = (DoubleLinkedListNode<T>) aux.next;
					aux.previous.next = next;
					next.previous = aux.previous;
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T> ) this.head;
		
		for (int i = 0; i < this.size(); i++) {
			result[i] = aux.getData();
			aux = (DoubleLinkedListNode<T>) aux.getNext();			
		}
		
		return result;
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(
					element,
					auxHead,
					nil
					);
			auxHead.previous = newHead;
			if (this.head.isNIL()) {
				this.last = newHead;
			}
			this.head = newHead;
		}
	}

	@Override
	public void removeFirst() {
		if (!this.head.isNIL()) {
			this.head = (DoubleLinkedListNode<T>) this.head.next;
			if (this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			} else {
				DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
				auxHead.previous = new DoubleLinkedListNode<T>();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.last = this.last.previous;
			if (this.last.isNIL()) {
				this.head = this.last;
			} else {
				this.last.next = new DoubleLinkedListNode<T>();
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
