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

public class UNOPlayer extends Player {
    private ArrayList<Card> hand;

    public UNOPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    @Override
    public void play() {
        // Implement player's turn logic for UNO
        // For example, selecting a card to play from the hand
        // You can implement this according to the UNO game rules
    }
}

