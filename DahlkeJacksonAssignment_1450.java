/* Jackson Dahlke
 * CS1450 Mon-Wed, Mich
 * Jan. 25, 2026
 * Assignment #1
 * This code creates 20 random numbers from 10-40 and puts then into a
 * 2 and 1 D array, organizes them, finds the sum, median, and average
 * and saves them to a file.
 */

//Imports
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class DahlkeJacksonAssignment_1450 {

	public static void main(String[] args)  throws IOException {
		//Create any needed variables
		int[] numb1D = new int[20];
		int[][] numb2D = new int[4][5];
		int sum = 0;
		int bigNumb = 1;
		int bigNumbOcc = 0;
		int counter = 0;
		File fileName = new File("assignment1.txt");
		PrintWriter outputFile = new PrintWriter(fileName);
		Scanner readFile = new Scanner (fileName);
		
		// Create 20 random values 10-40 and put them into an array
		System.out.println("\nRandom Numbers:");
		for(int i=0; i < numb1D.length; i++) {
			int num = (int) (Math.random() * 31) + 10;
			numb1D[i] = num;
			System.out.println(num);
				}//end for
		
		//Find sum
		Arrays.sort(numb1D);
		for(int i=0; i < numb1D.length; i++) {
			sum += numb1D[i];
		}//end for
		
		//Calculate average
		int average = sum / numb1D.length;
		//Calculate median
		int median = numb1D[numb1D.length / 2];
		
		//Find largest number and how many times it appears
		for(int i=0; i < numb1D.length; i++) {
			if(numb1D[i] > bigNumb) {
				bigNumb = numb1D[i];
			}//end if
		}//end for
		for(int i=0; i < numb1D.length; i++) {
			if(numb1D[i] == bigNumb) {
				bigNumbOcc++;
			}//end if
		}//end for
		
		//Print 1D array and  related values
		System.out.println("\nSum = " + sum);
		System.out.println("Average = " + average);
		System.out.println("Median = " + median);
		System.out.println("Biggest Number = " + bigNumb + 
				" and it occurs " + bigNumbOcc + " times.\n");
		
		//2D array and print
		for(int i=0; i < numb2D.length; i++) {
			for(int ii=0; ii < numb2D[i].length; ii++) {
				numb2D[i][ii] = numb1D[counter];
				counter++;
			}//end for
		}//end for
		
		System.out.println("2D array Numbers:");
		for(int i=0; i < numb2D.length; i++) {
			for(int ii=0; ii < numb2D[i].length; ii++) {
				System.out.print(numb2D[i][ii] + " ");
			}//end for
			System.out.println();
		}//end for
		
		//Print to file
		for(int i=0; i < numb2D.length; i++) {
			for(int ii=0; ii < numb2D[i].length; ii++) {
				outputFile.println(numb2D[i][ii] + " ");
			}//end for
		}//end for
		outputFile.close();
		
		//Print to console
		System.out.println("\nFile Numbers:");
		for(int i=0; i < numb1D.length; i++) {
			System.out.println(readFile.next());
		}//end for
		readFile.close();
	}//end main
}//end Assignment_1
