/* Jackson Dahlke
 * CS1450 Mon-Wed, Mich
 * Mar. 18 2026
 * Assignment #7
 * This program creates an escape room and reads players from a file 
 * (rank, university, and name of player). The program then puts the players
 * into the escape room, creates a random score based on the hash of the 
 * name and rank. Then prints the results in order, proving the game is over.
 */

//imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

public class DahlkeJacksonAssignment7_1450 {

	public static void main(String[] args) throws IOException {
		
		//initialize the game variables
		GameController employeeJack = new GameController();
		Game hauntedEscape = new Game();
		File Players = new File("Players.txt");
		Scanner playerReader = new Scanner(Players);
		
		//add players to game reading from the file
		System.out.printf("Employee Jack: Adding Players to game");
		System.out.printf("\n---------------------------------------------------------------");
		while(playerReader.hasNext()) {
			int rank = playerReader.nextInt();
			String university = playerReader.next();
			String name = playerReader.next();
			Player newPlayer = new Player(name, rank, university);
			employeeJack.addPlayerToGame(hauntedEscape, newPlayer);
		}//end adding players
		
		//play the simulation and display the results
		employeeJack.simulateGame(hauntedEscape);
		employeeJack.displayResults(hauntedEscape);
		System.out.printf("\n%s", employeeJack.isGameOver(hauntedEscape));
		
		playerReader.close();
	}//end main
}//end assignment 6



class Player implements Comparable<Player>{
	
	//encapsulated variables
	private String name;
	private int ranking;
	private String university;
	private int score;
	
	//constructor
	public Player(String name, int ranking, String university){
		this.name = name;
		this.ranking = ranking;
		this.university = university;
		score = 0;
	}//end constructor
	
	
	//getters
	public String getName() {
		return name;
	}//end name getter
	
	public int getRank() {
		return ranking;
	}//end rank getter
	
	public String getUniversity() {
		return university;
	}//end university getter
	
	public int getScore() {
		return score;
	}//end score getter
	
	
	//setters
	public void setScore(int score) {
		this.score = score;
	}//end score setter
	
	
	//methods
	public String toString() {
		return String.format("%s %s %d", name, university, score);
	}//end player string format
	
	@Override
	public int compareTo(Player otherPlayer) {
		if(this.score == otherPlayer.score) {
			return 0;
		}//end equal if
		
		else if(this.score > otherPlayer.score) {
			return -1;
		}//end higher priority if (higher in queue)
		
		else {
			return 1;
		}//end lower priority if (lower in queue)
	}//end compare players method
}//end player class



class EscapeRoom{
	
	//methods
	private int hash(String key) {
		
		//create a random number value from incoming string
		int hash = 0;
		for(int i = 0; i < key.length(); i++) {
			hash += key.charAt(i);
			hash += (hash << 10);
			hash ^= (hash >> 6);
		}//end hash for
		hash += (hash << 3);
		hash ^= (hash >> 11);
		hash += (hash << 15);
		
		return Math.abs(hash);
	}//end key hash method
	
	public int tryToEscape(String playerName, int playerRanking) {
		
		//create a key using name/ranking, hash and calculate the score
		String key = playerName + playerRanking;
		int score = hash(key) % (101);
		return score;
	}//end escape method
}//end escape room class



class Game{
	
	//encapsulated variables
	private Queue<Player> waitingToPlay;
	private PriorityQueue<Player> results;
	private EscapeRoom escapeRoom;
	
	//constructor
	public Game() {
		waitingToPlay = new LinkedList<>();
		results = new PriorityQueue<>();
		escapeRoom = new EscapeRoom();
	}//end constructor
	
	
	//methods
	public boolean isWaitingToPlayEmpty() {
		
		if(waitingToPlay.isEmpty() == true) {
			return true;
		}//end true if
		else {
			return false;
		}//end false if
	}//end is waiting empty
	
