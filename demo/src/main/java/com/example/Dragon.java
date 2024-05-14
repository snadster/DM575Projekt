package com.example;

public class Dragon extends Entity {
    private int lives;
    private KeyHandler kh;

    public Dragon(int px, int py, int v, KeyHandler kh) {
        super(px, py, v);
        this.lives = 2;
        this.kh = kh;
    }

    public void changeDirection() {
        if (kh.upPressed == true) {
            direction = Direction.UP;
        }

        if (kh.downPressed == true) {
            direction = Direction.DOWN;
        }

        if (kh.leftPressed == true) {
            direction = Direction.LEFT;
        }

        if (kh.rightPressed == true) {
            direction = Direction.RIGHT;
        }
    }

}