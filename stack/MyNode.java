package stack;
//Brooke Werner

//From Lab 6

//Part 1
public class MyNode<AnyType> {
	
	public AnyType data;
	public MyNode<AnyType> next;
	
	public MyNode(AnyType x, MyNode<AnyType> next){
		this.data = x;
		this.next = next;
	}

}
