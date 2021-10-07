/**
 * 
 */
package sales;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author plzsales
 *
 */

public class Sales {
	private static double[] getInput() {
		// Initialize the needed variables.
		// User input will be stored in a double[] array for easier processing
		Scanner sc = new Scanner(System.in);
		double[] inputVals = new double[3];
		boolean isValidInput = false;
		
		// user instructions
		System.out.println("Enter 2-3 numeric inputs. Separate your inputs using the Enter key.\n"
						 + "Please note that the operations Division and Module will ignore your third argument\n"
						 + "as these operations will only use your first and second inputs, i.e., input1 / input2 or input1 % input2.");
		// get the user input. Limit the input to three values
		for (int i = 0; i < 3; i++) {
			// take an input while the user is not giving a valid numeric input
			while(!isValidInput) {
				try {
					System.out.printf("Enter input %d: ", i + 1);
					inputVals[i] = sc.nextDouble();
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine(); // clear scanner
					continue; // take an input again
				}
				// input is valid, exit the while loop
				isValidInput = true;
			}
			// reset the value of the boolean counter for the next iteration
			isValidInput = false;
		}
//		sc.close();
		
		System.out.println("Input values are " + Arrays.toString(inputVals));
		return inputVals;
	}
	
	private static double Add(double[] values) {
		double sum = 0;
		for (Double d : values) {
			sum += d;
		}
		return sum;
	}
	
	private static double Subtract(double[] values) {
		return values[0] - values[1] - values[2];
	}

	private static double Multiply(double[] values) {
		double product = 1;
		for (Double d : values) {
			product *= d;
		}
		return product;
	}
	
	private static double Divide(double[] values) {
		return values[0] / values[1];
	}
	
	private static double Modulo(double[] values) {
		return values[0] % values[1];
	}
	
	private static double[] Predecrement(double[] values) {
		double[] values_copy = Arrays.copyOf(values, values.length);
		for (int i = 0; i < values_copy.length; i++) {
			--values_copy[i];
		}
		return values_copy;
	}
	
	private static double[] Postdecrement(double[] values) {
		double[] values_copy = Arrays.copyOf(values, values.length);
		for (int i = 0; i < values_copy.length; i++) {
			values_copy[i]--;
		}
		return values_copy;
	}
	
	private static double[] Preincrement(double[] values) {
		double[] values_copy = Arrays.copyOf(values, values.length);
		for (int i = 0; i < values_copy.length; i++) {
			++values_copy[i];
		}
		return values_copy;
	}
	
	private static double[] Postincrement(double[] values) {
		double[] values_copy = Arrays.copyOf(values, values.length);
		for (int i = 0; i < values_copy.length; i++) {
			values_copy[i]++;
		}
		return values_copy;
	}


	public static void main(String[] args) {
		
		double[] userInput = getInput();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		boolean isChoosing = true;
		// Map the number options to their corresponding operations. Used in print formatting
		Map<Integer, String> opsMapping = new HashMap<Integer, String>();
		opsMapping.put(1, "Addition");
		opsMapping.put(2, "Subtraction");
		opsMapping.put(3, "Multiplication");
		opsMapping.put(4, "Division");
		opsMapping.put(5, "Modulus");
		opsMapping.put(6, "Decrement");
		opsMapping.put(7, "Increment");
		
		// loop while the user is not entering a valid option
		while(isChoosing) {
//			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("Choose the operation to perform:");
				System.out.println("[1] Addition\n"
								 + "[2] Subtraction\n"
								 + "[3] Multiplication\n"
								 + "[4] Division (a / b from input [a, b, c (ignored)])\n"
								 + "[5] Modulus (a % b from input [a, b, c (ignored)])\n"
								 + "[6] Decrement\n"
								 + "[7] Increment"
								 + "\n\n[0] Exit Program.\n");
				System.out.print("Input the [number] of your choice: ");
				choice = sc.nextInt();
				
				if(choice == 0) {
					System.out.println("Exiting program. Goodbye!");
					sc.close();
					return;
				}
				if(choice < 1 || choice > 7) {
					throw new Exception("Error: The input is out of the input range. Please choose again.");
				}
				else {
					isChoosing = false;
				}
				
			} catch (Exception e){
				e.printStackTrace();
				sc.nextLine();
			}
		}
		// close the scanner object
		sc.close();
		// Print the chosen operation
		System.out.printf("The operation chosen is [%d] %s for inputs %s.\n\n",
				choice, opsMapping.get(choice), Arrays.toString(userInput));
		// print the result of the operation
		if(choice == 1) {
			System.out.println("The running sum of the user input is " + Add(userInput));
		}
		if(choice == 2) {
			System.out.println("The running difference of the user input is " + Subtract(userInput));
		}
		if(choice == 3) {
			System.out.println("The running product of the user input is " + Multiply(userInput));
		}
		if(choice == 4) {
			System.out.printf("The quotient of the %.3f over %.3f is %.3f user input is ", userInput[0], userInput[1], Divide(userInput));
		}
		if(choice == 5) {
			System.out.printf("The result of %.3f modulo %.3f from the user input is %.3f", userInput[0], userInput[1], Modulo(userInput));
		}
		if(choice == 6) {
			System.out.println("The decremented values of the user input are:");
			System.out.println("Pre-decrement: " + Arrays.toString(Predecrement(userInput)));
			System.out.println("Post-decrement (values used before the operation): " + Arrays.toString(userInput));
			System.out.println("Post-decrement (values used after the operation): " + Arrays.toString(Postdecrement(userInput)));
		}
		if(choice == 7) {
			System.out.println("The incremented values of the user input are:");
			System.out.println("Pre-increment: " + Arrays.toString(Preincrement(userInput)));
			System.out.println("Post-increment (values used before the operation): " + Arrays.toString(userInput));
			System.out.println("Post-increment (values used after the operation): " + Arrays.toString(Postincrement(userInput)));
		}
		
		System.out.println("\n***END OF PROGRAM***");

	}

}
