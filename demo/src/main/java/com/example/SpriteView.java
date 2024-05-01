package com.example;

import java.util.Vector;
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
    public Vector position;
    public Vector  velocity;
    public Image sprite;
    public Rectangle boundary;

    public SpriteView()
    {
        position = new Vector(0,0);
        velocity = new Vector(0,0);
        boundary = new Rectangle(0,0,0,0); // we update this when we use an image but neutralized for now 
    }

    public void setPosition(double x, double y)
    {
        position.set(x,y);
    }

    public void setSprite(String file, int sx, int sy, int sw, int sh)
    {
        sprite = new Image(file);
        


        boundary.width = sprite.getWidth();
        boundary.height = sprite.getHeight();

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