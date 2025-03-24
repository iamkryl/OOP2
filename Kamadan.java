package main;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Kamadan {
    public int x, y, speed, health, mana;
    private Image spriteRight, spriteLeft;
    private boolean facingRight = true; // Default direction

    public Kamadan() {
        x = 100;
        y = 520;
        speed = 5;
        health = 250; // Initial health
        mana = 200;   // Initial mana
        loadSprites();
    }

    private void loadSprites() {
        try {
            spriteRight = ImageIO.read(getClass().getResource("/res/characters/kamadanright.png"));
            spriteLeft = ImageIO.read(getClass().getResource("/res/characters/kamadanleft.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(boolean left, boolean right) {
        if (left) {
            x -= speed;
            facingRight = false;
        }
        if (right) {
            x += speed;
            facingRight = true;
        }
    }

    public void draw(Graphics2D g2, int screenHeight) {
        Image sprite = facingRight ? spriteRight : spriteLeft;
        int spriteHeight = (int) (screenHeight * 0.8);
        int spriteWidth = spriteHeight; // Maintain aspect ratio
        g2.drawImage(sprite, x, y, spriteWidth, spriteHeight, null);
    }

    public int attack(int skillChoice) {
        int damage = 0;
        switch (skillChoice) {
            case 1: // Syntax Sleuth
                if (mana >= 20) {
                    damage = 30;
                    mana -= 20;
                }
                break;
            case 2: // Logic Master
                if (mana >= 60) {
                    damage = 40;
                    mana -= 60;
                }
                break;
            case 3: // Loop Ninja
                if (mana >= 20) {
                    damage = 30;
                    mana -= 20;
                }
                break;
            case 4: // Mana Regeneration
                damage = 0; // No damage, but regenerate mana
                mana += 20;
                break;
        }
        return damage;
    }
}