package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder secretDigits = new StringBuilder();
        int n = scanner.nextInt();

        if (n > 10) {
            errorMessage();
        } else {
            pseudoRandomNumberGenerator(n, secretDigits);
            System.out.println(secretDigits);
        }


        /*        String userDigitsInput = scanner.nextLine();*/
        /*        cowsBulls(secretDigits, userDigitsInput);*/
    }

/*    public static void cowsBulls(String secret, String userDigits) {
        int cows = 0;
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (userDigits.charAt(i) == secret.charAt(i)) {
                bulls++;

            } else {
                for (int j = 0; j < secret.length(); j++) {
                    if (userDigits.charAt(i) == secret.charAt(j)) {
                        cows++;
                    }
                }
            }
        }

        if (cows > 0 || bulls > 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secret + ".");
        } else if (cows > 0 && bulls == 0) {
            System.out.println("Grade: " + cows + " cow(s). The secret code is " + secret + ".");
        } else if (cows == 0 && bulls > 0) {
            System.out.println("Grade: " + bulls + " bull(s). The secret code is " + secret + ".");
        } else {
            System.out.println("Grade: None. The secret code is " + secret + ".");
        }
    }*/

    public static void errorMessage() {
        System.out.println("Error");
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
        return secretDigits;
    }

}