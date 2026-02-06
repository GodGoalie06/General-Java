/* Jackson Dahlke
 * CS1450 Mon-Wed, Mich
 * Feb. 03 2026
 * Assignment #3
 * 
 */

//imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class DahlkeJacksonAssignment3_1450 {

	public static void main(String[] args) throws IOException {
		// imports, variables, constants
		File Athletes = new File("Athletes.txt");
		Scanner fileinput = new Scanner(Athletes);
		int arrayLenght = fileinput.nextInt();
		Athlete[] theAthletes = new Athlete[arrayLenght];
		fillArray(fileinput, theAthletes);
		System.out.println("Athletes and Disciplines\n------------------------------");
		displayArray(theAthletes);
		ArrayList<Athlete> swimmers = findSwimmers(theAthletes);
		System.out.println("Athletes that Swim\n------------------------------");
		System.out.printf("%-20s%-25s%10s", "Name", "Type", "Swim Speed\n");
		System.out.println("--------------------------------------------------------");
		for (int i = 0; i < swimmers.size(); i++) {
			Swimmer swimmer = (Swimmer) swimmers.get(i);
			System.out.printf("%-20s%-25s%4.2f\n"
					,swimmers.get(i).getName(), swimmers.get(i).getType(), swimmer.swim());
		}//end for
		Athlete bestBiker = bikeRace(theAthletes);
		Biker winningBiker = (Biker) bestBiker;
		System.out.println("\nBike race, go!\n------------------------------");
		System.out.printf("The winner is %s who is a %s with a biking speed "
				+ "of %.2f.", bestBiker.getName(), bestBiker.getType(), winningBiker.bike());
	}//ends main
	// fill array method
	public static void fillArray(Scanner fileinput, Athlete[] theAthletes) {
		for (int i = 0; i < theAthletes.length; i++) {
			String type = fileinput.next();
			double bikeSpeed = fileinput.nextDouble();
			double runSpeed = fileinput.nextDouble();
			double swimSpeed = fileinput.nextDouble();
			String name = fileinput.nextLine().trim();
			// create based on type
			if (type.equals("aquathlete")) {
				Aquathlete aquathlete = new Aquathlete(name, runSpeed, swimSpeed);
				theAthletes[i] = aquathlete;
				aquathlete.setType("aquathlete");
				aquathlete.setName(name);
			} // end if
			else if (type.equals("duathlete")) {
				Duathlete duathlete = new Duathlete(name, runSpeed, bikeSpeed);
				theAthletes[i] = duathlete;
				duathlete.setType("duathlete");
			} // end if
			else if (type.equals("marathoner")) {
				Marathoner marathoner = new Marathoner(name, runSpeed);
				theAthletes[i] = marathoner;
				marathoner.setType("marathoner");
			} // end if
			else if (type.equals("triathlete")) {
				Triathlete triathlete = new Triathlete(name, runSpeed, bikeSpeed, swimSpeed);
				theAthletes[i] = triathlete;
				triathlete.setType("triathlete");
			} // end if
		} // end for
	}// end method

	// display method
	public static void displayArray(Athlete[] theAthletes) {
		//cycle through athlete list
		for (int i = 0; i < theAthletes.length; i++) {
			//Print known values for each athlete
			System.out.printf("%s is a %s\n",theAthletes[i].getName(),
				theAthletes[i].getType());
			System.out.println(theAthletes[i].disciplines());
			
			//define run, swim and bike values
			double runSpeed = 0.0;
			double bikeSpeed = 0.0;
			double swimSpeed = 0.0;
			
			//check for instances and print values based on type
			if(theAthletes[i] instanceof Aquathlete){
				Aquathlete a = (Aquathlete) theAthletes[i];
				runSpeed = a.run();
				swimSpeed = a.swim();
				System.out.printf("Run Speed: %.2f   Bike Speed: %.2f   "
						+ "Swim Speed: %.2f\n\n", runSpeed, bikeSpeed, swimSpeed); 
			}//end if
			if(theAthletes[i] instanceof Duathlete){
				Duathlete a = (Duathlete) theAthletes[i];
				runSpeed = a.run();
				bikeSpeed = a.bike();
				System.out.printf("Run Speed: %.2f   Bike Speed: %.2f   "
						+ "Swim Speed: %.2f\n\n", runSpeed, bikeSpeed, swimSpeed); 
			}//end if
			if(theAthletes[i] instanceof Marathoner){
				Marathoner a = (Marathoner) theAthletes[i];
				runSpeed = a.run();
				System.out.printf("Run Speed: %.2f   Bike Speed: %.2f   "
						+ "Swim Speed: %.2f\n\n", runSpeed, bikeSpeed, swimSpeed); 
			}//end if
			if(theAthletes[i] instanceof Triathlete){
				Triathlete a = (Triathlete) theAthletes[i];
				runSpeed = a.run();
				bikeSpeed = a.bike();
				swimSpeed = a.swim();
				System.out.printf("Run Speed: %.2f   Bike Speed: %.2f   "
						+ "Swim Speed: %.2f\n\n", runSpeed, bikeSpeed, swimSpeed); 
			}//end if
		}//end for
	}// end method
	
	//find swimmers method
	public static ArrayList<Athlete> findSwimmers(Athlete[] theAthletes){
		ArrayList<Athlete> swimmers = new ArrayList<Athlete>();
		for (int i = 0; i < theAthletes.length; i++) {
			if(theAthletes[i] instanceof Swimmer) {
				swimmers.add(theAthletes[i]);
			}//end if
		}//end for
		return swimmers;
	}//end find swimmers
	
	//bike race method
	public static Athlete bikeRace(Athlete[] theAthletes) {
		Biker bestBiker = null;
		for(int i = 0; i < theAthletes.length; i++) {
			if(theAthletes[i] instanceof Biker) {
				Biker currentBiker = (Biker) theAthletes[i];
				if(bestBiker == null || currentBiker.bike() > bestBiker.bike()) {
					bestBiker = currentBiker;
				}//end if
			}//end if
		}//end for
		Athlete winningBiker = (Athlete) bestBiker;
		return winningBiker;
	}//end bike race
}//end DahlkeJacksonAssignment3

