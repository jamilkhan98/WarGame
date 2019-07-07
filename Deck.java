//Partners: Jamil Khan, Brandon Walker
//09/09/2018
//Simulate a card game of war
//No inputs required
//Card game simulation ending with which player wins the game

package warProject;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	/**
	 * creates full, shuffled deck of 52 cards
	 */
	public void getCards() {
		for(int j=1; j < 5; j++) {//first loop so Card objects have pre-determined suits and colors
			String suits = "";
			String colors = "";
			if(j==1) {suits = "Diamonds"; colors = "Red"; }//sets suit to Diamonds, so color will be red
			if(j==2) {suits = "Clubs"; colors = "Black"; }//sets suit to Clubs, so color will be black
			if(j==3) {suits = "Hearts"; colors = "Red"; }//sets suit to Hearts, so color will be red
			if(j==4) {suits = "Spades"; colors = "Black"; }//sets suit to Spades, so color will be black
			
			for(int i=2; i < 15; i++) {
				cards.add(new Card(i, suits, colors));//second loop so Card objects can be created using 
			}										  //assigned values and pre-determined suits and colors
		}
		
		shuffle(cards);//shuffles cards arraylist of Deck object
	}
	
	/**
	 * shuffles deck of cards
	 * @param cards - arraylist of Card objects to be shuffled
	 * @return - returns shuffled arraylist of Card objects contained in Deck
	 */
	public static ArrayList<Card> shuffle(ArrayList<Card> cards){
		Collections.shuffle(cards);
		return cards;
	}
	
	/**
	 * displays number of cards left in deck
	 * @return - returns integer quantity of cards left in deck
	 */
	public int size(){
		return cards.size();//returns number of cards left in deck
	}
	
	/**
	 * deals cards from game Deck to playerOne and playerTwo, so each has their own decks to play with in game
	 * @param game - Deck from which cards will be dealt to playerOne and playerTwo
	 * @param playerOne - deck of playerOne which will be filled with cards dealt from game Deck
	 * @param playerTwo - deck of playerTwo which will be filled with cards dealt from game Deck
	 */
	public void deal(Deck game, Deck playerOne, Deck playerTwo) {
		for(int i = 0; i < game.cards.size(); i++) {
			if(i%2==0) {//if condition makes it so playerOne gets dealt first and gets every other card
				playerOne.cards.add(game.cards.get(i));//playerOne cards arraylist adds first and every other card until end
			}
			else {//condition so playerTwo gets dealt after playerOne and receives every other card
				playerTwo.cards.add(game.cards.get(i));//playerTwo cards arraylist adds second and every other card until end
			}
		}
	}
	
	/**
	 * removes first card of deck, as card is being played in round/war
	 * @return - returns top card of deck
	 */
	public Card playCard() {
		return cards.remove(0);
	}

	/**
	 * plays a whole game of "War" between playerOne and playerTwo until a player loses or runs out of cards
	 * @param playerOne - deck with which playerOne will play game of "War" against playerTwo
	 * @param playerTwo - deck with which playerTwo will play game of "War" against playerOne
	 */
	public void play(Deck playerOne, Deck playerTwo) {
		boolean gameOver = false;
		while (!gameOver) {			
			if(playerOne.cards.size() > 0 && playerOne.cards.size() < 4) {//game stops when one player doesn't have cards in deck
				System.out.println("Player 2 wins the game!");
				gameOver = true;//makes while condition false and ends game
			}
			
			if(playerTwo.cards.size() > 0 && playerTwo.cards.size() < 4) {
				System.out.println("Player 1 wins the game!");
				gameOver = true;
			}

			else{
				playRound(playerOne, playerTwo);
			}
		}
	}

	/**
	 * plays one round of war between player 1 and player 2
	 * @param playerOne - deck of player 1 to be used for game play
	 * @param playerTwo - deck of player 2 to be used for game play
	 */
	public static void playRound(Deck playerOne, Deck playerTwo) {
		if(playerOne.cards.size() <4  || playerTwo.cards.size() < 4) {//
			return;
		}
		System.out.println("Player 1 plays Card " + playerOne.cards.get(0));//outputs first card of player 1
		System.out.println("Player 2 plays Card " + playerTwo.cards.get(0));//outputs first card of player 2
		if(playerOne.cards.get(0).getValue() > playerTwo.cards.get(0).getValue()) {//if player 1 top card is greater than player 2 top card
			playerOne.cards.add(playerTwo.cards.remove(0));//player 2 top card is removed and added to bottom of player 1 deck
			playerOne.cards.add(playerOne.cards.remove(0));//top card player 1 used for game play is now moved to bottom of deck
			System.out.println("Player 1 wins the round");
		}
		else if(playerOne.cards.get(0).getValue() < playerTwo.cards.get(0).getValue()) {//if player 1 top card is less than player 2 top card
			playerTwo.cards.add(playerOne.cards.remove(0));//player 1 top card is removed and added to bottom of player 2 deck
			playerTwo.cards.add(playerTwo.cards.remove(0));//top card player 2 used for game play is now moved to bottom of deck
			System.out.println("Player 2 wins the round");
		}
		else {
			System.out.println("WAR HAS COMMENCED!!");
			playWar(playerOne, playerTwo);//invokes playWar method to start a war round between player 1 and player 2
		}
	}	
	
	/**
	 * plays a war round between player 1 and player 2
	 * @param playerOne - deck of player 1 to be used for game play
	 * @param playerTwo - deck of player 2 to be used for game play
	 */
	public static void playWar(Deck playerOne, Deck playerTwo) {
		ArrayList<Card> p1Pile = new ArrayList<Card>();//empty pile in which player 1 war cards will be put
		ArrayList<Card> p2Pile = new ArrayList<Card>();//empty pile in which player 1 war cards will be put
		int count = 0;
		if(playerOne.cards.size() < 4) {//checks if playerOne has enough cards to play war round, loses if not enough
			System.out.println("PLAYER 1 LOSES! INSUFFICIENT CARDS TO PLAY!");
		}

		else if(playerTwo.cards.size() < 4) {//checks if playerTwo has enough cards to play war round, loses if not enough
			System.out.println("PLAYER 2 LOSES! INSUFFICIENT CARDS TO PLAY!");
		}
		
		else {//creates a pile of cards from player 1 and player 2 deck for war round, whoever wins will add pile to bottom of their deck
			String WarWinner = "";
			Card p1WarCard = new Card();
			Card p2WarCard = new Card();
			while(playerOne.cards.size() > 0 && count < 4) {
				p1Pile.add(playerOne.playCard());
				count++;
			}
			count = 0;
			while(playerTwo.cards.size() > 0 && count < 4) {
				p2Pile.add(playerTwo.playCard());
				count++;
			}
			for(int i = 0; i < 3; i++) {
				System.out.println("War card for Player 1 is xx");
				System.out.println("War card for Player 2 is xx");
			}
			p1WarCard = p1Pile.get(p1Pile.size()-1);
			p2WarCard = p2Pile.get(p2Pile.size()-1);
			System.out.println("War card for Player 1 is " + p1WarCard);
			System.out.println("War card for Player 2 is " + p2WarCard);
			
			if(p1WarCard.compareTo(p2WarCard) > 0) {
				WarWinner = "p1";
				System.out.println("Player 1 wins the war!!");
			}
			else if(p1WarCard.compareTo(p2WarCard) < 0) {
				WarWinner = "p2";
				System.out.println("Player 2 wins the war!!");
			}
			else {
				WarWinner = "none";
			}
			
			if(WarWinner == "p1") {
				while(p1Pile.size() > 0) {
					playerOne.cards.add(p1Pile.remove(0));
				}
				while(p2Pile.size()  > 0) {
					playerOne.cards.add(p2Pile.remove(0));
				}
			}
			
			if(WarWinner == "p2") {
				while(p1Pile.size() > 0) {
					playerTwo.cards.add(p1Pile.remove(0));
				}
				while(p2Pile.size()  > 0) {
					playerTwo.cards.add(p2Pile.remove(0));
				}
			}
			
			if(WarWinner == "none") {//in case war cards of both players are equal, another war round will be initiated until winner decided
				playWar(playerOne, playerTwo);
			}
		}
	}
	
	/**
	 * outputs the cards still in the deck
	 */
	@Override
	public String toString() {
		String c = "";
		for(Card each: cards) {
			c += each.toString() + "\n";
		}
		return c;
	}
}