package simple21_6;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


/**
 * This is a simplified version of a common card game, "21". 
 */
public class GameControl {
    
	//Fields (instance variables)
	/**
	 * Human player.
	 */
    HumanPlayer human;
    
    /**
     * Computer player.
     */
    ComputerPlayer player1;
    
    /**
     * Computer player.
     */
    ComputerPlayer player2;
    
    /**
     * Computer player.
     */
    ComputerPlayer player3;
    
    /** 
     * A random number generator to be used for returning random "cards" in a card deck.
     * */
    Random random = new Random();
      
    
    /**
     * The main method just creates a GameControl object and calls its run method.
     * @param args Not used.
     */
    public static void main(String args[]) {    
        new GameControl().run();
    }
    
    /**
     * Prints a welcome method, then calls methods to perform each of the following actions:
     * - Create the players (one of them a Human)
     * - Deal the initial two cards to each player
     * - Control the play of the game
     * - Print the final results
     */
    public void run() {
    	
        Scanner scanner = new Scanner(System.in);
        
        // Students: your code goes here.
        //welcome messages
        System.out.println("Welcome to Simple 21!");
        System.out.println("You'll play against 3 other players (computers).");
        System.out.println("Try to get as close to 21 as possible, without going over.");
        System.out.println("Welcome to Simple 21!");
        
        //get player name and create human players and computer players
        System.out.println("What is your name?");
        String humanName = scanner.next();
        this.createPlayers(humanName);
        
        //deal card and print out human player both cards (for the player), and inform human player the visible cards of computer players
        this.deal();
        System.out.println("\n");
        
        //print out current total score for human player and current total VISIBLE score for computer players
        
        this.controlPlay(scanner);
        
        System.out.println("\n");
        
        this.printResults();
       
        
        scanner.close();
    }
    
    /**
     * Creates one human player with the given humansName, and three computer players with hard-coded names.
     * @param humansName for human player
     */
    public void createPlayers(String humansName) {
       // Students: your code goes here.
    	
    	//create one human player, 3 computer player
    	this.human = new HumanPlayer(humansName);
    	this.player1 = new ComputerPlayer("Player 1");
    	this.player2 = new ComputerPlayer("Player 2");
    	this.player3 = new ComputerPlayer("Player 3");
    	
       
    }
    
    /**
     * Deals two "cards" to each player, one hidden, so that only the player who gets it knows what it is, 
     * and one face up, so that everyone can see it. (Actually, what the other players see is the total 
     * of each other player's cards, not the individual cards.)
     */
    public void deal() { 
        // Students: your code goes here.
    	
    	//deal human player 1 hidden 1 visible card
    	this.human.takeHiddenCard(nextCard());
    	this.human.takeVisibleCard(nextCard());
    	
    	//deal computer player 1 hidden 1 visible card
    	this.player1.takeHiddenCard(nextCard());
    	this.player1.takeVisibleCard(nextCard());
    	
    	//deal computer player 2 hidden 1 visible card
    	this.player2.takeHiddenCard(nextCard());
    	this.player2.takeVisibleCard(nextCard());
    	
    	//deal computer player 3 hidden 1 visible card
    	this.player3.takeHiddenCard(nextCard());
    	this.player3.takeVisibleCard(nextCard());
    	
    	
    }
    
    /**
     * Returns a random "card", represented by an integer between 1 and 10, inclusive. 
     * The odds of returning a 10 are four times as likely as any other value (because in an actual
     * deck of cards, 10, Jack, Queen, and King all count as 10).
     * 
     * Note: The java.util package contains a Random class, which is perfect for generating random numbers.
     * @return a random integer in the range 1 - 10.
     */
    public int nextCard() 
    { 
    	// Students: your code goes here.
    	int faceValue = random.nextInt(13) + 1; 
    	int card = 0;
    	
    	//1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 is 13 numbers in total, the chance of getting 10 when random faceValue = 10, 11, 12, 13 (position index-wise)
    	if (9 < faceValue && faceValue < 14) { 
    		card = 10;
    	}
    	
    	//the chance of getting 0~9 is when faceValue is from 1 to 9
    	else if (0 < faceValue && faceValue <= 9) {
    		card = faceValue;
    	}
    	
    	return card;
    }

