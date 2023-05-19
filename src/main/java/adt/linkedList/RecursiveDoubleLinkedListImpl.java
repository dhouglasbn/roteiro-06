package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		
	}
	
	public RecursiveDoubleLinkedListImpl(T data, RecursiveDoubleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		} else {
			return 1 + this.next.size();
		}
	}

	@Override
	public T search(T element) {
		if (this.isEmpty()) {
			return null;
		} else {
			if (this.data == element) {
				return this.data;
			} else {
				RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) this.next;
				return next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>();
				if (this.previous == null) {
					this.previous = new RecursiveDoubleLinkedListImpl<T>();
				}
			} else {
				this.next.insert(element);
			}			
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				if (this.data == element) {
					if (this.previous.isEmpty() && this.next.isEmpty()) {
						this.data = null;
						this.next = null;
						this.previous = null;
					} else {
						RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) this.next;
						this.data = next.data;
						this.next = next.next;
						if (this.next != null) {
							next = (RecursiveDoubleLinkedListImpl<T>) this.next;
							next.previous = this;
						}
					}
				} else {
					this.next.remove(element);
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] arrayLeft = toArrayLeft(this, 0);
		RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) this.next;
		T[] arrayRight = toArrayRight(next, 0);		
		return this.joinArrays(arrayLeft, arrayRight);
		
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.data = element;
				this.previous = new RecursiveDoubleLinkedListImpl<T>();
				this.previous.next = this;
				if (this.next == null) {
					this.next = new RecursiveDoubleLinkedListImpl<T>();
				}
			} else {
				this.previous.insertFirst(element);
			}			
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.previous.isEmpty()) {
				if (this.previous.isEmpty() && this.next.isEmpty()) {
					this.data = null;
					this.next = null;
					this.previous = null;
				} else {
					RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) this.next;
					this.data = next.data;
					this.next = next.next;
					if (this.next != null) {
						next = (RecursiveDoubleLinkedListImpl<T>) this.next;
						next.previous = this;
					}
				}
			} else {
				this.previous.removeFirst();
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.next.isEmpty()) {
				if (this.previous.isEmpty() && this.next.isEmpty()) {
					this.data = null;
					this.next = null;
					this.previous = null;
				} else {
					RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) this.next;
					this.data = next.data;
					this.next = next.next;
					if (this.next != null) {
						next = (RecursiveDoubleLinkedListImpl<T>) this.next;
						next.previous = this;
					}
				}
			} else {
				RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) this.next;
				next.removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
	
	private T[] toArrayRight(RecursiveDoubleLinkedListImpl<T> currentNode, int index) {
        if (currentNode == null || currentNode.isEmpty()) {
            return (T[]) new Object[index];
        }

        RecursiveDoubleLinkedListImpl<T> next = (RecursiveDoubleLinkedListImpl<T>) currentNode.getNext();
        T[] array = toArrayRight(next, index + 1);
        array[index] = currentNode.getData();
        return array;
    }
	
	private T[] toArrayLeft(RecursiveDoubleLinkedListImpl<T> currentNode, int index) {
        if (currentNode == null || currentNode.isEmpty()) {
            return (T[]) new Object[index * (-1)];
        }

        RecursiveDoubleLinkedListImpl<T> previous = currentNode.getPrevious();
        T[] array = toArrayLeft(previous, index - 1);
        array[array.length + index - 1] = currentNode.getData();
        return array;
    }
	
	private T[] joinArrays(T[] arr1, T[] arr2) {
		T[] result = (T[]) new Object[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		
		while (i < arr1.length) {
			result[i] = arr1[i];
			i++;
		}
		
		while (j < arr2.length) {
			result[i] = arr2[j];
			i++;
			j++;
		}
		
		return result;
	}
}
