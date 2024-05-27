//*************************************************************************\\
//                 Define nodes to use in Knight AI                        \\
//*************************************************************************\\

package com.example;

public class Node 
{
    protected int x;
    protected int y;
    protected Direction direction;
    protected Float distance;
    protected Node parent;
    
    public Node(int x, int y, Direction direction, float distance, Node parent) 
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.distance = distance;
        this.parent = parent;
    }
}