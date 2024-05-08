package com.example;

import javafx.scene.image.Image;
import javafx.scene.canvas.*;

/*
TODO: 

*/
public class Draw {

    private Gameworld gw;
    private Canvas canvas;
    private GraphicsContext context;
    private Image spriteSheet = new Image("ALL SPRITES LINEAR.png");

    public Draw(Gameworld gw, Canvas canvas) {
        this.gw = gw;
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
    }

    public void drawBoard() //we use switch case for fun and for speed
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
                }
            }
        }
    }
    public void drawCoins()
    {

    }

    public void drawAnimated(long nowNS, long animationLength, int startX, int startY, int positionX, int positionY, int dw, int dh)
    {
        long fourthOfSecondNS = 1000000000 / 4;
        long animationFrame = nowNS / fourthOfSecondNS % animationLength;
        context.setImageSmoothing(false);
        context.drawImage(spriteSheet, startX + animationFrame * 34, startY, 32, 32, positionX, positionY, dw, dh);
    } 

    // public void drawAnimatedBlueKnight(long nowNS)
    // {
    //     int x = 32;
    //     int y = 32;
    //     int dw = 32;
    //     int dh = 32;
    //     if (gw.knights[1].direction == Direction.UP)  //direction up
    //     {
    //         drawAnimated(nowNS, 3, 1, 35, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.DOWN)  //direction down
    //     {
    //         drawAnimated(nowNS, 3, 103, 35, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.LEFT)  //direction left
    //     {
    //         drawAnimated(nowNS, 3, 209, 35, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.RIGHT)  //direction right
    //     {
    //         drawAnimated(nowNS, 3, 309, 35, x, y, dw, dh);
    //     }
    // }

    // public void drawAnimatedPurpleKnight(long nowNS)
    // {
    //     int x = 32;
    //     int y = 32;
    //     int dw = 32;
    //     int dh = 32;
    //     if (gw.knights[2].direction == Direction.UP)  //direction up
    //     {
    //         drawAnimated(nowNS, 3, 1, 69, x, y, dw, dh);
    //     }
    //     else if (gw.knights[2].direction == Direction.DOWN)  //direction down
    //     {
    //         drawAnimated(nowNS, 3, 103, 69, x, y, dw, dh);
    //     }
    //     else if (gw.knights[2].direction == Direction.LEFT)  //direction left
    //     {
    //         drawAnimated(nowNS, 3, 209, 69, x, y, dw, dh);
    //     }
    //     else if (gw.knights[2].direction == Direction.RIGHT)  //direction right
    //     {
    //         drawAnimated(nowNS, 3, 309, 69, x, y, dw, dh);
    //     }
    // }

    // public void drawAnimatedPinkKnight(long nowNS)
    // {
    //     int x = 32;
    //     int y = 32;
    //     int dw = 32;
    //     int dh = 32;
    //     if (gw.knights[3].direction == Direction.UP)  //direction up
    //     {
    //         drawAnimated(nowNS, 3, 1, 103, x, y, dw, dh);
    //     }
    //     else if (gw.knights[3].direction == Direction.DOWN)  //direction down
    //     {
    //         drawAnimated(nowNS, 3, 103, 103, x, y, dw, dh);
    //     }
    //     else if (gw.knights[3].direction == Direction.LEFT)  //direction left
    //     {
    //         drawAnimated(nowNS, 3, 209, 103, x, y, dw, dh);
    //     }
    //     else if (gw.knights[3].direction == Direction.RIGHT)  //direction right
    //     {
    //         drawAnimated(nowNS, 3, 309, 103, x, y, dw, dh);
    //     }
    // }

    // public void drawAnimatedOrangeKnight(long nowNS)
    // {
    //     int x = 32;
    //     int y = 32;
    //     int dw = 32;
    //     int dh = 32;
    //     if (gw.knights[4].direction == Direction.UP)  //direction up
    //     {
    //         drawAnimated(nowNS, 3, 1, 137, x, y, dw, dh);
    //     }
    //     else if (gw.knights[4].direction == Direction.DOWN)  //direction down
    //     {
    //         drawAnimated(nowNS, 3, 103, 137, x, y, dw, dh);
    //     }
    //     else if (gw.knights[4].direction == Direction.LEFT)  //direction left
    //     {
    //         drawAnimated(nowNS, 3, 209, 137, x, y, dw, dh);
    //     }
    //     else if (gw.knights[4].direction == Direction.RIGHT)  //direction right
    //     {
    //         drawAnimated(nowNS, 3, 309, 137, x, y, dw, dh);
    //     }
    // }

    // public void drawAnimatedPowerKnight(long nowNS)
    // {
    //     int x = 32;
    //     int y = 32;
    //     int dw = 32;
    //     int dh = 32;
    //     if (gw.knights[1].direction == Direction.UP)  //direction up
    //     {
    //         drawAnimated(nowNS, 3, 1, 171, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.DOWN)  //direction down
    //     {
    //         drawAnimated(nowNS, 3, 103, 171, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.LEFT)  //direction left
    //     {
    //         drawAnimated(nowNS, 3, 209, 171, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.RIGHT)  //direction right
    //     {
    //         drawAnimated(nowNS, 3, 309, 171, x, y, dw, dh);
    //     }
    // }

    // public void drawAnimatedDeadKnight(long nowNS)
    // {
    //     int x = 32;
    //     int y = 32;
    //     int dw = 32;
    //     int dh = 32;
    //     if (gw.knights[1].direction == Direction.UP)  //direction up
    //     {
    //         drawAnimated(nowNS, 3, 1, 205, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.DOWN)  //direction down
    //     {
    //         drawAnimated(nowNS, 3, 103, 205, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.LEFT)  //direction left
    //     {
    //         drawAnimated(nowNS, 3, 209, 205, x, y, dw, dh);
    //     }
    //     else if (gw.knights[1].direction == Direction.RIGHT)  //direction right
    //     {
    //         drawAnimated(nowNS, 3, 309, 205, x, y, dw, dh);
    //     }
    // }

}
