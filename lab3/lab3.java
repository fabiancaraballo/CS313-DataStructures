import java.util.Scanner;

public class lab3 {
    public static void main(String[] args) {
    
    	// Loop over the Scanner
        // Split each line into the task and the corresponding number (if one exists)
        // Depending on what the input task was, preform the corresponding function
        //      (ie) insert, maximum, extractMax, isEmpty, or print
        // Hint: Use a switch-case statement
	Scanner scanner = new Scanner(System.in);

	int data;
	String task;


	String lineChecker = scanner.nextLine();
	int numLines = Integer.parseInt(lineChecker);

	pQueue<Integer> pQueue1 = new pQueue<Integer>(numLines);
	//MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
	
	for(int i = 0; i < numLines; i++) {
		String fileLine = scanner.nextLine();
		
		String[] arr = fileLine.split(" ");
//		System.out.println(Arrays.toString(arr));
	
		//Taken from TestContents.java in lab1
		task = arr[0];
		switch(task) {
			case "insert":
				data = Integer.parseInt(arr[1]);
				pQueue1.insert(data);
				//System.out.println("Printed: " + data);
				break;
			case "print":
	            		pQueue1.print();
	            		break;
			case "isEmpty":
				if(pQueue1.isEmpty()) {
					System.out.println("Empty");
				} else {
					System.out.println("Not Empty");
				}
				break;
			case "maximum":
                                System.out.println(pQueue1.maximum());
                                break;
			case "extractMax":
                               // qQueue1.extractMax();
                                System.out.println(pQueue1.extractMax());
                                break;
		}
    	}

	// Don't forget to close your Scanner!
	scanner.close();

    }
}
