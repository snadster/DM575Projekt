//*************************************************************************\\
//                 Handle collisions between entities.                     \\
//*************************************************************************\\

package com.example;
import java.util.ArrayList;

public class CollisionHandler
{
   private Gameworld gw;
   protected KeyHandler keyh;
   public ArrayList<Knight> dying = new ArrayList<Knight>();

   public CollisionHandler(Gameworld gw, KeyHandler keyh)
   {
      this.gw = gw;
      this.keyh = keyh;
   }
 
   //--------------------------------------------------------------------
   // Handle collisions between the knights and the dragon.
   //--------------------------------------------------------------------
   public void dragonKnightCollisionAction(long NowNS)
   {
      int knightIndex = dragonKnightCollisionKnightIndex();
      int no = -1;

      if (knightIndex != no && gw.state == State.NORMAL)
      {
         gw.score = gw.score / 4 * 3; // Remove points from the score after a collsion.
         gw.dragon.lives = gw.dragon.lives - 1; 
         gw.dragon.positionX = 448;
         gw.dragon.positionY = 384;

         for (int i = 0; i < gw.knights.size(); i++) {
            if (gw.knights.get(i).colour == "Blue") {
               gw.knights.get(i).positionX = 448;
               gw.knights.get(i).positionY = 288;
            }
            if (gw.knights.get(i).colour == "Purple") {
               gw.knights.get(i).positionX = 448;
               gw.knights.get(i).positionY = 320;
            }
            if (gw.knights.get(i).colour == "Pink") {
               gw.knights.get(i).positionX = 480;
               gw.knights.get(i).positionY = 320;
            }
            if (gw.knights.get(i).colour == "Orange") {
               gw.knights.get(i).positionX = 480;
               gw.knights.get(i).positionY = 288;
            }
        }
         // Make an intial delay after the dragon has lost a life.
         keyh.downPressed = false;  
         keyh.leftPressed = false;
         keyh.rightPressed = false;
         keyh.upPressed = false;
      }
      if (knightIndex != no && gw.state == State.POWER) //this state specifier is not strictly necessary; it is here for clear understanding
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
   // Check for collisions between the knights and the dragon.
   //--------------------------------------------------------------------
   public int dragonKnightCollisionKnightIndex()
   {
      ArrayList<Rectangle> knightRectangles = knightRectangles();
      int knightHitIndex = -1;
      for (int k = 0; k < knightRectangles.size(); k++)
      {
         if (knightRectangles.get(k).overlap(gw.dragon.dragonRectangle()))
         {
            knightHitIndex = k;
         }
      }
      return knightHitIndex;
   }

   //--------------------------------------------------------------------
   // Make rectangeles for the knights. Used to check for collisions
   // concerning knights.
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
