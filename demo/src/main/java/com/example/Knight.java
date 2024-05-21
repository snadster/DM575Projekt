package com.example;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;



public class Knight extends Entity {

    public Knight(int px, int py, int v) {
        super(px, py, v);
    
    }

//Gameworld gw = new Gameworld(Dragon);
public boolean canMoveLeft = false;
public boolean canMoveRight = false;
public boolean canMoveUp = false;
public boolean canMoveDown = false;

public void possibleDirections(){

    // Check if knight can move down on the board
    while(this.positionX > 600) {
        canMoveDown = true;
    }

     // Check if knight can move up on the board
     while(this.positionX > 30) {
        canMoveUp = true;
     }

    // Check if knight can move right on the board


    // Check if knight can move left on the board
}


//Called once per frame

public void DetermineKnightDirection(Entity knight, int DragonPositionX, int DragonPositionY ){
    Direction direction = ClosestDirection(DragonPositionX, DragonPositionY);

}

public Direction ClosestDirection(int DragonPositionX, int DragonPositionY){
    float shortestDistance = 0;
    Direction lastDirection = ;
    Direction newDirection = ;

    if(... && Direction != DOWN){

        // Get the Manhattan distance between target (Dragon) and knight
        int distance = Math.abs(Dragon[positionX] - this.positionX) + Math.abs(Dragon[positionY]-this.positionY);

        if(distance < shortestDistance || shortestDistance == 0){
            shortestDistance = distance;
            newDirection = "retning";
        }
    }
    return newDirection;
    
}

/*ridder bevægelse  (celine vil gerne kigge lidt her)
        brug samme funktion til at de kan flytte sig
        ai til søgealgoritme
        måske fire forskellige versioner
            bare sårn. den ene tager 50% random, den anden
            tager 25% random etc.
        velocity tilpasset efter dragon mans hast
        funktion som tager koordinater som input - skal kaldes i gameworld
*/
/* 
 public static void BFS(Gameworld gw){
    int row = 21; // number of rows
    int column = 30; // number of column
    int[][] matrix; // = row * column; // size of matrix

    // Define source and target
    int sr; //source row
    int sc; // source column
    int tr; // target row
    int tc; // target column 
    int[][] target;

    // Direction vectors
    int[] dr = {-1, +1, 0, 0}; //rows
    int[] dc = {0, 0, +1, -1}; // columns

    //Implement Queues
    LinkedList<Integer> rowQueue = new LinkedList<Integer>(); // make a queue to store nodes' rows
    LinkedList<Integer> columnQueue = new LinkedList<Integer>(); // make a queue to store nodes' columns

    //Track steps taken
    int moveCount = 0;
    int nodes_left_in_layer = 1;
    int nodes_left_next_layer = 0;

    boolean reachedTarget = false; // keep track of target reached
    boolean[][] visited = false; // keep track of visited nodes


    //The code for BFS
    rowQueue.add(sr); //add the row of the source to rowQueue
    columnQueue.add(sc); // add the column of the source to columnQueue
    visited[sr][sc] = true;

    while (rowQueue.size() > 0 || columnQueue.size() > 0){
        int r = rowQueue.removeFirst();
        int c = columnQueue.removeFirst();
        if(matrix[r][c] == target){
            reachedTarget = true;
            break;
        }
        checkNeighbours(r, c);
        nodes_left_in_layer = nodes_left_in_layer - 1;
        if (nodes_left_in_layer == 0){
            nodes_left_in_layer = nodes_left_next_layer;
            nodes_left_next_layer = 0;
            moveCount = moveCount + 1;
        }
    }
    if(reachedTarget){
        return move...;
    }
    private static void checkNeighbours(int r; int c) {
        for(int i = 0; i < 4; i++){ //4 = number of directions
            int rr = r + dr[i]; // new coordinate row
            int cc = c + dc[i]; // new coordinate column
            

            // Avoid including out of bounds locations
            if(rr < 0 || cc < 0){
                continue;
            }
            if(rr >= row || cc >= column){
                continue;
            } 

            // Avoid visiting same nodes and walls
            if(visited[rr][cc]){
                continue;
            }
            if(matrix[rr][cc] == '1' || matrix[rr][cc] == '4'){
                continue;
            }
            rowQueue.add(rr); 
            columnQueue.add(cc);
            visited[rr][cc] = true;
            nodes_left_next_layer = nodes_left_next_layer + 1;
        }
    } 
}
*/
/* 
public static Object BFS(Gameworld gw, int sr, int sc, int tr, int tc){
     // Direction vectors
     int[] dr = {-1, +1, 0, 0}; //rows
     int[] dc = {0, 0, +1, -1}; // columns
     int source = Map.map[sr][sc];
     int target = Map.map[tr][tc];
    
    LinkedList<Integer> queue = new LinkedList<>();  // make a empty queue
    queue.add(source); // add source to the queue

    Dictionary<Integer, Integer> parent = new Hashtable<>();
    parent.put(source, null);
    while (queue.isEmpty() == false){
        int current = queue.removeFirst();
        if (current == target) {
            return getPath(parent, current);
        }
        for(int i = 0; i < 4; i++) {
            int ssr = sr + dr[i];
            int ssc = sc + dc[i];
            if (u != parent.keys())
                parent[u] = current;
                queue.add(u);
        }
                
        }
          
        }
    private static Object getPath(Dictionary<Integer, Integer> parent, int target) {
        LinkedList<int[][]> solution = new LinkedList<>(); // empty linked list a first
        int [][] current = target;
        while (current != null){
            solution.addFirst(current);
            current = parent.get(current);
            }
        return current;
    }    

*/ 
}
