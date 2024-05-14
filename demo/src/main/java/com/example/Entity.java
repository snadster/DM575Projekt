package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Entity {
    protected Direction direction;
    protected int positionX;
    protected int positionY;
    protected int velocity;

    public Entity(int px, int py, int v) {
        this.direction = Direction.DOWN;
        this.positionX = px;
        this.positionY = py;
        this.velocity = v;
    }

    public void move(Entity entity) {
        if (wallCollision(entity) == false) {
             if (entity.direction == Direction.DOWN) {
                entity.positionY = entity.positionY + entity.velocity;
            }

            if (entity.direction == Direction.UP) {
                entity.positionY = entity.positionY - entity.velocity;
            }

            if (entity.direction == Direction.LEFT) {
                entity.positionX = entity.positionX - entity.velocity;
            }

            if (entity.direction == Direction.RIGHT) {
                entity.positionX = entity.positionX + entity.velocity;
            }
        }
       
    }
// byt om på x og y og tilføj flere som også checker diverse etc.
    public boolean wallCollision(Entity entity) {
        boolean collision = false;
        ArrayList<Integer> noNoSquares = new ArrayList<Integer>(
            Arrays.asList(1, 3, 4)
        );
        if (entity.direction == Direction.UP && noNoSquares.contains(Map.map[(entity.positionX / 32)][(entity.positionY / 32)])) {
            collision = true;
        }
        if (entity.direction == Direction.DOWN && noNoSquares.contains(Map.map[(entity.positionX / 32)][(entity.positionY / 32)])) {
            collision = true;
        }
        if (entity.direction == Direction.RIGHT && noNoSquares.contains(Map.map[(entity.positionX / 32)][(entity.positionY / 32)])) {
            collision = true;
        }
        if (entity.direction == Direction.LEFT && noNoSquares.contains(Map.map[(entity.positionX / 32)][(entity.positionY / 32)])) {
            collision = true;
        }
        return collision;
    }
}
