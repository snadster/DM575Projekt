package com.example;

import javafx.scene.image.Image;

public class Dragon extends Entity {
    private int lives;

    public Dragon(Image image, int px, int py, int v) {
        super(image, px, py, v);
        this.lives = 2;
    }

    public static void changeDirection(Dragon dragon) {
        if (KeyHandler.upPressed == true) {
            dragon.direction = Direction.UP;
        }

        if (KeyHandler.downPressed == true) {
            dragon.direction = Direction.DOWN;
        }

        if (KeyHandler.leftPressed == true) {
            dragon.direction = Direction.LEFT;
        }

        if (KeyHandler.rightPressed == true) {
            dragon.direction = Direction.RIGHT;
        }
    }

}