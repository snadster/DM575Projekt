package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.FlowPane;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {

        stage.setTitle("dragon-man");

        BorderPane root = new BorderPane();

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);

        Canvas canvas = new Canvas(1010, 722);
        GraphicsContext context = canvas.getGraphicsContext2D();

        root.setCenter(canvas);
        context.setFill(Color.rgb(54,60,61));
        context.fillRect(25, 25, 960, 672);
        

        stage.show();
    }


    //     // make group, scene, and stage
    //     Group root = new Group();
    //     Scene scene = new Scene(root,960,672,Color.DARKGRAY);

    //     //attempt at getting a different font loaded in
    //     //URL fontUrl = new URL("'");

    //     // make text, set size font and color
    //     // the finished program will need smaller text to show highscore, but not any circle or the like.
    //     // we might need to use canvas instead to be able to render our stuff, so this is temporary
    //     Text text = new Text();
    //     text.setText("pac-man :)");
    //     text.setX(350);
    //     text.setY(100);
    //     text.setFont(Font.font("Brush Script",60));
    //     text.setFill(Color.YELLOWGREEN);
    //     root.getChildren().add(text);

    //     Circle paccy = new Circle();
    //     paccy.setCenterX(480);
    //     paccy.setCenterY(336);
    //     paccy.setRadius(50);
    //     paccy.setFill(Color.YELLOW);
    //     root.getChildren().add(paccy);
        
    //     stage.setTitle("pac man?");
    //     stage.setScene(scene);
    //     stage.setWidth(960);
    //     stage.setHeight(672);
    //     stage.setResizable(false);
    //     stage.show();
    // }

    public static void main(String[] args) {
        launch(args);
        Gameworld gamie = new Gameworld();
        Draw drawie = new Draw(gamie);
    }

} 