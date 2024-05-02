package com.example;

import javafx.scene.image.Image;

public class Pacman extends Entity {
    private int lives;

    public Pacman(Image image, int px, int py, int vx, int vy) {
        super(image, px, py, vx, vy);
        this.lives = 2;
    }

}