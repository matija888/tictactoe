package com.example.java;

import javax.swing.*;
import java.awt.*;

/**
 * @author Matija Lukic
 */
public class MainFrame extends JFrame {

    public MainFrame() {

        JPanel panel = new JPanel(new GridLayout(3, 3));
        JLabel gameStatusText = new JLabel("X is turn to play");
        JButton[][] buttons = new JButton[3][3];

        // instantiate buttons and add them to the panel
        for (int row=0; row<3; row++) {
            for (int col=0; col<3; col++) {
                buttons[row][col] = new JButton();
                panel.add(buttons[row][col]);
//                buttons[row][col].addActionListener()
            }
        }

        add(panel, BorderLayout.CENTER);
        add(gameStatusText, BorderLayout.NORTH);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}