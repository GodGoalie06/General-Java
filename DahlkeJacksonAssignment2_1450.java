/* Jackson Dahlke
 * CS1450 Mon-Wed, Mich
 * Jan. 28 2026
 * Assignment #2
 * This program takes input from a turtle file and creates certain
 * turtle objects and over-rights the threat to the certain
 * turtle. Then prints any info about the turtle gathered, and puts them
 * in a tour de-france to see who went the furthest.
 */

//imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DahlkeJacksonAssignment2_1450 {

	public static void main(String[] args) throws IOException {
		// imports, variables, constants
		File turtles = new File("SeaTurtles.txt");
		Scanner fileinput = new Scanner(turtles);
		int arrayLenght = fileinput.nextInt();
		SeaTurtle[] theTurtles = new SeaTurtle[arrayLenght];
		//execute program
		fillArray(fileinput, theTurtles);
		displayArray(theTurtles);
		TourDeTurtles newTour = new TourDeTurtles(2025);
		newTour.setupTour(theTurtles);
		newTour.displayTourDetails();
	}// end main

	// fill array method
	public static void fillArray(Scanner fileinput, SeaTurtle[] theTurtles) {
		for (int i = 0; i < theTurtles.length; i++) {
			String type = fileinput.next();
			double miles = fileinput.nextDouble();
			int days = fileinput.nextInt();
			int year = fileinput.nextInt();
			String name = fileinput.next();
			// create based on type
			if (type.equals("hawksbill")) {
				Hawksbill hawksbill = new Hawksbill(miles, days, year, name);
				theTurtles[i] = hawksbill;
				type = "hawksbill";
			} // end if
			else if (type.equals("loggerhead")) {
				Loggerhead loggerhead = new Loggerhead(miles, days, year, name);
				theTurtles[i] = loggerhead;
				type = "loggerhead";
			} // end if
			else if (type.equals("greenturtle")) {
				Green_Turtle greenturtle = new Green_Turtle(miles, days, year, name);
				theTurtles[i] = greenturtle;
				type = "greenturtle";
			} // end if
			else if (type.equals("leatherback")) {
				Leatherback leatherback = new Leatherback(miles, days, year, name);
				theTurtles[i] = leatherback;
				type = "leatherback";
			} // end if
		} // end for
	}// end method

	// display method
	public static void displayArray(SeaTurtle[] theTurtles) {
		System.out.printf("%-15s%-15s%10s%12s    %-40s\n---------------------------------------------------"
				+ "----------------------------------------------\n", "Name", "Type", "Days", "Miles", "Threat");
		for (int i = 0; i < theTurtles.length; i++) {
			System.out.print(theTurtles[i].toString());
		} // end for
	}// end method
}// end Assign2 class

class SeaTurtle {
	// declare states
	private String type;
	private double miles_Traveled;
	private int days_Tracked;
	private int tour_Year;
	private String name;

	// default constructor
	public SeaTurtle() {
	}// end default constructor

	// complex constructor
	public SeaTurtle(String type, double miles_Traveled, int days_Tracked, int tour_Year, String name) {
		this.type = type;
		this.miles_Traveled = miles_Traveled;
		this.days_Tracked = days_Tracked;
		this.tour_Year = tour_Year;
		this.name = name;
	}// end complex constructor

	// getters
	public String getType() {
		return type;
	}// end getter

	public double getMiles() {
		return miles_Traveled;
	}// end getter

	public int getDays() {
		return days_Tracked;
	}// end getter

	public int getTour() {
		return tour_Year;
	}// end getter

	public String getname() {
		return name;
	}// end getter

	// behaviors
	public String toString() {
		return String.format("%-15s%-15s%10d%12.1f    %-40s\n", getname(),getType(),
				getDays(), getMiles(), threatsToSurvival());
	}
	public String threatsToSurvival() {
		return String.format("Turtles are in danger.");
	}
}// end SeaTurtle class

class Hawksbill extends SeaTurtle {

	// constructor
	public Hawksbill(double miles_Traveled, int days_Tracked, int tour_Year, String name) {
		super("Hawksbill", miles_Traveled, days_Tracked, tour_Year, name);
	}// end constructor

	// Override behaviors
	@Override
	public String threatsToSurvival() {
		return String.format("Harvesting of their shell");
	}// end behavior
}// end class

class Loggerhead extends SeaTurtle {

	// constructor
	public Loggerhead(double miles_Traveled, int days_Tracked, int tour_Year, String name) {
		super("Loggerhead", miles_Traveled, days_Tracked, tour_Year, name);
	}// end constructor

	// Override behaviors
	@Override
	public String threatsToSurvival() {
		return String.format("Loss of nesting habitat.");
	}// end behavior
}// end class

class Green_Turtle extends SeaTurtle {

	// constructor
	public Green_Turtle(double miles_Traveled, int days_Tracked, int tour_Year, String name) {
		super("Green Turtle", miles_Traveled, days_Tracked, tour_Year, name);
	}// end constructor

	// Override behaviors
	@Override
	public String threatsToSurvival() {
		return String.format("Commercial harvest for eggs and food.");
	}// end behavior
}// end class

class Leatherback extends SeaTurtle {

	// constructor
	public Leatherback(double miles_Traveled, int days_Tracked, int tour_Year, String name) {
		super("Leatherback", miles_Traveled, days_Tracked, tour_Year, name);
	}// end constructor

	// Override behaviors
	@Override
	public String threatsToSurvival() {
		return String.format("Plastic bag mistaken for jellyfish");
	}// end behavior
}// end class

class TourDeTurtles{
	//declare states
	private int tourYear;
	private int numTurtles;
	private SeaTurtle[] turtlesToTrack;
	
	public TourDeTurtles(){	
	}//default constructor
	
	public TourDeTurtles(int tourYear) {
		this.tourYear = tourYear;
	}//complex constructor
	
	//behaviors
	public void setupTour(SeaTurtle[] turtles) {
		SeaTurtle[] temp = new SeaTurtle[turtles.length];
		numTurtles = 0;
		for (int i = 0; i < temp.length; i++){
			if(turtles[i].getTour() == tourYear) {
				temp[numTurtles] = turtles[i];
				numTurtles ++;
			}//end if
		}//end for
		turtlesToTrack = new SeaTurtle[numTurtles];
		for (int i = 0; i < turtlesToTrack.length; i++){
			turtlesToTrack[i] = temp[i];
		}//end for
	}//end setup
	
	public void displayTourDetails() {
        System.out.println("\nTour de Turtles - Year: " + tourYear);
        System.out.printf("Number of turtles being tracked: " + numTurtles
        		+ "%-15s %10s\n", "\n]Name", "Miles Traveled\n--------------------"
        		+ "-----------");

        for (int i = 0; i < turtlesToTrack.length; i++) {
            System.out.printf("%-15s %10.1f\n", turtlesToTrack[i].getname(), 
            		turtlesToTrack[i].getMiles());
        }//end for
    }//end display
}//end TourDeTurtles Class