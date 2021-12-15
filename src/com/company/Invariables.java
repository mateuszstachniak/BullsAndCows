package com.company;

import java.util.Random;
import java.util.Scanner;

interface Invariables {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    String symbols = "0123456789abcdefghijklmnopqrstuvwxyz";

    int MIN_LENGTH = 0;

    int MAX_LENGTH = 36;

}
