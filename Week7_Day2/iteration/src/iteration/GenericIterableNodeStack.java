package iteration;

import java.util.Iterator;

/*
 * This is a modified version of our GenericNodeStack example we reviewed previously. 
 */
public class GenericIterableNodeStack<T> implements Iterable<GenericNode<T>> {
	private GenericNode<T> top;

	public void push(T element) {
		GenericNode<T> node = new GenericNode<T>(element);
		push(node);
	}

	public void push(GenericNode<T> node) {
		node.setNext(top);
		this.top = (node);
	}

	public GenericNode<T> pop() {
		GenericNode<T> poppedNode = top;
		top = top.getNext();
		poppedNode.setNext(null);
		return poppedNode;
	}

	public GenericNode<T> peek() {
		return top;
	}

	// The 'Iterator' method should return an object which can be used to iterate through a collection
	@Override
	public Iterator<GenericNode<T>> iterator() {
		return new NodeStackIterator();
	}

	// We are defining a private 'NodeStackIterator' here for simplicity & organization
	private class NodeStackIterator implements Iterator<GenericNode<T>> {
		private GenericNode<T> cursor;
		
		NodeStackIterator() {
			cursor = top;
		}

		// 'hasNext()' logic should determine if there is more data in the collection...
		@Override
		public boolean hasNext() {
			if (cursor != null)
				return true;

			return false;
		}

		// 'next()' logic should return the current object and move our cursor to the next item
		@Override
		public GenericNode<T> next() {
			GenericNode<T> ret = cursor;
			if (cursor != null)
				cursor = ret.getNext();

			return ret;
		}
	}
}

// This is the 'GenericNode' class we reviewed previously
class GenericNode<T> {
	private T data;
	private GenericNode<T> next;

	public GenericNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public GenericNode<T> getNext() {
		return next;
	}

	public void setNext(GenericNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}
