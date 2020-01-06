package com.example.java;

import javax.swing.*;

public class HeuristicStrategy implements StrategyType {

    private JButton[][] fields;

    private void setFields() {
        this.fields = TicTacToe.getFields();
    }

    private String getOponentSign(String sign) {
        return sign == "X" ? "O" : "X";
    }

    private boolean findTwoSignInOrder(String sign) {
        String opponentSign;
        if (sign == "O") {
            opponentSign = "O";
        } else {
            opponentSign = getOponentSign(sign);
        }
        // try to find two sing in order (horizontally, vertically or diagonally)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                if (
                    (fields[row][0].getText() == sign && fields[row][1].getText() == sign)
                    ||
                    (fields[row][0].getText() == sign && fields[row][2].getText() == sign)
                    ||
                    (fields[row][1].getText() == sign && fields[row][2].getText() == sign)
                ) {
                    if (fields[row][0].getText() == "") {
                        fields[row][0].setText(opponentSign);
                    } else if (fields[row][1].getText() == "") {
                        fields[row][1].setText(opponentSign);
                    } else if (fields[row][2].getText() == "") {
                        fields[row][2].setText(opponentSign);
                    } else {
                        continue;
                    }
                    return true;
                } else if (
                    (fields[0][col].getText() == sign && fields[1][col].getText() == sign)
                    ||
                    (fields[0][col].getText() == sign && fields[2][col].getText() == sign)
                    ||
                    (fields[1][col].getText() == sign && fields[2][col].getText() == sign)
                ) {
                    if (fields[0][col].getText() == "") {
                        fields[0][col].setText(opponentSign);
                    } else if (fields[1][col].getText() == "") {
                        fields[1][col].setText(opponentSign);
                    } else if (fields[2][col].getText() == "") {
                        fields[2][col].setText(opponentSign);
                    } else {
                        continue;
                    }
                    return true;
                } else if (
                    (fields[0][0].getText() == sign && fields[1][1].getText() == sign)
                    ||
                    (fields[0][0].getText() == sign && fields[2][2].getText() == sign)
                    ||
                    (fields[1][1].getText() == sign && fields[2][2].getText() == sign)
                ) {
                    if (fields[0][0].getText() == "") {
                        fields[0][0].setText(opponentSign);
                    } else if (fields[1][1].getText() == "") {
                        fields[1][1].setText(opponentSign);
                    } else if (fields[2][2].getText() == "") {
                        fields[2][2].setText(opponentSign);
                    } else {
                        continue;
                    }
                    return true;
                } else if (
                    (fields[0][2].getText() == sign && fields[1][1].getText() == sign)
                    ||
                    (fields[0][2].getText() == sign && fields[2][0].getText() == sign)
                    ||
                    (fields[1][1].getText() == sign && fields[2][0].getText() == sign)
                ) {
                    if (fields[0][2].getText() == "") {
                        fields[0][2].setText(opponentSign);
                    } else if (fields[1][1].getText() == "") {
                        fields[1][1].setText(opponentSign);
                    } else if (fields[2][0].getText() == "") {
                        fields[2][0].setText(opponentSign);
                    } else {
                        continue;
                    }
                    return true;
                }
                else {

                    continue;

//                    if (fields[row][col].getText() == "") {
//                        fields[row][col].setText("O");
//                        return;
//                    } else {
//                        continue;
//                    }
                }
            }
        }
        return false;
    }

    @Override
    public void algorithm() {
        setFields();

        if (fields[1][1].getText() == "") {
            fields[1][1].setText("O");
            return;
        }

        if (!findTwoSignInOrder("O")) {
            if (!findTwoSignInOrder("X")) {
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        if (fields[row][col].getText() == "") {
                            fields[row][col].setText("O");
                            return;
                        }
                    }
                }
            }
        }
    }
}
