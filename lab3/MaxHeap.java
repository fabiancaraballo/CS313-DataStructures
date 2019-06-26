import java.util.Comparator;
import java.lang.Math;

@SuppressWarnings("unchecked")
public class MaxHeap<E extends Comparable> {
    private E[] myArray;
    private int maxSize;
    private int length;

    public MaxHeap(int s){
    	// Build the constructor
	length = 0;
	maxSize = s;
	myArray = (E[]) new Comparable[maxSize+1];
    }

    // helper functions
    public E[] getArray(){
        return myArray;
    }

    public void setArray(E[] newArray){
    	if (newArray.length > maxSize+1){
    		return;
    	}
        myArray = newArray;
        length = newArray.length-1;
    }

    private int getParent(int i) {
	return (i - 1)/ 2;
    }

    private int getLeftChild(int i) {
	return (2*i);

    }

    private int getRightChild(int i) {
        return (2*i)+1;

    }

    public int getMaxSize(){
        return maxSize;
    }

    public void setMaxSize(int ms){
        maxSize = ms;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int l){
        length = l;
    }

    // Other Methods
    public void insert(E data){
    
    	// Insert an element into your heap.

	length++;
	int len = length;
	myArray[len] = data;
	E temp;
	
	//while tempLen is not Root and myArray[tempLen] is greater than myArray[tempLen/2]
	//while-loop checks the proper spot to insert i
	//if the current length in which is entered is not the root 
	//as it being less than it's parent then it will enter the loop 
	//this while loop basically checks to see if it's in the correct order with it's
	//parent node
	while((len > 1) && (myArray[len/2].compareTo(myArray[len]) < 0)){
			//if the current node value is greater than it's parent than it will
			//swap the two nodes
        		temp = myArray[len/2];
        		myArray[len/2] = myArray[len];
        		myArray[len] = temp; 
       			len = len/2;
        }
    }

    public Comparable<E> maximum(){
        // return the minimum value in the heap
	//This checks to see if the length of the array equal to zero, if it is,
	//it will return null, if not it will return the first element in the heap
	if(myArray.length == 0) {
		return null;
	} else {
		return myArray[1];	
	}
    }

    public Comparable<E> extractMax(){
        // remove and return the minimum value in the heap
	//Since we are extract the max, we know its the first node since this is a MaxHeap
	E temp = myArray[1];
	
	//Moves the max node to the bottom so we can not worry about it when heapify is called
	myArray[1] = myArray[length];
	
	//Since we are removing the maximum node, we are down decrease the heap by 1 length 
	length --;
	
	//This will fix the heapify the MaxHeap without temp in it
	heapify(1);

	return temp;
    }
    
    public void heapify(int i){
    	//helper function for reshaping the array
	
	//assign i to maxNode because the value might change    	
	int maxNode = i;
    	
	//This compares the left child, if the current node is less than the left child
	//then it will change the value of maxNode to left child
    	if(getLeftChild(i) <= length){
		if(myArray[maxNode].compareTo(myArray[getLeftChild(i)]) < 0) {	
			maxNode = getLeftChild(i);
		}
    	}
    	
	//This compares the right child and if the current node is less than the right child
	//then it will change the value of maxNode to the right child
	if(getRightChild(i) <= length) {
		if(myArray[maxNode].compareTo(myArray[getRightChild(i)]) < 0){
    			maxNode = getRightChild(i);	
    		}
	}
    	
	//This is where the nodes are changed. The if statement checks the value of maxNode
	//so if for whatever reason the value of MaxNode changed then it will swap the nodes
	//then it will recursively call heapify again but this time with the value of the
	//right or left child
    	if(maxNode != i){
    		E temp = myArray[maxNode];
    		myArray[maxNode] = myArray[i];
    		myArray[i] = temp;
    		heapify(maxNode);		
    	}
    }
    
    public void buildHeap(E[] newArr){
	// used for the extra credit
    }
}
