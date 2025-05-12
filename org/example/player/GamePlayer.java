package org.example.player;

import org.example.card.PlayingCard;

import java.util.LinkedList;
import java.util.Queue;

public class GamePlayer {
    private final String name;
    private final Queue<PlayingCard> hand;  // A Queue to represent the player's hand

    public GamePlayer(String name) {
        this.name = name;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getHandSize() {
        return hand.size();
    }

    // Add a card to the player's hand
    public void addCardToHand(PlayingCard playingCard) {
        hand.offer(playingCard);
    }

    // Play a card (remove and return the top card)
    public PlayingCard playCard() {
        return hand.poll();  // Returns the card at the front of the queue
    }

    // Check if the player has any cards left
    public boolean hasCards() {
        return !hand.isEmpty();
    }
}