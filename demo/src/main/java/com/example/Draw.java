//*************************************************************************\\
//               Render board and all game aestehtics.                     \\
//*************************************************************************\\

package com.example;

import javafx.scene.image.Image;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;

public class Draw
{
    private Gameworld gw;
    private GraphicsContext context;
    private Image spriteSheet = new Image("ALL_SPRITES_LINEAR.png");
    private CollisionHandler cool;
    

    public Draw(Gameworld gw, Canvas canvas, CollisionHandler cool) 
    {
        this.gw = gw;
        this.context = canvas.getGraphicsContext2D();
        this.cool = cool;
    }

      //*****************************\\
     //       board rendering         \\
    //*********************************\\

    public void render(long nowNS)
    {
        clearBackground();
        drawBoard(nowNS);
        drawScore();
        drawDragon(nowNS);
        drawKnights(nowNS);
        drawDeadKnights(nowNS);
    }

    public void drawBoard(long nowNS)
    {
        if (gw.state == State.NORMAL)
        {
            drawBoardNormal();
        }
        else if (gw.state == State.POWER)
        {
            drawBoardPower();
        }
    }

    //--------------------------------------------------------------------
    // Draw the board for normal mode.
    //--------------------------------------------------------------------
    public void drawBoardNormal()
    {
            for (int x = 0; x < Map.map[0].length; x++)
            {
                for (int y = 0; y < Map.map.length; y++)
                {
                    switch (Map.map[y][x])
                    {
                    case 0 :
                        context.drawImage(spriteSheet, 1, 239, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 1 :
                        context.drawImage(spriteSheet, 69, 239, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 2 :
                        context.drawImage(spriteSheet, 103, 239, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 3 :
                        context.drawImage(spriteSheet, 171, 239, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 4 :
                        context.drawImage(spriteSheet, 35, 239, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 5 :
                        context.drawImage(spriteSheet, 137, 239, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 6 :
                        context.drawImage(spriteSheet, 171, 239, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                }
            }
        }
    }
    
    //--------------------------------------------------------------------
    // Draw the board for power mode.
    //--------------------------------------------------------------------
    public void drawBoardPower()
    {
        for (int x = 0; x < Map.map[0].length; x++)
        {
            for (int y = 0; y < Map.map.length; y++)
            {
                switch (Map.map[y][x])
                {
                    case 0 :
                        context.drawImage(spriteSheet, 1, 307, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 1 :
                        context.drawImage(spriteSheet, 69, 307, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 2 :
                        context.drawImage(spriteSheet, 103, 307, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 3 :
                        context.drawImage(spriteSheet, 171, 307, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 4 :
                        context.drawImage(spriteSheet, 35, 307, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 5 :
                        context.drawImage(spriteSheet, 137, 307, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                    case 6 :
                        context.drawImage(spriteSheet, 171, 307, 32, 32, (x*32)+32, (y*32)+32, 32, 32);
                        break;
                }
            }
        }
    }  

    //--------------------------------------------------------------------
    // Draw a box around the board to visualise the score and number
    // of lives.
    //--------------------------------------------------------------------
    public void clearBackground()
    {
        this.context.setFill(Color.WHITESMOKE);
        context.fillRect(0, 0, 1050, 800);
    }

    public void drawScore() 
    {
        this.context.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
        this.context.setFill(Color.BLACK);
        context.fillText("Score: "+ gw.score, 30.0, 30.0);
        context.fillText("Lives: "+ gw.dragon.lives, 30, 730);
    }


      //*****************************\\
     //       Render Entities         \\
    //*********************************\\
    

    public void drawDragon(long nowNS)
    {
        drawAnimatedSprite(nowNS, gw.dragon, 4, 1, 1);
    }

    public void drawKnights(long nowNS)
    {
        if (gw.state == State.NORMAL)
        {
            drawNormalKnights(nowNS);
        }
        else if (gw.state == State.POWER)
        {
            drawPowerKnights(nowNS);
        }
    }

    public void drawNormalKnights(long nowNS)
    {    
        for (int i = 0; i < gw.knights.size(); i++) {
            if (gw.knights.get(i).colour == "Blue") {
                drawAnimatedSprite(nowNS, gw.knights.get(i), 3, 1, 35);
            }
            if (gw.knights.get(i).colour == "Purple") {
                drawAnimatedSprite(nowNS, gw.knights.get(i), 3, 1, 69);
            }
            if (gw.knights.get(i).colour == "Pink") {
                drawAnimatedSprite(nowNS, gw.knights.get(i), 3, 1, 103);
            }
            if (gw.knights.get(i).colour == "Orange") {
                drawAnimatedSprite(nowNS, gw.knights.get(i), 3, 1, 137);
            }

        }
        
    }

    public void drawPowerKnights(long nowNS)
    {
        for (Knight knight : gw.knights) 
        {
            drawAnimatedSprite(nowNS, knight, 3, 1, 171);
        } 
    }

    public void drawDeadKnights(long nowNS)
    {
        int animatedFrameTime = 1000000000;
        for (Knight knight : cool.dying)
        {
            if (nowNS - knight.deathTime < animatedFrameTime)
            {
                drawAnimatedSprite(nowNS - knight.deathTime, knight, 4, 1, 205);
            }
        }
    }

    //--------------------------------------------------------------------
    // Draw the animated sprites in their current direction.
    //--------------------------------------------------------------------
    public void drawAnimatedSprite(long nowNS, Entity entity, int animationLength, int startX, int startY)
    {
        int x = entity.positionX;
        int y = entity.positionY;
        int size = 32; 
        if (entity.direction == Direction.UP)
        {
            drawAnimated(nowNS, animationLength, startX, startY, x, y, size, size);
        }
        else if (entity.direction == Direction.DOWN)
        {
            drawAnimated(nowNS, animationLength, startX + 1 * animationLength * 34, startY, x, y, size, size);
        }
        else if (entity.direction == Direction.RIGHT)
        {
            drawAnimated(nowNS, animationLength, startX + 2 * animationLength * 34, startY, x, y, size, size);
        }
        else if (entity.direction == Direction.LEFT)
        {
            drawAnimated(nowNS, animationLength, startX + 3 * animationLength * 34, startY, x, y, size, size);
        }
    }

    //--------------------------------------------------------------------
    // Draw correct frames from spritesheet.
    //--------------------------------------------------------------------
    public void drawAnimated(long nowNS, long animationLength, int startX, int startY, int positionX, int positionY, int dw, int dh)
    {
        long fourthOfSecondNS = 1000000000 / 4;
        long animationFrame = nowNS / fourthOfSecondNS % animationLength;
        context.setImageSmoothing(false);
        context.drawImage(spriteSheet, startX + animationFrame * 34, startY, 32, 32, positionX + 32, positionY + 32, dw, dh);
    }     

    //--------------------------------------------------------------------
    // Draw the gameover screen.
    //--------------------------------------------------------------------
    public void drawEndScreen()
    {
        endBackground();
        endText();
    }

    public void endText()
    {
        if (gw.gameOver() == 0)
        {
            this.context.setFill(Color.WHITESMOKE);
            this.context.setFont(Font.font("Verdana", FontWeight.BOLD, 17));
            context.fillText("Score: ", 717.0, 612.0);
            this.context.setFont(Font.font("Verdana", FontWeight.BOLD, 35));
            context.fillText("" + gw.score, 700.0, 643);
        }
        else if (gw.gameOver() > 0)
        {
            this.context.setFont(Font.font("Verdana", 70));
            this.context.setFill(Color.WHITESMOKE);
            context.fillText("Score: "+ gw.score, 343.0, 390.0);
        }
        this.context.setFill(Color.WHITESMOKE);
        this.context.setFont(Font.font("Verdana", FontWeight.BOLD, 43));
        context.fillText("enter: YES!!", 255.0, 510.0);
        this.context.setFont(Font.font("Verdana", FontWeight.BOLD, 43));
        context.fillText("q: no... :(", 565.0, 510);
    }

    //--------------------------------------------------------------------
    // Draw a new background when the game is over.
    //--------------------------------------------------------------------
    public void endBackground()
    {
        Image winnerScreen = new Image("game_over_win.png");
        Image looserScreen = new Image("game_over_lost.png");
        
        if (gw.gameOver() == 0)
        {
            context.drawImage(winnerScreen, 32, 32, 960, 671);
            
        } 
        else if (gw.gameOver() > 0)
        {
            context.drawImage(looserScreen, 32, 32, 960, 671);

        }
        
    }   
}
