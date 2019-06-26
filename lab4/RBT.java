@SuppressWarnings("unchecked")
public class RBT<E extends Comparable<E>> {
    private Node<E> root;
    private Node<E> sentinel;

    public RBT(){
	//the book refers to T.nil as a sentinel so I am going to carry out my RB tree the same way
        sentinel = new Node<E>(null);
	sentinel.setColor('B'); //Sets the first node as a Black node
	root = sentinel; //Sets sentinel as the root
	
    }

    public Node<E> getRoot(){
        return root;
    }

	//Psuedo-code used from the book
    public void insert(E data){
    	// Preform a regular insert
        // Check to make sure the tree remains an RBT tree
	Node<E> z = new Node<E>(data); //In the book, data is defined as a Node called z so I decided to do the same
	Node<E> y = sentinel; //In the book, y is assigned to the sentinel
	Node<E> x = root; //Node x is assigned to the root
	while (x != sentinel) { //The first instance of null is replaced by the sentinel
		y = x;
		if (z.getData().compareTo(x.getData()) < 0) {
			x = x.getLeftChild();
		} else {
			x = x.getRightChild();
		}
	}
	z.setParent(y);
	if (y == sentinel) {
		root = z;
	} else {
		if (z.getData().compareTo(y.getData()) < 0) {
			y.setLeftChild(z);
		} else {
			y.setRightChild(z);
		}
	}

	//This is used to maintain the proper tree structure and RB properties
	z.setLeftChild(sentinel); //Set z.left is set to the sentinel
	z.setRightChild(sentinel); //Set z.right is set to the sentinel 
	z.setColor('R');

	//Going to change z's positioning in the tree with this function, fixInsert()
	fixInsert(z);
    }

    public Node<E> search(E data){
        // Return the node that corresponds with the given data
        // Note: No need to worry about duplicate values added to the tree
	Node<E> tempNode = root; //becomes the root
	while (tempNode != sentinel) {
		if (tempNode.getData().compareTo(data) == 0) {
			return tempNode;
		} else if (tempNode.getData().compareTo(data) > 0) {
			tempNode = tempNode.getLeftChild();
		} else if (tempNode.getData().compareTo(data) < 0) {
			tempNode = tempNode.getRightChild();
		}
	}
	return null;
    }

	//Psuedo-code used from the book
    public void delete(E data){
    	// Preform a regular delete
    	// Check to make sure the tree remains an RBT tree
	Node<E> z = search(data);
	Node<E> x = sentinel;
	Node<E> y = z;
	Character y_original_color = y.getColor();
	if (z.getLeftChild() == sentinel) {
		x = z.getRightChild();
		transplant(z, z.getRightChild());
	} else if (z.getRightChild() == sentinel) {
		x = z.getLeftChild();
		transplant(z, z.getLeftChild());
	} else {
		y = getMin(z.getRightChild());
		y_original_color = y.getColor();
		x = y.getRightChild();
		if (y.getParent() == z) {
			x.setParent(y);
		} else {
			transplant(y, y.getRightChild());
			y.setRightChild(z.getRightChild());
			y.getRightChild().setParent(y);
		}
		
		transplant(z, y);
		y.setLeftChild(z.getLeftChild());
		y.getLeftChild().setParent(y);
		y.setColor(z.getColor());
	}
	
	if (y_original_color == 'B') {
		fixDelete(x);
	}
		
    
   }
 
   //This function was used in the book and it switches out the subtrees of u and v
   public void transplant(Node<E> u, Node<E> v) {
	   //compares the u.getParent() and the sentinel 
   		if (u.getParent() == sentinel) {
			root = v;
		} else if (u == u.getParent().getLeftChild()) {
			u.getParent().setLeftChild(v);
		} else {
			u.getParent().setRightChild(v);
		}
		if (v != null) {
			v.setParent(u.getParent());
		}


   }

   //Taken from lab3
   public void traverse(String order, Node<E> top) {
        // Preform a preorder traversal of the tree
	if(order == "preorder") {
		if(top != null && top.getData() != null) {
			System.out.print(top.getData().toString() + " ");
			traverse("preorder",top.getLeftChild());
			traverse("preorder",top.getRightChild());
			}
			
		}

    }

	//Psuedo-code used from the book
    public void rightRotate(Node<E> y){
    	
        /*
        If y is the root of the tree to rotate with right child subtree T3 and left child x, 
        where T1 and T2 are the left and right children of x:
            y becomes right child of x and T1 as its left child of x
            T2 becomes left child of y and T3 becomes right child of y
        */
    	Node<E> x = y.getLeftChild(); //set x 
		y.setLeftChild(x.getRightChild()); //turn x's right subtree into y's left subtree
		x.getRightChild().setParent(y);
		x.setParent(y.getParent()); ////link y's parent to x
		if (y.getParent() == sentinel || y.getParent() == null) {
			root = x;
		} else if (y == y.getParent().getLeftChild()) { 
			y.getParent().setLeftChild(x);
		} else {
			y.getParent().setRightChild(x);
		}
		x.setRightChild(y); //put x on y's left
		y.setParent(x);
    }