	public void addPlayerToWaitingToPlay(Player player) {
		waitingToPlay.add(player);
	}//end add player to waitlist
	
	public Player removePlayerFromWaitingToPlay() {
		return waitingToPlay.remove();
	}//end remove player from waitlist
	
	
	public boolean isResultsEmpty() {
		
		if(results.isEmpty() == true) {
			return true;
		}//end true if
		else {
			return false;
		}//end false if
	}//end is results empty
	
	public void addPlayerToResults(Player player) {
		results.offer(player);
	}//end add player to results
	
	public Player removePlayerFromResults() {
			return results.remove();
	}//end remove player from results
	
	public Player peekResults() {
			return results.peek();
	}//end peek into results
	
	
	public int tryToEscape(String playerName, int playerRanking) {
		return escapeRoom.tryToEscape(playerName, playerRanking);
	}//end try to escape method
}//end game class



class PriorityQueue<E>{
	
	//encapsulated variables
	private ArrayList<Player> list;
	
	//constructor
	public PriorityQueue() {
		list = new ArrayList<Player>();
	}//end constructor
	
	
	//methods
	public boolean isEmpty() {
		return list.isEmpty();
	}//end empty method
	
	public Player peek() {
		
		if(list.isEmpty() == false) {
			return list.get(0);
		}//end false if
		else {
			return null;
		}//end null else
	}//end peek method
	
	public void offer(Player player) {
		list.add(player);
		Collections.sort(list);
	}//end offer method
	
	public Player remove() {
		
		if(list.isEmpty()) {
		    return null;
		}//end null if
		else {
			return list.remove(0);
		}
	}//end remove player method
	
}//end priority queue class



class GameController{
	
	//methods
	public void addPlayerToGame(Game game, Player player) {
		game.addPlayerToWaitingToPlay(player);
		System.out.printf("\nAdded to Game: %s", player.getName());
	}//end add a player to the game
	
	public void simulateGame (Game game) {
		
		System.out.printf("\n\nEmployee Jack: Starting Game, moving players to escape room.");
		System.out.printf("\n---------------------------------------------------------------");
		
		System.out.printf("\n%-10s%-15s%-5s%19s", "Player", "University", "Score", "Current Leader");
		System.out.printf("\n---------------------------------------------------------------");
		//cycle through waiting, send player to room, get score and print leaderboard
		while(!game.isWaitingToPlayEmpty()) {
			Player currentPlayer = game.removePlayerFromWaitingToPlay();
			int currentScore = game.tryToEscape(currentPlayer.getName(), currentPlayer.getRank());
			currentPlayer.setScore(currentScore);
			game.addPlayerToResults(currentPlayer);
			System.out.printf("\n%-10s%-15s%-10d%-15s", currentPlayer.getName(), currentPlayer.getUniversity(),
					currentPlayer.getScore(), game.peekResults().getName());
		}//end cycle through game wait list
		System.out.printf("\n---------------------------------------------------------------");
	}//end simulate game
	
	public void displayResults(Game game) {
		System.out.printf("\n\nEmployee Jack: Here are the escape room results");
		System.out.printf("\n---------------------------------------------------------------");
		System.out.printf("\n%-10s%-15s%-5s", "Player", "University", "Score");
		System.out.printf("\n---------------------------------------------------------------");
		while(!game.isResultsEmpty()) {
			Player currentPlayer = game.removePlayerFromResults();
			System.out.printf("\n%-10s%-15s%-5d", currentPlayer.getName(), currentPlayer.getUniversity(),
					currentPlayer.getScore());
		}//end cycle through results
	}//end display results
	
	public boolean isGameOver(Game game) {
		
		System.out.printf("\n\nEmployee Jack: Game over?");
		System.out.printf("\n---------------------------------------------------------------");
		if(!game.isResultsEmpty() && !game.isWaitingToPlayEmpty()) {
			return false;
		}//end false if
		else {
			return true;
		}//end true if
	}//end is game over
}//end game controller class