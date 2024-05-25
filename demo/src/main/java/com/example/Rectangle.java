//*************************************************************************\\
//            Define rectangles to use in collision checks                 \\
//*************************************************************************\\

package com.example;

public class Rectangle
{
    public double x;
    public double y;
    public double width;
    public double height; 

    public Rectangle(double x, double y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlap(Rectangle other)
    {
        //we use a concept of seperating axis to check when our boxes do NOT overlap
        boolean dontOverlap = 
            this.x + this.width < other.x    || //this is to the left of other
            other.x + other.width < this.x   || //this is to the right of other
            this.y + this.height < other.y   || // this is above other
            other.y + other.height < this.y;   // this is below other
        return !dontOverlap;
    }
}