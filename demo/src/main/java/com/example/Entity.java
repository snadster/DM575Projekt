//*************************************************************************\\
//           Define rules for -and control- all entities                   \\
//*************************************************************************\\
package com.example;

import java.util.ArrayList;

public class Entity 
{
    protected Direction direction;
    protected int positionX;
    protected int positionY;
    protected int velocity;
    protected Map map;

    public Entity(int px, int py, int v) 
    {
        this.direction = Direction.UP;
        this.positionX = px;
        this.positionY = py;
        this.velocity = v;
    }

    // Make the entity move if there is no wall collision.
    public void move(Entity entity) 
    {
        if (!wallCollision()) 
        {
            if (entity.direction == Direction.DOWN) 
            {
                entity.positionY = entity.positionY + entity.velocity;
            }

            if (entity.direction == Direction.UP)
            {
                entity.positionY = entity.positionY - entity.velocity;
            }

            if (entity.direction == Direction.LEFT) 
            {
                entity.positionX = entity.positionX - entity.velocity;
            }

            if (entity.direction == Direction.RIGHT) 
            {
                entity.positionX = entity.positionX + entity.velocity;
            }

            if (entity.positionX <= 0 && entity.direction == Direction.LEFT) 
            {
                entity.positionX = 928;
            }

            if (entity.positionX >= 928 && entity.direction == Direction.RIGHT) 
            {
                entity.positionX = 0;
            }
        } 

        else 
        {
            entity.positionX = (entity.positionX + 5) / 32 * 32;
            entity.positionY = (entity.positionY + 5) / 32 * 32;
        } 
    }

      //*********************************\\
     //  collision checking w/rectangles  \\
    //*************************************\\
    
    // Check for collision between entities and walls, and entities and towers.
    public boolean wallCollision()
    {
        boolean entityCollisionWall = collision(1) || collision(4) || collision(6);
        return entityCollisionWall;
    }

    // Check for collision between the given map number and entities - by checking for overlap of different rectangles.
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

    // Iterate over the map and create rectangles for given numbers in map. Used for collision checks.
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
