package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
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
        
        // make flowpane, scene, and stage
        FlowPane pane = new FlowPane();
        Scene scene = new Scene(pane,672,960,Color.DARKGRAY);
        

        // make text, set size font and color
        Text text = new Text();
        text.setText("pac-man :)");
        text.setX(300);
        text.setY(400);
        text.setFont(Font.font("Brush Script",60));
        text.setFill(Color.YELLOW);

        stage.setWidth(960);
        stage.setHeight(672);

        stage.setResizable(false);

        pane.getChildren().add(text);
        stage.setScene(scene);
        stage.setTitle("pac man?");
        stage.show();
        
        

    }

    public static void main(String[] args) {
        launch(args);
    }

} 