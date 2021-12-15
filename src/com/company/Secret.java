package com.company;

class Secret extends Messages implements Invariables {
    int codeLength;
    int possibleCharacters;
    StringBuilder secretPassword;

    Secret(int codeLength, int possibleCharacters, StringBuilder secretPassword) {
        this.codeLength = codeLength;
        this.possibleCharacters = possibleCharacters;
        this.secretPassword = secretPassword;
    }

    int getCodeLength() {
        return codeLength;
    }

    void setCodeLength() {
        do {
            System.out.println(inputCodeLengthMessage);
            String lengthInString = sc.nextLine();
            try {
                this.codeLength = Integer.parseInt(lengthInString);
                if (this.codeLength <= MIN_LENGTH || this.codeLength > MAX_LENGTH) {
                    System.out.println(errorMessageLength);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + this.codeLength + "\" isn't a valid number.");
            }
        } while (this.codeLength <= MIN_LENGTH || this.codeLength > MAX_LENGTH);
    }

    int getPossibleCharacters() {
        return possibleCharacters;
    }

    void setPossibleCharacters() {
        do {
            System.out.println(inputPossibleCharacters);
            String lengthInString = sc.nextLine();
            try {
                this.possibleCharacters = Integer.parseInt(lengthInString);
                if (this.possibleCharacters <= MIN_LENGTH || this.possibleCharacters > MAX_LENGTH) {
                    System.out.println(errorMessagePossibleCharacters);
                }
            } catch (
                    NumberFormatException e) {
                System.out.println("Error: \"" + this.codeLength + "\" isn't a valid number.");
            }
        } while (this.possibleCharacters <= MIN_LENGTH || this.possibleCharacters > MAX_LENGTH);
    }
    StringBuilder getSecretPassword() {
        return secretPassword;
    }

    void setSecretPassword(StringBuilder secretPassword) {
        this.secretPassword = secretPassword;
    }
}
