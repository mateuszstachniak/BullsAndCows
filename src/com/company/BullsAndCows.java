package com.company;

class BullsAndCows extends Messages implements Invariables {
    int codeLength;
    int possibleCharacters;
    StringBuilder secretPassword = new StringBuilder();
    Secret secret = new Secret(codeLength, possibleCharacters, secretPassword);

    void startGame() {
        secret.setCodeLength();
        secret.setPossibleCharacters();

        if (secret.getCodeLength() > secret.getPossibleCharacters()) {
            System.out.println("Error: it's not possible to generate a code with a length of " + secret.getCodeLength() + " with " + secret.getPossibleCharacters() + " unique symbols.");
        } else {
            StringBuilder symbolsRange = new StringBuilder(symbols.substring(0, secret.getPossibleCharacters()));
            pseudoRandomGenerator(secret.getCodeLength(), symbolsRange);
            startGameMessage(secret.getCodeLength(), secret.getPossibleCharacters(), symbolsRange);
            comparePasswordAndInput(secret.getSecretPassword());
        }
    }

    void pseudoRandomGenerator(int codeLength, StringBuilder symbolsRange) {
        StringBuilder symbolsTemp = new StringBuilder();
        symbolsTemp.append(symbolsRange);
        StringBuilder secretPassword = new StringBuilder();

        do {
            int randomNumber = random.nextInt(symbolsTemp.length());
            secretPassword.append(symbolsTemp.charAt(randomNumber));
            symbolsTemp.deleteCharAt(randomNumber);
            codeLength--;
        } while (codeLength != 0);
        secret.setSecretPassword(secretPassword);
    }

    void comparePasswordAndInput(StringBuilder secretPassword) {
        int attemptCounter = 0;
        boolean weHaveAWinner = false;
        do {
            int bulls = 0;
            int cows = 0;
            attemptCounter++;
            System.out.println("Turn " + attemptCounter + ":");
            String userNumbers = sc.nextLine();
            if (userNumbers.length() < secretPassword.length()) {
                System.out.println("Your answer is too short");
            } else {
                countBullsAndCows(bulls, cows, userNumbers);
                weHaveAWinner = checkUserSolution(bulls, cows, secretPassword);
            }
        } while (!weHaveAWinner);
    }

    void countBullsAndCows(int bulls, int cows, String userNumbers) {
        for (int i = 0; i < userNumbers.length(); i++) {
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
    }
}
