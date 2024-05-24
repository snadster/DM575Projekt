package com.example;

import java.util.ArrayList;
//import java.util.Random;

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
    

    public Node knightBFS(Node node, int dragonX, int dragonY) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(node);
        boolean[][] reached = new boolean[21][30];
        for (int y = 0; y < 21; y++) {
            for (int x = 0; x < 30; x++) {
                reached[y][x] = false;
            }
        }
        reached[node.y][node.x] = true;
        Direction[] directions = {Direction.DOWN, Direction.LEFT, Direction.RIGHT, Direction.UP};

        while (nodes.size() > 0) {

            Node current = nodes.get(0);
            nodes.remove(current);

            for (Direction direction: directions) {
                if (direction == Direction.DOWN) {
                    int tempY = current.y + 1;
                    if (Map.map[tempY][current.x] == 0 || Map.map[tempY][current.x] == 5 || Map.map[tempY][current.x] == 3) {
                        float distance = Math.abs(dragonX - current.x) + Math.abs(dragonY - tempY);
                        Node newNode = new Node(current.x, tempY, Direction.DOWN, distance, current);
                        if (reached[newNode.y][newNode.x] == false) {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.x] = true;
                        }
                    }
                }

                if (direction == Direction.UP) {
                    int tempY = current.y - 1;
                    if (Map.map[tempY][current.x] == 0 || Map.map[tempY][current.x] == 5 || Map.map[tempY][current.x] == 3) {
                        float distance = Math.abs(dragonX - current.x) + Math.abs(dragonY - tempY);
                        Node newNode = new Node(current.x, tempY, Direction.UP, distance, current);
                        if (reached[newNode.y][newNode.x] == false) {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.y] = true;
                        }
                    } 
                }

                if (direction == Direction.LEFT) {
                    int tempX = current.x - 1;
                    if (Map.map[current.y][tempX] == 0 || Map.map[current.y][tempX] == 5 || Map.map[current.y][tempX] == 3) {
                        float distance = Math.abs(dragonX - tempX) + Math.abs(dragonY - current.y);
                        Node newNode = new Node(tempX, current.y, Direction.LEFT, distance, current);
                        if (reached[newNode.y][newNode.x] == false) {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.x] = true;
                        }
                    }
                }

                if (direction == Direction.RIGHT) {
                    int tempX = current.x + 1;
                    if (Map.map[current.y][tempX] == 0 || Map.map[current.y][tempX] == 5 || Map.map[current.y][tempX] == 3) {
                        float distance = Math.abs(dragonX - tempX) + Math.abs(dragonY - current.y);
                        Node newNode = new Node(tempX, current.y, Direction.RIGHT, distance, current);
                        if (reached[newNode.y][newNode.x] == false) {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.x] = true;
                        }
                    } 
                }
            }
            Node goal = null;
            Node result = null;
            for (Node test: nodes) {
                if (test.distance <= 32) {
                    goal = test;
                    while (goal.parent != null) {
                        goal = goal.parent;
                        result = goal;
                    }
                    return result;
                }
            }
        }
        return null;
    }
}

