/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import static mapeditor.Form.DragStart;
import static mapeditor.Form.Mouse;
import static mapeditor.Form.MouseStart;
import static mapeditor.Form.canvasPaintObjekt1;

/**
 *
 * @author Zoran
 */
public class MouseDragThread extends Thread
{
    MouseEvent evt;
    public MouseDragThread(MouseEvent evt) {
        this.evt = evt;
    }
    
    
    @Override
    public void run() 
    {
        int x2 = evt.getPoint().x;
        int x1 = MapEditor.MouseDragPoints.x;
        int y1 = MapEditor.MouseDragPoints.y;
        int y2 = evt.getPoint().y;
        
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int err = dx - dy;

        while (true) 
        {
            
                if (SwingUtilities.isLeftMouseButton(evt))
                {
                    Mouse = new Point(x1, y1);
                    MapEditor.MouseDragPoints = new Point(x2, y2);
                    Form.UpdateMap();
                }
                else if(SwingUtilities.isRightMouseButton(evt))
                {
                    DragStart = evt.getPoint();

                    move();
                    Mouse = evt.getPoint();
                }

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;

            if (e2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }

            if (e2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
        }
        
    }
    public static void move()
    {
        if (MouseStart.x > canvasPaintObjekt1.getWidth()-40 && MouseStart.x < canvasPaintObjekt1.getWidth())
        {
            if (MapEditor.Scroll2.y > 0)
            {
                MapEditor.Scroll2.y = 0;
            }
            else if(MapEditor.Scroll.y <-(MapEditor.Tiles.length*MapEditor.Tiles[0].length) *40 - MapEditor.Tiles[0].length)
            {
                MapEditor.Scroll2.y = (MapEditor.Tiles.length*MapEditor.Tiles[0].length) *40 - MapEditor.Tiles[0].length;
            }
            else
            {
                MapEditor.Scroll2.y += DragStart.y-Mouse.y;
            }
        }
        else
        {
            MapEditor.Scroll.x += DragStart.x-Mouse.x;
            MapEditor.Scroll.y += DragStart.y-Mouse.y;
            DragStart = Mouse;
        }
    }
}
