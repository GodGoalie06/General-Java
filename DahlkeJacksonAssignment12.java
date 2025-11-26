/* Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Dec.3, 2025
 * Assignment #12
 * This program takes input from an animals file and creates certain
 * animal objects and over-rights certain aspects talored to the certain
 * animal. Then prints any info about the animal gathered.
 */

//imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DahlkeJacksonAssignment12 {

	public static void main(String[] args) throws IOException {
		//imports, variables, constants
		File animals = new File("Animals.txt");
		Scanner fileinput = new Scanner (animals);
		int arrayLenght = fileinput.nextInt();
		Animal[] theAnimals = new Animal[arrayLenght];
		fillArray(fileinput, theAnimals);
		displayArray(theAnimals);
		
	}//end main
	
	//fill array method
	public static void fillArray(Scanner fileinput, Animal[] theAnimals) {
		for(int i = 0; i < theAnimals.length; i++) {
			String type = fileinput.next(); 
			String name = fileinput.next();
			String food = fileinput.next();
			int weight = fileinput.nextInt();
			int sleep = fileinput.nextInt();
			String location = fileinput.nextLine();
			//create based on type
			if(type.equals("Bear")) {
				Bear bear = new Bear(name, food, location, weight, sleep);
				theAnimals[i] = bear;
			}//end if
			else if(type.equals("Sloth")) {
				Sloth sloth = new Sloth(name, food, location, weight, sleep);
				theAnimals[i] = sloth;
			}//end if
			else if(type.equals("Monkey")) {
				Monkey monkey = new Monkey(name, food, location, weight, sleep);
				theAnimals[i] = monkey;
			}//end if
			else if(type.equals("Elephant")) {
				Elephant elephant = new Elephant(name, food, location, weight, sleep);
				theAnimals[i] = elephant;
			}//end if
		}//end for
	}//end method
	
	//diplay method
	public static void displayArray(Animal[] theAnimals) {
		for(int i = 0; i < theAnimals.length; i++) {
			//print type
			if(theAnimals[i] instanceof Bear) {
				System.out.printf("Animal %d is a Bear\n", i);
			}//end if
			else if(theAnimals[i] instanceof Sloth) {
				System.out.printf("Animal %d is a Sloth\n", i);
			}//end if
			else if(theAnimals[i] instanceof Monkey) {
				System.out.printf("Animal %d is s a Monkey\n", i);
			}//end if
			else if(theAnimals[i] instanceof Elephant) {
				System.out.printf("Animal %d is a Elephant\n", i);
			}//end if
			System.out.println(theAnimals[i].toString());
			theAnimals[i].eat();
			theAnimals[i].sleep();
			theAnimals[i].swim();
		}//end for
	}//end method
}//end Assign12 class

class Animal{
	//declare states/behaviors
	private String name;
	private String food;
	private String location;
	private int weight;
	private int sleep;
	
	//default constructor
	public Animal(){
	}//end default constructor
	
	//complex constructor
	public Animal(String name, String food, String location,int weight,
			int sleep){
		this.name = name;
		this.food = food;
		this.location = location;
		this.weight = weight;
		this.sleep = sleep;
	}//endcomplex constructor
	
	//getters
	public String getName() {
		return name;
	}//end getter
	public String getFood() {
		return food;
	}//end getter
	public String getLocation() {
		return location;
	}//end getter
	public int getWeight() {
		return weight;
	}//end getter
	public int getSleep() {
		return sleep;
	}//end getter
	
	//behaviors
	public void eat() {
		System.out.println("Animal is eating.");
	}//end behavior
	public void sleep() {
		System.out.println("Animal is sleeping.");
	}//end behavior
	public void swim() {
		System.out.println("Animal is swimming.\n");
	}//end behavior
}//end animal class

class Bear extends Animal{
	
	//constructor
	public Bear(String name, String food, String location, int weight,
			int sleep){
		super(name, food, location, weight, sleep);
	}//end constructor
	
	//Override behaviors
		@Override
		public void eat() {
			System.out.printf("The Bear %s is eating %s.\n", getName(), getFood());
		}//end behavior
		@Override
		public void sleep() {
			System.out.printf("The Bear %s is sleeping for %d Hours.\n", getName(),
					getSleep());
		}//end behavior
		@Override
		public void swim() {
			System.out.printf("The Bear %s is swimming.\n\n", getName());
		}//end behavior
		
		//Overriding the String
		@Override
		public String toString() {
		    return String.format(
		        "Bear Info:\nName: %s\nWeight: %d lbs\nSleep: %d hours\nLocation: %s",
		        getName(), getWeight(), getSleep(), getLocation()
		    );
		}//end string override
}//end bear class

class Elephant extends Animal{
	
	//constructor
	public Elephant(String name, String food, String location, int weight,
			int sleep){
		super(name, food, location, weight, sleep);
	}//end constructor
	
	//Override behaviors
		@Override
		public void sleep() {
			System.out.printf("The Elephant %s is sleeping for %d Hours.\n", getName(),
					getSleep());
		}//end behavior
		
		//Overriding the String
		@Override
		public String toString() {
		    return String.format(
		        "Elephant Info:\nName: %s\nWeight: %d lbs\nSleep: %d hours\nLocation: %s",
		        getName(), getWeight(), getSleep(), getLocation()
		    );
		}//end string override
}//end elephant class

class Monkey extends Animal{
	
	//constructor
	public Monkey(String name, String food, String location, int weight,
			int sleep){
		super(name, food, location, weight, sleep);
	}//end constructor
	
	//Override behaviors
		@Override
		public void eat() {
			System.out.printf("The Monkey %s is eating %s.\n", getName(), getFood());
		}//end behavior
		@Override
		public void swim() {
			System.out.printf("The Monkey %s is swimming.\n\n", getName());
		}//end behavior
		
		//Overriding the String
		@Override
		public String toString() {
		    return String.format(
		        "Monkey Info:\nName: %s\nWeight: %d lbs\nSleep: %d hours\nLocation: %s",
		        getName(), getWeight(), getSleep(), getLocation()
		    );
		}//end string override
}//end monkey class

class Sloth extends Animal{
	
	//constructor
	public Sloth(String name, String food, String location, int weight,
			int sleep){
		super(name, food, location, weight, sleep);
	}//end constructor
		
		//Overriding the String
		@Override
		public String toString() {
		    return String.format(
		        "Sloth Info:\nName: %s\nWeight: %d lbs\nSleep: %d hours\nLocation: %s",
		        getName(), getWeight(), getSleep(), getLocation()
		    );
		}//end string override
}//end Sloth class