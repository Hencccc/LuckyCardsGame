import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck; 	//Declaring an ArrayList consisting of Card-objects

	public Deck() { 	//Constructor which creates the deck of cards and adds each card to the ArrayList "deck"
		final String[] suits = { "Hearts", "Spades", "Clubs", "Diamonds" };
		final int[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		deck = new ArrayList<Card>();

		for (int i = 0; i < 52; i++) { 	//Creates 52 cards (13 per suit) and adds each to the ArrayList "deck"
			deck.add(new Card(values[i % 13], suits[i % 4], 0));
		}

		for (Card card : deck) {	//Calls the methods for adding each cards value for each Card in the ArrayList "deck"
			card.setValue();
			card.setSuitValue();
		}
	}
	
	//Method for shuffling the deck
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	//Method for removing and returning the top card from the deck
	//The card is removed in order to secure uniquely picked cards
	public Card getRandomCard() {	
		return deck.remove(0);
	}
	
	public void insertDrawnCard(Card card1, Card card2, Card card3) {
		deck.add(card1);
		deck.add(card2);
		deck.add(card3);
	}

	public void printAllCards() {
		for (Card item : deck) {
			System.out.println(item.cardName + ". suit: " + item.suit);
		}

	}

}
