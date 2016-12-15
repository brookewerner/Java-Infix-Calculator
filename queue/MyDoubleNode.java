package queue;
//Brooke Werner

//from lab 7

//Part 1
public class MyDoubleNode<AnyType> {
	public AnyType data;
	public MyDoubleNode<AnyType> next;
	public MyDoubleNode<AnyType> prev;
	
	public MyDoubleNode(AnyType x, MyDoubleNode<AnyType> prev, MyDoubleNode<AnyType> next){
		this.data = x;
		this.next = next;
		this.prev = prev;
	}
}
