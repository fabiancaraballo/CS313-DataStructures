public class Queue<E> {
	private Node<E> head;
	private Node<E> tail;
	
	public Queue(){
		
		// We want to initialize our Queue to be empty
		// (ie) set head and tail to be null
		head = null;
		tail = null;		
	}
	
	public void enqueue(E newData){
	
		// Create a new node whose data is newData and whose next node is null
		Node<E> newNode = new Node<E>(newData, null);

		// Update head and tail
		// Hint: Think about what's different for the first node added to the Queue
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);;
                	tail = newNode;
		}
		
	}
	
	public Node<E> dequeue(){
	
		// Return the head of the Queue
		// Update head
		// Hint: The order you implement the above 2 tasks matters, so use a temporary node
	 	//	     to hold important information
		// Hint: Return null on a empty Queue
		
		Node<E> oldHead;		

		if(head == null) {
			return null;
		}
		oldHead = head;
		head = head.getNext();
		return oldHead;
		
		
	}
	
	public boolean isEmpty(){
	
		// Check if the Queue is empty
		if(tail == null){
			return true;
		} else {
			return false;
		}

	
	}
	
	public void printQueue(){

		// Loop through your queue and print each Node's data
		Node<E> headNode = head;

		//This iterates through the Queue starting with the top node and going to the next node
                //until it hits a null which means it is has hit the last node
		while(headNode != null) {
			System.out.println(headNode.getData());
			headNode = headNode.getNext();
		
		}
				
	}
}
