/*Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Oct. 1, 2025
 * Assignment #5
 * This program asks for the sales values collected for one day,
 * then it creates a total, min and max values, an average, and
 * measures how many where below 500, in-between 500-2000 and 
 * above 2000. Then it prints them out.
 */

//Imports
import java.util.Scanner;
public class DahlkeJacksonAssignment5 {
	public static void main(String[] args) {
		
		//Create Variables and Constants
		Scanner userinput = new Scanner(System.in);
		int numSales = 0;
		final int SALEBREAKER = -1;
		int numLessSales = 0;
		int numBetwSales = 0;
		int numMoreSales = 0;
		double totalSales = 0.00;
		double sale = 0;
		double averSale = 0;
		double largSale = 0;
		double smalSale = Double.MAX_VALUE;
		final double NUMLESS = 500;
		final double NUMMORE = 2000;
		
		//Prompt user and save their input
		System.out.println("Enter all the sales collected for the day, "
				+ "type -1 and press enter when done.");
		sale = userinput.nextInt();
		
		//Check to see if the user inputed -1 at the end
		if (sale == SALEBREAKER) {
			System.out.printf("No sales entered except %d", SALEBREAKER);
		}//Close if
		
		else {
			
			//While Loop checking for a -1 to end
			while(sale != SALEBREAKER) {
				numSales ++;
				totalSales = totalSales + sale;
				
				/*If statements to check for min, max, and
				*measures how many where below 500, in-between 500-2000 and 
				*above 2000.
				*/
				if (sale > largSale) {
					largSale = sale;
				}
				if (sale < smalSale) {
					smalSale = sale;
				}
				if (sale < NUMLESS) {
					numLessSales = numLessSales + 1;
				}
				if (sale <= NUMMORE && sale >= NUMLESS) {
					numBetwSales = numBetwSales + 1;
				}
				if (sale > NUMMORE) {
					numMoreSales  = numMoreSales + 1;
				}
				
				//Printing everything necessary out.
				System.out.print("\nSale #" + numSales + " ");
				while(sale > 100) {
					sale = sale - 100;
					System.out.print("*");
				}
				sale = userinput.nextInt();
			}
			averSale = totalSales / numSales;
			
			//Printing remaining values out.
			System.out.printf("\n\nNumber of Sales: %d" +"\nSmallest Sale: $%.2f" 
			+ "\nLargest Sale: $%.2f" + "\nTotal in Sales: $%.2f" 
			+ "\nAverage in Sales: $%.2f" + "\n\nNumber of Sales Less than $%.0f: %d" 
			+ "\nNumber of Sales Between $%.0f and $%.0f: %d"
			+  "\nNumber of Sales Above $%.0f: %d", numSales, smalSale, largSale, 
			totalSales, averSale, NUMLESS, numLessSales, NUMLESS, NUMMORE, 
			numBetwSales, NUMMORE, numMoreSales);
			
		}//close else
		userinput.close();
	}//Close main
}//Close Assignment5