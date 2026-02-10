/* Jackson Dahlke
 * CS1150 Mon-Wed, Mich
 * Nov.12, 2025
 * Assignment #10
 * The purpose of this code is to create a tree and forest object
 * to store tree variables in an array and a forest object. Then print
 * and find the tallest tree in each.
 */

//imports
public class DahlkeJacksonAssignment10 {

	public static void main(String[] args) {
		Tree[] trees = new Tree[7];
		//Build the trees
		Tree tree1 = new Tree("Giant Sequoia", 275);
		Tree tree2 = new Tree("Fremont Cottonwood", 68);
		Tree tree3 = new Tree("Sitka Spruce", 330);
		Tree tree4 = new Tree("Coast Douglas Fir", 297);
		Tree tree5 = new Tree("Coastal Redwood", 379);
		Tree tree6 = new Tree("Southern Magnolia", 87);
		Tree tree7 = new Tree("White Oak", 144);
		
		//Add them to the array
		trees[0] = tree1;
		trees[1] = tree2;
		trees[2] = tree3;
		trees[3] = tree4;
		trees[4] = tree5;
		trees[5] = tree6;
		trees[6] = tree7;
		
		//Display the OG array
		System.out.println("********************************\n"
				+ "        Trees in Array\n"
				+ "********************************");
		displayArray(trees);
		
		//find the tallest tree
		Tree tallestTree = findTallestTree(trees);
		System.out.println("\n********************************\n"
				+ "          Tallest Tree\n"
				+ "********************************");
		System.out.printf("Tree: %s\nHeight: %d\n", tallestTree.getType(), 
				tallestTree.getHeight());
		
		//forest of trees
		Forest rocky = new Forest("Rocky Forest", 200);
		rocky.addTree(tree1);
		rocky.addTree(tree2);
		rocky.addTree(tree3);
		rocky.addTree(tree4);
		rocky.addTree(tree5);
		rocky.addTree(tree6);
		rocky.addTree(tree7);
		System.out.println("\n********************************\n"
				+ "        Trees in Forest\n"
				+ "********************************");
		rocky.displayForest();
		Tree tallestInForest = rocky.findTallestTreeInForest();
		System.out.println("\n********************************\n"
				+ "          Tallest Tree\n"
				+ "********************************");
		System.out.printf("Tree: %s\nHeight: %d", tallestInForest.getType(), 
				tallestInForest.getHeight());
		
	}//end main
	
	//display
	public static void displayArray(Tree[] array) {
	    System.out.printf("--------------------------------"
	    		+ "\n%-25s%s\n"
	    		+ "--------------------------------\n", 
	    		"Trees", "Height");
	    for (int i = 0; i < array.length; i++) {
	        System.out.printf("%-25s%d\n", array[i].getType(),
	        		array[i].getHeight());
	    }//end for
	}//end display
	
	//Find the tallest tree
	public static Tree findTallestTree(Tree[] array) {
		Tree tallestTree = new Tree("", 0);
		for (int i = 0; i < array.length; i++) {
			if(tallestTree.getHeight() < array[i].getHeight()){
				tallestTree = array[i];
			}//end if
		}//end for
		return tallestTree;
	}//end tallest tree
	
}//end class Assign10

//tree class
class Tree {
	//variables
	private String type;
	private int height;
	
	public Tree(String type, int height) {	
		this.type = type;
	    this.height = height;
	}//this is the constructor, nothing needed more
	
	public String getType(){
		return type;
	}//return the type of tree
	
	public int getHeight() {
		return height;
	}//return the height of the tree
	
}//end tree class

//forest class and objects
class Forest{
	//variables
	private String name;
	private int maxTrees;
	private Tree[] trees;
	private int treeCounter;
	
	public Forest(String name, int maxTrees) {
		this.name = name;
		this.maxTrees = maxTrees;
		this.trees = new Tree[maxTrees];
	}//end constructor
	
	//getter for name
	public String name() {
		return name;
	}//end getname
	
	public void addTree(Tree treeToAdd) {
		if(treeCounter < maxTrees) {
			trees[treeCounter] = treeToAdd;
			treeCounter++;
		}//end if
	}//end addtree
	
	//display
	public void displayForest() {
	    System.out.printf("--------------------------------"
	    		+ "\n%-25s%s\n"
	    		+ "--------------------------------\n", 
	    		"Trees", "Height");
	    for (int i = 0; i < treeCounter; i++) {
	        System.out.printf("%-25s%d\n", trees[i].getType(),
	        		trees[i].getHeight());
	    }//end for
	}//end display
	
	//Find the tallest tree
	public Tree findTallestTreeInForest() {
		Tree tallestTree = new Tree("", 0);
		for (int i = 0; i < treeCounter; i++) {
			if(tallestTree.getHeight() < trees[i].getHeight()){
				tallestTree = trees[i];
			}//end if
		}//end for
		return tallestTree;
	}//end tallest tree
	
}//end forest class