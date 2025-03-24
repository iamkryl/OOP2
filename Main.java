package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("No Way Out");

        GamePanel gamePanel = new GamePanel(window); // Pass JFrame to GamePanel
        window.add(gamePanel);

        window.pack();

        window.setVisible(true);

        gamePanel.startGameThread();
    }
}