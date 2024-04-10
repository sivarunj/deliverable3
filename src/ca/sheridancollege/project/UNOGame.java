/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author aman aman
 */
import java.util.ArrayList;
import java.util.Scanner;

public class UNOGame extends Game {

    private GroupOfCards deck;
    private GroupOfCards discardPile;

    public UNOGame(String name) {
        super(name);
        deck = new GroupOfCards(108);
        discardPile = new GroupOfCards(108);
    }

    @Override
    public void play() {
        // Initialize deck and players
        initializeDeck();
        int numPlayers = initializePlayers();
        deck.shuffle();
        dealCards(numPlayers);

        // Start game loop
        int currentPlayerIndex = 0;
        boolean gameOver = false;
        while (!gameOver) {
            Player currentPlayer = getPlayers().get(currentPlayerIndex);
            displayGameState(currentPlayer);
            playerTurn(currentPlayer);
            if (playerHasWon(currentPlayer)) {
                gameOver = true;
                declareWinner(currentPlayer);
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        }
    }

    void initializeDeck() {
        // Initialize deck with UNO cards
        deck = new GroupOfCards(108);
        for (Card.Color color : Card.Color.values()) {
            if (color != Card.Color.WILD) {
                for (int i = 0; i <= 9; i++) {
                    deck.getCards().add(new Card(color, i));
                }
                for (int i = 1; i <= 9; i++) {
                    deck.getCards().add(new Card(color, i));
                }
                deck.getCards().add(new Card(color, Card.Action.SKIP));
                deck.getCards().add(new Card(color, Card.Action.REVERSE));
                deck.getCards().add(new Card(color, Card.Action.DRAW_TWO));
            }
        }
        for (int i = 0; i < 4; i++) {
            deck.getCards().add(new Card(Card.Color.WILD, Card.Action.WILD));
            deck.getCards().add(new Card(Card.Color.WILD, Card.Action.WILD_DRAW_FOUR));
        }
        deck.shuffle(); // Shuffle the deck
    }

    private int initializePlayers() {
        ArrayList<Player> players = getPlayers();
        int numPlayers = promptForNumberOfPlayers();
        for (int i = 0; i < numPlayers; i++) {
            String playerName = "Player " + (i + 1);
            players.add(new UNOPlayer(playerName));
        }
        setPlayers(players);
        return numPlayers;
    }

    private void dealCards(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            UNOPlayer player = (UNOPlayer) getPlayers().get(i);
            for (int j = 0; j < 7; j++) {
                Card card = deck.getCards().remove(0);
                player.getHand().add(card);
            }
        }
    }

    private void displayGameState(Player currentPlayer) {
        UNOPlayer unoPlayer = (UNOPlayer) currentPlayer;
        System.out.println("Current player: " + currentPlayer.getName());
        System.out.println("Current hand: " + unoPlayer.getHand());
    }

    void playerTurn(Player player) {
        System.out.println("It's " + player.getName() + "'s turn.");
        UNOPlayer unoPlayer = (UNOPlayer) player;
        ArrayList<Card> hand = unoPlayer.getHand();

        // Display player's hand
        System.out.println("Your hand: " + hand);

        // Implement player's turn logic to choose a card to play
        // For example, you can prompt the player to enter the index of the card they want to play
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the card you want to play: ");
        int index = scanner.nextInt();

        // Get the chosen card from the player's hand
        Card selectedCard = hand.get(index);

        // Perform any necessary validation checks here
        // Remove the selected card from the player's hand
        hand.remove(index);

        // Update the game state accordingly (e.g., update discard pile, check for special cards, etc.)
        // End the player's turn
        if (hand.isEmpty()) {
            declareWinner(player); // If hand is empty, declare the current player as the winner
            return; // Exit the method
        }

    }

    private boolean playerHasWon(Player player) {
        // Implement logic to check if the player has won
        return false;
    }

    @Override

    public void declareWinner(Player currentPlayer) {
        System.out.println("Player " + currentPlayer.getName() + " wins!");
        System.exit(0); // Terminate the program
    }

    public static void main(String[] args) {
        UNOGame unoGame = new UNOGame("UNO"); // Create an instance of the UNOGame
        unoGame.play(); // Start the game
    }
}
