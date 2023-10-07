package com.PabloDiaz.demo;

import java.util.Random;
import java.util.Scanner;

public class Input {

    static Scanner scanner = new Scanner(System.in);
    static Random slumpGenerator = new Random();

    public static int getAntalSpelare() {
        System.out.println("Ange antal spelare:");
        return scanner.nextInt();
    }

    public static int getAntalTarningar() {
        System.out.println("Ange antal tärningar:");
        return scanner.nextInt();
    }

    public static String[] getSpelarnamn(int antalSpelare) {
        String[] namn = new String[antalSpelare];
        for (int i = 0; i < antalSpelare; i++) {
            System.out.println("Ange namn för spelare " + (i + 1) + ":");
            namn[i] = scanner.next();
        }
        return namn;
    }

    public static int[] kastaTarningar(int antalTarningar) {
        int[] tarningar = new int[antalTarningar];
        for (int i = 0; i < antalTarningar; i++) {
            tarningar[i] = slumpGenerator.nextInt(6) + 1;
        }
        return tarningar;
    }

    public static int raknaPoang(int[] tarningar) {
        int summa = 0;
        for (int tarning : tarningar) {
            summa += tarning;
        }
        return summa;
    }
}