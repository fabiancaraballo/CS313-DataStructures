import java.util.Scanner;
import java.util.Arrays;

public class TreeCompare {
    public static void main(String[] args) {

	 // Loop over the Scanner
        // Split each line into the task and the corresponding number (if one exists)

	// Depending on what the input task was, preform the corresponding function
        //      (ie) insert, delete, find, inoder, preorder, or postorder
        // Hint: Use a switch-case statement

	// Don't forget to close your Scanner!
	Scanner scanner = new Scanner(System.in);

	BST<Integer> myBST1 = new BST<Integer>();
	BST<Integer> myBST2 = new BST<Integer>();

	int data;
	String task;

	String lineChecker = scanner.nextLine();
	int numLines = Integer.parseInt(lineChecker);

	//This for loops inserts into myBST1
	for(int i = 0; i < numLines; i++) {
		String fileLine = scanner.nextLine();
			
		String[] arr = fileLine.split(" ");
//		System.out.println(Arrays.toString(arr));

		//Taken from TestContents.java in lab1
		task = arr[0];
		switch(task) {
			case "insert":
				data = Integer.parseInt(arr[1]);
				myBST1.insert(data);
				//myBST2.insert(data);
				break;
			case "delete":
				data = Integer.parseInt(arr[1]);
				myBST1.delete(data);
				//myBST2.delete(data);
				break;
			case "preorder":
				myBST1.traverse(arr[0], myBST1.getRoot());
				System.out.print("\n");
				break;
			case "inorder":
                                myBST1.traverse(arr[0], myBST1.getRoot());
                                System.out.print("\n");
                                break;
			case "postorder":
                                myBST1.traverse(arr[0], myBST1.getRoot());
                                System.out.print("\n");
                                break;
		
		}
		

	}

	String lineChecker2 = scanner.nextLine();
        int numLines2 = Integer.parseInt(lineChecker);
	
	//This for loops inserts into my BST2
	for(int i = 0; i < numLines2; i++) {
                String fileLine = scanner.nextLine();

                String[] arr = fileLine.split(" ");
		//              System.out.println(Arrays.toString(arr));

                //Taken from TestContents.java in lab1
                task = arr[0];
                switch(task) {
			case "insert":
                                data = Integer.parseInt(arr[1]);
                                //myBST1.insert(data);
                                myBST2.insert(data);
                                break;
                        case "delete":
				data = Integer.parseInt(arr[1]);
                                //myBST1.delete(data);
                                myBST2.delete(data);
                                break;
			case "preorder":
				myBST2.traverse(arr[0], myBST2.getRoot());
				System.out.print("\n");
				break;
			case "inorder":
                                myBST2.traverse(arr[0], myBST2.getRoot());
                                System.out.print("\n");
                                break;
			case "postorder":
                                myBST2.traverse(arr[0], myBST2.getRoot());
                                System.out.print("\n");
                                break;

                }
	}			

	boolean comparingTrees = myBST1.identicalTrees(myBST1.getRoot(), myBST2.getRoot());
	if (comparingTrees == true) {
		System.out.println("The trees have the same shape.");
	} else {
		System.out.println("The trees do not have the same shape.");
	}

	scanner.close();


	}
}
