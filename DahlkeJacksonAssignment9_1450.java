/* Jackson Dahlke
 * CS1450 Mon-Wed, Mich
 * Apr. 08 2026
 * Assignment #9
 * This algorithm creates a linked list based on words read from a file. Then removes them,
 * if the word is not alphabetical, then sorts remaining nodes based on the first letter
 * (alphabetically). Then takes those nodes to create a double linked list, printing the 
 * results along the way.
 */

//imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DahlkeJacksonAssignment9_1450 {

	public static void main(String[] args)  throws IOException{
		
		//varibales
		WordLinkedList wordList = new WordLinkedList();
		DoubleLinkedList doubleWordList = new DoubleLinkedList();
		File wordFile = new File("Words.txt");
		Scanner fileInput = new Scanner(wordFile);
		
		//fill the wordList
		while(fileInput.hasNext()) {
			Word cWord = new Word(fileInput.nextLine());
			wordList.addInFront(cWord);
		}//end while
		
		//print the original wordList
		System.out.println("Original List\n");
		System.out.println("Word\t\tAbecedarian Status");
		System.out.println("-------------------");
		wordList.printList();
		
		//remove none alphabetical words, print how many are removed and the list
		int numberOfWordsRemoved = wordList.removeNonAbecedarianWords();
		System.out.println("\nNumber of Words Removed");
		System.out.println("-------------------");
		System.out.println(numberOfWordsRemoved);
		System.out.println("\nList With Words Removed");
		System.out.println("\nWord\t\tAbecedarian Status");
		System.out.println("-------------------");
		wordList.printList();
		
		//bubblesort the list, print
		System.out.println("\nOrganized List");
		System.out.println("\nWord\t\tAbecedarian Status");
		System.out.println("-------------------");
		wordList.bubbleSort();
		wordList.printList();
		
		//create a double linked list based on the first list, print backwards
		doubleWordList.build(wordList);
		System.out.println("\nBubble Sorted List");
		System.out.println("\nWord\t\tAbecedarian Status");
		System.out.println("-------------------");
		doubleWordList.printListBackwards();
		System.out.println("\nWords in Single Link List");
		System.out.println("-------------------");
		System.out.println(wordList.getSize());
		
		//close scanner
		fileInput.close();
	}//end main
}//end assignment 9 class



class Word implements Comparable<Word>{
	
	//private variables
	private String letters;
	private boolean abecedarian;

	//constructor
	public Word(String letters) {
		this.letters = letters;
		this.abecedarian = abecedarianTest();
	}//end constructor
	
	//getters
	public boolean isAbecedarian() {
		return abecedarian;
	}//end get boolean
	
	
	//methods
	private boolean abecedarianTest() {
		//cycle through word, test if every letter is in alphabetical order
		
		for(int i = 0; i < letters.length() -1; i++) {
			if(letters.charAt(i) > letters.charAt(i + 1)) {
				//if one letter out of order, set false
				return false;
			}//end if
		}//end for
		//if false not returned, return true
		return true;
	}//end letter sort test
	
	
	public String print() {
		
		return String.format("%s\t\t%b\n", letters, abecedarian);
	}//end print
	
	
	public int compareTo(Word otherWord) {
		//test the first letter in each, if equal, return one, if first
		//letter is less than second return 1, else return -1.
		
		if(this.letters.charAt(0) == otherWord.letters.charAt(0)) {
			return 0;
		}//end if
		else if(this.letters.charAt(0) < otherWord.letters.charAt(0)) {
			return 1;
		}//end else if
		return -1;
	}//end compare to
}//end word class



class WordLinkedList{
	
	//private varibales
	private Node head;
	private int size;
	
	//constructor
	public WordLinkedList() {
	}//end constructor
	
