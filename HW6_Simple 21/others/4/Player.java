package Simple21;

/**
 * Represents a player in this simplified version of the
 * "21" card game.
 * 
 * @author David Matuszek
 * @author (Students: Shuting Sun)
 * @version 0
 */
public class Player {

    /** The name of the player (used for printing purposes). */
    String name;
    
    /** The player's one hidden card (a value 1..10). */
    private int hiddenCard = 0;
    
    /** The sum of the player's cards, not counting the hidden card. */
    public int sumOfVisibleCards = 0;
    
    /**
     * Constructs a player with the given name.
     *
     * @param name the name to be given to this player.     */
    public Player (String name) {
        this.name = name;
    }
    
    /**
     * Decides whether to take another card. Information available
     * in making this decision includes the sum of all this Player's
     * cards, and the sum of each other Player's visible cards, but
     * not the value of other Player's hidden cards.
     * 
     * @param players An array of all Players, including this one.
     * @return <code>true</code> if the decision is to take another card.
     */
    boolean offerCard(Player[] players) { 
    	// A simple strategy:
    	// 1. If all the cards equal to or are more than 18, stop, return false.
    	// 2. If the total equals to 17:
    	//    a. if one of the sum of each other player's visible cards is greater than or equal to 10, 
    	//       then take another card.
    	//    b. Else, do not take another card.
    	// 3. If the total is less than 17, take another card, return true.	
    	int total = sumOfVisibleCards + hiddenCard;
    	if(total >= 18)
    		return false;
    	else if (total == 17)
    	{
    		for(int i = 0; i < players.length; i++)
    		{
    			if(players[i].sumOfVisibleCards >= 10)
    				return true;
    		}
    		return false;
    	}
    	else
    	return true;  		
    }
    
    /**
     * Adds the given card to the sum of the visible cards for this
     * Player, and prints a message saying that the card is being taken.
     * 
     * @param card The card (1..10) being taken.
     */
    void takeVisibleCard(int card)
    { 
        // Students: your code goes here.
    	sumOfVisibleCards = sumOfVisibleCards + card;
    	System.out.println(name + " takes " + card);
    }

    /**
     * Puts the specified card in this player's hand, and prints a
     * message saying that the card is being taken, but does not
     * print the value of the card.
     *
     * @param card the card received from the dealer
     */
    void takeHiddenCard(int card) { 
        // Students: your code goes here.
    	hiddenCard = card;
    	System.out.println(name + " takes a hidden card.");
    	// need to keep track of the value of the hidden card. Have not figured out yet.
    }

    /**
     * Return this player's score (the total of all this player's cards).<br />
     * <b>Note:</b> The way this program is organized, there is nothing to
     * prevent another player from calling this routine to "cheat." Please
     * don't do so. There are various ways to prevent cheating, but they all
     * add complexity that we don't need in a program this small.
     * 
     * @return The total of the cards (both visible and hidden) in this player's hand.
     */
    int getScore() 
    { 
        // Students: your code goes here.
    	int total = sumOfVisibleCards + hiddenCard;
    	return total; 
    }
}