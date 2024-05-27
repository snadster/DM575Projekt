//*************************************************************************\\
//            Define rectangles to use in collision checks.                \\
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

    //--------------------------------------------------------------------
    // Check when the boxes do NOT overlap by using a concept of 
    // seperating axis.
    //--------------------------------------------------------------------
    public boolean overlap(Rectangle other)
    {
        boolean dontOverlap = 
            this.x + this.width < other.x    || //this is to the left of other
            other.x + other.width < this.x   || //this is to the right of other
            this.y + this.height < other.y   || // this is above other
            other.y + other.height < this.y;   // this is below other
        return !dontOverlap;
    }
}