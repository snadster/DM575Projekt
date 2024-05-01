package com.example;

public class Vector
{
    public double x;
    public double y;

    public Vector(double x, double y)
    {
       this.set(x,y);
    }

    public void set(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}