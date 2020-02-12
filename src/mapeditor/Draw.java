/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;


/**
 *
 * @author Zoran
 */
public class Draw
{
    public static void Paint(Graphics g, Canvas can,Image main, Image sub)
    {
        int width = can.getWidth();
        int height = can.getHeight();
        int Section_1[] = {0,0,width-40,height};
        int Section_2[] = {width-40,0,width,height};
        
        
        
        
        Graphics gp = main.getGraphics();
        Graphics DrawTiles = sub.getGraphics();
        PaintTiles(DrawTiles,can);
        PaintMap(gp,can);
        g.drawImage(main, 0, 0, can);
        g.drawImage(sub, Section_2[0], Section_2[1], can);
        
    }
    public static void PaintTiles(Graphics g, Canvas can)
    {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 40, can.getHeight());
        g.setColor(Color.blue);
        if (MapEditor.EditState ==2)
        {
            for (int x=0; x < MapEditor.map_tiles.x;x++)
            {
                for (int y=0; y < MapEditor.map_tiles.y;y++)
                {
                    if (x+y*MapEditor.map_tiles.y == 1)
                    {
                        g.fillRect(0, (x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 40, 40);
                    }
                    else if(x+y*MapEditor.map_tiles.y == 2)
                    {
                        g.drawRect(0, 0+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(10, 0+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(20, 0+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(30, 0+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(0, 10+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(10, 10+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(20, 10+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(30, 10+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(0, 20+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(10, 20+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(20, 20+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(30, 20+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(0, 30+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(10, 30+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(20, 30+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                        g.drawRect(30, 30+(x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 10, 10);
                    }
                    else
                    {
                        g.drawRect(0, (x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 39, 39);
                    }
                }
            }
        }
        else
        {
            for (int x=0; x < MapEditor.map_tiles.x;x++)
            {
                for (int y=0; y < MapEditor.map_tiles.y;y++)
                {
                    g.drawRect(0, (x+y*MapEditor.map_tiles.y)*40+50 + MapEditor.Scroll2.y, 39, 39);
                    g.drawImage(MapEditor.Tiles[x][y], 0, (x+y*MapEditor.map_tiles.y)*40+ 50 + MapEditor.Scroll2.y, can);
                }
            }
        }
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 40, 50);
        g.fillRect(0, can.getHeight()-70, 40, 70);
        g.setColor(Color.blue);
        g.drawRect(0, 0, 39, 39);
        
        if (Form.CorrentTile.x >=0 && Form.CorrentTile.y >=0)
        {
            if (MapEditor.EditState ==2)
            {
                if (Form.CorrentTile.x+Form.CorrentTile.y* MapEditor.map_tiles.y == 1)
                {
                    g.fillRect(0, 0, 40, 40);
                }
                else if(Form.CorrentTile.x+Form.CorrentTile.y* MapEditor.map_tiles.y  == 2)
                {
                    g.drawRect(0, 0, 10, 10);
                    g.drawRect(10, 0, 10, 10);
                    g.drawRect(20, 0, 10, 10);
                    g.drawRect(30, 0, 10, 10);
                    g.drawRect(0, 10, 10, 10);
                    g.drawRect(10, 10, 10, 10);
                    g.drawRect(20, 10, 10, 10);
                    g.drawRect(30, 10, 10, 10);
                    g.drawRect(0, 20, 10, 10);
                    g.drawRect(10, 20, 10, 10);
                    g.drawRect(20, 20, 10, 10);
                    g.drawRect(30, 20, 10, 10);
                    g.drawRect(0, 30, 10, 10);
                    g.drawRect(10, 30, 10, 10);
                    g.drawRect(20, 30, 10, 10);
                    g.drawRect(30, 30, 10, 10);
                    
                }
                else
                {
                    g.drawRect(0, 0, 39, 39);
                }
            }
            
            else
            {
                g.drawImage(MapEditor.Tiles[Form.CorrentTile.x][Form.CorrentTile.y], 0, 0, can);
                g.drawRect(0, 0, 39, 39);
            }
        }
        else
        {
            g.drawImage(MapEditor.TileimageHand, 0, 0, can);
            g.drawRect(0, 0, 39, 39);
        }
    }
    public static void PaintMap(Graphics g, Canvas can)
    {
        Point TempData;
        g.setColor(Color.red);
        
        for (int X=0; X < MapEditor.map.length; X++)
        {
            
            for (int Y =0; Y < MapEditor.map[0].length; Y++)
            {
                
                g.drawRect(X*(int)(40*Form.zoom)+MapEditor.Scroll.x, Y*(int)(40*Form.zoom)+MapEditor.Scroll.y, (int)(39*Form.zoom), (int)(39*Form.zoom));
                TempData = MapEditor.map[X][Y];
                g.drawImage(MapEditor.Tiles[TempData.x][TempData.y], X*(int)(40*Form.zoom)+MapEditor.Scroll.x, Y*(int)(40*Form.zoom) +MapEditor.Scroll.y,(int)(40*Form.zoom),(int)(40*Form.zoom), can);
            }
            
        }
        if (MapEditor.EditState ==2)
        {
            for (int X=0; X < MapEditor.mapColision.length; X++)
            {

                for (int Y =0; Y < MapEditor.mapColision[0].length; Y++)
                {
                    if (MapEditor.mapColision[X][Y].x == 1)
                    {
                        g.drawRect((int)(X*(4*Form.zoom))+MapEditor.Scroll.x, (int)(Y*(4*Form.zoom))+MapEditor.Scroll.y, (int)(4*Form.zoom), (int)(4*Form.zoom));
                    }
                }
            }
        }
    }
}
