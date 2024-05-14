package com.example;

public class Dragon extends Entity {
    private int lives;
    private KeyHandler kh;

    public Dragon(int px, int py, int v, KeyHandler kh) {
        super(px, py, v);
        this.lives = 2;
        this.kh = kh;
    }

    public static void changeDirection(Dragon dragon) {
        if (dragon.kh.upPressed == true) {
            dragon.direction = Direction.UP;
        }

        if (dragon.kh.downPressed == true) {
            dragon.direction = Direction.DOWN;
        }

        if (dragon.kh.leftPressed == true) {
            dragon.direction = Direction.LEFT;
        }

        if (dragon.kh.rightPressed == true) {
            dragon.direction = Direction.RIGHT;
        }
    }

    
}