abstract class Athlete{
	//variables
	private String name;
	private String type;
	
	//getters and setters
	public String getName() {
		return name;
	}//end getter
	
	public String getType() {
		return type;
	}//end getter
	
	public void setName(String name) {
		this.name = name;
	}//end setter
	
	public void setType(String type) {
		this.type = type;
	}//end setter
	
	//behaviors
	public abstract String disciplines();
}//ends athlete

interface Runner{
	public abstract double run();
}//ends runner

interface Biker{
	public abstract double bike();
}//ends biker

interface Swimmer{
	public abstract double swim();
}//ends swimmer

class Aquathlete extends Athlete implements Runner, Swimmer{
	//variables
	private double runSpeed;
	private double swimSpeed;
	
	public Aquathlete(String name, double runSpeed, double swimSpeed) {
		setName(name);
		if(swimSpeed > 0) {
			this.swimSpeed = swimSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
		if(runSpeed > 0) {
			this.runSpeed = runSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
	}//end constructor
	
	public Aquathlete() {
	}//end default constructor
	
	//behaviors
	@Override
	public String disciplines(){
		return String.format("I run, swim, then run again. In the Swedish "
				+ "OTILLO Championship, the race\r\n"
				+ "takes place over 24 islands and requires 6 miles of "
				+ "swimming between the\r\n"
				+ "islands and 40 miles of trail running.");
	}//end behavior
	
	@Override
	public double run() {
		return runSpeed;
	}//end behavior
	
	@Override
	public double swim() {
		return swimSpeed;
	}//end behavior
}// end Aquathlete

class Duathlete extends Athlete implements Runner, Biker{
	//variables
	private double runSpeed;
	private double bikeSpeed;
	
	//Constructors
	public Duathlete (String name, double runSpeed, double bikeSpeed) {
		setName(name);
		if(bikeSpeed > 0) {
			this.bikeSpeed = bikeSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
		if(runSpeed > 0) {
			this.runSpeed = runSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
	}//end constructor
	
	public Duathlete() {
	}//end default constructor
		
	//behaviors
	@Override
	public String disciplines(){
		return String.format("I run, bike, then sometimes run again. "
				+ "In a long-distance duathlon, I run 6.2\r\n"
				+ "miles, bike 93 miles, then run 18.6 miles");
	}//end behavior
	
	@Override
	public double run() {
		return runSpeed;
	}//end behavior
	
	@Override
	public double bike() {
		return bikeSpeed;
	}//end behavior
}//ends Duathlete

class Marathoner extends Athlete implements Runner{
	//variables
	private double runSpeed;
		
	public Marathoner(String name, double runSpeed) {
		setName(name);
		if(runSpeed > 0) {
			this.runSpeed = runSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
	}//end constructor
	
	public Marathoner() {
	}//end default constructor
	
	@Override
	public String disciplines(){
		return String.format("During a full marathon I run 26.2 miles");
	}//end behavior
	
	@Override
	public double run() {
		return runSpeed;
	}//end behavior
}//ends Marathoner

class Triathlete extends Athlete implements Runner, Biker, Swimmer{
	//variables
	private double runSpeed;
	private double swimSpeed;
	private double bikeSpeed;
		
	public Triathlete(String name, double runSpeed, double bikeSpeed, double swimSpeed) {
		setName(name);
		if(swimSpeed > 0) {
			this.swimSpeed = swimSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
		if(runSpeed > 0) {
			this.runSpeed = runSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
		if(bikeSpeed > 0) {
			this.bikeSpeed = bikeSpeed;
		}//end if
		else{
			System.out.println("Speed cannot be zero, rewrite and resart the "
					+ "program");
		}//end else
	}//end constructor
		
	public Triathlete() {
	}//end default constructor
	
	@Override
	public String disciplines(){
		return String.format("During the Ironman triathlon, I swim 2.4 miles, "
				+ "bike 112 miles, then run\r\n26.2 miles.");
	}//end behavior
	
	@Override
	public double run() {
		return runSpeed;
	}//end behavior
	
	@Override
	public double swim() {
		return swimSpeed;
	}//end behavior
	
	@Override
	public double bike() {
		return bikeSpeed;
	}//end behavior
}//ends Triathlete