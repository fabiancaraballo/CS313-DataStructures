import java.util.Scanner;     //import Scanner package
import java.io.File;

public class lab0 {

    public static void main(String[] args) {
//	System.out.println("whats up");
        Scanner scanner = new Scanner(System.in);
//	System.out.println("done scanning");
        int numProblems = scanner.nextInt();          //retrieve the number of lines
        for(int i = 0; i < numProblems; ++i){
            int a = scanner.nextInt();                  //retrieve the first integer
            int b = scanner.nextInt();                  //retrieve the second integer

            int g = gcd(a,b);
            int l = lcm(a,b);
            System.out.println(g + " " + l);
//            System.out.println(l);
        }

        scanner.close();

    }

    public static int gcd(int a, int b) {
        // Find the greatest common divisor of a and b
        // Hint: Use Euclids Algorithm
        int firstInt = a;
        int secondInt = b;
	int mod; 
        if(firstInt == 0) {
            return secondInt;
        } 
	
	mod = secondInt % firstInt;
//	System.out.println("After modding fI is: " + firstInt);
//      System.out.println("After modding sI is: " + secondInt);
//      System.out.println("secondInt % firstInt: " + mod);

	return gcd(mod,firstInt);	//this line uses recursion to continously continous mod down both
					//a and b until we find a gcd using Euclids aglorithm 
        
    }

    public static int lcm(int a, int b) {
        // Find the least common multiple of a and b
        // Hint: Use the gcd of a and b
        int firstInt = a;
        int secondInt = b;

	int gcd1 = gcd(a,b);

	int lcm1 = (a*b)/gcd1;
        return lcm1;
    }

}
