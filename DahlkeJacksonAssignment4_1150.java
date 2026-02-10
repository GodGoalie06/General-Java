/*Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Sep. 17, 2025
 * Assignment #4
 * This assignment is taking a 2 character string and a 1 character integer from
 * the user as a console input. Creates a random 2 character string and 1 
 * character integer and compares them. Then determines the users winnings
 * based on if they are the same or not. Prints an output based on so.
 */
//Imports
import java.util.Scanner;
public class DahlkeJacksonAssignment4 {
	public static void main(String[] args) {
		//Declaring any needed variables and constants.
		Scanner userinput = new Scanner(System.in);
		final double MAXASCII = 90;
		final double MINASCII = 65;
		/* Print the Powerball menu and prompt the user for their input and 
		*save their input as a variable.
		*/
		System.out.println("Welcome to the Colorado Powerball!\n"
				+ "__________________________________________________"
				+ "_\n| JACKPOT!\tMatch both letters and the number |"
				+ "\n| Win $100\tMatch both letters                |"
				+ "\n| Win $40 \tMatch one letter                  |"
				+ "\n| Win $20 \tMatch the number                  |"
				+ "\n ][][][][][][][][][][][][][][][][][][][][][][][][][");
		System.out.println("\nPlease enter your lottery letters, only enter 2 "
				+ "letters A-Z with no spaces in between them.\nPress enter when "
				+ "done.");
		String lotterystr = userinput.nextLine();
		/*Checking for valid inputs an converting to char values, creating a random
		*ticket and comparing it/ displaying if the user "won" or not.
		*/
		if (lotterystr.length() == 2) {
			String lotterystrU = lotterystr.toUpperCase();
			char letter0Play = lotterystrU.charAt(0);
			char letter1Play = lotterystrU.charAt(1);
			if (letter0Play >= MINASCII && letter0Play <= MAXASCII && letter1Play >= 
					MINASCII && letter1Play <= MAXASCII) {
				System.out.println("Please enter your lottery number, only enter"
						+ " one number between 1 and 9 with no deciamal points. "
						+ "\nPress enter when done.");
				int number0Play = userinput.nextInt();
				userinput.close();
				if (number0Play >= 1 && number0Play <=9) {
					char letter0Lot = (char)(65 + (int)(Math.random()*26));
					char letter1Lot = (char)(65 + (int)(Math.random()*26));
					int number0Lot = (int)(1 + Math.random()*9);
					String userticket = (letter0Play + " " + letter1Play
							+ " " + number0Play);
					String lotticket = (letter0Lot + " " + letter1Lot
							+ " " + number0Lot);
					System.out.printf("\nYour Ticket: %s\n\n"
							+ "Winning Ticket: %s\n\n", userticket, lotticket);
					boolean nummatch = (number0Play == number0Lot);
					boolean lettermatch = (letter0Play == letter0Lot || letter1Play
							== letter1Lot);
					boolean lettersmatch = (letter0Play == letter0Lot && letter1Play
							== letter1Lot);
					if (lettersmatch && nummatch) {
						System.out.println("You won the JACKPOT!!!");
					}
					else if (lettersmatch) {
						System.out.println("You won $100!!!");
					}
					else if (lettermatch) {
						System.out.println("You won $40!!!");
					}
					else if (nummatch) {
						System.out.println("You won $20!!!");
					}
					else {
						System.out.println("You lost!");
					}
				}
				else {
					System.out.println("That is not a valid input for your lottery"
							+ " number!");
				}
			}
			else {
				System.out.println("You did not input vaild characters! "
						+ "Only input characters A through Z");
			}
		}
		else if (lotterystr.length() > 2) {
			System.out.println("That is too many characters! Only put 2, "
					+ "and do not put any spaces inbetween letters.");
		}
		else {
			System.out.println("That is too little characters! Put 2.");
		}
	}
}