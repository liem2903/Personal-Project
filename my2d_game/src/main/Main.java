package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Adventuring in 2D");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // Resizes window to fit the size of game panel.

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
