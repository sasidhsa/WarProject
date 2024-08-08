/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WarPlayer extends Player {
    private final Queue<Card> deck = new LinkedList<>();
    private int roundsWon = 0;

    public WarPlayer(String name) {
        super(name);
    }

    @Override
    public void receiveCard(Card card) {
        deck.add(card);
    }

    @Override
    public void receiveCards(List<Card> cards) {
        this.deck.addAll(cards);
    }

    public void incrementRoundsWon() {
        this.roundsWon++;
    }

    public int getRoundsWon() {
        return this.roundsWon;
    }

    public void addCardToDeck(Card card) {
        deck.add(card);
    }

    @Override
    public void play() {
        // Implement the play logic specific to WarPlayer
    }

    @Override
    public Card playCard() {
        return deck.poll();
    }

    @Override
    public boolean hasCards() {
        return !deck.isEmpty();
    }

    public int getDeckSize() {
        return deck.size();
    }

    public void addCardsToDeck(Queue<Card> cards) {
        deck.addAll(cards);
    }

    public Queue<Card> getDeck() {
        return new LinkedList<>(deck);
    }
}
