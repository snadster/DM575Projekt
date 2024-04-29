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

    public Draw(Gameworld gw, Canvas canvas) {
        this.gw = gw;
        this.canvas = canvas;
        this.context = canvas.getGraphicsContext2D();
    }

    public void drawBoard() //we use switch case for fun and for speed
    {
        Image spriteSheet = new Image("ALL SPRITES LINEAR.png");
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
    
}
