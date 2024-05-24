package com.example;
import java.util.ArrayList;
//import java.util.Random;
import java.util.concurrent.*; 


public class Gameworld {

    protected Dragon dragon;
    protected ArrayList<Knight> knights;
    protected int coinValue;
    protected State state;
    protected int score;

    public Gameworld(Dragon dragon, ArrayList<Knight> knightarray) {

        this.dragon = dragon;
        this.knights = knightarray;
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
        if (dragon.fireballCollision() && Map.map[dragonY][dragonX] == 2) {
            Map.map[dragonY][dragonX] = 0;
            state = State.POWER;
            Runnable endPowerState = () -> state = State.NORMAL;
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.schedule(endPowerState, 10, TimeUnit.SECONDS);
           // executeSelf.schedule(killSelf, 10.1, TimeUnit.SECONDS);

        }
    }

    /* ignorer disse forsøg på at få stopped den der runnable executor
    public void killSelf()
    {
        Runnable killSelf = () -> 
        ScheduledExecutorService executeSelf = Executors.newSingleThreadScheduledExecutor();
    }
    */

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

    /* public void GiveKnightDirection(Knight knight) {
        Random rand = new Random();
        int x = rand.nextInt(2);
        if (x == 7) {
            Direction direction = knight.randomDirection(knight);
            knight.direction = direction;
        }
        else {
            if (state == State.NORMAL) {
                Direction direction = knight.ClosestDirection(knight, dragon.positionX, dragon.positionY); 
                knight.direction = direction;
            }
            else if (state == State.POWER) {
                Direction direction = knight.FurthestDirection(knight, dragon.positionX, dragon.positionY); 
                knight.direction = direction;
            } 
        } 
    } */

}
