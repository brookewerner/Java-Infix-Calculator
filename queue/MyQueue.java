package queue;
//Brooke Werner

//from lab 7

//part 2
public class MyQueue<AnyType> implements Queue<AnyType> {

	public MyDoublyLinkedList<AnyType> list;
	
	public MyQueue() {
		list = new MyDoublyLinkedList<AnyType>();
	}
	
	//part 3
	@Override
	public void enqueue(AnyType x) {
		list.insertToEnd(x);
	}
	
	//part 4
	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AnyType dequeue() {
		if (isEmpty()) {
			return null;
		} else {
			return list.deleteFromFront();
		}
	}

	//part 5
	@Override
	public AnyType peek() {
		return list.start.next.data;
	}

	
}
