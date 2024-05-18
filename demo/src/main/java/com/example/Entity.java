package com.example;

import java.util.ArrayList;

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
                entity.positionX = 928;
            }

            if (entity.positionX >= 928 && entity.direction == Direction.RIGHT) {
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


    // kombinere de to metoder under for at faktisk checke de givne rektangler for kollisioner.
    public boolean wallCollision()
    {
        boolean entityCollisionWall = collision(1) || collision(4);
        return entityCollisionWall;
    }

    // kalder rektangle laveren på kortnummer input of checker om nogle entities rammer ind i nogle af rektanglerne.
    public boolean collision(int mapNumber)
    {
        Rectangle entityRectangle = new Rectangle(positionX+1, positionY+1, 30, 30);
        ArrayList<Rectangle> colliders = rectangleMaker(mapNumber);
        boolean yep = false;
        for(int x = 0; x < colliders.size(); x++)
        {
            if(colliders.get(x).overlap(entityRectangle))
            {
                yep = true;
            }
            
        }
        return yep;
    }

    // iterer over kortet og skaber rektangler til det givne nummer
    public ArrayList<Rectangle> rectangleMaker(int mapNumber)
    {
        ArrayList<Rectangle> listRectangles = new ArrayList<>();
        for (int x = 0; x < Map.map[0].length; x++) //Map.map er det, som kalder vores map fra filen Map.
        {
            for (int y = 0; y < Map.map.length; y++)
            {
                if (Map.map[y][x] == mapNumber)
                {
                    Rectangle rectangles = new Rectangle(x*32, y*32, 32, 32);
                    listRectangles.add(rectangles);
                }
            }
        }
        return listRectangles;
    }
}
