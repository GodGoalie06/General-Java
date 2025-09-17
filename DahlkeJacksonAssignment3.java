/*Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Sep. 13, 2025
 * Assignment #3
 * This program displays a menu for the user to choose from, and takes their choices 
 * to display them at the end. The program also is set to take the users choice for
 * a drink, add taxes and add discounts for students and military.
 */
import java.util.Scanner;
public class DahlkeJacksonAssignment3 {

	public static void main(String[] args) {
		//Name any Variables or Constants
		final Double SAND_CHIP_SDRIN = 15.50;
		final Double SAND_CHIP_LDRIN = 17.50;
		final Double SAND_BROW_SDRIN = 14.00;
		final Double SAND_BROW_LDRIN = 16.00;
		final Double SDRIN_ONLY = 5.75;
		final Double LDRIN_ONLY = 7.75;
		final Double TAX_RATE = 7.5/100;
		final Double STUD_DISCOUNT = 10.00/100.00;
		final Double MILI_DISCOUNT = 15.00/100.00;
		Double discountm = 0.00;
		Double choice = 0.00;
		Double total = 0.00;
		String item = "";
		/*Display the menu and promt the user for their choice of snack, drink
		*and if they are a student or military.
		*/
		System.out.printf("Welcome to the snack bar! Here is our menu!\n\n"
				+ "Options                                     Price with "
				+ "small drink     Price with large drink\n---------------"
				+ "-------------------------------------------------------"
				+ "----------------------\n1. Sandwhich with Chips and a "
				+ "Drink         $%.2f                     $%.2f\n2. "
				+ "Sandwhich with a Brownie and a Drink     $%.2f        "
				+ "             $%.2f\n3. Drink Only                     "
				+ "          $%.2f                      $%.2f", SAND_CHIP_SDRIN,
				SAND_CHIP_LDRIN, SAND_BROW_SDRIN, SAND_BROW_LDRIN, SDRIN_ONLY
				, LDRIN_ONLY);	
		Scanner userinput = new Scanner(System.in);
		System.out.println("\n\nWhat option would you like from our menu?"
				+ " Please use 1, 2 and 3 as listed on the menu.");
		int snackChoice = userinput.nextInt();
		if (snackChoice == 1 || snackChoice == 2 || snackChoice == 3) {
			System.out.println("\nWhich Drink choice would you like with your"
					+ "order? Please use 1 or 2, 1 for small and 2 for large.");
			int drinkChoice = userinput.nextInt();
			if (drinkChoice == 1 || drinkChoice == 2) {
				System.out.println("\nAre you a Student, Military Veteran or"
						+ " personnel? For student type 1, 2 for Veteran or"
						+ " Military member,\nand type 3 for none of the above.");
				int discount = userinput.nextInt();
				//If discount isn't a valid option, print so
				if (discount > 3 || discount < 1) {
					System.out.printf("%d is not a vaild option!\n", discount);
				}
				//Assigning the users snack choice to the prices/string values
				userinput.close();
				if (snackChoice == 1 && drinkChoice ==1){
					choice = SAND_CHIP_SDRIN;
					item = "Sandwich with chips and a small drink";
				}
				else if (snackChoice == 1 && drinkChoice ==2) {
					choice = SAND_CHIP_LDRIN;
					item = "Sandwich with chips and a large drink";
				}
				else if (snackChoice == 2 && drinkChoice ==1) {
					choice = SAND_BROW_SDRIN;
					item = "Sandwich with a brownie and a small drink";
				}
				else if (snackChoice == 2 && drinkChoice ==2) {
					choice = SAND_BROW_LDRIN;
					item = "Sandwich with a brownie and a large drink";
				}
				else if (snackChoice ==3 && drinkChoice == 1) {
					choice = SDRIN_ONLY;
					item = "Small drink";
				}
				else if (snackChoice == 3 && drinkChoice ==2) {
					choice = LDRIN_ONLY;
					item = "Large drink";
				}
				// Assigning the users Discount to a variable
				if (discount == 1) {
					discountm = STUD_DISCOUNT;
				}
				else if (discount == 2) {
					discountm = MILI_DISCOUNT;
				}
				Double discountf = choice * discountm;
				Double subtotal = choice - discountf;
				Double taxes = subtotal * TAX_RATE;
				total = subtotal + taxes;
				System.out.printf("\nRecipt\n--------------------"
						+ "-------------------------\n%s   $%.2f\nDiscount"
						+ "    $%.2f\nTaxes       $%.2f\n-----------"
						+ "----------------------------------\nTotal"
						+ "       $%.2f"
						, item, choice, discountf, taxes, total);
			}
			else {
				System.out.printf("%d is not a valid option, Bye Bye!", drinkChoice);
			}
		}
		else{
			System.out.printf("%d is not a valid option, Bye Bye!", snackChoice);
		}
	}
}