//*************************************************************************\\
//          Create dragon entity and define unique behaviour.              \\
//*************************************************************************\\

package com.example;

public class Dragon extends Entity 
{
    protected int lives;
    private KeyHandler keyH;

    public Dragon(int px, int py, int v, KeyHandler keyH) 
    {
        super(px, py, v);
        this.lives = 2;
        this.keyH = keyH;
    }

    //--------------------------------------------------------------------
    // Update the dragon's direction according to the key input.
    //--------------------------------------------------------------------
    public void changeDirection() 
    {
        if (keyH.upPressed) 
        {
            direction = Direction.UP;
        }

        if (keyH.downPressed) 
        {
            direction = Direction.DOWN;
        }

        if (keyH.leftPressed) 
        {
            direction = Direction.LEFT;
        }

        if (keyH.rightPressed) 
        {
            direction = Direction.RIGHT;
        }
    }

       //*****************************\\
      //     Collision checking        \\
     //*********************************\\
    // Use the method from entity to add knight vault rectangles for collision checking.
    @Override 
    public boolean wallCollision()
    {
        boolean dragonCollisionWalls = super.wallCollision() || collision(3);
        return dragonCollisionWalls;
    }

    public boolean coinCollision()
    {
        boolean dragonCollisionCoin = collision(5);
        return dragonCollisionCoin;
    }

    public boolean fireballCollision()
    {
        boolean dragonCollisionFireball = collision(2);
        return dragonCollisionFireball;
    }

    // Create a rectangle for the dragon sprite using the Rectangle class.
    public Rectangle dragonRectangle() 
    {
        Rectangle dragonRectangle = new Rectangle(this.positionX, this.positionY, 32, 32);
        return dragonRectangle;
    }
}