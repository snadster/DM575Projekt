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
        // FlowPane pane = new FlowPane();
        // vi skifter til group fordi flowPane sutter hårdt.
        Group root = new Group();
        Scene scene = new Scene(root,960,672,Color.DARKGRAY);

        // make text, set size font and color
        Text text = new Text();
        text.setText("pac-man :)");
        text.setX(350);
        text.setY(100);
        text.setFont(Font.font("Brush Script",60));
        text.setFill(Color.YELLOW);
        root.getChildren().add(text);
        
        stage.setTitle("pac man?");
        stage.setScene(scene);
        stage.setWidth(960);
        stage.setHeight(672);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

} 