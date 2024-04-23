package com.example;

import javafx.scene.image.Image;

public class Ghost {
    private Image sprite;
    private Direction direction;
    private int x;
    private int y;

    public Ghost(Image sprite, int x, int y) {
        Image blueGhost = new Image("/blue guy.jpg");
        this.sprite = sprite;
        this.direction = Direction.UP;
        this.x = x;
        this.y = y;
    }
}

