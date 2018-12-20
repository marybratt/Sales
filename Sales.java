import java.lang.reflect.Array;
import java.util.Scanner;

public class Sales {
	
	public static void main(String[] args)	{
		// open Scanner and request the number of employees to be entered
		Scanner input = new Scanner(System.in);
		System.out.println("How many employees do you have: ");
		int noOfEmployees = input.nextInt();
		// declare and size the arrays with the number of employees entered above
		int [] employeeID = new int[noOfEmployees]; //array to keep the employee ID
		String [] employee = new String[noOfEmployees]; // array to keep the employee name
		double [] totalSales = new double[noOfEmployees]; // array to keep the total sales for each employee
		
		// get the name and total sales for each employee, will loop until it reaches the number of employee
		// that were entered above
		
		for (int i =0; i < noOfEmployees; i++) {
			employee[i] = getName(); // get the name of the employee
			employeeID[i] = i+1; // assign the employee ID - so that none use id number 0 we start with 1 and increase
											// for each time thru loop
			totalSales[i] = getSales(employee[i]); // get the total sales for each employee 
		}
		// once all employees and sales are entered call program to print out the information requested
		printNamesAndSales(employeeID, employee, totalSales);
		// call a function to ask user for the value to compare the sales amount for each employee to
		double comparedValue = getCompareValue();
		// call the function to print out the employees that have sales over or equal to amount user input
		printNamesAndSalesOverValue(employeeID, employee, totalSales, comparedValue);
		input.close();
	}
	/*
	 * This function received in the arrays and the value to compare. It then compares that amount to
	 * the sales of each employee in the array. If the sales are higher will print out ID, name and Total Sales
	 * It will also keep a count of the number of employees that exceed the amount and print out a final 
	 * statement that will show this number.
	 */
	public static void printNamesAndSalesOverValue
		(int [] employeeID, String[] employee, double[] totalSales, double comparedValue) {
		int count = employeeID.length; //find the length of the arrays - all should be equal
		int numberExceed = 0; //declare value and set to 0
		// loop will run from 0 to the length of the arrays and check if the sales are higher than the 
		// value that user input
		for (int i = 0; i < count; i++) {
			if (comparedValue <= totalSales[i]) {
				System.out.printf("\n Employee # "+ employeeID[i] + " " + 
							employee[i] + " has sales of $%.2f", totalSales[i]); //print out employee information
				numberExceed++;		// increase counter	
			}
		}
		//print out the number of employees that exceeded the user value
		System.out.println("\nNumber of employees that exceed your amount is " + numberExceed + "!");
	}
	/*
	 * function will request the user to enter a value which will be used to find employees that have sales
	 * over that amount
	 *@return comparedValue - value to use to compare sales
	 */
	public static double getCompareValue() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter a value: "); // \n will put output on a new line
		double comparedValue = input.nextDouble();
		return comparedValue;
	}
	/*
	 * This function receives in all of the arrays and then will loop to print out the following:
	 * 1. Each employee ID, name, and sales for that employee
	 * 2. Grand total of all sales
	 * 3. Average of all sales
	 * 4. Employee ID, name and sales amount for the employee with the lowest sales
	 * 5. Employee ID, name and sales amount for the employee with the highest sales
	 */
	public static void printNamesAndSales(int[] employeeID, String[] employee, double[] totalSales) {
		//Initialize the grand total to 0 , min and max sales to the sales in index 0,
		// and index to 0 for the index with min and max sales
		double finalTotal = 0;
		double minSales = totalSales[0];
		int minIndex = 0;
		double maxSales = totalSales[0];
		int maxIndex = 0;
		// loop through the array and print out the ID, name and sales for each employee
		for (int i = 0; i < Array.getLength(totalSales); i++) {
			System.out.printf("\nTotal sales for employee # "+ employeeID[i] + " " + employee[i] + " is $%.2f", totalSales[i]);
			finalTotal += totalSales[i]; // sum the total sales
			// check if the current sales are lower than the min sale if so update minSales and index
			if (totalSales[i] < minSales) {
				minSales = totalSales[i];
				minIndex = i;
				//if current sales are not lower check if greater than max sales is so update max Sales and Index
			} else if (totalSales[i] > maxSales) {
				maxSales = totalSales[i];
				maxIndex = i;
			}
		}
		 // calculate the average of the total sales by dividing sum from above by the number of elements in array
		// then print out the required information
		double averageOfSales = finalTotal / totalSales.length;
		System.out.printf("\nThe grand total for all employees is $%.2f", finalTotal );
		System.out.printf("\nThe average sales amount is $%.2f", averageOfSales);
		System.out.printf("\nEmployee # " + employeeID[minIndex] + " " + employee[minIndex] + " has the lowest sales at $%.2f", minSales);
		System.out.printf("\nEmployee # " + employeeID[maxIndex] + " " + employee[maxIndex] + " has the highest sales at $%.2f", maxSales);
	}

	/*
	 * This function asks for the total sales for the employee that was entered just before this call
	 */
	public static double getSales(String employee) {
		Scanner input = new Scanner(System.in);
		System.out.println("Total sales for " + employee + " : ");
		double totalSales = input.nextDouble();
		//input.close();
		return totalSales;
	}
	/*
	 * This function will get the Name of the employee and return it
	 */
	public static String getName() {
		Scanner input = new Scanner(System.in);
		System.out.println("Employee name: ");
		String name = input.nextLine();
		return name;
	}

}
# Sales
