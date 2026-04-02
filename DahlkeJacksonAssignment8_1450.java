/* Jackson Dahlke
 * CS1450 Mon-Wed, Mich
 * Apr. 01 2026
 * Assignment #8
 * This code is a decryption algorithm using an array of key letters
 * with coordinates to the letters in the array that creates a decrypted 
 * message printed.
 */

//imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;


public class DahlkeJacksonAssignment8_1450 {

	public static void main(String[] args) throws IOException{
		
		//name files, create scanners
		File Grid = new File("CodeGrid.txt");
		File Message = new File("Message.txt");
		Scanner gridReader = new Scanner(Grid);
		Scanner messageReader = new Scanner(Message);
		
		//get the size of the "key" array
		int gridRows = gridReader.nextInt();
		int gridColumns = gridReader.nextInt();
		
		
		//create a decode machine, and array list, fill the array list with
		//grid values and create an iterator for it.
		CodeMachine dots = new CodeMachine(gridRows, gridColumns);
		ArrayList<Character> key = new ArrayList<>();
		
		while(gridReader.hasNext()) {
			Character singleLetter = gridReader.next().charAt(0);
			key.add(singleLetter);
		}//end array for key while
		
		Iterator<Character> paramore = key.iterator();
		
		//create a queue, fill the queue with
		//message coordinates using code elements and create an iterator for it.
		Queue<CodeElement> encoded = new LinkedList<>();
		
		while(messageReader.hasNext()) {
			int rows = messageReader.nextInt();
			int columns = messageReader.nextInt();
			CodeElement addDecrypt = new CodeElement(rows, columns);
			encoded.add(addDecrypt);
		}//end array for encoded while
		
		Iterator<CodeElement> toBeDecoded = encoded.iterator();
		
		
		//load the grid with characters, decode the message and print the grid/decoded
		//message
		dots.loadCodeGrid(paramore);
		System.out.println("Grid");
		System.out.println("----------");
		dots.displayCodeGrid();
		Iterator<Character> decoded = dots.decode(toBeDecoded);
		System.out.println("\nDecoded Message");
		System.out.println("---------------------");
		while(decoded.hasNext()) {
			System.out.printf("%c", decoded.next());
		}//end print while
		
		//close the scanners
		gridReader.close();
		messageReader.close();
	}//end main
}//end assignment 8 class



class CodeElement{
	
	//encapsulated variables
	private int row;
	private int column;
	
	//constructor
	public CodeElement(int row, int column) {
		this.row = row;
		this.column = column;
	}//end constructor
	
	
	//getters
	public int getRow() {
		return row;
	}//end get row
	
	public int getColumn() {
		return column;
	}//end get column
}//end code element



class CodeMachine{
	
	//encapsulated variables
	private char[][] codeGrid;
	private int numRows;
	private int numColumns;
	
	//constructor
	public CodeMachine(int numRows, int numColumns) {
		this.numRows = numRows;
		this.numColumns = numColumns;
		codeGrid = new char[numRows][numColumns];
	}//end constructor
	
	
	//methods
	public void loadCodeGrid(Iterator<Character> characterIterator) {
		
		//iterate through the grid, fill it with character values
		for(int r = 0; r < numRows; r++) {
			for(int c = 0; c < numColumns; c ++) {
				codeGrid[r][c] = characterIterator.next();
			}//end inner for
		}//end outer for
	}//end load code grid
	
	public Iterator<Character> decode(Iterator<CodeElement> messageIterator){
		
		//create an array list, fill it with characters with coordinates from code elements plugged
		//into the grid array
		ArrayList<Character> decodedMessage = new ArrayList<>();
		while(messageIterator.hasNext()) {
			CodeElement tempValue = messageIterator.next();
			Character decodedCharacter = codeGrid[tempValue.getRow()][tempValue.getColumn()];
			decodedMessage.add(decodedCharacter);
		}//end decode message iteration
		return decodedMessage.iterator();
	}//end decode
	
	public void displayCodeGrid() {
		
		//iterate through the grid,print it 1 for 1
		for(int r = 0; r < numRows; r++) {
			for(int c = 0; c < numColumns; c ++) {
				System.out.printf("%c ", codeGrid[r][c]);
			}//end inner for
			System.out.println("");
		}//end outer for
	}//end display grid
}//end code machine