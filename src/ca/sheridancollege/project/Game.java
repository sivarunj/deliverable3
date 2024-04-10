/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {

    private final String name;
    private ArrayList<Player> players;
    private final Scanner scanner;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public abstract void play();

    public abstract void declareWinner(Player currentPlayer);

    public int promptForNumberOfPlayers() {
        int numPlayers;
        do {
            System.out.print("Enter the number of players (2 to 10): ");
            numPlayers = scanner.nextInt();
        } while (numPlayers < 2 || numPlayers > 10);
        return numPlayers;
    }
}
