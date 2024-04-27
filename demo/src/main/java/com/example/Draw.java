package com.example;
import javafx.scene.image.Image;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
/*
TODO: 

*/
public class Draw {
    private Gameworld gw;
    private Canvas canvas;

    public Draw(Gameworld gw, Canvas canvas) {
        this.gw = gw;
        this.canvas = canvas;
    }


    public void switchCase(Image img) //we use switch case for fun and for speed
    {
        for (int x = 0; x < Map.map[0].length; x++) //Map.map er det, som kalder vores map fra filen Map.
        {
            for (int y = 0; y < Map.map.length; y++)
            {
                switch (Map.map[y][x]) //vi tar det der stårpå pladsen og læser det.
                {
                    case 0 :
                        canvas.drawImage("ALL SPRITES LINEAR.png", 1, 239, 32, 32, x, y, 32, 32);
                        break;
                    case 1 :
                        canvas.drawImage("ALL SPRITES LINEAR.png", 69, 239, 32, 32, x, y, 32, 32);
                        break;
                    case 2 :
                        // canvas.drawImage(null, sx, sy, sw, sh, x, y, w, h);
                        break;
                    case 3 :
                        // canvas.drawImage(null, sx, sy, sw, sh, x, y, w, h);
                        break;
                    case 4 :
                        canvas.drawImage("ALL SPRITES LINEAR.png", 35, 239, 32, 32, x, y, 32, 32);
                        break;


                }
            }
        }
    }
    
}
