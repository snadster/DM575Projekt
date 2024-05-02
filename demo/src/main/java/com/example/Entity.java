package com.example;

import javafx.scene.image.Image;

public class Entity {
    protected Image sprite;
    protected Direction direction;
    protected int positionX;
    protected int positionY;
    protected int velocityX;
    protected int velocityY;

    public Entity(Image image, int px, int py, int vx, int vy) {
        this.sprite = image;
        this.direction = Direction.UP;
        this.positionX = px;
        this.positionY = py;
        this.velocityX = vx;
        this.velocityY = vy;
    }
}
