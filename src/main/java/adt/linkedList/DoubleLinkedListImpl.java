package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		super();
		this.head = new DoubleLinkedListNode<T>();
		
		this.last = (DoubleLinkedListNode<T>)this.head;
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
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
		while (!auxHead.isNIL() && auxHead.getData() != element) {
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
		}
		return auxHead.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
			if (this.head.isNIL()) {
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
				DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, nil, nil);
				this.head = newHead;
			} else {
				while(!auxHead.getNext().isNIL()) {
					auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				}
				
				DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
				auxHead.setNext(new DoubleLinkedListNode<T>(element, auxHead, nil));
			}			
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (head.getData() == element) {
				this.head = this.head.getNext();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
				while (!aux.isNIL() && aux.getData() != element) {
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
				
				if (!aux.isNIL()) {					
					DoubleLinkedListNode<T> next = (DoubleLinkedListNode<T>) aux.getNext();
					aux.data = aux.next.getData();
					aux.next = next;
					next.previous = aux.previous;
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
		
		for (int i = 0; i < this.size(); i++) {
			result[i] = aux.getData();
			aux = (DoubleLinkedListNode<T>) aux.getNext();			
		}
		
		return result;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, auxHead, nil);
		auxHead.previous = newHead;
		
		if (this.head.isNIL()) {
			this.last = newHead;
		}
		auxHead = newHead;
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.head = this.head.next;
			
			if(this.head.isNIL()) {
				this.last = new DoubleLinkedListNode<T>();
			} else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
				aux.previous = new DoubleLinkedListNode<T>();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			this.last = this.last.previous;
			
			if(this.last.isNIL()) {
				this.head = new DoubleLinkedListNode<T>();
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
