package com.example;

import javafx.scene.image.Image;

public class Entity {
    protected Image sprite;
    protected Direction direction;
    protected int positionX;
    protected int positionY;
    protected int velocity;

    public Entity(Image image, int px, int py, int v) {
        this.sprite = image;
        this.direction = Direction.UP;
        this.positionX = px;
        this.positionY = py;
        this.velocity = v;
    }

    public void move(Entity entity) {
        if (entity.direction == Direction.DOWN) {
            entity.positionY = entity.positionY - entity.velocity;
        }

        if (entity.direction == Direction.UP) {
            entity.positionY = entity.positionY + entity.velocity;
        }

        if (entity.direction == Direction.LEFT) {
            entity.positionX = entity.positionX - entity.velocity;
        }

        if (entity.direction == Direction.RIGHT) {
            entity.positionX = entity.positionX + entity.velocity;
        }
    }
}
