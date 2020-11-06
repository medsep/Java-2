package Simple21;

import java.util.Scanner;
import java.util.Random;

/**
 * This is a simplified version of a common card game, "21".<p>
 * In this game, the dealer deals two "cards" to each player,
 * one hidden, so that only the player who gets the card knows
 * what it is, and one face up, so that everyone can see it.
 * (Actually, what the other players see is the <i>total</i>
 * of each other player's visible cards, not the individual cards.)<p>
 *
 * The players then take turns requesting cards, trying to get
 * as close to 21 as possible, but not going over 21. These cards
 * will be visible to all players.  A player may pass (ask for no
 * more cards). Once a player has passed, he or she cannot later
 * ask for another card. When all players have passed, the
 * game ends.<p>
 *
 * The winner is the player who has come closest to 21 without
 * exceeding it. In the case of a tie, or if everyone goes over
 * 21, no one wins.<p>
 *
 * In this program, there are some number of computer players
 * and one human player. The game is only played once. 
 * 
 * @author David Matuszek
 * @author (Students: Shuting Sun) 
 * @version 0
 */
public class GameControl {
    
    /** All the Player objects, including the Human player.
     * The number of players is set here; other places in the
     * program should use <code>players.length</code>. */
    Player[] players = new Player[4];
    
    /** passed[i] == true indicates that players[i] has passed. */
    boolean[] passed = new boolean[] {false, false, false, false};
    
    /** Used for getting input from the user. */
    Scanner scanner = new Scanner(System.in);
    
    /** A random number generator. */
    Random random = new Random();
      
    /**
     * The main method just creates a GameControl object and calls
     * its <code>run</code> method.
     * 
     * @param args Not used.
     */
    public static void main(String args[]) {    
        // Students: your code goes here.
    	new GameControl().run(); // Escape from static
    }
    
    /**
     * Prints a welcome method, then calls methods to perform each
     * of the following actions:
     * <ol>
     *   <li>Create the Players (one of them a Human),</li>
     *   <li>Deal the initial two cards to each player,</li>
     *   <li>Control the play of the game, and</li>
     *   <li>Print the final results.</li>
     * </ol>
     */
    void run() { 
        // Students: your code goes here.
    	// Prints a welcome message.
    	System.out.println("Welcome to the game of 21!");
    	// 1. Create the Players (one of them a Human)
    	createPlayers();
    	// 2. Deal the initial two cards to each player
    	deal();
    	// 3. Control the play of the game
    	controlPlay();
    	// 4. Print the final results
    	printResults();	
    }
    
    /**
     * Asks the human player for a name, and then creates a Human
     * object and all the other Player objects, saving them in the
     * <code>players</code> array. (Names of the other players may
     * be hardwired; don't ask the user for them.)
     */
    void createPlayers() {
        System.out.print("What is your name?  ");
        String humansName = scanner.next();
        // Students: your code goes here.
        // A Human object
        Human aHuman = new Human(humansName);
        // All the other Player objects
        players[0] = aHuman;
        players[1] = new Player("Sun");
        players[2] = new Player("Depp");
        players[3] = new Player("Pitt");
    }
    
    /**
     * Deals the initial two cards (one hidden, one not hidden)
     * to each player.
     */
    void deal() { 
        // Students: your code goes here.
    	for(Player player:players)
    	{
    		int hidden = nextCard();
    		int visible = nextCard();
    		player.takeVisibleCard(visible);
    		player.takeHiddenCard(hidden);	
    	}
    }
    
    /**
     * Returns a random "card", represented by a integer between
     * 1 and 10, inclusive. The odds of returning a 10 are four
     * times as likely as any other value (because in an actual
     * deck of cards, 10, Jack, Queen, and King all count as 10).<br />
     * <b>Note:</b> The java.util package contains a <code>Random</code>
     * class, which is perfect for generating random numbers.
     *
     * @return a random integer in the range 1..10.
     */
    int nextCard() { 
        // Students: your code goes here.
    	// Generate a number between 1 and 13.
    	int aCard = random.nextInt(13) + 1;
    	// When the random number is bigger than 10, it would be converted to 10.
    	if(aCard > 10) {
             aCard = 10;
    	}    		
    	return aCard;
    }

    /**
     * Gives each player in turn a chance to take a card, until all
     * players have passed. Prints a message when a player passes.
     * Once a player has passed, that player is not given another
     * chance to take a card.<br />
     * <b>Note:</b> The global array <code>passed</code> is used to
     * keep track of which players have passed.
     */
    void controlPlay() { 
        // Students: your code goes here.
    	
    	int count = 0;
    	while(count != 4)
    	{
    		System.out.println();
    		for(int i = 0; i < 4; i++)
    		{
    			if(!passed[i])
    			{
    				if(players[i].offerCard(players))
    				{
    					int acard = nextCard();
    					players[i].takeVisibleCard(acard);
    				}
    				else
    				{
    					passed[i] = true;
    					count++;
    					System.out.println(players[i].name + " passes.");
    				}
    			}  	
    		}
    	}
    }
    
    /**
     * Prints a summary at the end of the game, saying how many
     * points each player had, and who won.
     */
    void printResults() { 
        // Students: your code goes here.
    	System.out.println();
    	System.out.println("Game Over.");
    	for (Player player : players)
    	{
    		System.out.println(player.name + " has " + player.getScore() + " points.");
    	}
    	if (findWinningPlayer() == -1)
    		System.out.println("Nobody wins.");
    	else
    	{   
    		int theIndex = findWinningPlayer();
    		System.out.println(players[theIndex].name + " wins with " + players[theIndex].getScore() + " points!");
    	}
    }

    /**
     * Determines who won the game, and returns it as an index into
     * the players array.
     * 
     * @return The index of the winner, or -1 if nobody won.
     */
    int findWinningPlayer() { 
        // Students: your code goes here.
    	
    	int maxCard = 0;
    	int count = 0;
    	int theIndex = 0;
    	// We need to find those players whose points are less or equal to 21.
    	// From them, we pick the biggest one.
    	for (int i = 0; i < 4; i ++)
    	{
    		if (players[i].getScore() > maxCard && players[i].getScore() <= 21)
    			maxCard = players[i].getScore();
    	}
    	// If more than one players attain the biggest, we have to return -1, since no one wins.
    	// If only one player attain the biggest, we could then return the index of the player.
    	for (int i = 0; i < 4; i ++)
    	{
    	   if (maxCard == players[i].getScore())
    	   {
    		   count++;
    		   theIndex = i;
    	   }
    	}
    	if (count == 1)
    		return theIndex;
    	else
    		return -1;  		
    }
}
