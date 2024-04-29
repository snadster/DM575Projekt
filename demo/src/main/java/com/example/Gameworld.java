package com.example;

import java.lang.reflect.Array;

import javafx.scene.image.Image;

/*
 TODO: 
 FRAMES PR SECOND INT
 GAMELOOP 
 SPRITE MANAGAER
 everything to do with starting the game, 
 the follwoing things may have methods they call on from other classes, but like kind of:
 building the stage, checking for collisons,
 handling collisions
 updating sprites 
 check the reference thingy image (named: placement of methods pacman)
 speed for the ghosts
*/

public class Gameworld {
    private Pacman Pacman;
    private Ghost[] ghosts;
    private Coin[] coins;
    private State state;
    private int score;

    public Gameworld() {
        // Pacman pac = new Pacman();
        // this.Pacman = pac;

        // // Here we add the sprites for ghosts, and create new ghost objects that use them.
        // Image blueGhost = new Image("/blue guy.jpg");
        // Ghost blue = new Ghost(blueGhost, 50, 50);

        // Image orangeGhost = new Image("/orange guy.jpg");
        // Ghost orange = new Ghost(orangeGhost, 51, 50);
        
        // Image pinkGhost = new Image("/pink guy.jpg");
        // Ghost pink = new Ghost(pinkGhost, 50, 51);

        // Image redGhost = new Image("/red ghost.jpg");
        // Ghost red = new Ghost(redGhost, 52, 50);

        // Ghost[] ghostarray = {blue, orange, pink, red};
        // this.ghosts = ghostarray;

        // Coin[] coinarray = new Coin[308];
        // this.coins = coinarray;

        this.state = State.NORMAL;

    }
    
    
    // public void createCoins(Gameworld GW) {
    //     for(int y = 0; y < 21; y++) {
    //         for(int x = 0; x < 30; x++) {
    //             if (GW.map[x][y] == 0) { 
    //                 //create normal coin and add to gw list
    //             }
    //             if (GW.map[x][y] == 2) {
    //                 //create powerup
    //             }
    //         }
    //     }
    // } 
    
    // public void collectCoin(){
        
    // }


    // public void collision(){
        
    // }


    // public void EatGhost(){
        
    // }

    
    
}
