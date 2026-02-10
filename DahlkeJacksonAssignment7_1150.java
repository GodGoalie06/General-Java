/*Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Oct. 15, 2025
 * Assignment #7
 * This assignment is asking me to create a program to calculate
 * the volume of a cube, sphere, cylinder, and rectangle using a
 * switch statement and methods and taking user input for the shapes.
 */

//Imports
import java.util.Scanner;
public class DahlkeJacksonAssignment7 {

	public static void main(String[] args){
		
		// Constants and Variable declaration
		Scanner userinput = new Scanner(System.in);
		
		//Print welcome
		System.out.println("********************************\n"
				+ "Welcome to the Volume Calculator\n"
				+ "********************************\n\n");
		
		//Start the program
		int shapeOption = getShapeOption(userinput);

		/*Main while, closes program if 5 entered, calculates volume
		 *based on user inputs
		 */
		while(shapeOption != 5) {
			switch (shapeOption){
				//If cube
				case 1: 
					System.out.println("How long is one side of the cube?");
					double cubeSide = userinput.nextDouble();
					double volumeOfCube = cubeVolume(cubeSide);
					System.out.printf("Cube Volume: %.2f\n\n", 
							volumeOfCube);
					break;
				//If sphere
				case 2:
					System.out.println("What is the radius of the sphere?");
					double sphereRadius = userinput.nextDouble();
					double volumeOfSphere = sphereVolume(sphereRadius);
					System.out.printf("Sphere Volume: %.2f\n\n", 
							volumeOfSphere);
					break;
				//If cylinder
				case 3:
					System.out.println("What is the radius of the cylinder?");
					double cylinderRadius = userinput.nextDouble();
					System.out.println("What is the height of the cylinder?");
					double cylinderHeight = userinput.nextDouble();
					double volumeOfCylinder = cylinderVolume(cylinderRadius, cylinderHeight);
					System.out.printf("Cylinder Volume: %.2f\n\n",
							volumeOfCylinder);
					break;
				//If rectangle
				case 4:
					System.out.println("What is the length of the rectangle?");
					double rectangleLength = userinput.nextDouble();
					System.out.println("What is the width of the rectangle?");
					double rectangleWidth = userinput.nextDouble();
					System.out.println("What is the height of the rectangle?");
					double rectangleHeight = userinput.nextDouble();
					double volumeOfRectangle = rectangleVolume(rectangleLength, rectangleWidth,
							rectangleHeight);
					System.out.printf("Rectangle Volume: %.2f\n\n",
							volumeOfRectangle);
					break;
			}//Close main switch
			
		//Promt to start program again or end
		shapeOption = getShapeOption(userinput);
		
		}//Close main while
		//Print end statement if program ended, close scanner
		if(shapeOption == 5) {
			System.out.println("Ending Program...");
		}
		userinput.close();
	}//End void
	
	//Methods
	
	//Get the shape from user
	public static int getShapeOption(Scanner userinput) {
		System.out.println("Option\tShape\n---------------"
		+ "\n1     \tCube\n2     \tSphere\n"
		+ "3     \tCylinder\n4    \tRectangle\n5     "
		+ "\tExit\n\nSelect a shape to calculate the "
		+ "volume enter 1, 2, 3, 4, or 5 to exit the"
		+ " program.");
		int shapeOption = userinput.nextInt();
		while(shapeOption < 1 || shapeOption > 5) {
			System.out.printf("%d is not a valid option! Enter 1-5:", 
					shapeOption);
			shapeOption = userinput.nextInt();
		}
		return shapeOption;
	}
	
	//Calculate cube volume
	public static double cubeVolume(double cubeSide) {
		double cubeVolume = Math.pow(cubeSide, 3);
		return cubeVolume;
	}
	
	//Calculate sphere volume
	public static double sphereVolume(double sphereRadius) {
		double sphereVolume = (4.0 / 3.0) * Math.PI * 
				Math.pow(sphereRadius, 3);
		return sphereVolume;
	}
	
	//Calculate cylinder volume
	public static double cylinderVolume(double cylinderRadius, 
			double cylinderHeight) {
		double cylinderVolume = Math.PI * Math.pow(cylinderRadius, 2) *
				cylinderHeight;
		return cylinderVolume;
	}
	
	//Calculate rectangle volume
	public static double rectangleVolume(double rectangleLength, 
			double rectangleWidth, double rectangleHeight) {
		double rectangleVolume = rectangleLength * rectangleWidth *
				rectangleHeight;
		return rectangleVolume;
	}
}//End class