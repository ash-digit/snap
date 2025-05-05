import java.util.ArrayList;

public class CardGame {
    private ArrayList<Card> deckOfCards;
    private String name;

    private final String[] suits = {"♥", "♣", "♦", "♠"};
    private final String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final int[] values =    { 2,   3,   4,   5,   6,   7,   8,   9,   10,  11,  12,  13,  14 };

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    public void printDeck() {
        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }
}
