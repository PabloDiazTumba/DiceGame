package com.PabloDiaz.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int antalSpelare = Input.getAntalSpelare();
        int antalTarningar = Input.getAntalTarningar();
        String[] spelarnamn = Input.getSpelarnamn(antalSpelare);

        int[] resultat = spelaSpelet(antalSpelare, antalTarningar, spelarnamn);

        skrivUtResultat(spelarnamn, resultat);
    }

    static int[] spelaSpelet(int antalSpelare, int antalTarningar, String[] spelarnamn) {
        int[] resultat = new int[antalSpelare];

        for (int i = 0; i < antalSpelare; i++) {
            System.out.println(spelarnamn[i] + ", tryck 1 för att kasta dina tärningar:");

            try {


            int val = scanner.nextInt();

            if (val == 1) {
                int[] tarningar = Input.kastaTarningar(antalTarningar);
                int poang = Input.raknaPoang(tarningar);
                resultat[i] = poang;
                System.out.println(spelarnamn[i] + " kastade: " + poang);
            } else {
                System.out.println("Ogiltigt val. Hopper över tur.");
            }

            } catch (InputMismatchException e) {
                System.out.println("Du måste välja 1, var god försök igen.");
                scanner.next();
                i--;
            }
        }

        if (resultat[0] == resultat[1]) {
            System.out.println("Det blev oavgjort! Fortsätter till utslagsrunda!.");

            while (resultat[0] == resultat[1]) {
                System.out.println("Båda spelare kastar igen.");

                for (int i = 0; i < antalSpelare; i++) {
                    System.out.println(spelarnamn[i] + ", tryck 1 för att kasta dina tärningar:");
                    try {
                        int val = scanner.nextInt();

                        if (val == 1) {
                            int[] tarningar = Input.kastaTarningar(antalTarningar);
                            int poang = Input.raknaPoang(tarningar);
                            resultat[i] = poang;
                            System.out.println(spelarnamn[i] + " kastade: " + poang);
                        } else {
                            System.out.println("Ogiltigt val. Hopper över tur.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Du måste välja 1, var god försök igen.");
                        scanner.next();
                        i--;
                    }
                }
            }
        }

        return resultat;
    }

    static void skrivUtResultat(String[] spelarnamn, int[] resultat) {
        int maxPoang = -1;
        int vinnareIndex = -1;

        for (int i = 0; i < resultat.length; i++) {
            System.out.println(spelarnamn[i] + " fick: " + resultat[i]);
            if (resultat[i] > maxPoang) {
                maxPoang = resultat[i];
                vinnareIndex = i;
            }
        }

        System.out.println("Vinnaren är: " + spelarnamn[vinnareIndex] + ", GRATTIS!!");
    }
}