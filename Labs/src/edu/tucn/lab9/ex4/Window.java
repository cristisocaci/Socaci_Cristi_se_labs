package edu.tucn.lab9.ex4;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Integer[][] board = new Integer[3][3];
    private boolean xturn = true;
    public Window(){
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j){
                board[i][j] = -1;
            }
        JButton[] buttons = new JButton[9];
        for(int i = 0; i < 9; ++i) {
            buttons[i] = new JButton();
            buttons[i].setMinimumSize(new Dimension(170, 170));
            final int finalI = i;
            buttons[i].addActionListener(e -> {
                int[] index = _1dto2d(finalI);
                if(board[index[0]][index[1]] == -1){
                   board[index[0]][index[1]] = xturn ? 1 : 0;
                   buttons[finalI].setText(xturn ? "X" : "O");
                   if(checkWin() || checkDraw()){
                       for(int j = 0; j < 9; ++j){
                           buttons[j].setText("");
                           int[] temp = _1dto2d(j);
                           board[temp[0]][temp[1]] = -1;
                       }
                   }
                   xturn = (!xturn && true) || (xturn && false); // xturn xor true
                }
            });
            add(buttons[i]);
        }

        setLayout(new GridLayout(3,3));
        setSize(360, 360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private int[] _1dto2d(int i){
        int[] out = new int[2];
        out[0] = i % 3;
        out[1] = i / 3;
        return out;
    }
    private boolean checkWin(){
        for(int i = 0; i < 3; ++i)
        {
            if(board[i][i] == -1)
                continue;
            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]))
                return true;
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]))
                return true;
        }
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0] != -1)
            return true;
        if(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2]) && board[2][0] != -1)
            return true;

        return false;
    }
    private  boolean checkDraw(){
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j)
                if(board[i][j] == -1)
                    return false;

         return true;
    }
}
