package com.example;

public class Gameworld {
    private Pacman pacciboy;
    private Ghost[] ghosts;
    private Coin[] coins;
    private State state;
    private int score;
    private final boolean[][] map = null; //sup, herved indsat null så det kører uden fejl

    public Gameworld() {

    }
    
    public void createCoins() {
        for(int i = 0; i < 21; i++) {
            for(int k = 0; k < 30; k++) {
                if (false) { //her igen indsat false indtil den er færdig så den kører uden fejl
                    //create coin and add to GW list
                }
            }
        }
    } 
}
