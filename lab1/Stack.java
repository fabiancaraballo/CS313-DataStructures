public class Stack<E> {
	private Node<E> top;
	
	public Stack(){
	
		// We want to initialize our Stack to be empty
		// (ie) Set top as null
		top = null;
	}
	
	public void push(E newData){
	
		// We want to create a node whose data is newData and next node is top
		// Push this new node onto the stack
		// Update top
		
		Node<E> newNode = new Node<E>(newData, null);
		
		if(top == null) {
			top = newNode;
		} else {
			newNode.setNext(top);
			top = newNode;
		}

	}
	
	public Node<E> pop(){
	
		// Return the Node that currently represents the top of the stack
		// Update top
		// Hint: The order you implement the above 2 tasks matters, so use a temporary node
	 	//	     to hold important information
		// Hint: Return null on a empty stack
		
		Node<E> popNode;

		if(top != null){
			popNode = top;
                	top = top.getNext();
                	return popNode;
		} else {
			return top;
		}
		
	}
	
	public boolean isEmpty(){

		//Check if the Stack is empty
		if(top == null) {
			return true;
		} else {
			return false;
		}
			
	}
	
	
	public void printStack(){

		// Loop through your stack and print each Node's data

		Node<E> topNode = top;
		
		//This iterates through the Stack starting with the top node and going to the next node
		//until it hits a null which means it is has hit the last node
		while(topNode != null) {
			System.out.println(topNode.getData());
			topNode = topNode.getNext();
		}
		
	}
}
