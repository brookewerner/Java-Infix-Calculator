package stack;
//Brooke Werner

//from Lab 6

//Part 3
public class MyList<AnyType> implements SimpleLinkedList<AnyType>{

	public MyNode<AnyType> startOfList;
	public MyNode<AnyType> node;
	
	public MyList() {
		startOfList = new MyNode<AnyType>(null, null);
	}

	@Override
	public boolean isEmpty() {
		if(startOfList.next == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//modified for lab 6
	@Override
	public void insert(AnyType x) {		
		if(node != null) {
			MyNode<AnyType> newNode = new MyNode<AnyType>(x, node);
			
			startOfList.next = newNode;
			node = newNode;
		} else if(node == null){
			startOfList.next = new MyNode<AnyType>(x, null);
			node = startOfList.next;
		}
//		if(node != null) {
//			MyNode<AnyType> newNode = new MyNode<AnyType>(x, node.next);
//			
//			node.next = newNode;
//			node = newNode;
//		} else if(node == null){
//			startOfList = new MyNode<AnyType>(x, null);
//			node = startOfList;
//		}
		//Expected runtime of this method: O(1)
	}

	//Part 4
	//prints the items in a way such that the first item in the list is at the bottom
	//and the most recent item is on top, portraying an actual stack of items where
	//only the one at the top can be taken off
	public void printStack() {
		if (!isEmpty()) {
			MyNode<AnyType> temp = startOfList.next;
			
			while (temp.next != null) {
				System.out.println(temp.data.toString());
				temp = temp.next;
			}
			System.out.println(temp.data.toString());
		}
		//Expected runtime: O(n)
	}
	
	@Override
	public void printList() {
		if (!isEmpty()) {
			MyNode<AnyType> temp = startOfList.next;
			
			String stackInOrder = "";
			
			while (temp.next != null) {
				stackInOrder = "\n" + temp.data.toString() + stackInOrder;
				
				temp = temp.next;
			}
			
			stackInOrder = temp.data.toString() + stackInOrder;
			
			System.out.println(stackInOrder);
		}
	}
	
	//Part 5
	@Override
	public boolean contains(AnyType x) {
	
		MyNode<AnyType> temp = startOfList.next;

		while(temp != null) {
			if (temp.data.equals(x)) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}
	
	//Part 6
	@Override
	public AnyType lookup(AnyType x) {
		if(contains(x)) {
			return x;
		} else {
			return null;
		}
	}
	
	//Part 7
	@Override
	public void deleteItem(AnyType x) {
		if (contains(x)) {
			MyNode<AnyType> temp = startOfList.next;
			
			while (temp.next != null) {
				
				if(temp == startOfList.next && temp.data.equals(x)) {
					
					while(temp.next != null) {
						temp.data = temp.next.data;
						
						temp = temp.next;
					}
					
					deleteItem(temp.data);
					break;
					
				} 
				
				if(temp.next.data.equals(x)) {
					
					temp.next = temp.next.next;
						
					break;
				}
				
				temp = temp.next;
			}
		}
	}


	//Revision for Lab 6 with constant run time
	public AnyType deleteLastIn() {
		MyNode<AnyType> temp = startOfList.next;
		
		startOfList.next = startOfList.next.next;
		node = startOfList.next;
		
		return temp.data;
	}

}
