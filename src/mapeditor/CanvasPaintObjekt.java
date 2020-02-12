/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
/**
 *
 * @author TE10ZoOs
 */
public class CanvasPaintObjekt extends Canvas
{
    //Overides The Paint Method
    @Override
    public void paint(Graphics g)
    {
        //Makes A Double Buffer To Prevent Flickering
        //<editor-fold defaultstate="collapsed" desc="{Double Buffer}">
        Graphics G; 
        Image offscreen;
        Dimension dim = this.getSize(); 
        offscreen = createImage(dim.width,dim.height);
        G = offscreen.getGraphics();
        Image Paint1 = createImage(this.getWidth()-40, this.getHeight());
        Image Paint2 = createImage(40, this.getHeight());
        //</editor-fold>
        //Runs Draw Function In Another Class
        Draw.Paint(G,this,Paint1,Paint2);
        //<editor-fold defaultstate="collapsed" desc="{Double Buffer}">
        g.drawImage(offscreen,0,0,this);
        //</editor-fold>
    }
    //Overides The Update Method To Prevent Canvas Fill And Flickering
    @Override
    public void update(Graphics g)
    {
        //Runs The Paint Method
        paint(g);
    }
}
