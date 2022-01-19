import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		//Declares a Deck-object which contains a list of the cards in the deck
		//and declares a scanner in order to accept user-input
		Deck deck = new Deck();
		Scanner in = new Scanner(System.in);

		printWelcomeMessage();

		printBlankRow();
		//While-loop which controls the game until the user quits via input in the end of the loop
		while (true) {
			//Method for shuffling the deck of cards
			deck.shuffleDeck();
			// Draw the top card from deck and assign to variable
			Card card1 = deck.getRandomCard();
			Card card2 = deck.getRandomCard();
			Card card3 = deck.getRandomCard();

			printPlayingRound();
			
			//Prints respective cards results
			printCardsAttributes(card1, card2,card3);
			printBlankRow();
			
			//Prints the result by the drawn cards by sending them in correct order to the method "validateResults()"
			System.out.println(validateResults(card1, card2, card3));
			printBlankRow();
			
			//After lost/win is printed the drawn cards are inserted back to the deck
			returnCardsToDeck(deck, card1, card2, card3);

			//Controls whether to continue or quit the game based on user input
			System.out.println("=========> Press ENTER to play again or “q” to quit:");
			String playerInput = in.nextLine();
			if (playerInput.equals("q") || playerInput.equals("Q")) {
				break;
			}

		}
		in.close();
		printBlankRow();
		System.out.println("Thank you for playing and welcome back!");
	}
	
	//Method for printing a method message
	public static void printWelcomeMessage() {
		System.out.println("Welcome to Lucky Card game by Henric Hemmander!");
	}
	
	//Method for returning the drawn cards to the deck
	public static void returnCardsToDeck(Deck deck, Card card1, Card card2, Card card3) {
		deck.insertDrawnCard(card1, card2, card3);
	}
	
	//Method for printing a blank row
	public static void printBlankRow() {
		System.out.println("");
	}
	
	//Method for printing the Cards attributes to the console
	public static void printCardsAttributes(Card card1, Card card2, Card card3) {
		System.out.println("Card 1: " + card1.suit + " " + card1.getCardName() + " → Value =  " + card1.value);
		System.out.println("Card 2: " + card2.suit + " " + card2.getCardName() + " → Value =  " + card2.value);
		System.out.println("Card 3: " + card3.suit + " " + card3.getCardName() + " → Value =  " + card3.value);
	}
	
	//Method for printing the message "Playing Round"
	public static void printPlayingRound() {
		System.out.println("------- Playing a game round");
	}
	
	// Static method in order to be able to call the function without calling it on
	// an instance
	private static String validateResults(Card card1, Card card2, Card card3) {
		if (card2.value > card1.value) {
			if (card3.value > card1.value && card3.value < card2.value) {
				return "You win!";
			} else {
				return "You lose!";
			}
		} else if (card1.value > card2.value) {
			if (card3.value > card2.value && card3.value < card1.value) {
				return "You win!";
			} else {
				return "You lose!";
			}
		}
		return "You lose!";
	}

}
