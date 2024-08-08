/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner; 

/**
 *
 * @author Saranya Nair
 * @date 7 August 2024
 */
public class WarGame extends Game {
    Scanner scanner = new Scanner(System.in); 
    private int totalRounds = 0;
    private int player1Wins = 0;
    private int player2Wins = 0;

    public WarGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        resetGameStatistics();
        final int maxRounds = 26;
        ArrayList<Card> tempPile;

        while (players.get(0).hasCards() && players.get(1).hasCards() && totalRounds < maxRounds) {
            totalRounds++;
            System.out.println("\n---- Round " + totalRounds + " of " + maxRounds + " ----");
            System.out.println("Press Enter to play the next round...");
            scanner.nextLine();
            tempPile = new ArrayList<>();
            ArrayList<Card> playedCards = new ArrayList<>();

            for (Player player : players) {
                Card playedCard = player.playCard();
                if (playedCard != null) {
                    playedCards.add(playedCard);
                    tempPile.add(playedCard);
                    System.out.println(player.getName() + " plays: " + playedCard.toString());
                }
            }

            if (playedCards.size() == 2) {
                int compare = playedCards.get(0).getValue() - playedCards.get(1).getValue();

                if (compare > 0) {
                    players.get(0).receiveCards(tempPile);
                    ((WarPlayer) players.get(0)).incrementRoundsWon(); 
                    player1Wins++;
                    System.out.println(players.get(0).getName() + " Wins this round!");
                } else if (compare < 0) {
                    players.get(1).receiveCards(tempPile);
                    ((WarPlayer) players.get(1)).incrementRoundsWon(); 
                    player2Wins++;
                    System.out.println(players.get(1).getName() + " Wins this round!");
                } else {
                    System.out.println("This round is a tie, initiating war!");
                    handleWar(tempPile);
                }
            }

            System.out.println("Current Score: [ " + players.get(0).getName() + ": " + ((WarPlayer) players.get(0)).getRoundsWon() + " ] [ " + players.get(1).getName() + ": " + ((WarPlayer) players.get(1)).getRoundsWon() + " ]");
            displayRemainingCards();
        }

        declareWinner();
    }

    private void handleWar(ArrayList<Card> tempPile) {
        System.out.println("This round is a tie, initiating war!");

        while (true) {
            ArrayList<Card> warCards = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                if (!players.get(i).hasCards()) {
                    System.out.println(players.get(i).getName() + " cannot continue the war! Running out of cards!");
                    return; 
                }
                Card card = players.get(i).playCard();
                warCards.add(card);
                tempPile.add(card); 
                System.out.println(players.get(i).getName() + " draws for war: " + card.toString());
            }

            int compare = warCards.get(0).getValue() - warCards.get(1).getValue();
            if (compare > 0) {
                players.get(0).receiveCards(tempPile);
                ((WarPlayer) players.get(0)).incrementRoundsWon();
                System.out.println(players.get(0).getName() + " wins the war and gains " + tempPile.size() + " cards!");
                break;
            } else if (compare < 0) {
                players.get(1).receiveCards(tempPile);
                ((WarPlayer) players.get(1)).incrementRoundsWon();
                System.out.println(players.get(1).getName() + " wins the war and gains " + tempPile.size() + " cards!");
                break;
            } else {
                System.out.println("The war continues!");
            }
        }
    }

    private void displayRemainingCards() {
        for (Player player : players) {
            System.out.println(player.getName() + " has " + ((WarPlayer) player).getDeckSize() + " remaining cards.");
        }
    }

    public void declareWinner() {
        ArrayList<Player> players = getPlayers();
        int player1RoundsWon = ((WarPlayer) players.get(0)).getRoundsWon();
        int player2RoundsWon = ((WarPlayer) players.get(1)).getRoundsWon();

        System.out.println("\n---- FINAL SCORES ----");
        System.out.println(players.get(0).getName() + ": " + player1RoundsWon);
        System.out.println(players.get(1).getName() + ": " + player2RoundsWon);

        if (player1RoundsWon > player2RoundsWon) {
            System.out.println("*** " + players.get(0).getName() + " Wins! Congratulations! ***");
        } else if (player2RoundsWon > player1RoundsWon) {
            System.out.println("*** " + players.get(1).getName() + " Wins! Congratulations! ***");
        } else {
            System.out.println("*** The game is a draw! ***");
        }
        showEndGameOptions();
    }

    private void showEndGameOptions() {
        while (true) {
            System.out.println("\n--- End of Game Options ---");
            System.out.println("1. Play Again");
            System.out.println("2. View Game Summary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    play();
                    return;
                case "2":
                    displayGameSummary();
                    break;
                case "3":
                    System.out.println("Exiting game. Thank you for playing!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void displayGameSummary() {
        System.out.println("--- Game Summary ---");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println(players.get(0).getName() + " Total Wins: " + player1Wins);
        System.out.println(players.get(1).getName() + " Total Wins: " + player2Wins);
        System.out.println("Congratulations for winning the game");
    }

    private void resetGameStatistics() {
        totalRounds = 0;
        player1Wins = 0;
        player2Wins = 0;
    }
}
