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
        String[] strategyComboBoxType = {"Random Strategy", "Heuristic strategy"};
        JComboBox strategyComboBox = new JComboBox(strategyComboBoxType);

        RandomStrategy strategy = new RandomStrategy();
        strategy.setGameStatusText("X is turn to play");

        // instantiate buttons, add them to the panel and add actionListener on each button
        for (int row=0; row<3; row++) {
            for (int col=0; col<3; col++) {
                JButton button = new JButton();
                strategy.getFields()[row][col] = button;
                panel.add(strategy.getFields()[row][col]);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (strategy.isGameOver()) {
                            return;
                        }

                        if (strategyComboBox.isEnabled()) {
                            strategyComboBox.setEnabled(false);

                            if (strategyType == "Heuristic Strategy") {
                                HeuristicStrategy strategy = new HeuristicStrategy();
                            }
                        }

                        button.setText(strategy.getPlayerSign());
                        if (strategy.isWon(strategy.getPlayerSign())) {
                            strategy.setGameOver(true);
                            return;
                        }

                        strategy.setRandomField();
                        int randRow = strategy.getRandomField()[0];
                        int randCol = strategy.getRandomField()[1];
                        while (strategy.getFields()[randRow][randCol].getText() != "") {
                            strategy.setRandomField();
                            randRow = strategy.getRandomField()[0];
                            randCol = strategy.getRandomField()[1];
                        }
                        strategy.getFields()[randRow][randCol].setText(strategy.getComputerSign());
                        if (strategy.isWon(strategy.getComputerSign())) {
                            strategy.setGameOver(true);
                            return;
                        }

                        if (strategy.isMatrixFull()) {
                            strategy.setGameOver(true);
                            return;
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
        add(strategy.getGameStatusText(), BorderLayout.SOUTH);
        add(strategyComboBox, BorderLayout.NORTH);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}