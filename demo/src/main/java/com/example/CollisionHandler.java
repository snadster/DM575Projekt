//*************************************************************************\\
//                 Handle collisions betwwen entities                      \\
//*************************************************************************\\

package com.example;
import java.util.ArrayList;

public class CollisionHandler
{
   private Gameworld gw;

   public CollisionHandler(Gameworld gw)
   {
      this.gw = gw;
   }
 
   public void dragonKnightCollisionAction()
   {
      int knightIndex = dragonKnightCollisionKnightIndex();
      int no = -1;
      if (knightIndex != no && gw.state == State.NORMAL)
      {
         gw.score = gw.score / 4 * 3;
         gw.dragon.lives = gw.dragon.lives - 1;
         gw.dragon.positionX = 448;
         gw.dragon.positionY = 384;
         gw.knights.get(0).positionX = 448;
         gw.knights.get(0).positionY = 288;
         gw.knights.get(1).positionX = 448;
         gw.knights.get(1).positionY = 320;
         gw.knights.get(2).positionX = 480;
         gw.knights.get(2).positionY = 320;
         gw.knights.get(3).positionX = 480;
         gw.knights.get(3).positionY = 288;
      }
      if (knightIndex != no && gw.state == State.POWER) //this state specifier is not strictly necessary; it is here for clear understanding
      {
         gw.score = gw.score + 400;
         gw.knights.remove(knightIndex);
      } 
   }

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
