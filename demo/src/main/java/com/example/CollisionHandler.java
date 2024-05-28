//*************************************************************************\\
//                 Handle collisions between entities.                     \\
//*************************************************************************\\

package com.example;
import java.util.ArrayList;

public class CollisionHandler
{
   private Gameworld gw;
   private KeyHandler keyH;
   protected ArrayList<Knight> dying = new ArrayList<Knight>();

   public CollisionHandler(Gameworld gw, KeyHandler keyH)
   {
      this.gw = gw;
      this.keyH = keyH;
   }
 
   //--------------------------------------------------------------------
   // Handle collisions between the knights and the dragon.
   //--------------------------------------------------------------------
   public void collisionAction(long NowNS)
   {
      int knightIndex = collidedKnightIndex();
      int noCollision = -1;

      if (knightIndex != noCollision && gw.state == State.NORMAL)
      {
         // Reduce the score and lives after a collsion.
         gw.score = gw.score / 4 * 3; 
         gw.dragonman.lives = gw.dragonman.lives - 1; 

         // Reset positions.
         gw.dragonman.positionX = 448;
         gw.dragonman.positionY = 384;
         for (int i = 0; i < gw.knights.size(); i++) 
         {
            if (gw.knights.get(i).colour == "Blue") 
            {
               gw.knights.get(i).positionX = 448;
               gw.knights.get(i).positionY = 288;
            }
            if (gw.knights.get(i).colour == "Purple") 
            {
               gw.knights.get(i).positionX = 448;
               gw.knights.get(i).positionY = 320;
            }
            if (gw.knights.get(i).colour == "Pink") 
            {
               gw.knights.get(i).positionX = 480;
               gw.knights.get(i).positionY = 320;
            }
            if (gw.knights.get(i).colour == "Orange") 
            {
               gw.knights.get(i).positionX = 480;
               gw.knights.get(i).positionY = 288;
            }
        }
         // Make an intial delay after the dragon has lost a life.
         keyH.downPressed = false;  
         keyH.leftPressed = false;
         keyH.rightPressed = false;
         keyH.upPressed = false;
      }
      if (knightIndex != noCollision && gw.state == State.POWER)
      {
         gw.score = gw.score + 400;
         // Add dead knight to seperate array.
         dying.add(gw.knights.get(knightIndex)); 
         gw.knights.get(knightIndex).deathTime = NowNS; 
         gw.knights.get(knightIndex).direction = Direction.UP;
         gw.knights.remove(knightIndex); 
      } 
   }

   //--------------------------------------------------------------------
   // Return the index of the knight the dragon collided with.
   //--------------------------------------------------------------------
   public int collidedKnightIndex()
   {
      ArrayList<Rectangle> knightRectangles = knightRectangles();
      int knightHitIndex = -1;
      for (int k = 0; k < knightRectangles.size(); k++)
      {
         if (knightRectangles.get(k).overlap(gw.dragonman.dragonRectangle()))
         {
            knightHitIndex = k;
         }
      }
      return knightHitIndex;
   }

   //--------------------------------------------------------------------
   // Make rectangeles for the knights.
   //--------------------------------------------------------------------
   public ArrayList<Rectangle> knightRectangles()
   {
      ArrayList<Rectangle> knightRectangles = new ArrayList<Rectangle>();
      for (int i = 0; i < gw.knights.size(); i++) 
      {
         Rectangle knightRectangle = new Rectangle(gw.knights.get(i).positionX, gw.knights.get(i).positionY, 32, 32);
         knightRectangles.add(knightRectangle);
      }
      return knightRectangles;
   }
}
