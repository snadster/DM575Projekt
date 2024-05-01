package com.example;

//the start of our collisioon handler using rectangles
//

public class Rectangle
{
    public double x;
    public double y;
    public double width; //if these two arent double, .height
    public double height; // and .width wont work with them...

    public Rectangle(double x, double y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public boolean collisionWall(Rectangle other)
    {
        // we use a concept of seperating axis to
        //check when our boxes do NOT overlap
        boolean dontOverlap = 
            this.x + this.width < other.x   || //this is to the left of other
            other.x + other.width < this.x  || //this is to the right of other
            this.y + this.height < other.y  ||  // this is above other
            other.y + other.height < this.y;   // this is below other
       
        return !dontOverlap;

    }

}