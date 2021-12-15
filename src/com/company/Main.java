package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder secretPassword = new StringBuilder();
        String symbols = "0123456789abcdefghijklmnopqrstuvwxyz";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        int n = scanner.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int m = scanner.nextInt();
        String symbolsRange = symbols.substring(0, m);

        if (n > 36) {
            errorMessage(n);
        } else {
            pseudoRandomNumberGenerator(n, m, secretPassword, symbolsRange);
            cowsBulls(secretPassword);
        }
    }

    public static void cowsBulls(StringBuilder secretPassword) {
        Scanner scanner = new Scanner(System.in);
        int tryCounter = 0;
        boolean weHaveAWinner = false;
        do {
            tryCounter++;
            System.out.println("Turn " + tryCounter + ":");
            String userNumbers = scanner.nextLine();

            int cows = 0;
            int bulls = 0;
            for (int i = 0; i < secretPassword.length(); i++) {
                if (userNumbers.charAt(i) == secretPassword.charAt(i)) {
                    bulls++;

                } else {
                    for (int j = 0; j < secretPassword.length(); j++) {
                        if (userNumbers.charAt(i) == secretPassword.charAt(j)) {
                            cows++;
                        }
                    }
                }
            }

            if (bulls == secretPassword.length()) {
                System.out.println("Grade: " + bulls + " bull(s).");
                System.out.println("Congratulations! You guessed the secret code.");
                weHaveAWinner = true;
            } else if (cows > 0 || bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            } else if (cows > 0 && bulls == 0) {
                System.out.println("Grade: " + cows + " cow(s).");
            } else if (cows == 0 && bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s).");
            } else {
                System.out.println("Grade: None.");
            }

        } while (!weHaveAWinner);
    }

    public static void errorMessage(int n) {
        System.out.println("Error: can't generate a secret number with a length of " + n + " because there aren't enough unique digits and letters.");
    }

    public static StringBuilder secretCharsString(int n) {
        StringBuilder secretChars = new StringBuilder();

        for (int i = 0; i < n; i++) {
            secretChars.append("*");
        }
        return secretChars;
    }

    public static void startGameMessage(int n, int m, String symbolsRange) {
        if (m <= 10) {
            System.out.println("The secret is prepared: " + secretCharsString(n) + " (0-" + symbolsRange.charAt(m - 1) + ").");
        } else if (m == 11) {
            System.out.println("The secret is prepared: " + secretCharsString(n) + " (0-9, a).");
        } else {
            System.out.println("The secret is prepared: " + secretCharsString(n) + " (0-9, a-" + symbolsRange.charAt(m - 1) + ").");
        }

        System.out.println("Okay, let's start a game!");
    }

    public static StringBuilder pseudoRandomNumberGenerator(int n, int m, StringBuilder secretPassword, String symbolsRange) {
        boolean repeat = true;
        do {
            Random random = new Random();

            for (int i = 1; i <= n; i++) {
                secretPassword.append(symbolsRange.charAt(random.nextInt(m)));
            }

            for (int i = 0; i < secretPassword.length(); i++) {
                for (int j = 0; j < secretPassword.length(); j++) {
                    if (i == j && n == 1) {
                        repeat = false;
                    } else if (i == j) {

                    } else if (secretPassword.charAt(i) == secretPassword.charAt(j)) {
                        repeat = true;
                        secretPassword.setLength(0);
                        break;
                    } else {
                        repeat = false;
                    }
                }
            }
        } while (repeat);

        startGameMessage(n, m, symbolsRange);
        return secretPassword;
    }
}