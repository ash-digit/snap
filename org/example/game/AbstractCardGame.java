package org.example.game;

import org.example.card.PlayingCard;
import org.example.player.GamePlayer;

import java.util.List;

public abstract class AbstractCardGame {
    protected List<GamePlayer> players;
    protected List<PlayingCard> deck;

    // Abstract methods to be implemented by subclasses
    protected abstract void initializePlayers();
    protected abstract void dealCards();

    public abstract void setupGame();
    public abstract void run();

    protected void shuffleDeck() {
        java.util.Collections.shuffle(deck);
    }

    protected void announceWinner(GamePlayer winner) {
        System.out.println("Winner: " + winner.getName());
    }
}

