package com.example;

public class Dragon extends Entity {
    protected int lives;
    private KeyHandler kh;

    public Dragon(int px, int py, int v, KeyHandler kh) {
        super(px, py, v);
        this.lives = 2;
        this.kh = kh;
    }

    public void changeDirection() {
        if (kh.upPressed == true) {
            direction = Direction.UP;
        }

        if (kh.downPressed == true) {
            direction = Direction.DOWN;
        }

        if (kh.leftPressed == true) {
            direction = Direction.LEFT;
        }

        if (kh.rightPressed == true) {
            direction = Direction.RIGHT;
        }
    }

    // vi bruger metoden fra entity, men tilføjer at vaults ikke kan begås i.
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

    // denne metode laver en rectangel til dragen ved brug af vores fancy rectangle klasse
    public Rectangle dragonRectangle() 
    {
        Rectangle dragonRectangle = new Rectangle(this.positionX, this.positionY, 32, 32);
        return dragonRectangle;
    }


}