//*************************************************************************\\
//      Authors: Sandra K. Johansen, Sofie Løfberg, Celine S. Fussing      \\
//                                                                         \\
//                              App.java                                   \\
//                                                                         \\
//    This is the top level and used as mediator between model and view.   \\
//                                                                         \\
//*************************************************************************\\

package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
//import javafx.scene.text.*;
import java.util.ArrayList;
import java.util.concurrent.*; 
import java.util.Random;

/* TODO

    lav powermode og de tilhørende skift (i.e aesthetics.)
        test evt velocities

    ridder bevægelse  (celine vil gerne kigge lidt her)
        brug samme funktion til at de kan flytte sig
        ai til søgealgoritme
        måske fire forskellige versioner
            bare sårn. den ene tager 50% random, den anden
            tager 25% random etc.
        velocity tilpasset efter dragon mans hast
        funktion som tager koordinater som input - skal kaldes i gameworld

    collison checker
        mellem dragon og ridder (to forskellige, hvor skal den ligge?)
        mellem mønter og dragon (skal ligge i gameworld)
            fire forskellige måder
        mellem ridder og væg (skal ligge i ridder)
            fire forskellige måder.
    
    Designmønstre

    states
        skift mellem 
        definer hvad der sker i dem
    
    kig på diagram; tilpas måske tre overordnede under app.
*/


/**
 * JavaFX App
 */
public class App extends Application {
   
	public void start(Stage stage) {

        stage.setTitle("Camelot's Burning");
        stage.setFullScreen(true);
        //stage.setFullScreenExitHint("Should thou wish to minimise thine screen, press 'ESC'");
        stage.setFullScreenExitHint("");
        stage.getIcons().add(new Image("TILE_EMPTY_FLAME.png"));
    
        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        Canvas canvas = new Canvas(1024, 736);
        root.setCenter(canvas);

        KeyHandler keyH = new KeyHandler(mainScene);
        keyH.inputHandler();

        Dragon dragonman = new Dragon(448, 384, 2, keyH); 
        ArrayList<Knight> knightArray = new ArrayList<>();
        knightArray.add(new Knight(448, 288, 1));
        knightArray.add(new Knight(448, 320, 1));
        knightArray.add(new Knight(480, 320, 1));
        knightArray.add(new Knight(480, 288, 1));


        Gameworld gw = new Gameworld(dragonman, knightArray);
        CollisionHandler cool = new CollisionHandler(gw);
        Draw drawie = new Draw(gw, canvas, cool);

        drawie.drawBoard();


        //*****************************\\
       //       Game loop and AI        \\
      //*********************************\\
        
        Random rand = new Random();
        int chaseOrScatter = rand.nextInt(2);
        
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable interval = () -> {
           for (int i = 0; i < gw.knights.size(); i++) {
                if (chaseOrScatter == 0) {
                    gw.knights.get(i).updateChase(gw.knights.get(i), false);
                    gw.knights.get(i).scatterX = rand.nextInt(29);
                    gw.knights.get(i).scatterY = rand.nextInt(20);
                }
                else {
                    gw.knights.get(i).updateChase(gw.knights.get(i), true);
                }
           }
        };

        ses.scheduleAtFixedRate(interval, 5, 1, TimeUnit.SECONDS);

        int chaseX = (dragonman.positionX + 5) / 32;
        int chaseY = (dragonman.positionY + 5) / 32;

        AnimationTimer gameloop = new AnimationTimer()
        {
            public void handle(long nowNS)
            {
                //box draws our board each frame so the dragon can move without leaving a trail of dragons.
                drawie.drawBox();
                drawie.drawBoard();
                drawie.drawScore();
                drawie.drawDragon(nowNS);
                drawie.drawKnights(nowNS);

                dragonman.move(dragonman);
                dragonman.changeDirection();

                gw.collectCoin();
                gw.collectFireball();

                cool.dragonKnightCollisionAction();


                for (int i = 0; i < gw.knights.size(); i++) {            
                    gw.knights.get(i).move(gw.knights.get(i));
                    int knightMapX = (gw.knights.get(i).positionX + 5) / 32;
                    int knightMapY = (gw.knights.get(i).positionY + 5) / 32;
                    if (gw.knights.get(i).chase) {
                        float distance = Math.abs(chaseX - knightMapX) + Math.abs(chaseY - knightMapY);
                        Node node = new Node(knightMapX, knightMapY, gw.knights.get(i).direction, distance, null);
                        Node bestNode = gw.knights.get(i).knightBFS(node, chaseX, chaseY);
                        gw.knights.get(i).updateDirection(gw.knights.get(i), bestNode.direction);
                    }
                    else {
                        float distance = Math.abs(gw.knights.get(i).scatterX - knightMapX) + Math.abs(gw.knights.get(i).scatterY - knightMapY);
                        Node node = new Node(knightMapX, knightMapY, gw.knights.get(i).direction, distance, null);
                        Node bestNode = gw.knights.get(i).knightBFS(node, gw.knights.get(i).scatterX , gw.knights.get(i).scatterY);
                        gw.knights.get(i).updateDirection(gw.knights.get(i), bestNode.direction);
                    }
                }  
            }
        }; 
        gameloop.start();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
 
    }

} 