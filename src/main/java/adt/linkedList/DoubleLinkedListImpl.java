package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> auxHead = this.last;
		
		if (auxHead == null) {
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, nil, nil);
			this.last = newHead;
			this.head = newHead;
		} else {
			while(!auxHead.previous.isNIL()) {
				auxHead = auxHead.previous;
			}
			
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, auxHead, nil);
			auxHead.previous = newHead;			
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.head = this.head.next;
			
			if(this.head.isNIL()) {
				this.last = new DoubleLinkedListNode<T>();;
			} else {
				DoubleLinkedListNode<T> aux = this.last;
				while(!aux.previous.previous.isNIL()) {
					aux = aux.previous;
				}
				aux.previous = new DoubleLinkedListNode<T>();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			this.last = this.last.previous;
			
			if(this.last.isNIL()) {
				this.head = new SingleLinkedListNode<T>();
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
