package main;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class Minion {
    public int x, y, health;
    private Image sprite;

    public Minion() {
        x = 800; // Position the minion in the scene
        y = 590;
        health = 100; // Initial health
        loadSprite();
    }

    private void loadSprite() {
        try {
            sprite = ImageIO.read(getClass().getResource("/res/characters/minion.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, int screenHeight) {
        if (health > 0) { // Only draw if the Minion is alive
            int spriteHeight = (int) (screenHeight * 0.6); // 30% of screen height
            int spriteWidth = spriteHeight;
            g2.drawImage(sprite, x, y, spriteWidth, spriteHeight, null);
        }
    }

    public int attack() {
        return 30; // Returns a random value between 0 and 20 (inclusive)
    }
}