	//getters
	public int getSize() {
		return size;
	}//end getter
	
	
	//methods
	public void addInFront(Word wordToAdd) {
		//create new node, if list empty set to head,
		//if not set incoming next to head, set head to incoming, incrament size.
		
		Node cNode = new Node(wordToAdd);
		//if list is empty
		if(size == 0) {
			head = cNode;
		}//end if
		else {
			cNode.next = head;
			head = cNode;
		}//end else
		size++;
	}//end add in front
	
	
	public int removeNonAbecedarianWords() {
		//create current and previous nodes, and varibale for how many words removed,
		//while the current node isn't null and if the previous node is null set head 
		//to next-else, set previous node's next to current nodes next, decrament size 
		//and incrament removed words otherwise, set previous node to current node and 
		//set current node to current nodes next. Return words removed.
		
		Node cNode = head;
		Node pNode = null;
		int wordsRemoved = 0;
	    while (cNode != null) {
	        if (!cNode.data.isAbecedarian()) {
	            if (pNode == null) {
	                // removing head
	                head = cNode.next;
	            }//end if 
	            else {
	                pNode.next = cNode.next;
	            }//end else
	            size--;
	            wordsRemoved++;
	        }//end if
	        else {
	            pNode = cNode;
	        }//end else
	        cNode = cNode.next;
	    }//end while
		return wordsRemoved;
	}//end remove no compliant words
	
	
	public Word removeFirstNode() {
		//if there is nothing in the list, return null, otherwise, create a current node and
		//set it to the head, if there is no other nodes in the list, return null and otherwise
		//set the head to the next node, decrament size and return the data in current node.
		
		if(size == 0) {
			return null;
		}//end if
		else {
			Node cNode = head;
			if(head.next == null) {
				head = null;
			}//end if
			else {
				head = head.next;
			}//end else
			size--;
			return cNode.data;
		}//end else
	}//end remove first node
	
	
	public void bubbleSort() {
		//Cycle through list, create a current node, cycle through the list minus the itteration
		//as in each itteration the end of the list gets more and more sorted. If compare to
		//returns a less than one value, swap the values, otherwise set the current node to the
		//next node
		
		for(int i = 1; i < size; i++) {
			Node cNode = head;
			for(int j = 0; j <  size - i; j++) {
				Node nNode = cNode.next;
				if(cNode.data.compareTo(nNode.data) < 0) {
					swapNodeData(cNode, nNode);
				}//end if
				cNode = cNode.next;
			}//end for
		}//end for
	}//end bubble sort
	
	
	public void swapNodeData(Node node1, Node node2) {
		//create a temp for 1, swap 1 and 2, set 2 to temp of the data
		
		Word temp = node1.data;
		node1.data = node2.data;
		node2.data = temp;
	}//end swap node data
	
	
	public void printList() {
		
		Node cNode = head;
		while(cNode != null) {
			System.out.printf("%s", cNode.data.print());
			cNode = cNode.next;
		}//end for
	}//end print list
	
	
	private static class Node{
		
		//private variables
		private Word data;
		private Node next;
		
		//constructor
		public Node(Word word) {
			this.data = word;
			next = null;
		}//end constructor
	}//end node class
}//end linked list class



class DoubleLinkedList{
	
	//private variables
	private Node head;
	private Node tail;
	
	//constructor
	public DoubleLinkedList() {
	}//end constructor
	
	
	//methods
	public void build(WordLinkedList wordList) {
		//get the number of nodes, iterate through that and recreate the linked list,
		//but use the tail and header from this class of nodes. If the head is null,
		//set the tail and head to incoming node, otherwise add the incoming node to
		//the next of the previous node and set the incoming node to the tail.
		
		int numberOfNodes = wordList.getSize();
		for(int i = 0; i < numberOfNodes; i++) {
			Word cWord = wordList.removeFirstNode();
			Node cNode = new Node(cWord);
			
			if(head == null) {
				head = cNode;
				tail = cNode;
			}//end if
			else {
				tail.next = cNode;
				cNode.previous = tail;
				tail = cNode;
			}//end else
		}//end for
	}//end build double list
	
	
	public void printListBackwards() {
		//print the list in reverse order, from tail
		
		Node cNode = tail;
		while(cNode != null) {
			System.out.printf("%s", cNode.data.print());
			cNode = cNode.previous;
		}//end for
	}//end print list backwards
	
	
	private static class Node{
		
		//private variables
		private Word data;
		private Node next;
		private Node previous;
		
		//constructor
		public Node(Word word) {
			this.data = word;
			next = null;
			previous = null;
		}//end constructor
	}//end node class
}//end double linked list class