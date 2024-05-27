//*************************************************************************\\
//         Contain game-mechanincs; collections and gameover               \\
//*************************************************************************\\

package com.example;
import java.util.ArrayList;
import java.util.concurrent.*; 


public class Gameworld 
{
    protected Dragon dragon;
    protected ArrayList<Knight> knights;
    protected int coinValue;
    protected State state;
    protected int score;

    public Gameworld(Dragon dragon, ArrayList<Knight> knightarray) 
    {
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

    //--------------------------------------------------------------------
    // Collect coins and remove them from the board.
    //--------------------------------------------------------------------
    public void collectCoin()
    {
        int dragonX = ((dragon.positionX + 5) / 32);
        int dragonY = ((dragon.positionY + 5) / 32);
        if (dragon.coinCollision() && Map.map[dragonY][dragonX]== 5) 
        {
            score = score + coinValue;
            Map.map[dragonY][dragonX] = 0;
        }
    }

    //--------------------------------------------------------------------
    // Collect fireballs and remove them from the board. Change the state
    // to power mode.
    //--------------------------------------------------------------------
    public void collectFireball()
    {
        int dragonX = (dragon.positionX / 32);
        int dragonY = (dragon.positionY / 32);
        if (dragon.fireballCollision() && Map.map[dragonY][dragonX] == 2) 
        {
            Map.map[dragonY][dragonX] = 0;
            state = State.POWER;
            // Make the state change back to normal after 10.1 seconds.
            Runnable endPowerState = () -> state = State.NORMAL;
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.schedule(endPowerState, 10, TimeUnit.SECONDS);
           // executeSelf.schedule(killSelf, 10.1, TimeUnit.SECONDS);
        }
    }

    //--------------------------------------------------------------------
    // Check if the game is over.
    //--------------------------------------------------------------------
    public int gameOver() 
    {
        int CoinsLeft = 0;
        for (int x = 0; x < 30; x++) 
        {
            for (int y = 0; y < 21; y++) 
            {
                if (Map.map[y][x] == 5) 
                {
                    CoinsLeft++;
                }
            }
        }
        if (CoinsLeft == 0 || dragon.lives == 0) 
        {
            this.state = State.GAMEOVER;
        }
        return CoinsLeft;
    }

    public void newGame() {
        this.state = State.NORMAL;
        this.score = 0;
        dragon.lives = 2;
        for (int x = 0; x < 30; x++) {
            for (int y = 0; y < 21; y++) {
                if (Map.map[y][x] == 0) {
                    Map.map[y][x] = 5;
                }
            }
        }
        Map.map[5][7] = 2;
        Map.map[9][28] = 2;
        Map.map[13][2] = 2;
        Map.map[19][21] = 2;

        knights.add(new Knight(448, 288, 1, "Blue"));
        knights.add(new Knight(448, 320, 1, "Purple"));
        knights.add(new Knight(480, 320, 1, "Pink"));
        knights.add(new Knight(480, 288, 1, "Orange"));
    }
}
