package com.company;

abstract class Messages {

    final String inputCodeLengthMessage = "Input the length of the secret code:";

    final String errorMessageLength = "Error: number of possible length of the the code is 1-36.";

    final String inputPossibleCharacters = "Input the number of possible symbols in the code:";

    final String errorMessagePossibleCharacters = "Error: number of possible symbols in the code is 36 (0-9, a-z).";

    String secretCharsVisualisation(int codeLength) {
        String star = "*";
        return star.repeat(codeLength);
    }

    void startGameMessage(int codeLength, int possibleCharacters, StringBuilder symbolsRange) {
        if (possibleCharacters <= 10) {
            System.out.println("The secret is prepared: " + secretCharsVisualisation(codeLength) + " (0-" + symbolsRange.charAt(possibleCharacters - 1) + ").");
        } else if (possibleCharacters == 11) {
            System.out.println("The secret is prepared: " + secretCharsVisualisation(codeLength) + " (0-9, a).");
        } else {
            System.out.println("The secret is prepared: " + secretCharsVisualisation(codeLength) + " (0-9, a-" + symbolsRange.charAt(possibleCharacters - 1) + ").");
        }

        System.out.println("Okay, let's start a game!");
    }

    boolean checkUserSolution(int bulls, int cows, StringBuilder secretPassword) {
        if (bulls == secretPassword.length()) {
            System.out.println("Grade: " + bulls + " bull(s).");
            System.out.println("Congratulations! You guessed the secret code.");
            return true;
        } else if (cows > 0 || bulls > 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
        } else if (bulls == 0) {
            System.out.println("Grade: " + cows + " cow(s).");
        } else if (cows == 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
        } else {
            System.out.println("Grade: None.");
        }
        return false;
    }
}
