package com.example.java;

import javax.swing.*;
import java.awt.*;

public class TicTacToe {

    private static JButton[][] fields = new JButton[3][3];
    private static JLabel gameStatusText = new JLabel();

    protected StrategyType strategyType;

    public StrategyType getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(StrategyType strategyType) {
        this.strategyType = strategyType;
    }

    private boolean gameOver = false;
    static String playerSign = "X";

    static String computerSign = "O";

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public static String getPlayerSign() {
        return playerSign;
    }

    public static String getComputerSign() {
        return computerSign;
    }

    public static JButton[][] getFields() {
        return fields;
    }

    public void setGameStatusText(String statusText) {
        gameStatusText.setText(statusText);
    }

    public static JLabel getGameStatusText() {
        return gameStatusText;
    }

    public static boolean isWon(String sign) {
        for(int row=0; row<3; row++) {
            for (int col=0; col<3; col++) {
                if (fields[row][0].getText() == sign
                        && fields[row][1].getText() == sign
                        && fields[row][2].getText() == sign) {

                    // three field in one row are the same sign
                    for (int i = 0; i < 3; i++) {
                        fields[row][i].setBackground(Color.GREEN);
                    }
                    gameStatusText.setText(sign + " is won");
                    return true;
                } else if (fields[0][col].getText() == sign
                        && fields[1][col].getText() == sign
                        && fields[2][col].getText() == sign) {

                    // three field in one column are the same sign
                    for (int i = 0; i < 3; i++) {
                        fields[i][col].setBackground(Color.GREEN);
                    }
                    gameStatusText.setText(sign + " is won");
                    return true;
                } else if (fields[0][0].getText() == sign
                        && fields[1][1].getText() == sign
                        && fields[2][2].getText() == sign) {

                    // three field diagonally are the same sign
                    for (int i = 0; i < 3; i++) {
                        fields[i][i].setBackground(Color.GREEN);
                    }
                    gameStatusText.setText(sign + " is won");
                    return true;
                } else if (fields[0][2].getText() == sign
                        && fields[1][1].getText() == sign
                        && fields[2][0].getText() == sign) {
                    // three field diagonally are the same sign
                    fields[0][2].setBackground(Color.GREEN);
                    fields[1][1].setBackground(Color.GREEN);
                    fields[2][0].setBackground(Color.GREEN);
                    gameStatusText.setText(sign + " is won");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isMatrixFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (fields[row][col].getText() == "") {
                    return false;
                }
            }
        }
        gameStatusText.setText("Matrix is full.");
        return true;

    }
}
