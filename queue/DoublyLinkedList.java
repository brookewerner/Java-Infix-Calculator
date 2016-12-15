package queue;
//Brooke Werner

//from lab 7

//Part 2
public interface DoublyLinkedList<AnyType> {
	public void insertToEnd(AnyType x);
	public void insertToFront(AnyType x);
	public void delete(AnyType x);
	public boolean contains(AnyType x);
	public AnyType lookup(AnyType x);
	public boolean isEmpty();
	public void printList();
	public void printListRev();
}
