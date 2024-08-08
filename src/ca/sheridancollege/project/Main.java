/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Saranya Nair
 * @date 7 August 2024
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Welcome to War Game!");
            System.out.println("Press Enter to start the game...");

            scanner.nextLine();
            WarGame game = new WarGame("War Card Game");

            String player1Name = "";
            
            while (player1Name.trim().isEmpty()) {
                System.out.print("Enter Player 1's name (max 9 characters): ");
                player1Name = scanner.nextLine();
                if (player1Name.trim().isEmpty()) { 
                    System.out.println("Player 1's name cannot be empty. Please enter a name.");
                } else if (player1Name.trim().length() > 9) {
                    System.out.println("Player 1's name is too long. Please enter a name with no more than 9 characters.");
                    player1Name = "";
                }
            }

            String player2Name = "";
            while (player2Name.trim().isEmpty() || player2Name.trim().length() > 9) {
                System.out.print("Enter Player 2's name (max 9 characters): ");
                player2Name = scanner.nextLine();
                if (player2Name.trim().isEmpty()) { 
                    System.out.println("Player 2's name cannot be empty. Please enter a name.");
                } else if (player2Name.trim().length() > 9) {
                    System.out.println("Player 2's name is too long. Please enter a name with no more than 9 characters.");
                    player2Name = "";
                }
            }

            WarPlayer player1 = new WarPlayer(player1Name);
            WarPlayer player2 = new WarPlayer(player2Name);
            
            // Add players to the game
            game.addPlayer(player1);
            game.addPlayer(player2);
            
            Deck deck = new Deck();
            deck.shuffle();
            
            while (!deck.isEmpty()) {
                player1.receiveCard(deck.draw());
                if (!deck.isEmpty()) {
                    player2.receiveCard(deck.draw());
                }
            }

            System.out.println(player1Name + "'s cards:");
            for (Card card : player1.getDeck()) {
                System.out.println(card);
            }
            System.out.println(player2Name + "'s cards:");
            for (Card card : player2.getDeck()) {
                System.out.println(card);
            }

            game.play();
        }
    }
}
