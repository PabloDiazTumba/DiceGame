package com.PabloDiaz.demo;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numPlayers = Input.getNumPlayers();
        int numDice = Input.getNumDice();
        String[] playerNames = Input.getPlayerNames(numPlayers);

        int[] scores = playGame(numPlayers, numDice, playerNames);

        printResults(playerNames, scores);
    }

    static int[] playGame(int numPlayers, int numDice, String[] playerNames) {
        int[] scores = new int[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.println(playerNames[i] + ", press 1 to roll your dice:");
            int rollChoice = scanner.nextInt();

            if (rollChoice == 1) {
                int[] diceRolls = rollDice(numDice);
                int score = calculateScore(diceRolls);
                scores[i] = score;
                System.out.println(playerNames[i] + " rolled: " + score);
            } else {
                System.out.println("Invalid choice. Skipping turn.");
            }
        }

        if (scores[0] == scores[1]) {
            System.out.println("It's a tie! Proceeding to tiebreaker round.");

            while (scores[0] == scores[1]) {
                System.out.println("Both players roll again.");

                for (int i = 0; i < numPlayers; i++) {
                    System.out.println(playerNames[i] + ", press 1 to roll your dice:");
                    int rollChoice = scanner.nextInt();

                    if (rollChoice == 1) {
                        int[] diceRolls = rollDice(numDice);
                        int score = calculateScore(diceRolls);
                        scores[i] = score;
                        System.out.println(playerNames[i] + " rolled: " + score);
                    } else {
                        System.out.println("Invalid choice. Skipping turn.");
                    }
                }
            }
        }

        return scores;
    }

    static void printResults(String[] playerNames, int[] scores) {
        int maxScore = -1;
        int winnerIndex = -1;

        for (int i = 0; i < scores.length; i++) {
            System.out.println(playerNames[i] + " scored: " + scores[i]);
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                winnerIndex = i;
            }
        }

        System.out.println("The winner is: " + playerNames[winnerIndex]);
    }
}