# Snap Card Game

## Project Overview
This is a simple command-line implementation of the classic **Snap** card game written in **Java**. The game involves two players who take turns drawing cards. If two cards of the same rank are played consecutively, players can call out "Snap" to win the pile of cards. The game ends when one player collects all the cards.

## Setup Instructions

### Prerequisites
1. **Java 8 or higher** installed.
    - You can verify this by running the following command:
      ```bash
      java -version
      ```

2. **IntelliJ IDEA** or any Java IDE of your choice.

### Clone the Repository
Clone this repository to your local machine using the following command:
```bash
git clone <https://github.com/ash-digit/snap.git>
```

### Build and Run
1. Open the project in your IDE (e.g., IntelliJ IDEA).
2. Build and run the project using the `GameLauncher` class, which is the entry point for the game.

## Gameplay
1. Players take turns drawing cards by pressing **Enter**.
2. When two consecutive cards have the same rank, players must type `"snap"` within 2 seconds to win the pile.
3. The game continues until one player collects all 52 cards.

### Commands:
- **Press Enter**: Draw a card.
- **Type 'snap' within 2 seconds**: If two cards match, type 'snap' to win the pile.

## Project Structure

- **`org.example.card`**: Contains the `PlayingCard`, `CardSuit`, and `RankValue` classes to represent the cards and their properties.
- **`org.example.player`**: Contains the `GamePlayer` class to represent each player in the game.
- **`org.example.game`**: Contains the `SnapGame` class and the abstract `AbstractCardGame` class which defines the basic game logic.


