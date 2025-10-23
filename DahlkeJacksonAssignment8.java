/*Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Oct. 29, 2025
 * Assignment #8
 * This code creates a ski resort and snowfall array and analyzes/prints out
 * various calculated results. It also creates a Dog class used in the creation
 * of another array with multiple strings in each variable, then gets and prints
 * out the dogs and how they bark.
 */

public class DahlkeJacksonAssignment8 {

	public static void main(String[] args) {
		
		//Array and Variable declaration
		String[] resorts = {"Vail", "Steamboat", "Wolf Creek", "Keystone",
				"Breckenridge", "Telluride", "Purgatory"};
		double[] snowfall = {189.2, 154.4, 430.2, 159.9, 184.6, 167.7, 260.2};
		
		//Calculating Values
		double total = totalsnow(snowfall); //Total snowfall
		double average = averagesnow(totalsnow(snowfall), snowfall); //Average snowfall
		int indexForMostSnow = mostsnow(snowfall); //Resort with most snowfall
		
		//System Output
		displaysnowfall(resorts, snowfall); //Displays table
		System.out.printf("Total Snowfall = %.2f\n", total);
		System.out.printf("Average Snowfall = %.2f\n", average);
		System.out.printf("Most Snowfall = %s with %.2f\n", resorts[indexForMostSnow],
				snowfall[indexForMostSnow]);
		aboveaveragesnow(snowfall, resorts, average);
		
		//Dog Barking
		//Declare variables and arrays
		Dog[] dogarray = new Dog[5];
		Dog dog1 = new Dog("Rover", "Woof Woof");
		Dog dog2 = new Dog("Max", "Arf Arf Arf");
		Dog dog3 = new Dog("Tiny", "Yap Yap Yap");
		Dog dog4 = new Dog("Trooper", "Ruff Ruff Ruff");
		Dog dog5 = new Dog("Mangoo", "Bow Wow Bow Wow");
		dogarray[0] = dog1;
		dogarray[1] = dog2;
		dogarray[2] = dog3;
		dogarray[3] = dog4;
		dogarray[4] = dog5;
		//Do the method
		makeDogsBark(dogarray);
		
	}//end main
	
	//Methods
	//Display Snowfall Chart
	public static void displaysnowfall(String[] resorts, double[] snowfall) {
		System.out.printf("________________________________\n|Resort\t\t|"
				+ "YearlySnowfall|\n--------------------------------\n|%s"
				+ "\t\t|%.1f\t       |\n|%s\t|%.1f\t       |\n|%s\t|%.1f\t   "
				+ "    |\n|%s\t|%.1f\t       |\n|%s\t|%.1f\t       |"
				+ "\n|%s\t|%.1f\t       |\n|%s\t|%.1f\t       |\n"
				+ "--------------------------------\n\n", 
				resorts[0], snowfall[0], resorts[1], snowfall[1], resorts[2],
				snowfall[2], resorts[3], snowfall[3], resorts[4], snowfall[4],
				resorts[5], snowfall[5], resorts[6], snowfall[6]);
		return;
	}/*End Display, I understand that I can use a for or while loop here, however to
	*get a nice table I manually configured it.
	*/
	
	//Total Snowfall
	public static double totalsnow(double[] snowfall) {
		double total = 0;
		for(int i = 0; i < snowfall.length; i++) {
			total += snowfall[i];
		}
		return total;
	}//end total
	
	//Average Snowfall
	public static double averagesnow(double totalsnow, double[] snowfall) {
		double average = totalsnow(snowfall)/ snowfall.length;
		return average;
	}//end average
	
	//Resort With The Most Snowfall
	public static int mostsnow(double[] snowfall) {
		int index = 0;
		double mostSnowV = 0;
		for(int i = 0; i < snowfall.length; i++) {
			double currentSnow = snowfall[i];
			if(mostSnowV < currentSnow) {
				index = i; 
				mostSnowV = currentSnow;
			}//end if
		}//end for
		return index;
	}//end most snowfall
	
	//Above Average Snowfall
	public static void aboveaveragesnow(double[] snowfall, String[] resorts,
			double average) {
		for(int i = 0; i < snowfall.length; i++) {
			double currentSnow = snowfall[i];
			if(currentSnow > average) {
				System.out.printf("%s has above average snowfall with %.2f.\n",
						resorts[i], snowfall[i]);
			}//end if
		}//end for
		return;
	}//end above average snowfall
	
	//Dog methods
	public static void makeDogsBark(Dog[] dogarray) {
		System.out.println("\nMaking Dogs Bark:\n----------------------------\n");
		for(int i = 0; i < dogarray.length; i++) {
			String bark = dogarray[i].getBark();
			String dog = dogarray[i].getName();
			System.out.printf("%s barks like: %s\n", dog, bark
					);
		}//end for
	}//end dog method

}//end class for Assignment8

class Dog{
	//Get methods for array and variables 
	private String name;
	private String bark;
	public Dog(String name, String bark) {
		this.name = name;
		this.bark = bark;
	}
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBark() {
		return bark;
	}
	public void setBark(String bark) {
		this.bark = bark;
	}
}//end dog