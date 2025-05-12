package org.example.card;


public class PlayingCard {
    private final CardSuit suit;
    private final RankValue rank;

    public PlayingCard(CardSuit suit, RankValue rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public RankValue getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

