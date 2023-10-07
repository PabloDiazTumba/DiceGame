package com.PabloDiaz.demo;

import java.util.Scanner;

public class Input {

    static Scanner scanner = new Scanner(System.in);

    public static int getNumPlayers() {
        System.out.println("Enter the number of players:");
        return scanner.nextInt();
    }

    public static int getNumDice() {
        System.out.println("Enter the number of dice:");
        return scanner.nextInt();
    }

    public static String[] getPlayerNames(int numPlayers) {
        String[] names = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + "'s name:");
            names[i] = scanner.next();
        }
        return names;
    }

    public static int[] rollDice(int numDice) {
        int[] diceRolls = new int[numDice];
        for (int i = 0; i < numDice; i++) {
            diceRolls[i] = random.nextInt(6) + 1;
        }
        return diceRolls;
    }

    public static int calculateScore(int[] diceRolls) {
        int sum = 0;
        for (int roll : diceRolls) {
            sum += roll;
        }
        return sum;
    }
}