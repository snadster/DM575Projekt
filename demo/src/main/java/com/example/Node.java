package com.example;

public class Node {
    Knight knight;
    Direction direction;
    Float distance;
    Node parent;
    
    public Node(Knight knight, Direction direction, float distance, Node parent) {
        this.knight = knight;
        this.direction = direction;
        this.distance = distance;
        this.parent = parent;
    }
}