/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import models.Shit;

/**
 *
 * @author ADMIN
 */
public class ShitDrawer extends BaseDrawer{

    Shit s;

    public ShitDrawer(Shit s) {
        this.s = s;
    }    
                               
    @Override
    protected void loadSprite() {
       
        loadSprite("res/shit.png");
    }

    @Override
    public void draw(Graphics g) {
                    g.drawImage(sprite, s.getX(), s.getY(), ViewConfig.MAP_CELL_SIZE,
                            ViewConfig.MAP_CELL_SIZE, null);
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
