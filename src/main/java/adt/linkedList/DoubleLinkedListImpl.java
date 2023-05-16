package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> nil = new DoubleLinkedListNode<T>();
		DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.head;
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(element, head, nil);
		head.previous = newHead;
		if (head.isNIL()) {
			this.last = newHead;
		}
		this.head = newHead;
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.head = this.head.next;
			
			DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.head;
			
			if(head.isNIL()) {
				this.last = head;
			} else {
				head.previous = new DoubleLinkedListNode<T>();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			this.last = this.last.previous;
			
			if(this.last.isNIL()) {
				this.head = last;
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
