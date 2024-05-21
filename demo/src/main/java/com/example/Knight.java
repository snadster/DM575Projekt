package com.example;


public class Knight extends Entity {

    public Knight(int px, int py, int v) {
        super(px, py, v);
    
    }

public boolean canMoveLeft = false;
public boolean canMoveRight = false;
public boolean canMoveUp = false;
public boolean canMoveDown = false;

// Trying to find out which directions are possible. Sould maybe be a part of move.
public void possibleDirections(){
    if (this.direction == Direction.DOWN) {
        canMoveDown = true;
        canMoveLeft = true;
        canMoveRight = true;
        canMoveUp = false;
    }

    if (this.direction == Direction.UP) {
        canMoveUp = true;
        canMoveLeft = true;
        canMoveRight = true;
        canMoveDown = false;
    }

    if (this.direction == Direction.LEFT) {
        canMoveDown = true;
        canMoveUp = true;
        canMoveLeft = true;
        canMoveRight = false;
    }

    if (this.direction == Direction.RIGHT) {
        canMoveDown = true;
        canMoveUp = true;
        canMoveRight = true;
        canMoveLeft = false;
    }
}


public void DetermineKnightDirection(Entity knight, int DragonPositionX, int DragonPositionY ){
    Direction direction = ClosestDirection(DragonPositionX, DragonPositionY); 
    // mangler randomize
}

public Direction ClosestDirection(int DragonPositionX, int DragonPositionY){
    float shortestDistance = 0;
    Direction lastDirection = this.direction;
    Direction newDirection = direction;

    
    // Need to change direction after wall collision. Note missing something if there's an junction
    if(wallCollision()){

        // If we can move up and are not reversing direction
        if(canMoveUp && lastDirection != Direction.DOWN){

         // Get the Manhattan distance between target (Dragon) and knight
        float distance = Math.abs(DragonPositionX - this.positionX) + Math.abs(DragonPositionY - this.positionY);

            // Shortest distance so far
            if(distance < shortestDistance || shortestDistance == 0){
                shortestDistance = distance;
                newDirection = Direction.UP;
            }
        }

        // If we can move down and are not reversing direction
        else if(canMoveDown && lastDirection != Direction.UP){

        // Get the Manhattan distance between target (Dragon) and knight
        float distance = Math.abs(DragonPositionX - this.positionX) + Math.abs(DragonPositionY - this.positionY);

            // Shortest distance so far
            if(distance < shortestDistance || shortestDistance == 0){
                shortestDistance = distance;
                newDirection = Direction.DOWN;
            }
        }

        // If we can move left and are not reversing direction
        else if(canMoveLeft && lastDirection != Direction.RIGHT){

         // Get the Manhattan distance between target (Dragon) and knight
        float distance = Math.abs(DragonPositionX - this.positionX) + Math.abs(DragonPositionY - this.positionY);

            // Shortest distance so far
            if(distance < shortestDistance || shortestDistance == 0){
                shortestDistance = distance;
                newDirection = Direction.LEFT;
            }
        }

        // If we can move right and are not reversing direction
        else if(canMoveRight && lastDirection != Direction.LEFT){

        // Get the Manhattan distance between target (Dragon) and knight
        float distance = Math.abs(DragonPositionX - this.positionX) + Math.abs(DragonPositionY - this.positionY);

            // Shortest distance so far
            if(distance < shortestDistance || shortestDistance == 0){
                shortestDistance = distance;
                newDirection = Direction.RIGHT;
            }
        }

    }

    return newDirection;
}


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
