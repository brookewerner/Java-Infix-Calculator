package queue;
//Brooke Werner

//from lab 7

//Part 3
public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {
	protected MyDoubleNode<AnyType> start;
	protected MyDoubleNode<AnyType> end;
	protected MyDoubleNode<AnyType> doubleNode;
	
	public MyDoublyLinkedList() {
		start = new MyDoubleNode<AnyType>(null, null, null);
		end = new MyDoubleNode<AnyType>(null, start, null);
		start.next = end;
	}
	
	//Part 3 - modified
	@Override
	public void insertToEnd(AnyType x) {
		if (isEmpty()) {
			MyDoubleNode<AnyType> temp = new MyDoubleNode<AnyType>(x, start, end);
			
			doubleNode = temp;
			
			start.next = doubleNode;
			end.prev = doubleNode;
		} else {
			MyDoubleNode<AnyType> temp = new MyDoubleNode<AnyType>(x, end.prev, end);
		
			end.prev.next = temp;
			end.prev = temp;
		}
		
	}
	
	@Override
	public void insertToFront(AnyType x) {
		if (isEmpty()) {
			MyDoubleNode<AnyType> temp = new MyDoubleNode<AnyType>(x, start, end);
			
			doubleNode = temp;
			
			start.next = doubleNode;
			end.prev = doubleNode;
		} else {
			start.next.next = start.next;
			
			MyDoubleNode<AnyType> temp = new MyDoubleNode<AnyType>(x, start, start.next);
		
			start.next.prev = temp;
			start.next = temp;
		}
		
	}
	
	@Override
	public boolean isEmpty() {
		if (start.next == end && end.prev == start) {
			 return true;
		}
		return false;
	}
	
	//Part 4
	@Override
	public void printList() {
		MyDoubleNode<AnyType> temp = start;
		
		while (temp.next.data != null) {
			System.out.println(temp.next.data);
			temp = temp.next;
		}
		
		//expected runtime: O(n)
	}
	
	@Override
	public void printListRev() {
		MyDoubleNode<AnyType> temp = end;
		
		while (temp.prev.data != null) {
			System.out.println(temp.prev.data);
			temp = temp.prev;
		}
	}
	
	//Part 5
	@Override
	public boolean contains(AnyType x) {
		if (isEmpty()) {
			return false;
		} else {
			MyDoubleNode<AnyType> temp = start;
			
			while (temp.next.data != null) {
				if (temp.next.data.equals(x)) {
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}
	
	//Part 6
	@Override
	public AnyType lookup(AnyType x) {
		if (contains(x)) {
			return x;
		} else {
			return null;
		}
	}
	
	//Part 7
	@Override
	public void delete(AnyType x) {
		if (contains(x)) {
			MyDoubleNode<AnyType> temp = start;
			
			while (temp.next.data != null) {
				if (temp.next.data.equals(x)) {
					temp.next.next.prev = temp;
					
					temp.next = temp.next.next;
					
					break;
				}
				
				temp = temp.next;
			}
		}	
	}
	
	//added for lab 7 - constant runtime
	public AnyType deleteFromFront() {
		MyDoubleNode<AnyType> temp = start.next;
		
		start.next.next.prev = start;
		start.next = start.next.next;
		
		return temp.data;
	}
	
	public AnyType deleteFromEnd() {
		MyDoubleNode<AnyType> temp = end.prev;
		
		end.prev.prev.next = end;
		end.prev = end.prev.prev;
		
		return temp.data;
	}
	
	
}