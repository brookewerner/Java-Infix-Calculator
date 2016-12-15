package stack;
//Brooke Werner

//from Lab 6

//Part 2
public class MyStack<AnyType> implements Stack<AnyType> {

	protected MyList<AnyType> list;
	
	public MyStack() {
		list = new MyList<AnyType>();
	}
	
	//Part 3
	@Override
	public void push(AnyType x) {
		list.insert(x);
	}
	
	//Part 4
	@Override
	public AnyType pop() {
		if (isEmpty())
		{
			return null;
		} else {
			return list.deleteLastIn();
		}
	}

	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	//Part 5
	@Override
	public AnyType peek() {
		return list.startOfList.next.data;
	}

	
}