    /**
     * Gives each player in turn a chance to take a card, until all players have passed. Prints a message when 
     * a player passes. Once a player has passed, that player is not given another chance to take a card.
     * @param scanner to use for user input
     */
    public void controlPlay(Scanner scanner) { 
        // Students: your code goes here.

    	//check all pass
    	
    	//while loop: while (!checkAllPassed)
        while (!this.checkAllPassed()) {
	        
        	// if human has not passed, offer card to human player
	        if (this.human.passed == false) {
	        	if (this.human.offerCard(this.human, this.player1, this.player2, this.player3, scanner) == true) {
	        		this.human.takeVisibleCard(nextCard());
	        		}
	        	else {
	        		System.out.println(this.human.name + " passes.");
	        		}
	        	}
	        
	        //if player1 has not passed and wants to take a card, 
	        if (this.player1.passed == false) { 
	        	if (this.player1.offerCard(this.human, this.player1, this.player2, this.player3) == true) {
	        		//provide card and print messages
		        	this.player1.takeVisibleCard(nextCard());
		        	}
	        	else {
	        		System.out.println("Player 1 passes.");
	        		}
	        	}
	        
	        if (this.player2.passed == false) {
	        	if(this.player2.offerCard(this.human, this.player1, this.player2, this.player3) == true) {
	        		//provide card and print messages
	        		this.player2.takeVisibleCard(nextCard());
	        		}
	        	else {
	        			System.out.println("Player 2 passes.");
	       			}
	        	}
	        
	        
	        if (this.player3.passed == false) {
	        	if(this.player3.offerCard(this.human, this.player1, this.player2, this.player3) == true) {
	        		//provide card and print messages
	        		this.player3.takeVisibleCard(nextCard());
	        		}
	        	else {
	        		System.out.println("Player 3 passes.");
	        		}
	        	}
	        System.out.println("\n");
        	}
        }

        
 
     
       	
    /**
     * Checks if all players have passed.
     * @return true if all players have passed
     */
    public boolean checkAllPassed() 
    {
    	// Students: your code goes here.
    	if (this.human.passed == true && this.player1.passed == true && this.player2.passed == true && this.player3.passed == true) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     * find the minimum number of the given "list"/array
     * @param list
     * @return minimum number of the given "list"/array
     */
    public int findMin(int[] list) {
    	int minDiff = list[0];
    	for (int i = 1; i < list.length; i++) {
    		if (list[i] < minDiff) {
    			minDiff = list[i];
    		}
    	}
    	return minDiff;
    }
    
    //this is just for my self learning purpose, not for the assignment.
    public int findMinWrong(int[] list) {
    	int minDiff = list[0];
    	for (int i = 1; i < list.length; i++) {
    		if (list[i] <= minDiff) {
    			minDiff = list[i];
    		}
    		else return minDiff;
    		//return here in situation such as: find the first 5. 
    	}
    	return minDiff;
    }
    
    public boolean smallestScoreDuplicate(int[] list ) {
    	
    	Arrays.sort(list);
    	int i = 0;
    	if (list[i] == list[i + 1]) {
    		return true;
    	}
    	
    	else return false;
    }
    
    /**                                           
     * Prints a summary at the end of the game.
     * Displays how many points each player had, and if applicable, who won.
     */
    public void printResults() { 
        // Students: your code goes here.
    	System.out.println("Game Over." + "\n" + 
        this.human.name + " has " + this.human.getScore() + " total points." + "\n" + 
    			"Player 1 has " + this.player1.getScore() + " total points." + "\n" +
        "Player 2 has " + this.player2.getScore() + " total points." + "\n" + 
    			"Player 3 has " + this.player3.getScore() + " total points.");
    	this.printWinner();
    }

    /**
     * Determines who won the game, and prints the results.
     */
    public void printWinner() { 
        // Students: your code goes here.
int [] scoreList = {this.human.diffTo21(), this.player1.diffTo21(), this.player2.diffTo21(), this.player3.diffTo21()};
    	
    	int theMinDiff = this.findMin(scoreList);
    	
    	if (this.checkAllPassed() == true) {
    		
    		//if 2 players have duplicate highest score, tie, no one wins
    		if (this.smallestScoreDuplicate(scoreList) == true) {
    			System.out.println("Tie, nobody wins.");
    		}
    		
    		//if all 4 players exceed 21 points, no one wins
    		else if (this.human.diffTo21() == 21 && this.player1.diffTo21() == 21 && this.player2.diffTo21() ==21 && this.player3.diffTo21() == 21) {
    			System.out.println("All four players exceed 21 points. No one wins!");
    		}
    		
    		
    		else {
	    		//if human is the one closes or equal to 21, human wins
	    		if (this.human.diffTo21() == theMinDiff) {
	    			System.out.println(this.human.name + " wins with " + this.human.getScore() + " point(s)!");
	    		}
	    		
	    		//if player1 is the one closes or equal to 21, player1 wins
	    		if (this.player1.diffTo21() == theMinDiff) {
	    			System.out.println(this.player1.name + " wins with " + this.player1.getScore() + " point(s)!");
	    		}
	    		
	    		//if player2 is the one closes or equal to 21, player2 wins
	    		if (this.player2.diffTo21() == theMinDiff) {
	    			System.out.println(this.player2.name + " wins with " + this.player2.getScore() + " point(s)!");
	    		}
	    		
	    		//if player3 is the one closes or equal to 21, player3 wins
	    		if (this.player3.diffTo21() == theMinDiff) {
	    			System.out.println(this.player3.name + " wins with " + this.player3.getScore() + " point(s)!");
	    		}
    		}
    		
    	}
    }
}