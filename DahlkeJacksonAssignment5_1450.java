/* Jackson Dahlke
 * CS1450 Mon-Wed, Mich
 * Feb. 25 2026
 * Assignment #5
 * This code can read data from a file, put it into a stack, sort the stack,
 * and put a chosen value at the bottom of said stack.
 */

//imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class DahlkeJacksonAssignment5_1450 {
	public static void main(String[] args) throws IOException{
		
		//variables
		Scanner userinput = new Scanner(System.in);
		
		
		//Part 1
		//Create random number stack from array, remove odd numbers, and print
		int[] numbers = {7,2,4,3,5,1,6,8,9};
		Stack<Integer> part1Numb = new Stack<>();
		for(int i = 0;i < numbers.length; i++) {
			part1Numb.push(numbers[i]);
		}//end for
		removeOddValues(part1Numb);
		System.out.println("Stack After Odd Values Removed");
		System.out.println("------------------------------");
		printStack(part1Numb);
		
		
		//Numbers.txt
		//create a scanner and file to read, fill a generic stack
		File numbersToStack = new File("Numbers.txt");
		Scanner fileInputNumbers = new Scanner(numbersToStack);
		GenericStack<Integer> part2Numb = new GenericStack<>();
		while (fileInputNumbers.hasNext()) {
			part2Numb.push(fileInputNumbers.nextInt());
		}//end while
		
		//Print, sort and print again
		System.out.println("Raw Values from File");
		System.out.println("--------------------");
		printGenericStack(part2Numb);
		sortStack(part2Numb);
		System.out.println("Sorted Values from File");
		System.out.println("--------------------");
		printGenericStack(part2Numb);
		
		//Move a user chosen value to the bottom, close file
		System.out.println("Please, choose a value to move to the bottom of the list");
		int part2NumbMoveValue = userinput.nextInt();
		while(moveToBottom(part2Numb, part2NumbMoveValue) == false) {
			System.out.println("Please, choose a value in the list");
			part2NumbMoveValue = userinput.nextInt();
		}//end while
		System.out.println("You Value at the bottom");
		System.out.println("-----------------------");
		printGenericStack(part2Numb);
		fileInputNumbers.close();
		
		
		//Strings.txt
		//create a scanner and file to read, fill a generic stack
		File stringsToStack = new File("Strings.txt");
		Scanner fileInputStrings = new Scanner(stringsToStack);
		GenericStack<String> part2Str = new GenericStack<>();
		while (fileInputStrings.hasNext()) {
			part2Str.push(fileInputStrings.next());
		}//end while
		
		//Print, sort, print again
		System.out.println("Raw Values from File");
		System.out.println("--------------------");
		printGenericStack(part2Str);
		sortStack(part2Str);
		System.out.println("Sorted Values From File");
		System.out.println("--------------------");
		printGenericStack(part2Str);
		
		//Move a user chosen value to the bottom, close file
		System.out.println("Please, choose a value to move to the bottom of the list");
		String part2StringMoveValue = userinput.next();
		while(moveToBottom(part2Str, part2StringMoveValue) == false) {
			System.out.println("Please, choose a value in the list");
			part2StringMoveValue = userinput.next();
		}//end while
		System.out.println("You Value at the bottom");
		System.out.println("-----------------------");
		printGenericStack(part2Str);
		fileInputStrings.close();
		
		userinput.close();
	}//end main
	
	
	//remove odd values method
	public static void removeOddValues(Stack<Integer> stack){
		
		//Create a tempStack from incoming stack
		Stack<Integer> tempStack = new Stack<>();
		for(int i = stack.size(); i > 0; i--) {
			tempStack.push(stack.pop());
		}//end for
		
		//If it's an even number, return value to original stack
		for(int i = tempStack.size(); i > 0; i--) {
			int tempNumber = tempStack.pop();
			if(tempNumber % 2 == 0) {
				stack.push(tempNumber);
			}//end if
		}//end for
	}//end remove odds
	
	
	//print specific stack method
	public static void printStack(Stack<Integer> stack) {
		
		//Print incoming value and put it into a temp stack
		Stack<Integer> tempStack = new Stack<>();
		while(!stack.isEmpty()) {
			int tempNumber = stack.pop();
			System.out.println(tempNumber);
			tempStack.push(tempNumber);
		}//end while
		
		//Put values back into original stack
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}//end while
	}//end print stack
	
	
	//print generic stack method
	public static <E> void printGenericStack(GenericStack<E> stack) {
		
		//Print incoming value and put it into a temp stack
		GenericStack<E> tempStack = new GenericStack<>();
		while(!stack.isEmpty()) {
			E tempVariable = stack.pop();
			System.out.println(tempVariable);
			tempStack.push(tempVariable);
		}//end while
		
		//Put values back into original stack
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}//end while
	}//end print generic stack
	
	//sort stack method
	public static <E extends Comparable<E>> void sortStack(GenericStack<E> stack) {
		
		//create a temp stack and get the size
	    GenericStack<E> sortedStack = new GenericStack<>();
	    int size = stack.getSize();

	    //cycle through stack, putting the smallest value on top
	    for (int i = 0; i < size; i++) {
	        E smallest = removeSmallest(stack);
	        sortedStack.push(smallest);
	    }//end for

	    //Move back to original stack
	    while (!sortedStack.isEmpty()) {
	        stack.push(sortedStack.pop());
	    }//end while
	}//end sortStack
	
	
	//remove the smallest value method
	public static <E extends Comparable<E>> E removeSmallest(GenericStack<E> stack) {
		
		//create a temp stack, take the first value off
		GenericStack<E> tempStack = new GenericStack<>();
		E smallest = stack.pop();
		tempStack.push(smallest);
		
		//cycle through stack, find smallest value and add to temp stack
	    while (!stack.isEmpty()) {
	        E current = stack.pop();
	        if (current.compareTo(smallest) < 0) {
	            smallest = current;
	        }//end if
	        tempStack.push(current);
	    }//end while

	    //add values to original stack, dont add the smallest value
	    boolean removed = false;
	    while (!tempStack.isEmpty()) {
	        E current = tempStack.pop();
	        if (current.equals(smallest) && removed == false) {
	            removed = true;
	        } //end if
	        else {
	            stack.push(current);
	        }//end else
	    }//end while
	    //return smallest value
		return smallest;
	}//end remove smallest
	
	
	//move values to bottom method
	public static <E> boolean moveToBottom(GenericStack<E> stack, E valueToMove) {
		
		//create a temp stack, boolean to return and users move value
		GenericStack<E> tempStack = new GenericStack<>();
		boolean found = false;
		E moveValue = null;
		
		//cycle through stack, find move value, change boolean, save value
		while(!stack.isEmpty()) {
			E tempValue = stack.pop();
			if(tempValue.equals(valueToMove) && found == false) {
				moveValue = tempValue;
				found = true;
			}//end if
			else{
				tempStack.push(tempValue);
			}//end else
		}//end while
		
		//if value not found, return false
	    if(found == false) {
	        while(!tempStack.isEmpty()) {
	            stack.push(tempStack.pop());
	        }//end while
	        return false;
	    }//end if
	    
	    //value found, return to main
		stack.push(moveValue);
		while (!tempStack.isEmpty()) {
	        stack.push(tempStack.pop());
	    }//end while
		return true;
	}//end move to bottom
}//end class


//generic stack class
class GenericStack<E>{
	
	//variables
	private ArrayList<E> genericStack;
	
	//constructor
	public GenericStack() {
		genericStack = new ArrayList<>();
	}//end constructor
	
	//behaviors
	public boolean isEmpty() {
		return genericStack.isEmpty();
	}//end behavior
	
	public int getSize() {
		return genericStack.size();
	}//end behavior
	
	public E peek() {
		if (isEmpty()) {
			 throw new IllegalArgumentException("Cannot peak into an empty stack.");
	    }//end if
		return genericStack.get(genericStack.size() - 1);
	}//end behavior
	
	public E pop() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Cannot pop an empty stack.");
	    }//end if
		return genericStack.remove(genericStack.size() - 1);
	}//end behavior

	public void push(E value) {
		genericStack.add(value);
	}//end behavior
	
}//end stack class