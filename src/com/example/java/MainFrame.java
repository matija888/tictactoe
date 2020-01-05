package com.example.java;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
import java.util.HashMap;

public class MainFrame extends JFrame {

    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private JTextField btn1Text, btn2Text, btn3Text, btn4Text, btn5Text, btn6Text, btn7Text, btn8Text, btn9Text;

    Integer[] userX = new Integer[5];
    Integer[] user0 = new Integer[5];
    int nextUserXIndex = 0;
    int nextUserOIndex = 0;

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public void push(String arrayType, int e) {
        if (arrayType.equals("userX")) {
            userX[nextUserXIndex] = e;
            ++nextUserXIndex;
        } else if (arrayType.equals("user0")) {
            user0[nextUserOIndex] = e;
            ++nextUserOIndex;
        }
    }

    public MainFrame() {

        setLayout(new GridLayout(3, 3));

        JButton[] buttons = new JButton[9];
        String[] buttonsTexts = new String[9];
        int[] selectedFields = new int[9];

//        HashMap<Integer, Integer[]> successfulCombination = new HashMap<>();
//        // three horizontally
//        int index = 0;
//        for (int i=0; index<3; i=i+3) {
//            Integer[] comb = {i, i+1, i+2};
//            successfulCombination.put(index, comb);
//            index++;
//        }
//
//        // three vertically
//        for (int i=0; index<6; i=i+1) {
//            Integer[] comb = {i, i+3, i+6};
//            successfulCombination.put(index, comb);
//            index++;
//        }
//
//        // two diagonally
//        Integer[] combD1 = {0, 4, 8};
//        successfulCombination.put(index++, combD1);
//        Integer[] combD2 = {2, 4, 6};
//        successfulCombination.put(index++, combD2);

        for (int i=0; i<9; i++) {
//            int positionInt = i + 1;
//            String positionStr = Integer.toString(positionInt);
//            buttons[i] = new JButton(positionStr);
            buttons[i] = new JButton();
            add(buttons[i]);
            int currentIndex = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    // check to see if user has three X or O in the order
//                    for (int i=0; i<9; i++) {
//                        if (Arrays.equals(successfulCombination.get(i), userX)) {
//                            System.out.println("You have three X in ORDER.");
//                            return;
//                        }
//                    }

                    if (buttons[currentIndex].getText().equals("")) {
                        buttons[currentIndex].setText("X");
                        selectedFields[currentIndex] = currentIndex;
                        push("userX", currentIndex);
                    }

//                    int randNumber;
//                    boolean isSet = false; // check to see if opponent's field is set
//                    while (!isSet) {
//                        randNumber = RandomStrategy.getRandomNumber();
//                        if (!contains(selectedFields, randNumber)) {
//                            buttons[randNumber].setText("O");
//                            selectedFields[randNumber] = randNumber;
//                            isSet = true;
//                        }
//                    }

                }
            });
        }

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}