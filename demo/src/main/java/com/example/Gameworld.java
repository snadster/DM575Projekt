package com.example;

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

    protected Entity dragon;
    protected Entity[] knights;
    protected Coin[] coins;
    protected State state;
    protected int score;

    public Gameworld(Entity dragon, Entity[] knights) {


        // Coin[] coinarray = new Coin[308];
        // this.coins = coinarray;
        this.dragon = dragon;
        this.knights = knights;
        this.state = State.NORMAL;

    }

    
    
    public void createCoins(Gameworld GW) {
        for(int y = 0; y < 21; y++) {
            for(int x = 0; x < 30; x++) {
                if (Map.map[x][y] == 0) { 
                    //create normal coin and add to gw list
                }
            }
        }
    } 
    
    // public void collectCoin(){
        
    // }


    // public void EatKnight(){
        
    // }

}
