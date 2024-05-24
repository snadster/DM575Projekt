package com.example;

public class Node {
    int x;
    int y;
    Direction direction;
    Float distance;
    Node parent;
    
    public Node(int x, int y, Direction direction, float distance, Node parent) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.distance = distance;
        this.parent = parent;
    }
}