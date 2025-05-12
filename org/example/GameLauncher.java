package org.example;

import org.example.game.SnapGame;
public class GameLauncher {
    public static void main(String[] args) {
        SnapGame snapGameInstance = new SnapGame();

        snapGameInstance.setupGame();

        snapGameInstance.run();
    }
}
