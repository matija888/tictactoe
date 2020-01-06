package com.example.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Matija Lukic
 */
public class MainFrame extends JFrame {

    private static String strategyType = "Random Strategy";

    public MainFrame() {

        JPanel panel = new JPanel(new GridLayout(3, 3));
        String[] strategyComboBoxType = {"Random Strategy", "Heuristic Strategy"};
        JComboBox strategyComboBox = new JComboBox(strategyComboBoxType);

        TicTacToe game = new TicTacToe();
        game.setStrategyType(new RandomStrategy());
        game.setGameStatusText("X is turn to play");

        // instantiate buttons, add them to the panel and add actionListener on each button
        for (int row=0; row<3; row++) {
            for (int col=0; col<3; col++) {
                JButton button = new JButton();
                game.getFields()[row][col] = button;
                panel.add(game.getFields()[row][col]);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (game.isGameOver()) {
                            return;
                        }

                        if (strategyComboBox.isEnabled()) {
                            strategyComboBox.setEnabled(false);

                            if (strategyType == "Heuristic Strategy") {
                                game.setStrategyType(new HeuristicStrategy());
                            }
                        }

                        if (button.getText() == "") {
                            button.setText(game.getPlayerSign());
                            if (game.isWon(game.getPlayerSign())) {
                                game.setGameOver(true);
                                return;
                            } else if (game.isMatrixFull()) {
                                game.setGameOver(true);
                                return;
                            } else {
                                game.getStrategyType().algorithm();
                                if (game.isWon(game.getComputerSign())) {
                                    game.setGameOver(true);
                                    return;
                                }
                            }
                        }

                    }
                });
            }
        }

        // choose which strategy will be used depending on which strategy type has been chosen by the user
        strategyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (strategyComboBox.getSelectedItem() == "Heuristic Strategy") {
                    strategyType = "Heuristic Strategy";
                }
            }
        });

        System.out.println(strategyType);

        add(panel, BorderLayout.CENTER);
        add(game.getGameStatusText(), BorderLayout.SOUTH);
        add(strategyComboBox, BorderLayout.NORTH);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}