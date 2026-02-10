/*Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Sep. 10, 2025
 * Assignment #2
 * This program takes 4 inputs from the user name, weight, and height in feet and inches. It then converts those values 
 * into BMI numbers for the department of health and neatly puts them into a table to look at.
 */
import java.util.Scanner;
public class DahlkeJacksonAssignment2 {
	public static void main(String[] args) {
		//Inputting any constants needed
		final int BMICON = 703;
		/*Creating the scanner and prompting the user for their input name, weight, 
		*height in feet and height in inches. 
		*/
		Scanner userinput = new Scanner(System.in);
		System.out.println("Please, enter your first and last name, press enter when done.");
		String name = userinput.nextLine();		
		System.out.println("Please, enter your weight in pounds (only numbers), press enter when done.");
		Double weight = userinput.nextDouble();
		System.out.println("Please, enter your height in feet and only feet (only numbers), press enter when done");
		Double heightfeet = userinput.nextDouble();
		System.out.println("Please, enter your remaining height in inches and only inches (only numbers), press enter when done.");
		Double heightinches = userinput.nextDouble();
		userinput.close();
		//Changing feet into inches, get mass values and calculating the BMI values
		Double totalheight = (heightfeet * 12) + heightinches;
		Double weightm5 = weight - 5;
		Double weightm10 = weight - 10;
		Double weightm15 = weight - 15;
		Double weightp5 = weight + 5;
		Double weightp10 = weight + 10;
		Double weightp15 = weight + 15;
		Double bmibase = BMICON * (weight / (totalheight*totalheight));
		Double bmim5 = BMICON * (weightm5 / (totalheight*totalheight));
		Double bmim10 = BMICON * (weightm10 / (totalheight*totalheight));
		Double bmim15 = BMICON * (weightm15 / (totalheight*totalheight));
		Double bmip5 = BMICON * (weightp5 / (totalheight*totalheight));
		Double bmip10 = BMICON * (weightp10 / (totalheight*totalheight));
		Double bmip15 = BMICON * (weightp15 / (totalheight*totalheight));
		//Printing the user information table
		System.out.println("\nUser Information\n" + "---------------------------");
		System.out.printf("User's Name:\s%s\n", name);
		System.out.printf("Weight in Pounds:\s%.1f\n", weight);
		System.out.printf("Height:\s%.0f\sFeet\s&\s%.0f\sInches\n\n", heightfeet, heightinches);
		System.out.println("*****************************************************\n");
		System.out.println("\tBody Mass Index Calculator\n");
		System.out.printf("\tName:\s%s\n", name);
		System.out.printf("\tWeight:\s%.1f\spounds\n", weight);
		System.out.printf("\tHeight:\s%.1f\sInches\n\n", totalheight);
		System.out.println("-----------------------------------\n");
		System.out.println("\tWeight\t\tBMI\n");
		System.out.println("-----------------------------------\n");
		System.out.printf("\t%.2f\t\t%.2f\n", weightm15, bmim15);
		System.out.printf("\t%.2f\t\t%.2f\n", weightm10, bmim10);
		System.out.printf("\t%.2f\t\t%.2f\n", weightm5, bmim5);
		System.out.printf("\t%.2f\t\t%.2f\s(Current)\n", weight, bmibase);
		System.out.printf("\t%.2f\t\t%.2f\n", weightp5, bmip5);
		System.out.printf("\t%.2f\t\t%.2f\n", weightp10, bmip10);
		System.out.printf("\t%.2f\t\t%.2f\n", weightp15, bmip15);
		System.out.println("-----------------------------------\n");
		System.out.println("\tBMI Values from The Department of Health");
		System.out.printf("\t\sUnderweight: less than 18.5\n");
		System.out.printf("\t\sNormal: between 18.5-25\n");
		System.out.printf("\t\sOverweight: more than 25\n");
	}
}