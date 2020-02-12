/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeditor;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Zoran
 */
public class ReDrawThread extends Thread
{
    Timer timer1 = new Timer();
    
    @Override
    public void run() 
    {
        timer1.scheduleAtFixedRate(new TimerTask() 
        {

            @Override
            public void run() 
            {
                Form.canvasPaintObjekt1.repaint();
            }
        }, 0, 1000/60);
    }
    
}
