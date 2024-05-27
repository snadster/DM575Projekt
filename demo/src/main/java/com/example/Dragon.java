//*************************************************************************\\
//                 Create and control the entity, dragon                   \\
//*************************************************************************\\
package com.example;

public class Dragon extends Entity 
{
    protected int lives;
    private KeyHandler kh;

    public Dragon(int px, int py, int v, KeyHandler kh) 
    {
        super(px, py, v);
        this.lives = 2;
        this.kh = kh;
    }

    //--------------------------------------------------------------------
    // Update the dragon's direction matching the pressed key input.
    //--------------------------------------------------------------------
    public void changeDirection() 
    {
        if (kh.upPressed == true) 
        {
            direction = Direction.UP;
        }

        if (kh.downPressed == true) 
        {
            direction = Direction.DOWN;
        }

        if (kh.leftPressed == true) 
        {
            direction = Direction.LEFT;
        }

        if (kh.rightPressed == true) 
        {
            direction = Direction.RIGHT;
        }
    }

      //*****************************\\
     //     collision checking        \\
    //*********************************\\

    // Use the method from entity to add the knight vault as a collision.
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

    // Create a rectangle around the dragon sprite using the Rectangle class.
    public Rectangle dragonRectangle() 
    {
        Rectangle dragonRectangle = new Rectangle(this.positionX, this.positionY, 32, 32);
        return dragonRectangle;
    }
}