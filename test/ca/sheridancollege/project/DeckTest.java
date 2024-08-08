/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author saranya Nair
 */
public class DeckTest {

    public DeckTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of initializeDeck method, of class Deck.
     */
    @Test
    public void testInitializeDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.size(), "Deck should contain 52 cards after initialization");
    }

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        List<Card> originalOrder = deck.getCards();
        deck.shuffle();
        List<Card> shuffledOrder = deck.getCards();

        // Check that the order has changed
        assertFalse(originalOrder.equals(shuffledOrder), "Deck order should be different after shuffling");

        // Check that no cards are lost during shuffle
        assertEquals(52, shuffledOrder.size(), "Shuffled deck should still contain 52 cards");
        assertEquals(new HashSet<>(originalOrder), new HashSet<>(shuffledOrder), "Shuffled deck should contain the same cards");
    }

    /**
     * Test of draw method, of class Deck.
     */
    @Test
    public void testDraw() {
        Deck deck = new Deck();
        Card card = deck.draw();
        assertNotNull(card, "Drawing from a full deck should return a card");
        assertEquals(51, deck.size(), "Deck size should decrease by one after drawing a card");

        // Draw all cards to empty the deck
        for (int i = 0; i < 51; i++) {
            deck.draw();
        }
        assertNull(deck.draw(), "Drawing from an empty deck should return null");
    }

    /**
     * Test of isEmpty method, of class Deck.
     */
    @Test
    public void testIsEmpty() {
        Deck deck = new Deck();
        assertFalse(deck.isEmpty(), "New deck should not be empty");

        // Draw all cards to empty the deck
        for (int i = 0; i < 52; i++) {
            deck.draw();
        }
        assertTrue(deck.isEmpty(), "Deck should be empty after drawing all cards");
    }

    /**
     * Test of size method, of class Deck.
     */
    @Test
    public void testSize() {
        Deck deck = new Deck();
        assertEquals(52, deck.size(), "New deck should contain 52 cards");

        deck.draw();
        assertEquals(51, deck.size(), "Deck should contain 51 cards after drawing one");

        // Draw all cards to empty the deck
        for (int i = 0; i < 51; i++) {
            deck.draw();
        }
        assertEquals(0, deck.size(), "Deck should contain 0 cards after drawing all cards");
    }

    /**
     * Test of printDeck method, of class Deck.
     */
    @Test
    public void testPrintDeck() {
        Deck deck = new Deck();
        deck.printDeck();
        // Not much to assert here, as it's just printing to the console.
        // You might want to capture the console output and assert on it if necessary.
    }

    /**
     * Test of getCards method, of class Deck.
     */
    @Test
    public void testGetCards() {
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();
        assertEquals(52, cards.size(), "getCards should return a list containing 52 cards");
    }
}
