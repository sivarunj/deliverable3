/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */

public class Card {

    public enum Color {
        RED, YELLOW, GREEN, BLUE, WILD
    }

    public enum Action {
        SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR
    }

    private Color color;
    private Action action;
    private int number;

    public Card(Color color, int number) {
        this.color = color;
        this.number = number;
    }

    public Card(Color color, Action action) {
        this.color = color;
        this.action = action;
    }

    public Color getColor() {
        return color;
    }

    public Action getAction() {
        return action;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        if (color != Color.WILD) {
            if (action == null)
                return color + " " + number;
            else
                return color + " " + action;
        } else {
            if (action == Action.WILD)
                return color + "";
            else
                return color + " " + action;
        }
    }
}
