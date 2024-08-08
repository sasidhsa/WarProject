/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Saranya Nair
 * @date 7 August 2024
 */
public class Deck {
    public List<Card> cards; 

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int value = 2; value <= 14; value++) {
                this.cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Card draw() {
        if (!cards.isEmpty()) {
            return this.cards.remove(0); 
        }
        return null; 
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public int size() {
        return this.cards.size();
    }

    public void printDeck() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
