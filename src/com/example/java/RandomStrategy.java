package com.example.java;

import java.util.Random;

public class RandomStrategy {
    private static int randomNumber;

    public static int getRandomNumber() {
        String randomDouble = Double.toString(Math.random());
        char intStr = randomDouble.charAt(2);
        int radomInt = Integer.parseInt(String.valueOf(intStr));
        randomNumber = radomInt - 1;
        return randomNumber;
    }
}
