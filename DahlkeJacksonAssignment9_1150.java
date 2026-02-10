/* Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Nov.5, 2025
 * Assignment #8
 * 
 */

//imports
import java.util.Arrays;
public class DahlkeJacksonAssignment9 {

	public static void main(String[] args) {
		//Declare variables, arrays, etc.
		int[] numbers1 = {4, 11, 5, 10, 7, 6, 8, 9};
		int[] numbers2 = {5, 6, 3, 8, 8, 7, 4, 5};
		int[] numbers3 = {3, 3, 4, 3, 6, 3};
		
		//Display the arrays
		System.out.println("Orignial Arrays:\n------------------------------");
		display(numbers1, "numbers1");
		display(numbers2, "numbers2");
		display(numbers3, "numbers3");
		
		//Remove duplicates and sort
		int[] numbers1Dot1 = createArrayWithoutDuplicates(numbers1);
		int[] numbers2Dot1 = createArrayWithoutDuplicates(numbers2);
		int[] numbers3Dot1 = createArrayWithoutDuplicates(numbers3);
		Arrays.sort(numbers1Dot1);
		Arrays.sort(numbers2Dot1);
		Arrays.sort(numbers3Dot1);
		System.out.println("\nSorted Arrays without Duplicates:\n---------------"
				+ "------------------");
		
		//Display the new arrays
		display(numbers1Dot1, "numbers1Dot1");
		display(numbers2Dot1, "numbers2Dot1");
		display(numbers3Dot1, "numbers3Dot1");
		
		//Find the common numbers
		int[] common = findCommonElements(numbers1Dot1, numbers2Dot1);
		int[] commonAll = findCommonElements(common, numbers3Dot1);
		System.out.println("\nCommon Elements Between the 3 Arrays:\n---------------"
				+ "----------------------");
		display(commonAll, "Common Elements");

	}//end main
	
	//Methods
	//Display arrays
	public static void display(int[] array, String arrayName) {
	    System.out.print(arrayName + "\n***************\n");
	    for (int i = 0; i < array.length; i++) {
	        System.out.printf("array[%d] = %d\n", i, array[i]);
	    }//end for
	}//end display
		 
	//create new arrays without duplicates
	public static int[] createArrayWithoutDuplicates(int[] numbers) {
		int[] arrayTemp = new int[numbers.length];
		int counter = 0;
			for(int i = 0; i < numbers.length; i++) {
				boolean collision = false;
				for(int ii = 0; ii < arrayTemp.length; ii++) {
					if(numbers[i] == arrayTemp[ii]) {
						collision = true;
					}//end if
				}//end inner for
				if(collision == false) {
					arrayTemp[counter] = numbers[i];
					counter++;
				}//end if
			}//end outer for
		int[] result = new int[counter];
		for (int i = 0; i < counter; i++) {
			result[i] = arrayTemp[i];
		}//end for
		return result;
	}//end create array without duplicates
	
	//Find common elements
	public static int[] findCommonElements(int[] array, int[] array2) {
		int[] arrayTemp = new int[array.length];
		int counter = 0;
		for(int i = 0; i < array.length; i++) {
			boolean commonElement = false;
			for(int ii = 0; ii < array2.length; ii++) {
				if(array[i] == array2[ii]) {
					commonElement = true;
				}//end if
			}//end inner for
			if(commonElement == true) {
				arrayTemp[counter] = array[i];
				counter++;
			}//end if
		}//end outer for
		int[] result = new int[counter];
		for (int i = 0; i < counter; i++) {
			result[i] = arrayTemp[i];
		}//end for
		return result;
	}//end find common elements

}//end class Assig9
