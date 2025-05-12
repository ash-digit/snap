package org.example.game;

import org.example.card.CardSuit;
import org.example.card.PlayingCard;
import org.example.card.RankValue;
import org.example.player.GamePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnapGame extends AbstractCardGame {
    private List<PlayingCard> deck;
    private List<PlayingCard> pile;
    private GamePlayer player1;
    private GamePlayer player2;
    private int currentPlayerIndex;
    private static final Scanner scanner = new Scanner(System.in);

    public SnapGame() {
        super();
        deck = new ArrayList<>();
        pile = new ArrayList<>();
    }

    @Override
    protected void initializePlayers() {
        player1 = new GamePlayer("Player 1");
        player2 = new GamePlayer("Player 2");
        players = List.of(player1, player2);
    }

    @Override
    protected void dealCards() {
        for (CardSuit suit : CardSuit.values()) {
            for (RankValue rank : RankValue.values()) {
                deck.add(new PlayingCard(suit, rank));
            }
        }
        java.util.Collections.shuffle(deck);
        for (int i = 0; i < deck.size(); i++) {
            if (i % 2 == 0) {
                player1.addCardToHand(deck.get(i));
            } else {
                player2.addCardToHand(deck.get(i));
            }
        }
    }

    @Override
    public void setupGame() {
        initializePlayers(); // Initialize players
        dealCards();         // Deal cards to players
    }

    @Override
    public void run() {
        System.out.println("Starting Snap Game!");
        GamePlayer currentPlayer = player1;
        PlayingCard lastCard = null;

        while (player1.hasCards() && player2.hasCards()) {
            promptEnterKey(currentPlayer);

            PlayingCard playedCard = currentPlayer.playCard();
            System.out.println(currentPlayer.getName() + " played: " + playedCard);
            pile.add(playedCard);

            if (lastCard != null && playedCard.getRank() == lastCard.getRank()) {
                System.out.println(currentPlayer.getName() + " says SNAP!");
                handleSnapInput(currentPlayer);
                break;
            }

            lastCard = playedCard;
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        // Use the method from the superclass
        if (player1.hasCards()) {
            announceWinner(player1);
        } else if (player2.hasCards()) {
            announceWinner(player2);
        } else {
            System.out.println("Game ended with no winner.");
        }
    }

    private void promptEnterKey(GamePlayer currentPlayer) {
        System.out.println(currentPlayer.getName() + ", press ENTER to draw a card...");
        scanner.nextLine(); // Wait for user to press Enter
    }

    private void handleSnapInput(GamePlayer currentPlayer) {
        System.out.println("Match found! Type 'snap' within 2 seconds to win!");

        Thread snapThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("\nToo late! 2 seconds are up");
                System.exit(0); // End the game if time is up
            } catch (InterruptedException e) {
                // Do nothing, the user typed snap within 2 seconds
            }
        });

        snapThread.start();

        if (scanner.nextLine().equalsIgnoreCase("snap")) {
            System.out.println(currentPlayer.getName() + " wins the game with a SNAP!");
        } else {
            System.out.println("Incorrect input! " + currentPlayer.getName() + " loses the game.");
        }

        snapThread.interrupt(); // Stop the timer thread
    }
}