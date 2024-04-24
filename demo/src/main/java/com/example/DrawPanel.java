import javax.swing.JPanel; // container to store a group of components
import java.awt.Dimension;

// Celines forsøg på kode:

    
public class DrawPanel extends JPanel{
// Screen settings
    final int tileSize = 32; //32x32 pixelstørrelse

     final int maxScreenCol = 30; //horizontalt antal tiles
     final int maxScreenRow = 21; // vertikalt antal tiles

     final int screenWidth = tileSize * maxScreenCol; //32*30 = 960 pixels horisontalt
     final int screenheight = tileSize * maxScreenRow; //32*21 = 672 pixels vertikalt
     }

     public GamePanel() {
         this.setPrefferedSize(new Dimension(screenWidth, screenHeight));
         this.setDoubleBuffered(true); // so drawing is done offscreen
     }
