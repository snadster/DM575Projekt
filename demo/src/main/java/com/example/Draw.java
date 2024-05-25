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
    private Image spriteSheet = new Image("ALL SPRITES LINEAR.png");
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

    public void drawBoard()//we use switch case for fun and for speed
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

    public void drawBoardNormal()
    {
            for (int x = 0; x < Map.map[0].length; x++) //Map.map er det, som kalder vores map fra filen Map.
            {
                for (int y = 0; y < Map.map.length; y++)
                {
                    switch (Map.map[y][x]) //vi tar det der stårpå pladsen og læser det.
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
    

    public void drawBoardPower()
    {
        for (int x = 0; x < Map.map[0].length; x++) //Map.map er det, som kalder vores map fra filen Map.
        {
            for (int y = 0; y < Map.map.length; y++)
            {
                switch (Map.map[y][x]) //vi tar det der står på pladsen og læser det.
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

    public void drawBox()
    {
        this.context.setFill(Color.WHITESMOKE);
        context.fillRect(0, 0, 1050, 800);
    }

    public void drawScore() 
    {
        this.context.setFont(Font.loadFont("Verdana", 25));
        this.context.setFill(Color.BLACK);
        context.fillText("Score: "+ gw.score, 30.0, 30.0);
        context.fillText("Lives: "+ gw.dragon.lives, 30, 720);
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
        if (gw.state == State.POWER) 
        {
            drawPowerKnights(nowNS);
        }
    }

    public void drawNormalKnights(long nowNS)
    {
        drawAnimatedSprite(nowNS, gw.knights.get(0), 3, 1, 35);
        drawAnimatedSprite(nowNS, gw.knights.get(1), 3, 1, 69);
        drawAnimatedSprite(nowNS, gw.knights.get(2), 3, 1, 103);
        drawAnimatedSprite(nowNS, gw.knights.get(3), 3, 1, 137);
    }

    public void drawPowerKnights(long nowNS)
    {
        for (Knight knight : gw.knights) 
        {
            drawAnimatedSprite(nowNS, knight, 3, 1, 171);
        } 
    }

    public void drawDeadKnights(long nowNS, Knight deadKnightPosition)
    {
        drawAnimatedSprite(nowNS, deadKnightPosition, 4, 1, 205);
    }

    public void drawAnimatedSprite(long nowNS, Entity entity, int animationLength, int startX, int startY)
    {
        //animates the dragon from the spritesheet.
        Entity entities = entity;
        int x = entities.positionX;
        int y = entities.positionY;
        int size = 33;
        //endelige størrelse burde være 32 størrelsesmuligheder: 64, 128, 160, 192, 224
        if (entities.direction == Direction.UP)
        {
            drawAnimated(nowNS, animationLength, startX, startY, x, y, size, size);
        }
        else if (entities.direction == Direction.DOWN)
        {
            drawAnimated(nowNS, animationLength, startX + 1 * animationLength * 34, startY, x, y, size, size);
        }
        else if (entities.direction == Direction.RIGHT)
        {
            drawAnimated(nowNS, animationLength, startX + 2 * animationLength * 34, startY, x, y, size, size);
        }
        else if (entities.direction == Direction.LEFT)
        {
            drawAnimated(nowNS, animationLength, startX + 3 * animationLength * 34, startY, x, y, size, size);
        }
    }

    public void drawAnimated(long nowNS, long animationLength, int startX, int startY, int positionX, int positionY, int dw, int dh)
    {
        long fourthOfSecondNS = 1000000000 / 4;
        long animationFrame = nowNS / fourthOfSecondNS % animationLength;
        context.setImageSmoothing(false);
        context.drawImage(spriteSheet, startX + animationFrame * 34, startY, 32, 32, positionX + 32, positionY + 32, dw, dh);
    } 

}
