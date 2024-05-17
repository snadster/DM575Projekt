package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Entity {
    protected Direction direction;
    protected int positionX;
    protected int positionY;
    protected int velocity;
    protected Map map;

    public Entity(int px, int py, int v) {
        this.direction = Direction.DOWN;
        this.positionX = px;
        this.positionY = py;
        this.velocity = v;
    }

    public void move(Entity entity) {
        if (!wallCollision()) {
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

            if (entity.positionX <= 0 && entity.direction == Direction.LEFT) {
                entity.positionX = 960;
            }

            if (entity.positionX >= 960 && entity.direction == Direction.RIGHT) {
                entity.positionX = 0;
            }
            
        } else {
            entity.positionX = (entity.positionX + 5) / 32 * 32;
            entity.positionY = (entity.positionY + 5) / 32 * 32;
        }
       
    }

    // public boolean wallCollision(Entity entity) {
    //     boolean collision = false;
    //     ArrayList<Integer> noNoSquares = new ArrayList<Integer>(
    //         Arrays.asList(1, 3, 4)
    //     );
    //     if (entity.direction == Direction.UP && noNoSquares.contains(Map.map[(entity.positionX / 32) - 2][(entity.positionY / 32) - 1])) {
    //         collision = true;
    //     }
    //     else if (entity.direction == Direction.DOWN && noNoSquares.contains(Map.map[(entity.positionX / 32)][(entity.positionY / 32) - 1])) {
    //         collision = true;
    //     }
    //     else if (entity.direction == Direction.RIGHT && noNoSquares.contains(Map.map[(entity.positionX / 32) - 1][(entity.positionY / 32)])) {
    //         collision = true;
    //     }
    //     else if (entity.direction == Direction.LEFT && noNoSquares.contains(Map.map[(entity.positionX / 32) - 1][(entity.positionY / 32) - 2])) {
    //         collision = true;
    //     }
    //     return collision;
    // }

    public ArrayList<Rectangle> wallRectangle()
    {
        ArrayList<Rectangle> wallRectangles = new ArrayList<>();
        for (int x = 0; x < Map.map[0].length; x++) //Map.map er det, som kalder vores map fra filen Map.
        {
            for (int y = 0; y < Map.map.length; y++)
            {
                if (Map.map[y][x] == 1 || Map.map[y][x] == 4)
                {
                    Rectangle wall = new Rectangle(x*32, y*32, 32, 32);
                    wallRectangles.add(wall);
                }
            }
        }
        return wallRectangles;
    }

    public ArrayList<Rectangle> vaultRectangle(Rectangle rectangle)
    {
        ArrayList<Rectangle> vaultRectangles = new ArrayList<>();
        for (int x = 0; x < Map.map[0].length; x++) //Map.map er det, som kalder vores map fra filen Map.
        {
            for (int y = 0; y < Map.map.length; y++)
            {
                if (Map.map[y][x] == 3)
                {
                    Rectangle vault = new Rectangle(x, y, 32, 32);
                    vaultRectangles.add(vault);
                }
            }
        }
        return vaultRectangles;
    }


    public boolean wallCollision()
    {
        Rectangle entityRectangle = new Rectangle(positionX+1, positionY+1, 30, 30);
        ArrayList<Rectangle> walls = wallRectangle();
        System.out.println(walls.size());
        boolean yep = false;
        for(int x = 0; x < walls.size(); x++)
        {
            if(walls.get(x).overlap(entityRectangle))
            {
                yep = true;
                System.out.println("wall");
            }
            
        }
        return yep;
    }


}
