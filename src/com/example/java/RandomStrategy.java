package com.example.java;

import javax.swing.*;
import java.util.Random;

public class RandomStrategy implements StrategyType {

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

    @Override
    public void algorithm() {
        setRandomField();
        int randRow = getRandomField()[0];
        int randCol = getRandomField()[1];
        while (TicTacToe.getFields()[randRow][randCol].getText() != "") {
            setRandomField();
            randRow = getRandomField()[0];
            randCol = getRandomField()[1];
        }
        TicTacToe.getFields()[randRow][randCol].setText(TicTacToe.getComputerSign());
        if (TicTacToe.isWon(TicTacToe.getComputerSign())) {
            return;
        }
    }
}
