/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

/**
 *
 * @author Zoran
 */
public class MapEditor
{

    /**
     * @param args the command line arguments
     */
    public static Point[][] map = UpdateMap(10, 10);
    public static Point[][] mapColision = UpdateMap(100, 100);
    public static Point map_tiles = new Point(10,10);
    public static Image[][] Tiles = new Image[10][10];
    public static BufferedImage Tileimage;
    public static Image TileimageHand;
    public static Timer timer1 = new Timer();
    public static Point limit = new Point(0,0);
    public static Point limit2 = new Point(map.length*40,map[0].length*40);
    public static Point Scroll = new Point(0,0);
    public static Point Scroll2 = new Point(0,0);
    public static int EditState = 0;
    public static Point MouseDragPoints = new Point(0,0);
    public static void main(String[] args)
    {
        try
        {
            
            Tileimage = ImageIO.read(MapEditor.class.getResourceAsStream("/mapeditor/Tiles.png"));
            TileimageHand = ImageIO.read(MapEditor.class.getResourceAsStream("/mapeditor/Hand.png"));
            for (int x=0; x < map.length;x++)
            {
                
            }
            for (int i =0; i < Tiles.length;i++)
            {
                for (int t=0; t < Tiles[0].length;t++)
                {
                    Tiles[i][t] = Tileimage.getSubimage(i*40, t*40, 40, 40);
                }
            }
            Form MainDrawForm = new Form();
            MainDrawForm.show();
            Thread ReDrawHandler = new ReDrawThread();
            ReDrawHandler.start();
        }
        catch (Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        
    }
    public static Point[][] UpdateMap(int x, int y)
    {
        Point[][] temp = new Point[x][y];
        for (int i=0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                temp[i][j] = new Point(0,0);
            }
        }
        return temp;
    }
}
