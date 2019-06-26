import java.util.Scanner;
import java.util.Arrays;

public class lab2 {
    public static void main(String[] args) {

        // Loop over the Scanner
        // Split each line into the task and the corresponding number (if one exists)
        // Depending on what the input task was, preform the corresponding function
        //      (ie) insert, delete, find, inoder, preorder, or postorder
        // Hint: Use a switch-case statement

        // Don't forget to close your Scanner!
	Scanner scanner = new Scanner(System.in);

	BST<Integer> myBST = new BST<Integer>();
	
	int data;
	String task;


	String lineChecker = scanner.nextLine();
	int numLines = Integer.parseInt(lineChecker);

	for(int i = 0; i < numLines; i++) {
		String fileLine = scanner.nextLine();
		
		String[] arr = fileLine.split(" ");
//		System.out.println(Arrays.toString(arr));
	
		//Taken from TestContents.java in lab1
		task = arr[0];
		switch(task) {
			case "insert":
				data = Integer.parseInt(arr[1]);
				myBST.insert(data);
				break;
			case "delete":
				data = Integer.parseInt(arr[1]);
				myBST.delete(data);
				break;
			case "find":
	            		data = Integer.parseInt(arr[1]);
	            		myBST.find(data).getData();
	            		break;
			case "preorder":
				myBST.traverse(arr[0], myBST.getRoot());
				System.out.print("\n");
				break;
			case "inorder":
                                myBST.traverse(arr[0], myBST.getRoot());
                                System.out.print("\n");
                                break;
			case "postorder":
                                myBST.traverse(arr[0], myBST.getRoot());
                                System.out.print("\n");
                                break;

		}
    	}

	scanner.close();

	}
}
