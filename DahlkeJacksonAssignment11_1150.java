/* Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Nov.19, 2025
 * Assignment #11
 * This code creates a car object with a fuelgauge and odometer and puts them
 * through a simulation incramenting 25 miles to see when they will run outta 
 * gas.
 */

//imports
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class DahlkeJacksonAssignment11 {

	public static void main(String[] args) throws IOException {
		//variables
		Car[] Cars = new Car[5];
		final double milesTraveled = 25;
		//methods
		createCars(Cars);
		writeCarDetailsToFile(Cars);
		System.out.println("Cars Before Simulation\n"
				+ "--------------------------------------------------------");
		printCars(Cars);
		simulation(Cars, milesTraveled);
		System.out.println("\n\nCars After Simulation\n"
				+ "--------------------------------------------------------");
		printCars(Cars);
		
	}//end main

	public static void createCars(Car[] cars) {
		cars[0] = new Car("Donkey", "Toyota Tundra", 15, 34000, 8);
		cars[1] = new Car("Fiona", "Audi Q7", 21, 7110, 10);
		cars[2] = new Car("Shrek", "Jeep CJ5", 14, 11800, 5);
		cars[3] = new Car("Farquaad", "Smart Car", 42, 82700, 4);
		cars[4] = new Car("Dragon", "Chevy Suburban", 12, 150245, 30);
	}//end create
	
	public static void writeCarDetailsToFile(Car[] cars) throws IOException{
		File fileName = new File("Assignment11.txt");
		PrintWriter resultsFile = new PrintWriter (fileName);
		resultsFile.println("Car Details");
		for (int i = 0; i < cars.length; i ++) {
			resultsFile.println(cars[i].getOwner());
			resultsFile.println(cars[i].getModel());
			resultsFile.println(cars[i].getMPG());
			resultsFile.println(cars[i].getOdometer().getMileage());
			resultsFile.println(cars[i].getfuelGauge().getCurrentFuel());
			resultsFile.println();
		}//end for
		resultsFile.close();
	}//end method
	
	public static void printCars(Car[] cars) {
		System.out.printf("%-10s|%-20s|%-5s|%-10s|%s\n-------------------------"
				+ "-------------------------------", "Owner", "Car Type", "MPG",
				"Mileage", "Gallons");
		for (int i = 0; i < cars.length; i ++) {
			System.out.printf("\n%-10s|%-20s|%-7.2f|%-11.2f|%.2f", cars[i].getOwner(),
					cars[i].getModel(), cars[i].getMPG(), 
					cars[i].getOdometer().getMileage(),
					cars[i].getfuelGauge().getCurrentFuel());
		}//end for
	}//end method
	
	public static void simulation(Car[] cars, double milesTraveled) {
		boolean allCarsAreOuttaGas = false;
		Car[] carsOuttaGas = new Car[cars.length];
		int carsOuttaGasCounter = 0;
		while(allCarsAreOuttaGas == false) {
			for (int i = 0; i < cars.length; i ++) {
				if(!cars[i].getFuelLevel().equals("Doesn't have gas")) {
					double gallonsUsed = milesTraveled / cars[i].getMPG();
					if(cars[i].getfuelGauge().getCurrentFuel() > gallonsUsed) {
						cars[i].getfuelGauge().updateFuel(gallonsUsed);
						cars[i].getOdometer().updateOdometer(milesTraveled);
					}//end inner if
					else {	
						cars[i].setFuelLevel("Doesn't have gas");
						carsOuttaGas[carsOuttaGasCounter] = cars[i];
						carsOuttaGasCounter += 1;
					}//end inner else
				}//end outter if
			}//end for
			allCarsAreOuttaGas = areCarsOuttaGas(cars);
		}//end while
		for (int i = 0; i < carsOuttaGas.length; i ++) {
			System.out.printf("\n%s ran outta gas.", carsOuttaGas[i].getOwner());
		}//end for
	}//end method
	
	public static boolean areCarsOuttaGas(Car[] cars) {
		for (int i = 0; i < cars.length; i ++) {
			if(!cars[i].getFuelLevel().equals("Doesn't have gas")) {
				return false;
			}//end if
		}//end for
		return true;
	}//end method
}//end Assign11

class Car{
	//variables
	private String owner;
	private String model;
	private double mpg;
	private String fuellevel;
	private odometer odometer;
	private fuelGauge fuelGauge;
	
	public Car(String owner, String model, double mpg,
			double mileage, double gallons){
		this.owner = owner;
		this.model =model;
		this.mpg = mpg;
		odometer = new odometer(mileage);
		fuelGauge = new fuelGauge(gallons);
		fuellevel = "Has Gas";
	}//end constructor
	
	public String getOwner() {
		return owner;
	}//end getter
	
	public String getModel() {
		return model;
	}//end getter
	
	public double getMPG() {
		return mpg;
	}//end getter
	
	public String getFuelLevel() {
		return fuellevel;
	}//end getter
	
	public void setFuelLevel(String fuellevel) {
		this.fuellevel = fuellevel;
	}//end setter
	
	public odometer getOdometer() {
		return odometer;
	}//end getter
	
	public fuelGauge getfuelGauge() {
		return fuelGauge;
	}//end getter
}//end car class

class odometer{
	//variables
	private double mileage;
	
	public odometer(double mileage){
		this.mileage = mileage;
	}//end constructor
	
	public double getMileage() {
		return mileage;
	}//end getter
	
	public void updateOdometer(final double milesTraveled) {
		this.mileage = mileage + milesTraveled;
	}//end update
}//end class

class fuelGauge{
	//variables
	private double gallons;
	
	public fuelGauge(double gallons){
		this.gallons = gallons;
	}//end constructor
	
	public double getCurrentFuel() {
		return gallons;
	}//end getter
	
	public void updateFuel(double fuelUsed) {
		if(gallons >= fuelUsed) {
			this.gallons = gallons - fuelUsed;
		}//end if
		else {
			this.gallons = 0;
		}//end else
	}//end update
}//end class