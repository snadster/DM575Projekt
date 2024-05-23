package com.example;

import javafx.scene.image.Image;
import javafx.scene.canvas.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.String;
import java.net.URL;

/*
TODO: 

*/
public class Draw
{

    private Gameworld gw;
    private GraphicsContext context;
    private Image spriteSheet = new Image("ALL SPRITES LINEAR.png");
    

    public Draw(Gameworld gw, Canvas canvas) 
    {
        this.gw = gw;
        this.context = canvas.getGraphicsContext2D();
    }

    public void drawBoard()//we use switch case for fun and for speed
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
                }
            }
        }
        
    }

    public void drawBox()
    {
        context.fillRect(0, 0, 1050, 800);
        this.context.setFill(Color.WHITESMOKE);
    }

    public static Font loadFont()
    {
        Font gothic = Font.loadFont("Sketch Gothic School.ttf", 25);
        return gothic;
    }

    public void drawScore() 
    {
        context.fillText("Score: "+ gw.score, 30.0, 30.0);
        context.fillText("Lives: "+ gw.dragon.lives, 30, 720);
        this.context.setFill(Color.BLACK);
    }

    public void drawDragon(long nowNS)
    {
        drawAnimatedSprite(nowNS, gw.dragon, 4, 1, 1);
    }

    public void drawKnights(long nowNS) {
        if (gw.state == State.NORMAL) {
            drawNormalKnights(nowNS);
        }
        if (gw.state == State.POWER) {
            drawPowerKnights(nowNS);
        }
    }

    public void drawNormalKnights(long nowNS)
    {
        drawAnimatedSprite(nowNS, gw.knights[0], 3, 1, 35);
        drawAnimatedSprite(nowNS, gw.knights[1], 3, 1, 69);
        drawAnimatedSprite(nowNS, gw.knights[2], 3, 1, 103);
        drawAnimatedSprite(nowNS, gw.knights[3], 3, 1, 137);
    }

    public void drawPowerKnights(long nowNS)
    {
        drawAnimatedSprite(nowNS, gw.knights[0], 3, 1, 171);
        drawAnimatedSprite(nowNS, gw.knights[1], 3, 1, 171);
        drawAnimatedSprite(nowNS, gw.knights[2], 3, 1, 171);
        drawAnimatedSprite(nowNS, gw.knights[3], 3, 1, 171);
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
        int size = 32;
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
