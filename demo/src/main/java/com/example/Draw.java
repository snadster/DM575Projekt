package com.example;
import javafx.scene.image.Image;

/*
TODO: 

*/
public class Draw {
    private Gameworld gw;

    public Draw(Gameworld gw) {
        this.gw = gw;
    }

    public void switchCasePrinter(Image args) //we use switch case for fun and for speed
    {
        for (int x = 0; x < Map.map[0].length; x++) //Map.map er det, som kalder vores map fra filen Map.
        {
            for (int y = 0; y < Map.map.length; y++)
            {
                switch (Map.map[y][x]) //vi tar det der stårpå pladsen og læser det.
                {
                    case 0 :
                                 // time to put sprites in with their size
                        break;
                    case 1 :
                        
                        break;
                    case 2 :
                        // and here (im workin on a sprite sheet)
                        break;
                    case 3 :
                        //also here
                        break;


                }
            }
        }
    }
    
}
