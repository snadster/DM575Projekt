package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public class KeyHandler implements KeyListener{

    public boolean upPressed, downPressed, rightPressed, leftPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
    
}


public class KeyHandler implements ActionListener, KeyListener {
    Gameworld gameworld;
    Timer t = new Timer(10,this);
    
    public KeyHandler(Gameworld gameworld) {
        this.gameworld = gameworld;
        addKeyListener(this);
        setFocusable(true);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        
    }


    public void keyTyped(KeyEvent e) {
        
    }

    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gameworld.pacman.direction = Direction.LEFT;
                break;
        
            case KeyEvent.VK_RIGHT:
                gameworld.pacman.direction = Direction.RIGHT;
                break;
                
            case KeyEvent.VK_UP:
                gameworld.pacman.direction = Direction.UP;
                break;
            
            case KeyEvent.VK_DOWN:
                gameworld.pacman.direction = Direction.DOWN;
                break;
        }
    }

 
    public void keyReleased(KeyEvent e) {
        
    }

    
}