package com.example;

import java.util.ArrayList;
//import java.util.Random;
import java.util.Stack;
import java.util.Iterator;

public class Knight extends Entity {

    public Knight(int px, int py, int v) {
        super(px, py, v);
    
    }


/* // Determine possible directions.
public ArrayList<Direction> possibleDirections(Knight knight){
    ArrayList<Direction> posdir = new ArrayList<Direction>();
    posdir.add(Direction.DOWN);
    posdir.add(Direction.UP);
    posdir.add(Direction.LEFT);
    posdir.add(Direction.RIGHT);

    if (knight.direction == Direction.DOWN && knight.wallCollision()) {
            posdir.remove(Direction.DOWN);  
    }

    if (knight.direction == Direction.UP && knight.wallCollision()) {
            posdir.remove(Direction.UP);
    }

    if (knight.direction == Direction.LEFT && knight.wallCollision()) {
            posdir.remove(Direction.LEFT);
    } 
        
    if (knight.direction == Direction.RIGHT && knight.wallCollision()){
            posdir.remove(Direction.RIGHT);
    }
    return posdir;
}

// Determine closest direction beween knight and dragon.
public Direction ClosestDirection(Knight knight, int DragonPositionX, int DragonPositionY){
    float shortestDistance = 0;
    ArrayList<Direction> possibles = possibleDirections(knight);
    Direction bestDirection = null;

    for (int i = 0; i < possibles.size(); i++) {
        int x = 0;
        int y = 0;
        if (possibles.get(i) == Direction.DOWN) {
            x = knight.positionX;
            y = knight.positionY + knight.velocity;
        }
        else if (possibles.get(i) == Direction.UP) {
            x = knight.positionX;
            y = knight.positionY - knight.velocity;
        }
        else if (possibles.get(i) == Direction.RIGHT) {
            x = knight.positionX + knight.velocity;
            y = knight.positionY;
        }
        else if (possibles.get(i) == Direction.LEFT) {
            x = knight.positionX - knight.velocity;
            y = knight.positionY;
        }

         // Get the Manhattan distance between target (Dragon) and knight
        float distance = Math.abs(DragonPositionX - x) + Math.abs(DragonPositionY - y);

            // Shortest distance so far
            if(distance < shortestDistance || shortestDistance == 0){
                shortestDistance = distance;
                bestDirection = possibles.get(i);
            }
        }
        
        return bestDirection;
    }  

// Determine furthest direction between knight and dragon.
public Direction FurthestDirection(Knight knight, int DragonPositionX, int DragonPositionY) {
    float farthestDistance = 0;
    ArrayList<Direction> possibles = possibleDirections(knight);
    Direction bestDirection = null;

    for (int i = 0; i < possibles.size(); i++) {
        int x = 0;
        int y = 0;
        if (possibles.get(i) == Direction.DOWN) {
            x = knight.positionX;
            y = knight.positionY + knight.velocity;
        }
        else if (possibles.get(i) == Direction.UP) {
            x = knight.positionX;
            y = knight.positionY - knight.velocity;
        }
        else if (possibles.get(i) == Direction.RIGHT) {
            x = knight.positionX + knight.velocity;
            y = knight.positionY;
        }
        else if (possibles.get(i) == Direction.LEFT) {
            x = knight.positionX - knight.velocity;
            y = knight.positionY;
        }

         // Get the Manhattan distance between target (Dragon) and knight
        float distance = Math.abs(DragonPositionX - x) + Math.abs(DragonPositionY - y);

            // Furthest distance so far
            if(distance > farthestDistance){
                farthestDistance = distance;
                bestDirection = possibles.get(i);
            }
        }
        
        return bestDirection;
    }  

    // Randomize the choice of direction.
    public Direction randomDirection(Knight knight) 
    {
        ArrayList<Direction> possibles = possibleDirections(knight);
        Random rand = new Random();
        int randomIndex = rand.nextInt(2);
        Direction newDirection = possibles.get(randomIndex);
        return newDirection;
    }

     */
    

    public Direction knightAI(Node node, int dragonX, int dragonY) {
        Direction[] directions = {Direction.UP, Direction.DOWN, Direction.RIGHT, Direction.LEFT};
        Stack<Node> stack = new Stack<Node>();
        ArrayList<Direction> result = new ArrayList<Direction>();
        Iterator<Node> iterator = stack.iterator();
        Node current = node;
        // Expand while stack is not empty and we have not found the goal.
        while (current.distance > 32) {
            while (iterator.hasNext()) {
                Node next = iterator.next();
                if (next.distance < current.distance) {   // Heuristic
                    current = next;
                }
            }
            stack.push(current);
            result.add(current.knight.direction);
            for (Direction direction: directions) {
                if (direction == Direction.UP) {
                    Knight test = new Knight(current.knight.positionX, current.knight.positionY - current.knight.velocity, current.knight.velocity);
                    if (!test.wallCollision()){
                        float dis = Math.abs(dragonX - test.positionX) + Math.abs(dragonY - test.positionY);
                        Node newNode = new Node(test, dis);
                        stack.push(newNode);
                    }   
                } 
                if (direction == Direction.DOWN) {
                    Knight test = new Knight(current.knight.positionX, current.knight.positionY + current.knight.velocity, current.knight.velocity);
                    if (!test.wallCollision()){
                        float dis = Math.abs(dragonX - test.positionX) + Math.abs(dragonY - test.positionY);
                        Node newNode = new Node(test, dis);
                        stack.push(newNode);
                    }   
                } 
                if (direction == Direction.RIGHT) {
                    Knight test = new Knight(current.knight.positionX + current.knight.velocity, current.knight.positionY, current.knight.velocity);
                    if (!test.wallCollision()){
                        float dis = Math.abs(dragonX - test.positionX) + Math.abs(dragonY - test.positionY);
                        Node newNode = new Node(test, dis);
                        stack.push(newNode);
                    }   
                } 
                if (direction == Direction.LEFT) {
                    Knight test = new Knight(current.knight.positionX - current.knight.velocity, current.knight.positionY, current.knight.velocity);
                    if (!test.wallCollision()){
                        float dis = Math.abs(dragonX - test.positionX) + Math.abs(dragonY - test.positionY);
                        Node newNode = new Node(test, dis);
                        stack.push(newNode);
                    }   
                } 
            }
            
        }
        return result.get(1);
    }

}

