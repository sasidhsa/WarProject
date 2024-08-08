/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.List;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Saranya Nair
 */
public abstract class Player {
    private String name; //the unique name for this player

    /**
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public abstract void play();

    public abstract void receiveCard(Card card);

    public abstract boolean hasCards();

    public abstract Card playCard();

    public abstract void receiveCards(List<Card> cards);
}
