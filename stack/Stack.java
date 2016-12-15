package stack;
//Brooke Werner

//From lab 6

//Part 1
public interface Stack<AnyType> {
	public boolean isEmpty();
	public void push(AnyType x);
	public AnyType pop();
	public AnyType peek();
}
