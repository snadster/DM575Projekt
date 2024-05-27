//*************************************************************************\\
//                    Handle all key-inputs                                \\
//*************************************************************************\\

package com.example;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class KeyHandler 
{
    public boolean upPressed, downPressed, rightPressed, leftPressed;
    private Scene scene;

    public KeyHandler(Scene scene) 
    {
        this.upPressed = false;
        this.downPressed = false;
        this.rightPressed = false;
        this.leftPressed = false;
        this.scene = scene;
    }

    //--------------------------------------------------------------------
    // Handle keyboard input from the user.
    //--------------------------------------------------------------------
    public void inputHandler() 
    {
        scene.setOnKeyPressed (new EventHandler <KeyEvent>() 
        {
            @Override
            public void handle(KeyEvent event) 
            {
                switch (event.getCode()) 
                {
                    case UP:  
                    upPressed = true;
                    downPressed = false;
                    leftPressed = false;
                    rightPressed = false;
                    break;

                    case DOWN:
                    downPressed = true;
                    upPressed = false;
                    leftPressed = false;
                    rightPressed = false;
                    break;  

                    case LEFT: 
                    leftPressed = true;
                    downPressed = false;
                    upPressed = false;
                    rightPressed = false;
                    break; 

                    case RIGHT: 
                    rightPressed = true;
                    upPressed = false;
                    downPressed = false;
                    leftPressed = false;
                    break;

                    default: // Only the arrows are permitted as valid inputs.
                    break;
                }
            }
        });
    }
}
