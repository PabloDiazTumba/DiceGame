package com.PabloDiaz.demo;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int numPlayers = getNumPlayers();
        int numDice = getNumDice();
        String[] playerNames = getPlayerNames(numPlayers);

        int[] scores = playGame(numPlayers, numDice, playerNames);

        printResults(playerNames, scores);
    }

    static int getNumPlayers() {
        System.out.println("Enter the number of players:");
        return scanner.nextInt();
    }

    static int getNumDice() {
        System.out.println("Enter the number of dice:");
        return scanner.nextInt();
    }

    static String[] getPlayerNames(int numPlayers) {
        String[] names = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + "'s name:");
            names[i] = scanner.next();
        }
        return names;
    }

    static int[] rollDice(int numDice) {
        int[] diceRolls = new int[numDice];
        for (int i = 0; i < numDice; i++) {
            diceRolls[i] = random.nextInt(6) + 1;
        }
        return diceRolls;
    }

    static int calculateScore(int[] diceRolls) {
        int sum = 0;
        for (int roll : diceRolls) {
            sum += roll;
        }
        return sum;
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

        if (scores.length > 1) {
            int secondMaxScore = -1;
            int secondWinnerIndex = -1;

            for (int i = 0; i < scores.length; i++) {
                if (i != winnerIndex && scores[i] > secondMaxScore) {
                    secondMaxScore = scores[i];
                    secondWinnerIndex = i;
                }
            }

            System.out.println("The winners are: " + playerNames[winnerIndex] + " and " + playerNames[secondWinnerIndex]);
        } else {
            System.out.println("The winner is: " + playerNames[winnerIndex]);
        }
    }
}