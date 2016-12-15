package stack;
//Brooke Werner

//From Lab 6

//Part 2
public interface SimpleLinkedList<AnyType> {
	public void insert(AnyType x);
	public void deleteItem(AnyType x);
	public boolean contains(AnyType x);
	public AnyType lookup(AnyType x);
	public boolean isEmpty();
	public void printList();
}
