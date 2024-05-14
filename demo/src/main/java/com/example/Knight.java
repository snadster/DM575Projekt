package com.example;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Knight extends Entity {

    public Knight(int px, int py, int v) {
        super(px, py, v);
    }



/*ridder bevægelse  (celine vil gerne kigge lidt her)
        brug samme funktion til at de kan flytte sig
        ai til søgealgoritme
        måske fire forskellige versioner
            bare sårn. den ene tager 50% random, den anden
            tager 25% random etc.
        velocity tilpasset efter dragon mans hast
        funktion som tager koordinater som input - skal kaldes i gameworld
*/
/*
 public static void BFS(int source, int target){
    queue = new queue;
    queue.add(source);
    parent = new dictionary;
    parent.add(source, null);
    while (queue.empty() == false){
        current = queue.dequeue()
        if (current == target)
            return getPath(dict, current)
        for (){
            if (u != parent.get(key))
            parent[u] = current
            queue.add(u)
        }

    }
} 
*/
}
