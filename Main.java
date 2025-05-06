public class Main {
    public static void main(String[] args) {
        CardGame game = new CardGame("Snap");

        game.addPlayer("Alice");
        game.addPlayer("Bob");
        game.addPlayer("Charlie");
        game.addPlayer("Diana");

        game.shuffleDeck();
        game.dealCards();

        for (Player player : game.getPlayers()) {
            player.showHand();
        }
    }
}