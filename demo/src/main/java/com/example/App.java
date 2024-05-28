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
import java.util.ArrayList;
import java.util.concurrent.*; 
import java.util.Random;
/* TODO

    Tekst til slutskærm

    korrektur (Celine mm.)
    Rapport
   
*/

public class App extends Application 
{   
    //-----------------------------------------------------------------
    // Set the stage by printing the board, the dragon, and the knights
    //-----------------------------------------------------------------
	public void start(Stage stage) 
    {
        // Set the screen preferences.
        stage.setTitle("Camelot's Burning");
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("We bid thee welcome. Press q to forefit thine battle.");
        //stage.setFullScreenExitHint("");
        stage.getIcons().add(new Image("TILE_EMPTY_FLAME.png"));
    
        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        Canvas canvas = new Canvas(1024, 736);
        root.setCenter(canvas);
            
        // Initialize the keyhandler to handle keyboard input.
        KeyHandler keyH = new KeyHandler(mainScene);
        keyH.inputHandler();

        // Intialize the dragon and knights on the board.
        Dragon dragonman = new Dragon(448, 384, 2, keyH); 
        ArrayList<Knight> knightArray = new ArrayList<>();
        knightArray.add(new Knight(448, 288, 1, "Blue"));
        knightArray.add(new Knight(448, 320, 1, "Purple"));
        knightArray.add(new Knight(480, 320, 1, "Pink"));
        knightArray.add(new Knight(480, 288, 1, "Orange"));

        Gameworld gw = new Gameworld(dragonman, knightArray);
        CollisionHandler cool = new CollisionHandler(gw, keyH);
        Draw drawie = new Draw(gw, canvas, cool);
    
        // Randomize if the knights scatter or chase the dragon.
        Random rand = new Random();
        int chaseOrScatter = rand.nextInt(3);
        
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable interval = () -> 
        {
            for (int i = 0; i < gw.knights.size(); i++) 
            {
                if (chaseOrScatter == 1) 
                {
                    gw.knights.get(i).updateChase(gw.knights.get(i), false);
                    gw.knights.get(i).scatterX = rand.nextInt(29);
                    gw.knights.get(i).scatterY = rand.nextInt(20);
                }
                else 
                {
                gw.knights.get(i).updateChase(gw.knights.get(i), true);
                }
            }
        };
        // Make the knights reconsider their target every 1.5 seconds.
        ses.scheduleAtFixedRate(interval, 3000, 1500, TimeUnit.MILLISECONDS);


          //****************\\
         //     Game loop    \\
        //********************\\
        AnimationTimer gameloop = new AnimationTimer()
        {
            //----------------------------------------------------------------
            // Update the appearance of board for every action performed
            // by the entities per frame.
            //----------------------------------------------------------------
            public void handle(long nowNS)
            {
                if (keyH.newGame) {
                    keyH.newGame = false;
                    keyH.downPressed = false;
                    keyH.leftPressed = false;
                    keyH.rightPressed = false;
                    keyH.upPressed = false;
                    gw.newGame();
                } 

                if (gw.state != State.GAMEOVER)
                {
                    drawie.render(nowNS);
                }
                else if (gw.state == State.GAMEOVER)
                {
                    ses.shutdown();
                    drawie.drawEndScreen();
                }
                
                gw.gameOver(); 
                
                // Make dragon move by pressing one of the key input.
                if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
                    dragonman.move(dragonman);
                }
                // Make the dragon move according to key input.
                dragonman.changeDirection();

                gw.collectCoin();
                gw.collectFireball();

                cool.dragonKnightCollisionAction(nowNS);

                // The position of the dragon used in the search algorithm.
                int chaseX = (gw.dragon.positionX + 5) / 32;
                int chaseY = (gw.dragon.positionY + 5) / 32;

                // Update the knights direction.
                for (int i = 0; i < gw.knights.size(); i++) {

                    //Make intial delay for knights, so they only start moving when the user
                    //moves the dragon.
                    if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
                        gw.knights.get(i).move(gw.knights.get(i));
                    } 

                    // The position of the knights used in the search algorithm.        
                    int knightMapX = (gw.knights.get(i).positionX + 5) / 32;
                    int knightMapY = (gw.knights.get(i).positionY + 5) / 32;

                    if (gw.state == State.NORMAL) 
                    {
                        // Update the knights' direction to chase the dragon.
                        if (gw.knights.get(i).chase) {
                            float distance = Math.abs(chaseX - knightMapX) + Math.abs(chaseY - knightMapY);
                            Node node = new Node(knightMapX, knightMapY, gw.knights.get(i).direction, distance, null);
                            Node bestNode = gw.knights.get(i).knightBFS(node, chaseX, chaseY, false);
                            gw.knights.get(i).updateDirection(gw.knights.get(i), bestNode.direction);
                        }
                        // Update the knights' direction to chase a random position.
                        else {
                            float distance = Math.abs(gw.knights.get(i).scatterX - knightMapX) + Math.abs(gw.knights.get(i).scatterY - knightMapY);
                            Node node = new Node(knightMapX, knightMapY, gw.knights.get(i).direction, distance, null);
                            Node bestNode = gw.knights.get(i).knightBFS(node, gw.knights.get(i).scatterX , gw.knights.get(i).scatterY, false);
                            gw.knights.get(i).updateDirection(gw.knights.get(i), bestNode.direction);
                        }
                    }
                    // Update the knights' direction to run away from the dragon.
                    else if (gw.state == State.POWER) {
                        float distance = Math.abs(chaseX - knightMapX) + Math.abs(chaseY - knightMapY);
                        Node node = new Node(knightMapX, knightMapY, gw.knights.get(i).direction, distance, null);
                        Node bestNode = gw.knights.get(i).knightBFS(node, chaseX, chaseY, true);
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