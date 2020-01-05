package com.example.java;

import javax.swing.*;
import java.util.Random;

public class RandomStrategy extends Strategy {

    public RandomStrategy() {
    }

    private static int randomNumber;
    private static Integer[] randomField = new Integer[2];

    public static Integer[] getRandomField() {
        return randomField;
    }

    public static void setRandomField() {
        setRandomNumber();
        int rowRand = getRandomNumber();
        setRandomNumber();
        int colRand = getRandomNumber();

        randomField[0] = rowRand;
        randomField[1] = colRand;
    }

    static void setRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(3);
    }

    static int getRandomNumber() {
        return randomNumber;
    }
}
