import java.util.Scanner;     //import Scanner package
import java.io.File;

public class lab1 {
	public static void main(String[] args){
	
		// Create a Scanner that reads system input
		Scanner scanner = new Scanner(System.in);

		String lineChecker = scanner.nextLine();
		int numLines = Integer.parseInt(lineChecker);
		
		// Loop over the scanner's input
		// For each line of the input, send it to isPalindrome()
		// If isPalindrome returns true, print "This is a Palindrome." 
		// Otherwise print "Not a Palindrome."
		for(int i = 0; i < numLines; i++) {
			String fileLine = scanner.nextLine();
			boolean palChecker = isPalindrome(fileLine);

			if (palChecker == true) {
				System.out.println("This is a Palindrome.");
			} else {
				System.out.println("Not a Palindrome.");
			}


		}
		



		// Close the Scanner		
		scanner.close();
	}
	
	public static boolean isPalindrome(String s){
	
		// Create a stack and a Queue of chars that represents the passed in string
		Stack<Character> stack = new Stack<Character>();
		Queue<Character> queue = new Queue<Character>();
		
		// Hint: While you loop through the given string, push the same char onto your stack
		//		 that you enqueue into your Queue. This way you can use dequeue to get 
		//       the string from left to right, but you pop the string from right to left
		
		// Compare your Queue and Stack to see if the input String was a Palindrome or not	
		for(int i = 0; i< s.length(); i++) {
                        char c = s.charAt(i);
                        stack.push(c);
                }

		for(int i = 0; i< s.length(); i++) {
                        char c = s.charAt(i);
                        queue.enqueue(c);
                }
	

                //This compares the Stack and Queue for the Palindrome
                while((stack.isEmpty() == false) && (queue.isEmpty() == false)) {
                        Node<Character> stackNode = stack.pop();
                        Node<Character> queueNode = queue.dequeue();

			if(stackNode.getData() != queueNode.getData()) {
				return false;
			}

                }

                return true;	
			
	}
	
	public static boolean isPalindromeEC(String s){
	
		// Implement if you wish to do the extra credit.
		boolean ecPalindrome = true;
		
		return ecPalindrome;	
	}
}
