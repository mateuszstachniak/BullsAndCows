package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretDigits = "9004";
        String userDigitsInput = scanner.nextLine();

        cowsBulls(secretDigits, userDigitsInput);
    }

    public static void cowsBulls(String secret, String userDigits) {
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
    }

}
