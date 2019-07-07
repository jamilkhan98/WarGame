//Partners: Jamil Khan, Brandon Walker
//09/09/2018
//Simulate a card game of war
//No inputs required
//Card game simulation ending with which player wins the game

package warProject;
import java.util.*;

public class warTester {
	public static void main(String[] args) {
		Deck gameDeck = new Deck();
		gameDeck.getCards();//gets cards for game deck
		Deck playerOne = new Deck();//player 1 deck
		Deck playerTwo = new Deck();//player 2 deck
		gameDeck.deal(gameDeck, playerOne, playerTwo);//deals from game deck to player 1 and player 2
		gameDeck.play(playerOne, playerTwo);//starts game of war
	}
}
