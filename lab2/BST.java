public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public BST(){
        root = null;
    }
    

    // down and slow, focus
    public Node<E> getRoot(){
        return root;
    }

    public void insert(E data){
	
	//Used geeksforgeeks as a reference


        // Find the right spot in the tree for the new node
        // Make sure to check if anything is in the tree
        // Hint: if a node n is null, calling n.getData() will cause an error

	root = insert_rec(getRoot(), data);
    }


    private Node<E> insert_rec(Node<E> root, E data) {

	//Used geeksforgeeks as a reference


	if(root == null) {
		Node<E> newNode = new Node<E>(data);
		root = newNode;
		return root;
	}	

	//int tempNode = null;
	if(root.getData().compareTo(data) > 0) {
		root.setLeftChild(insert_rec(root.getLeftChild(), data));
	} else if(root.getData().compareTo(data) < 0) {
		root.setRightChild(insert_rec(root.getRightChild(), data));
	}

	return root;
    }
    public Node<E> find(E data){
 	

        // Search the tree for a node whose data field is equal to data
	Node<E> tempNode = root;
	while((tempNode != null) && (tempNode.getData() != data)){ 
		if(tempNode.getData().compareTo(data) < 0) {
			tempNode = tempNode.getRightChild();
		}
		else {
			tempNode = tempNode.getLeftChild();
		} 
	}
	
	return tempNode;
    }

    public void delete(E data){
	
	//Used geeksforgeeks as a reference

	root = recursive_delete(getRoot(), data);
    }
	
    private Node<E> recursive_delete(Node<E> root, E newData) {
		
	//Used geeksforgeeks as a reference
		
	if(root == null) {
		return root;
	}
	

	if(newData.compareTo(root.getData()) < 0) {
		root.setLeftChild(recursive_delete(root.getLeftChild(), newData));
	} else if (newData.compareTo(root.getData()) > 0) {
		root.setRightChild(recursive_delete(root.getRightChild(), newData));
	}
	else {
		if(root.getLeftChild() == null) {
			return root.getRightChild();
		}
		else if(root.getRightChild() == null) {
			return root.getLeftChild();
		}
		
		Node<E> minRightRoot = getMin(root.getRightChild());
		root.setData(minRightRoot.getData());

		root.setRightChild(recursive_delete(root.getRightChild(), root.getData()));
	}

	return root;	
	
    }

    public void traverse(String order, Node<E> top) {
        if (top != null){
            switch (order) {
                case "preorder":
                    // Your Code here
		    System.out.print(top.getData());
		    System.out.print(" ");
		    traverse(order, top.getLeftChild());
		    traverse(order, top.getRightChild());
                    break;
                case "inorder":
                    // Your Code here
		    traverse(order, top.getLeftChild());
		    System.out.print(top.getData());
		    System.out.print(" ");
		    traverse(order, top.getRightChild());
                    break;
                case "postorder":
                    // Your Code here
		    traverse(order, top.getLeftChild());
		    traverse(order, top.getRightChild());
		    System.out.print(top.getData());
		    System.out.print(" ");
                    break;
            }
        }
    }

    public Node<E> getMin(Node<E> top){
	//Used geeksforgeeks as a reference 
	
        // Return the min node
	
	if(top == null) {
		return null;
	}
	
	if(top.getLeftChild() == null) {
		return top;
	} 
	
	return getMin(top.getLeftChild());
    }

    public boolean identicalTrees(Node<E> node1, Node<E> node2) {
	
	//Used geeksforgeeks as a reference	


	//if both are empty
	if(node1 == null && node2 == null) {
		return true;
	}

	//if both nodes are not empyty then we compare them
	if(node1 != null && node2 != null) {
		return (node1.getData() == node2.getData() 
                    && identicalTrees(node1.getLeftChild(), node2.getLeftChild()) 
                    && identicalTrees(node1.getRightChild(), node2.getRightChild()));

	}

	//if one is empty and the other isn't 
	return false;
    }

}
