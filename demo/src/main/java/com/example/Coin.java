package com.example;

import javafx.scene.image.Image;

public class Coin {
    private Image sprite;
    private int value;
    private int x;
    private int y;

    public Coin(Image sprite, int value, int x, int y) {
        this.sprite = sprite;
        this.value = value;
        this.x = x;
        this.y = y;
    }
    
}