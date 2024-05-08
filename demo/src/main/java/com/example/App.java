package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;


/**
 * JavaFX App
 */
public class App extends Application {
   
	public void start(Stage stage) {

        stage.setTitle("Camelot's Burning");
        stage.setFullScreen(true);
        stage.getIcons().add(new Image("TILE_COIN.png"));
        BorderPane root = new BorderPane();

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);

        Canvas canvas = new Canvas(1024, 736);
        root.setCenter(canvas);

        KeyHandler keyH = new KeyHandler(mainScene);
        keyH.inputHandler();

        Dragon dragonman = new Dragon(null, 0, 0, 0, keyH);
        Knight knight1 = new Knight(null, 0, 0, 0);
        Knight knight2 = new Knight(null, 0, 0, 0);
        Knight knight3 = new Knight(null, 0, 0, 0);
        Knight knight4 = new Knight(null, 0, 0, 0);

        Entity[] knightarray = {knight1, knight2, knight3, knight4};
        
        Gameworld gamie = new Gameworld(dragonman, knightarray);

        Draw drawie = new Draw(gamie, canvas);
        drawie.drawBoard();

        // gamie.createCoins(gamie);

        AnimationTimer gameloop = new AnimationTimer()
        {
            public void handle(long nowNS)
            {
                //draws our board each frame so the dragon can move without leaving a trail of dragons.
                drawie.drawBoard();
                
                //animates the dragon from the spritesheet.
                int x = 320;
                int y = 320;
                int dw = 160; //endelige størrelse burde være 32
                int dh = 160; // størrelsesmuligheder: 64, 128, 160, 192, 224
                if (keyH.upPressed) 
                {
                    drawie.drawAnimated(nowNS, 4, 409, 1, x, y, dw, dh);
                }
                else if (keyH.downPressed)
                {
                    drawie.drawAnimated(nowNS, 4, 1, 1, x, y, dw, dh);
                }
                else if (keyH.leftPressed)
                {
                    drawie.drawAnimated(nowNS, 4, 137, 1, x, y, dw, dh);
                }
                else if (keyH.rightPressed)
                {
                    drawie.drawAnimated(nowNS, 4, 273, 1, x, y, dw, dh);
                }
                //animates the knights
                // drawie.drawAnimatedBlueKnight(nowNS);
                // drawie.drawAnimatedPinkKnight(nowNS);
                // drawie.drawAnimatedPurpleKnight(nowNS);
                // drawie.drawAnimatedOrangeKnight(nowNS);


            }
        }; 
        gameloop.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
 
    }

} 