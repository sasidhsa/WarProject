/*
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @author Saranya Nair
 * @date 7 August 2024
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    private final String suit;
    private final int value;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the value of the card.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Provides a string representation of a card.
     *
     * @return a String representation of the card
     */
    @Override
    public String toString() {
        String valueString;
        switch (value) {
            case 11:
                valueString = "Jack";
                break;
            case 12:
                valueString = "Queen";
                break;
            case 13:
                valueString = "King";
                break;
            case 14:
                valueString = "Ace";
                break;
            default:
                valueString = String.valueOf(value);
        }
        return valueString + " of " + suit;
    }
}
