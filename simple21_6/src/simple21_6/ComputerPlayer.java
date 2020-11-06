package simple21_6;

/**
 * Represents a computer player in this simplified version of the "21" card game.
 */
public class ComputerPlayer {

	/** 
	 * The name of the player.
	 */
    String name;
    
    /**
     * The player's one hidden card (a value from 1 - 10).
     */
    private int hiddenCard = 0;
    
    /** 
     * The sum of the player's cards, not counting the hidden card. 
     */
    private int sumOfVisibleCards = 0;
    
    /**
     * The sum of visible card and hidden card
     */
    private int totalScore = 0;
    
    /**
     * Flag indicating if the player has passed (asked for no more cards).
     */
    boolean passed = false;
    
    /**
     * Constructs a computer player with the given name.
     * @param name of the user.
     */
    public ComputerPlayer (String name) {
        this.name = name;
    }
    
    
    /**
     * how far is computer player's total score is to 21
     */
    private int scoreTo21 = 21;
    
    /**
     * Decides whether to take another card. In order to make this decision, this player considers 
     * their own total points (sum of visible cards + hidden card). 
     * This player may also consider other players' sum of visible cards, but not the value 
     * of other players' hidden cards.
     * @param human The other human player
     * @param player1 Another (computer) player
     * @param player2 Another (computer) player
     * @param player3 Another (computer) player
     * @return true if this player wants another card
     */
    public boolean offerCard(HumanPlayer human, ComputerPlayer player1, ComputerPlayer player2, ComputerPlayer player3) { 
    	// Students: your code goes here.
    	// look at its own points
    	// look at others' visible points 
    	boolean response = true; 
    	
    	//if own points - 21 > 10, get a card, get a card
    	if (this.diffTo21() >= 10) {
    		response = true;
    	}
    	else {
    		response = false;
    		this.passed = true;
    	}
    	return response; 
    }
    
    /**    
     * Puts the specified card in this player's hand as the hidden card.
     * Prints a message saying that the card is being taken, but does not print the value of the hidden card.
     * @param card being taken
     */
    public void takeHiddenCard(int card) {
    	// Students: your code goes here.
    	this.hiddenCard += card;
    	this.totalScore += card;
    	System.out.println(this.name + " takes a hidden card.");
    	
    }
    
    /**
     * Adds the given card to the sum of the visible cards for this player.
     * Prints a message saying that the card is being taken.
     * @param card being taken
     */
    public void takeVisibleCard(int card) { 
    	// Students: your code goes here.
    	this.sumOfVisibleCards += card;
    	this.totalScore += card;
    	System.out.println(this.name + " takes " + card);
    	
    }

    /**
     * Returns the total sum of this player's cards, not counting the hidden card. 
     * @return sumOfVisibleCards
     */
    public int getSumOfVisibleCards() { 
    	// Students: your code goes here.
    	System.out.println(this.name +" has " + this.sumOfVisibleCards + " visible point(s).");
    	return this.sumOfVisibleCards;
    }
    
    /**
     * Return this player's total score (the total of all this player's cards).
     * That is to say, the sum of the visible cards + the hidden card.
     * @return total score 
     */
    public int getScore() 
    { 
    	// Students: your code goes here.
    	this.totalScore = this.hiddenCard + this.sumOfVisibleCards;
    	return this.totalScore;	
    }
    
    /**
     * Return how far this player's score is to 21
     * @return difference between 21 and this player's total score
     */
    public int diffTo21() {
    	this.scoreTo21 = 21 - this.getScore();
    	
    	//if total score is larger than 21, this player lost, return 21
    	if (this.scoreTo21 < 0) {
    		return 21;
    	}
    	else return this.scoreTo21;
    }
    

}