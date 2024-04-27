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


    public static void main(String[] args) {
        launch(args);
        Gameworld gamie = new Gameworld();
        Draw drawie = new Draw(gamie);
    }

} 