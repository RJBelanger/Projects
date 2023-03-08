package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame gameScreen = new JFrame();
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.setResizable(false);
        gameScreen.setTitle("java link");

        GameConsole gameConsole = new GameConsole();
        gameScreen.add(gameConsole);
        gameScreen.pack();
        gameScreen.setLocationRelativeTo(null);
        gameScreen.setVisible(true);
        //calls tge game to start
        gameConsole.startGameThr();
    }
}