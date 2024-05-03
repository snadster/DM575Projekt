package com.example;

import javafx.scene.image.Image;

public class Coin {
    private Image sprite;
    private final int value = 10;
    private int x;
    private int y;

    public Coin(Image sprite, int x, int y) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
    }
    
}