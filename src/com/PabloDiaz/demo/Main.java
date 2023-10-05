package com.PabloDiaz.demo;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int userScore = 0;
        int cpuScore = 0;

        System.out.println("How many rounds?");
        int rounds = scan.nextInt();

        for (int x = 0; x < rounds; x++) {
            int userChoice = rand.nextInt(6) +1;
            int cpuChoice = rand.nextInt(6) +1;

            if (cpuChoice > userChoice) {
                cpuScore += 1;

            } else if (cpuChoice < userChoice) {
                userScore += 1;

            }

        }

        System.out.printf("User Score", args);


    }
}