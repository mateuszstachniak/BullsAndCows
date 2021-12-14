package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder secretDigits = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int n = scanner.nextInt();

        if (n > 10) {
            errorMessage(n);
        } else {
            pseudoRandomNumberGenerator(n, secretDigits);
            cowsBulls(secretDigits);
        }
    }

    public static void cowsBulls(StringBuilder secretDigits) {
        Scanner scanner = new Scanner(System.in);
        int tryCounter = 0;
        boolean weHaveAWinner = false;
        do {
            tryCounter++;
            System.out.println("Turn " + tryCounter + ":");
            String userNumbers = scanner.nextLine();

            int cows = 0;
            int bulls = 0;
            for (int i = 0; i < secretDigits.length(); i++) {
                if (userNumbers.charAt(i) == secretDigits.charAt(i)) {
                    bulls++;

                } else {
                    for (int j = 0; j < secretDigits.length(); j++) {
                        if (userNumbers.charAt(i) == secretDigits.charAt(j)) {
                            cows++;
                        }
                    }
                }
            }

            if (bulls == secretDigits.length()) {
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
        System.out.println("Error: can't generate a secret number with a length of " + n + " because there aren't enough unique digits.");
    }

    public static StringBuilder pseudoRandomNumberGenerator(int n, StringBuilder secretDigits) {
        boolean repeat = true;
        do {
            String pseudoRandomNumber = Long.toString(System.nanoTime()).substring(0, 11);

            for (int i = 1; i <= n; i++) {
                secretDigits.append(pseudoRandomNumber.charAt(pseudoRandomNumber.length() - i));
            }

            for (int i = 0; i < secretDigits.length(); i++) {
                for (int j = 0; j < secretDigits.length(); j++) {
                    if (secretDigits.charAt(0) != '0' && i == j && n == 1) {
                        repeat = false;
                    } else if (i == j) {

                    } else if (secretDigits.charAt(0) == '0') {
                        repeat = true;
                        secretDigits.setLength(0);
                        break;
                    } else if (secretDigits.charAt(i) == secretDigits.charAt(j)) {
                        repeat = true;
                        secretDigits.setLength(0);
                        break;
                    } else {
                        repeat = false;
                    }
                }
            }

        } while (repeat);
        System.out.println("Okay, let's start a game! ");
        return secretDigits;
    }
}