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

        stage.setTitle("dragon-man");
        stage.setFullScreen(true);
        stage.getIcons().add(new Image("TILE_COIN.png"));
        BorderPane root = new BorderPane();

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);

        Canvas canvas = new Canvas(1024, 736);
        root.setCenter(canvas);

        KeyHandler keyH = new KeyHandler(mainScene);
        keyH.inputHandler();
        
        Gameworld gamie = new Gameworld();

        Draw drawie = new Draw(gamie, canvas);
        drawie.drawBoard();

        AnimationTimer gameloop = new AnimationTimer()
        {
            public void handle(long nowNS)
            {
                drawie.drawBoard();

                int x = 32;
                int y = 32;
                if (keyH.upPressed) 
                {
                    drawie.drawAnimated(nowNS, 4, 409, 1, x, y);
                }
                else if (keyH.downPressed)
                {
                    drawie.drawAnimated(nowNS, 4, 1, 1, x, y);
                }
                else if (keyH.leftPressed)
                {
                    drawie.drawAnimated(nowNS, 4, 137, 1, x, y);
                }
                else if (keyH.rightPressed)
                {
                    drawie.drawAnimated(nowNS, 4, 273, 1, x, y);
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