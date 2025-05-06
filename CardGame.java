import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    private ArrayList<Card> deckOfCards;
    private ArrayList<Player> players;
    private String name;

    private final String [] suits = {"♥", "♣", "♦", "♠"};
    private final String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private final int[] values =    { 2,   3,   4,   5,   6,   7,   8,   9,   10,  11,  12,  13,  14 };

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        this.players = new ArrayList<>();
        createDeck();
    }

    private void createDeck() {
        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i]));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }

    public void dealCards() {
        int cardsPerPlayer = deckOfCards.size() / players.size();
        int cardIndex = 0;

        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                if (cardIndex < deckOfCards.size()) {
                    player.receiveCard(deckOfCards.get(cardIndex));
                    cardIndex++;
                }
            }
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}