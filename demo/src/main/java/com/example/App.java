package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;

/* TODO
    dragon man bevægelse (sofie kigger lidt her)
        wallCollision skal fikses
        test evt velocities

    ridder bevægelse  (celine vil gerne kigge lidt her)
        brug samme funktion til at de kan flytte sig
        ai til søgealgoritme
        måske fire forskellige versioner
            bare sårn. den ene tager 50% random, den anden
            tager 25% random etc.
        velocity tilpasset efter dragon mans hast
        funktion som tager koordinater som input - skal kaldes i gameworld
    
    coins (ligger i gameworld)
        lav switchcase for coins i draw

    collison checker
        mellem dragon og ridder ()
        mellem mønter og dragon (skal ligge i gameworld)
        mellem dragon og væg (skal ligge i drage)
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
        stage.setFullScreenExitHint("Should thou wish to minimise thine screen, press 'ESC'");
        stage.getIcons().add(new Image("TILE_EMPTY_FLAME.png"));
        BorderPane root = new BorderPane();

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);

        Canvas canvas = new Canvas(1024, 736);
        root.setCenter(canvas);

        KeyHandler keyH = new KeyHandler(mainScene);
        keyH.inputHandler();

        Dragon dragonman = new Dragon(448, 384, 3, keyH);
        Knight knight1 = new Knight(416, 320, 0);
        Knight knight2 = new Knight(448, 320, 0);
        Knight knight3 = new Knight(480, 320, 0);
        Knight knight4 = new Knight(512, 320, 0);

        Knight[] knightarray = {knight1, knight2, knight3, knight4};

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
                drawie.drawDragon(nowNS);
                drawie.drawKnights(nowNS);
                dragonman.move(dragonman);
                dragonman.changeDirection();
                drawie.drawScore();
            }
        }; 
        gameloop.start();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
 
    }

} 