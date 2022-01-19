public class Card {

	int cardName;
	String suit;
	int value;

	public Card(int cardName, String suit, int value) { //Constructor for the class "Card" with
		this.cardName = cardName;						   //cardName, suit and value as properties
		this.suit = suit;
		this.value = value;
	}

	public int getCardName() { //Method for getting the cards "cardName" for example "7"
		return this.cardName;
	}

	public void setValue() { //Method for adding the value for the game for each cards base value
		this.value += this.cardName;
	}

	public void setSuitValue() { //Method for adding the bonus value based on the cards suit
		if (this.suit == "Hearts") {
			this.value += 8;
		} else if (this.suit == "Diamonds") {
			this.value += 4;
		} else if (this.suit == "Clubs") {
			this.value += 6;
		} else if (this.suit == "Spades") {
			this.value += 10;
		}

	}
}
