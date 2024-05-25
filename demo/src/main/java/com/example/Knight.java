//*************************************************************************\\
//                 Create and control Knight Entity                        \\
//*************************************************************************\\

package com.example;

import java.util.ArrayList;

public class Knight extends Entity 
{
    boolean chase;
    int scatterX;
    int scatterY;

    public Knight(int px, int py, int v) 
    {
        super(px, py, v);
        this.chase = true;
        this.scatterX = 0;
        this.scatterY = 0;
    }

    public void updateDirection(Knight knight, Direction direction) 
    {
        knight.direction = direction;
    }

    public void updateChase(Knight knight, boolean chase) 
    {
        knight.chase = chase;
    }

    public Node knightBFS(Node node, int dragonX, int dragonY, boolean powermode) 
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(node);
        boolean[][] reached = new boolean[21][30];
        for (int y = 0; y < 21; y++) 
        {
            for (int x = 0; x < 30; x++) 
            {
                reached[y][x] = false;
            }
        }
        reached[node.y][node.x] = true;
        Direction[] directions = {Direction.DOWN, Direction.LEFT, Direction.RIGHT, Direction.UP};

        while (nodes.size() > 0) 
        {

            Node current = nodes.get(0);
            nodes.remove(current);

            for (Direction direction: directions) 
            {
                if (direction == Direction.DOWN && current.y < 20) 
                {
                    int tempY = current.y + 1;
                    if (Map.map[tempY][current.x] == 0 || Map.map[tempY][current.x] == 5 || Map.map[tempY][current.x] == 3) 
                    {
                        float distance = Math.abs(dragonX - current.x) + Math.abs(dragonY - tempY);
                        Node newNode = new Node(current.x, tempY, Direction.DOWN, distance, current);
                        if (reached[newNode.y][newNode.x] == false) 
                        {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.x] = true;
                        }
                    }
                }

                if (direction == Direction.UP && current.y > 0) 
                {
                    int tempY = current.y - 1;
                    if (Map.map[tempY][current.x] == 0 || Map.map[tempY][current.x] == 5 || Map.map[tempY][current.x] == 3) 
                    {
                        float distance = Math.abs(dragonX - current.x) + Math.abs(dragonY - tempY);
                        Node newNode = new Node(current.x, tempY, Direction.UP, distance, current);
                        if (reached[newNode.y][newNode.x] == false) 
                        {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.x] = true;
                        }
                    } 
                }

                if (direction == Direction.LEFT && current.x >= 0) 
                {
                    if (current.x == 0) 
                    //To account for wrapping around the map
                    {
                        float distance = Math.abs(dragonX - 29) + Math.abs(dragonY - current.y);
                        Node newNode = new Node(29, current.y, Direction.RIGHT, distance, current);
                        if (reached[newNode.y][newNode.x] == false) 
                        {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.x] = true;
                        }
                    }
                    else 
                    {
                        int tempX = current.x - 1;
                        if (Map.map[current.y][tempX] == 0 || Map.map[current.y][tempX] == 5 || Map.map[current.y][tempX] == 3) 
                        {
                            float distance = Math.abs(dragonX - tempX) + Math.abs(dragonY - current.y);
                            Node newNode = new Node(tempX, current.y, Direction.LEFT, distance, current);
                            if (reached[newNode.y][newNode.x] == false) 
                            {
                                nodes.add(newNode);
                                reached[newNode.y][newNode.x] = true;
                            }
                        }
                    }
                    
                }

                if (direction == Direction.RIGHT && current.x <= 29) 
                {
                    if (current.x == 29)
                    //To account for wrapping around the map
                    {
                        float distance = Math.abs(dragonX - 0) + Math.abs(dragonY - current.y);
                        Node newNode = new Node(0, current.y, Direction.RIGHT, distance, current);
                        if (reached[newNode.y][newNode.x] == false) 
                        {
                            nodes.add(newNode);
                            reached[newNode.y][newNode.x] = true;
                        }
                    }
                    else 
                    {
                        int tempX = current.x + 1;
                        if (Map.map[current.y][tempX] == 0 || Map.map[current.y][tempX] == 5 || Map.map[current.y][tempX] == 3) 
                        {
                            float distance = Math.abs(dragonX - tempX) + Math.abs(dragonY - current.y);
                            Node newNode = new Node(tempX, current.y, Direction.RIGHT, distance, current);
                            if (reached[newNode.y][newNode.x] == false) 
                            {
                                nodes.add(newNode);
                                reached[newNode.y][newNode.x] = true;
                            }
                        } 
                    }
                    
                }
            }
            Node goal = null;
            for (Node test: nodes) 
            {
                if (test.distance >= 15 && powermode == true) 
                {
                    goal = test;
                    while (goal.parent != node) 
                    {
                        goal = goal.parent;
                    }
                    return goal;
                }
                if (test.distance <= 1 && powermode == false) 
                {
                    goal = test;
                    while (goal.parent != node) 
                    {
                        goal = goal.parent;
                    }
                    return goal;
                }
            }
        }
        return null;
    }
}

