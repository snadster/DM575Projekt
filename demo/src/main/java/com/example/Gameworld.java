package com.example;

public class Gameworld {

    protected Dragon dragon;
    protected Knight[] knights;
    protected int coinValue;
    protected State state;
    protected int score;

    public Gameworld(Dragon dragon, Knight[] knights) {

        this.dragon = dragon;
        this.knights = knights;
        this.coinValue = 10;
        this.state = State.NORMAL;
        this.score = 0;

    }

    public void collectCoin(){
        int dragonX = (dragon.positionX / 32);
        int dragonY = (dragon.positionY / 32);
        if (Map.map[dragonX][dragonY] == 5) {
            score = score + coinValue;
            Map.map[dragonX][dragonY] = 0;
        }
        
    }

    public void gameOver() {

        boolean gameOver = false;

        int CoinsLeft = 0;
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 21; y++) {
                if (Map.map[y][x] == 5) {
                    CoinsLeft++;
                }
            }
        }
        if (CoinsLeft == 0) {
            gameOver = true;
        }

        if (dragon.lives == 0) {
            gameOver = true;
        }

        if (gameOver == true) {
           state = State.GAMEOVER;
        }
    }

}
