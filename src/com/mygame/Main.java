package com.mygame;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Project Start!");
        Game game = new Game();

        //imposta la finestra di gioco
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.setSize(800, 600);
        frame.setVisible(true);

        game.init();
        game.start();
    }
}
