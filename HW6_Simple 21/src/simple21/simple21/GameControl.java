/*
 * Name : Mehdi Sepahvand,
* Penn ID: 15228700,
* Statement of work: Work is completely my own. The only resources used were lecture\n
 * codes, recitation videos, Java Concepts book and Java library.
 */
package simple21;

import java.util.Random;
import java.util.Scanner;

/**
 * This is a simplified version of a common card game, "21".
 */
public class GameControl {

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
	 * A random number generator to be used for returning random "cards" in a card
	 * deck.
	 */
	Random random = new Random();

	/**
	 * The main method just creates a GameControl object and calls its run method.
	 * 
	 * @param args Not used.
	 */
	public static void main(String args[]) {
		new GameControl().run();
	}

	/**
	 * Prints a welcome method, then calls methods to perform each of the following
	 * actions: - Create the players (one of them a Human) - Deal the initial two
	 * cards to each player - Control the play of the game - Print the final results
	 */
	public void run() {
		// We structure this method to make it more interactive. So after we get the
		// players name then we begin playing. After that we run a while loop
		// to check that the players have not passed. Then print results.

		Scanner scanner = new Scanner(System.in);

		// Students: your code goes here.
		// System.out.println("What is your name?");
		// String humanName = scanner.next();
		System.out.println("Welcome to Simple 21!");
		System.out.println("You'll play against 3 other players (computers).\n"
				+ "Try to get as close to 21 as possible, without going over.");
		System.out.println("To begin playing, please enter your name!");
		// Stringify entered name
		String humanName = scanner.next();
		this.createPlayers(humanName);
		this.deal();
		while (checkAllPlayersHavePassed() == false) {
			this.controlPlay(scanner);
			System.out.println();
		}
		// print out current total score for human player and current total VISIBLE
		// score for computer players, and finally the results.
		this.printResults();
		scanner.close();
	}

	/**
	 * Creates one human player with the given humansName, and three computer
	 * players with hard-coded names.
	 * 
	 * @param humansName for human player
	 */
	public void createPlayers(String humansName) {
		// Students: your code goes here.
		// Create player names. Basically give players the names we will
		// using through the game.
		this.human = new HumanPlayer(humansName);
		this.player1 = new ComputerPlayer("Player 1");
		this.player2 = new ComputerPlayer("Player 2");
		this.player3 = new ComputerPlayer("Player 3");
	}

	/**
	 * Deals two "cards" to each player, one hidden, so that only the player who
	 * gets it knows what it is, and one face up, so that everyone can see it.
	 * (Actually, what the other players see is the total of each other player's
	 * cards, not the individual cards.)
	 */
	public void deal() {
		// Students: your code goes here.
		// Give hidden and visible to each player.
		System.out.println();
		this.human.takeHiddenCard(nextCard());
		this.human.takeVisibleCard(nextCard());

		System.out.println();
		this.player1.takeHiddenCard(nextCard());
		this.player1.takeVisibleCard(nextCard());

		System.out.println();
		this.player2.takeHiddenCard(nextCard());
		this.player2.takeVisibleCard(nextCard());

		System.out.println();
		this.player3.takeHiddenCard(nextCard());
		this.player3.takeVisibleCard(nextCard());

	}

	/**
	 * Returns a random "card", represented by an integer between 1 and 10,
	 * inclusive. The odds of returning a 10 are four times as likely as any other
	 * value (because in an actual deck of cards, 10, Jack, Queen, and King all
	 * count as 10).
	 * 
	 * Note: The java.util package contains a Random class, which is perfect for
	 * generating random numbers.
	 * 
	 * @return a random integer in the range 1 - 10.
	 */
	public int nextCard() {
		// Students: your code goes here.
		// Random number generator. We will have 4 tens, hence the if statement.
		int card = random.nextInt(13) + 1;
		if (card > 10) {
			card = 10;
		}
		return card;
	}

