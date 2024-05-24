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
//import java.util.concurrent.*; 

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

        Draw drawie = new Draw(gw, canvas);
        drawie.drawBoard();

        CollisionHandler cool = new CollisionHandler(gw);

    /*  CollisionHandler cool = new CollisionHandler(gw);
        
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1); */

        // Runnable knightDirection = () -> {
        //     for (int i = 0; i < 4; i++) {
        //         gw.GiveKnightDirection(gw.knights.get(i));
        //     }
        // };
        // ses.scheduleAtFixedRate(knightDirection, 2000, 250, TimeUnit.MILLISECONDS);

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

                for (int i = 0; i < 4; i++) {            
                    gw.knights.get(i).move(gw.knights.get(i));
                    float distance = Math.abs(dragonman.positionX - gw.knights.get(i).positionX) + Math.abs(dragonman.positionY - gw.knights.get(i).positionY);
                    Node node = new Node(gw.knights.get(i), null, distance, null);
                    Node bestNode = gw.knights.get(i).knightBFS(node, dragonman.positionX, dragonman.positionY);
                    gw.knights.get(i).direction = bestNode.direction;
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