//*************************************************************************\\
//                          Contain game mechanics.                        \\
//*************************************************************************\\

package com.example;

import java.util.ArrayList;
import java.util.concurrent.*; 

public class Gameworld 
{
    protected Dragon dragonman;
    protected ArrayList<Knight> knights;
    protected int coinValue;
    protected State state;
    protected int score;

    public Gameworld(Dragon dragonman, ArrayList<Knight> knights) 
    {
        this.dragonman = dragonman;
        this.knights = knights;
        this.coinValue = 10;
        this.state = State.NORMAL;
        this.score = 0;
    }

    //--------------------------------------------------------------------
    // Collect coins and remove them from the board.
    //--------------------------------------------------------------------
    public void collectCoin()
    {
        int dragonX = ((dragonman.positionX + 5) / 32);
        int dragonY = ((dragonman.positionY + 5) / 32);
        if (dragonman.coinCollision() && Map.map[dragonY][dragonX]== 5) 
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
        int dragonX = (dragonman.positionX / 32);
        int dragonY = (dragonman.positionY / 32);
        if (dragonman.fireballCollision() && Map.map[dragonY][dragonX] == 2) 
        {
            Map.map[dragonY][dragonX] = 0;
            state = State.POWER;
            // Make the state change back to normal after 10 seconds.
            Runnable endPowerState = () -> state = State.NORMAL;
            ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
            ses.schedule(endPowerState, 10, TimeUnit.SECONDS);
            // Shut down the executorservice a second after the power state ends. 
            Runnable killSes = () -> ses.shutdown();
            ses.schedule(killSes, 11, TimeUnit.SECONDS);
        }
    }

    //--------------------------------------------------------------------
    // Check if the game is over.
    //--------------------------------------------------------------------
    public int gameOver() 
    {
        // Count how many coins there are left.
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
        if (CoinsLeft == 0 || dragonman.lives == 0) 
        {
            this.state = State.GAMEOVER;
        }
        return CoinsLeft;
    }

    //--------------------------------------------------------------------
    // Start new game with start settings.
    //--------------------------------------------------------------------
    public void newGame() 
    {
        this.state = State.NORMAL;
        this.score = 0;
        dragonman.lives = 2;
        // Return coins to map.
        for (int x = 0; x < 30; x++) 
        {
            for (int y = 0; y < 21; y++) 
            {
                if (Map.map[y][x] == 0) 
                {
                    Map.map[y][x] = 5;
                }
            }
        }
        // Return fireballs to map.
        Map.map[5][7] = 2;
        Map.map[9][28] = 2;
        Map.map[13][2] = 2;
        Map.map[19][21] = 2;

        // Place dragon on correct spot in map
        dragonman.positionX = 448;
        dragonman.positionY = 384;
        
        // Delete old knights. Make new knights.
        knights.clear();
        knights.add(new Knight(448, 288, 1, "Blue"));
        knights.add(new Knight(448, 320, 1, "Purple"));
        knights.add(new Knight(480, 320, 1, "Pink"));
        knights.add(new Knight(480, 288, 1, "Orange"));
    }
}