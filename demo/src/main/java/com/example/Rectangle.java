//*************************************************************************\\
//            Define rectangles to use in collision checks.                \\
//*************************************************************************\\

package com.example;

public class Rectangle
{
    protected double x;
    protected double y;
    protected double width;
    protected double height; 

    public Rectangle(double x, double y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //--------------------------------------------------------------------
    // Check when the boxes do NOT overlap by using the concept of 
    // seperating axis.
    //--------------------------------------------------------------------
    public boolean overlap(Rectangle other)
    {
        boolean dontOverlap = 
            // This is to the left of other.
            this.x + this.width < other.x    || 

            // This is to the right of other.
            other.x + other.width < this.x   ||

            // This is above other.
            this.y + this.height < other.y   ||
             
            // This is below other.
            other.y + other.height < this.y;   
        return !dontOverlap;
    }
}