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

    // jeg vil prøve at lave en metode som håndtere at checke for collections, for at holde os til dry
    // men det må blive en anden dag hvis overhovedet.
    // public void collection(int mapNumber, int newMapNumber, int attribute, int valueAttribute)
    // {
    //     int dragonX = (dragon.positionX / 32);
    //     int dragonY = (dragon.positionY / 32);
    //     if (dragon.coinCollision() && Map.map[dragonY][dragonX]== mapNumber) {
    //         attribute = attribute + valueAttribute;
    //         Map.map[dragonY][dragonX] = newMapNumber;
    //     } 
    // }

    public void collectCoin()
    {
        int dragonX = (dragon.positionX / 32);
        int dragonY = (dragon.positionY / 32);
        if (dragon.coinCollision() && Map.map[dragonY][dragonX]== 5) {
            score = score + coinValue;
            Map.map[dragonY][dragonX] = 0;
        }
        
    }

    public void collectFireball()
    {
        int dragonX = (dragon.positionX / 32);
        int dragonY = (dragon.positionY / 32);
        if (dragon.fireballCollision() && Map.map[dragonY][dragonX]== 2) {
            //mode = powermode; den skal i powermode men det ved jeg ikke hvordan man gør.
            Map.map[dragonY][dragonX] = 0;
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
