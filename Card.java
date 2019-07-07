//Partners: Jamil Khan, Brandon Walker
//09/09/2018
//Simulate a card game of war
//No inputs required
//Card game simulation ending with which player wins the game

package warProject;
import java.util.*;

public class Card implements Comparable{
	private Integer value;
	private String suit;
	private String color;
	
	public Card() {
		value = 0;
		suit = "";
		color = "";
	}
	
	/**
	 * creates Card object with rank, suit, and color parameters passed in
	 * @param worth - value of card, from A-K
	 * @param symbol - suit of card, either Hearts, Clubs, Diamonds, or Spades
	 * @param coloring - color of card, either red or black
	 */
	public Card(Integer worth, String symbol, String coloring) {
		value = worth;
		suit = symbol;
		color = coloring;
	}
	
	/**
	 * returns rank/value of a card
	 * @return - returns rank/value of Card object
	 */
	public Integer getValue() {
		return value;
	}
	
	/**
	 * returns suit of card, either Hearts, Clubs, Diamonds, or Spades
	 * @return - returns suit of Card object
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * returns color of card, either red or black
	 * @return - returns color of Card object (red or black)
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * changes value of card
	 * @param newValue - new value of Card object
	 */
	public void setValue(Integer newValue) {
		value = newValue;
	}
	
	/**
	 * changes suit of card
	 * @param newSuit - new suit of Card object
	 */
	public void setSuit(String newSuit) {
		suit = newSuit;
	}
	
	/**
	 * changes color of card
	 * @param newColor - new color of Card object
	 */
	public void setColor(String newColor) {
		color = newColor;
	}
	
	/**
	 * compares Card objects to determine which has lesser, greater, or equal value
	 */
	public int compareTo(Object c) {
		Card other = (Card) c;
		if(value > other.value) {
			return 1;
		}
		else if(value < other.value) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * outputs value, suit and color of Card object
	 */
	@Override
	public String toString() {
		if (value == 11) {
			return "J of " + suit + " (" + color + ")";
		}
		if (value == 12) {
			return "Q of " + suit + " (" + color + ")";
		}
		if (value == 13) {
			return "K of " + suit + " (" + color + ")";
		}
		if (value ==14){
			return "A of " + suit + " (" + color + ")";
		}
		return value + " of " + suit + " (" +  color + ")";
		}
	}