	/**
	 * Gives each player in turn a chance to take a card, until all players have
	 * passed. Prints a message when a player passes. Once a player has passed, that
	 * player is not given another chance to take a card.
	 * 
	 * @param scanner to use for user input
	 */
	public void controlPlay(Scanner scanner) {
		// Students: your code goes here.
		// As long as a player has not passed they get the chance to take a card.
		// Once all have passed while loop ends.
		while (!this.checkAllPlayersHavePassed()) {
			if (!human.passed) {
				boolean humanResponse = human.offerCard(human, player1, player2, player3, scanner);
				if (humanResponse == true) {
					System.out.println();
					int card0 = nextCard();
					human.takeVisibleCard(card0);
				} else {
					human.passed = true;
					System.out.println();
					System.out.println(human.name + " passes.");
				}
			}

			if (!player1.passed) {
				boolean Player1Response = player1.offerCard(human, player1, player2, player3);
				if (Player1Response == true) {
					System.out.println();
					int card1 = nextCard();
					player1.takeVisibleCard(card1);
				} else {
					player1.passed = true;
					System.out.println();
					System.out.println(player1.name + " passes.");
				}
			}

			if (!player2.passed) {
				boolean Player2Response = player2.offerCard(human, player1, player2, player3);
				if (Player2Response == true) {
					System.out.println();
					int card2 = nextCard();
					player2.takeVisibleCard(card2);
				} else {
					player2.passed = true;
					System.out.println();
					System.out.println(player2.name + " passes.");
				}
			}

			if (!player3.passed) {
				boolean Player3Response = player3.offerCard(human, player1, player2, player3);
				if (Player3Response == true) {
					System.out.println();
					int card3 = nextCard();
					player3.takeVisibleCard(card3);
				} else {
					player3.passed = true;
					System.out.println();
					System.out.println(player3.name + " passes.");
				}
			}
		}
	}

	/**
	 * Checks if all players have passed.
	 * 
	 * @return true if all players have passed
	 */
	public boolean checkAllPlayersHavePassed() {
		// Students: your code goes here.
		// Boolean method, and check true if all all 4 players have passed.
		if (this.human.passed == true && this.player1.passed == true && this.player2.passed == true
				&& this.player3.passed == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Prints a summary at the end of the game. Displays how many points each player
	 * had, and if applicable, who won.
	 */
	public void printResults() {
		// Students: your code goes here.
		// Print results. We will call the printWinner method here just to make the main
		// method more compact.
		System.out.println("Game Over.");
		System.out.println(human.name + " has " + human.getScore() + " total point(s).\n" + player1.name + " has "
				+ player1.getScore() + " total point(s).\n" + player2.name + " has " + player2.getScore()
				+ " total point(s).\n" + player3.name + " has " + player3.getScore() + " total point(s).\n");
		printWinner();
	}

	/**
	 * Determines who won the game, and prints the results.
	 */
	public void printWinner() {
		// Students: your code goes here.
		// this variable will be used to find the winner.
		int minDelta = 21;
		// Stringify the winner. set to null unil found.
		String winner = null;
		// define a boolean to check whether there is a tie, as there are many cases
		// where this is the case.
		boolean tie = false;

		// check human player. If the delta to 21 is 0 human wins.
		if ((0 <= human.delta()) && (human.delta() < minDelta)) {
			minDelta = human.delta();
			winner = human.name;
		}
		// check player1. If the delta to 21 is 0 player1 wins. If the score is at
		// parity
		// human tie.
		if ((0 <= player1.delta()) && (player1.delta() < minDelta)) {
			minDelta = player1.delta();
			winner = player1.name;
		} else if ((0 < player1.delta()) && (player1.delta() == minDelta)) {
			tie = true;
		}

		// check player2. If the delta to 21 is 0 player1 wins. If the score is at
		// parity
		// human or player1 tie.
		if ((0 <= player2.delta()) && (player2.delta() < minDelta)) {
			tie = false;
			minDelta = player2.delta();
			winner = player2.name;
		} else if ((0 < player2.delta()) && (player2.delta() == minDelta)) {
			tie = true;
		}
		// check player3. If the delta to 21 is 0 player1 wins. If the score is at
		// parity
		// human, player1 or player2 tie.
		if ((0 <= player3.delta()) && (player3.delta() < minDelta)) {
			tie = false;
			minDelta = player3.delta();
			winner = player3.name;
		} else if ((0 < player3.delta()) && (player3.delta() == minDelta)) {
			tie = true;
		}

		// This is where we determine who wins, or tie is declared.
		if (winner != null) {
			if (tie != true) {
				System.out.println(winner + " wins with " + (21 - minDelta) + ".");
			} else {
				System.out.println("It is a tie. Nobody wins.");
			}
		} else {
			System.out.println("It is a tie. Everyone went over 21.");
		}
	}
}