	//Psuedo-code used from the book
    public void leftRotate(Node<E> x){
    
    	/*
        If x is the root of the tree to rotate with left child subtree T1 and right child y, 
        where T2 and T3 are the left and right children of y:
            x becomes left child of y and T3 as its right child of y
            T1 becomes left child of x and T2 becomes right child of x
        */
		Node<E> y = x.getRightChild(); //set y
		x.setRightChild(y.getLeftChild()); //turn y's subtree into x's right subtree
		y.getLeftChild().setParent(x);
		y.setParent(x.getParent());
		if (x.getParent() == sentinel || x.getParent() == null) {
			root = y;
		} else if (x == x.getParent().getLeftChild()) { //link x's parent to y
			x.getParent().setLeftChild(y);
		} else {
			x.getParent().setRightChild(y);
		}
		y.setLeftChild(x); //put x on y's left
		x.setParent(y);
	
    }

	// HINT: You may want to create extra methods such as fixDelete or fixInsert
	
	//Psuedo-code used from the book
    public void fixDelete(Node<E> x) {
   		while (x != root && x.getColor() == 'B') {

			if (x == x.getParent().getLeftChild()) {
				Node<E> tempNode = x.getParent().getRightChild();
				if (tempNode.getColor() == 'R') {
					// case 1
					tempNode.setColor('B');
					x.getParent().setColor('R');
					leftRotate(x.getParent());
					tempNode = x.getParent().getRightChild();
				}

				if (tempNode.getLeftChild().getColor() == 'B' && tempNode.getRightChild().getColor() == 'B') {
					// case 2
					tempNode.setColor('R');
					x = x.getParent();
				} else {
					if (tempNode.getRightChild().getColor() == 'B') {
						// case 3
						tempNode.getLeftChild().setColor('B');
						tempNode.setColor('R');
						rightRotate(tempNode);
						tempNode = x.getParent().getRightChild();

					}
					// case 4
					tempNode.setColor(x.getParent().getColor());
					x.getParent().setColor('B');
					tempNode.getRightChild().setColor('B');
					leftRotate(x.getParent());
					x = root;
				}
			} else {
				Node<E> tempNode = x.getParent().getLeftChild();

				if (tempNode.getColor() == 'R') {
					tempNode.setColor('B');
					x.getParent().setColor('R');
					rightRotate(x.getParent());
					tempNode = x.getParent().getLeftChild();
				}
				if (tempNode.getRightChild().getColor() == 'B' && (tempNode.getLeftChild().getColor() == 'B')) {
					tempNode.setColor('R');
					x = x.getParent();
				} else {
					if (!(tempNode.getLeftChild().getColor() == 'B')) {
						tempNode.getRightChild().setColor('B');
						tempNode.setColor('R');
						leftRotate(tempNode);
						tempNode = x.getParent().getLeftChild();
					}

					tempNode.setColor(x.getParent().getColor());
					x.getParent().setColor('B');
					tempNode.getLeftChild().setColor('B');
					rightRotate(x.getParent());
					x = root;
				}
			}
		}
		x.setColor('B');
    }


	//Psuedo-code used from the book
    public void fixInsert(Node<E> z) {
		while (z.getParent().getColor() == 'R') {
			if (z.getParent() == z.getParent().getParent().getLeftChild()) {
				Node<E> y = z.getParent().getParent().getRightChild();
				//case 1 if z.p is the root, then z.p is black
				if (y.getColor() == 'R') {
					z.getParent().setColor('B');
					y.setColor('B');
					z.getParent().getParent().setColor('R');
					z = z.getParent().getParent();
				} else {
					//case 2. z’s uncle y is black and z is a right child
					if (z == z.getParent().getRightChild()) {
						z = z.getParent();
						leftRotate(z);
					}
					//case 3. z’s uncle y is black and z is a left child
					z.getParent().setColor('B');
					z.getParent().getParent().setColor('R');
					rightRotate(z.getParent().getParent());
				}
			} else {
				//This does the same thing as the code above in the if statement
				//However, there we switch the "left" and "right" from the if statement
				Node<E> y = z.getParent().getParent().getLeftChild();
				//case 1 if z.p is the root, then z.p is black
				if (y.getColor() == 'R') {
					z.getParent().setColor('B');
					y.setColor('B');
					z.getParent().getParent().setColor('R');
					z = z.getParent().getParent();
				} else {
					//case 2. z’s uncle y is black and z is a right child
					if (z == z.getParent().getLeftChild()) {
						z = z.getParent();
						rightRotate(z);
					}
					//case 3. z’s uncle y is black and z is a left child
					z.getParent().setColor('B');
					z.getParent().getParent().setColor('R');
					leftRotate(z.getParent().getParent());
				}
			}
		}
		root.setColor('B');
	
	}

	//Added this function to use in delete(), 
	//In the book line 9 of the RB-Delete(), there is a tree-minimum
	//that I have decided to use.
	public Node<E> getMin(Node<E> x) {
		if (x.getLeftChild() != sentinel) {
			return getMin(x.getLeftChild()); //Recurisvely go throughs the left side of the tree until a null node pops up
		} else {

			return x; //x will be the node with the minimum value 
		}
	}

}



