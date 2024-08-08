/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author SREEJITH PANIKAR
 */
public class WarPlayerTest {

    private WarPlayer player;
    private Card card1;
    private Card card2;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        player = new WarPlayer("Test Player");
        card1 = new Card("Hearts", 10);
        card2 = new Card("Spades", 5);
    }

    @AfterEach
    public void tearDown() {
        player = null;
    }

    @Test
    public void testReceiveCard() {
        player.receiveCard(card1);
        assertEquals(1, player.getDeckSize(), "Deck size should be 1 after receiving one card");
    }

    @Test
    public void testReceiveCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        player.receiveCards(cards);
        assertEquals(2, player.getDeckSize(), "Deck size should be 2 after receiving two cards");
    }

    @Test
    public void testPlayCard() {
        player.receiveCard(card1);
        Card playedCard = player.playCard();
        assertEquals(card1, playedCard, "Played card should be the same as the card added");
        assertEquals(0, player.getDeckSize(), "Deck size should be 0 after playing the card");
    }

    @Test
    public void testHasCards() {
        assertFalse(player.hasCards(), "Player should not have cards initially");
        player.receiveCard(card1);
        assertTrue(player.hasCards(), "Player should have cards after receiving one card");
    }

    @Test
    public void testIncrementRoundsWon() {
        assertEquals(0, player.getRoundsWon(), "Rounds won should be 0 initially");
        player.incrementRoundsWon();
        assertEquals(1, player.getRoundsWon(), "Rounds won should be 1 after incrementing");
    }

    @Test
    public void testAddCardToDeck() {
        player.addCardToDeck(card1);
        assertEquals(1, player.getDeckSize(), "Deck size should be 1 after adding one card to deck");
    }

    @Test
    public void testGetDeck() {
        player.receiveCard(card1);
        player.receiveCard(card2);
        assertEquals(2, player.getDeck().size(), "Deck size should be 2 after receiving two cards");
    }

    @Test
    public void testGetDeckSize() {
        assertEquals(0, player.getDeckSize(), "Deck size should be 0 initially");
        player.receiveCard(card1);
        assertEquals(1, player.getDeckSize(), "Deck size should be 1 after receiving one card");
    }

    @Test
    public void testAddCardsToDeck() {
        Queue<Card> cards = new LinkedList<>();
        cards.add(card1);
        cards.add(card2);
        player.addCardsToDeck(cards);
        assertEquals(2, player.getDeckSize(), "Deck size should be 2 after adding two cards to deck");
    }
}
