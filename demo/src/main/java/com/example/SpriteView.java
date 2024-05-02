package com.example;


import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.canvas.GraphicsContext;

// here we use our Rectangle, we make sprites and their boundaries
// we do that to check if the boundaries of the sprites overlap
// this includes walls, characters, and coins.

public class SpriteView
{
    public Entity entity;
    public Rectangle boundary;

    public SpriteView(Entity entity)
    {
        this.entity = entity;
        this.boundary = new Rectangle(x,y,32,32); // we update this when we use an image but neutralized for now  
    }

    public void setPosition(double x, double y)
    {
        position.set(x,y);
    }

    public void spriteBundariesDragon(String file)
    {
        
        boundary.width = entity.sprite.getWidth();
        boundary.height = entity.sprite.getHeight();

    }

    public Rectangle boundary()
    {
        boundary.x = position.x;
        boundary.y = position.y;
        return boundary;

    }

    public boolean overlaps(SpriteView other)
    {
        return this.boundary().overlaps(other.boundary());
    }
    
    public void drawSprite(GraphicsContext context) //render = drawSprite
    {
        context.drawImage(sprite, position.x, position.y);
    }

}