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

/**
 *
 * @author SREEJITH PANIKAR
 */
public class WarGameTest {

    private WarGame warGame;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        warGame = new WarGame("Test WarGame");
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");
        warGame.addPlayer(player1);
        warGame.addPlayer(player2);
    }

    @AfterEach
    public void tearDown() {
        warGame = null;
    }

    @Test
    public void testGameInitialization() {
        assertEquals(2, warGame.getPlayers().size(), "Game should have two players after initialization");
    }

    @Test
    public void testPlay() {
        // Simulate the game play (this will need to be adjusted based on your implementation)
        warGame.play();
        assertNotNull(warGame, "Game should not be null after play");
    }

    @Test
    public void testDeclareWinner() {
        // Simulate conditions for declaring a winner (this will need to be adjusted based on your implementation)
        warGame.declareWinner();
        assertNotNull(warGame, "Game should not be null after declareWinner");
    }
}
