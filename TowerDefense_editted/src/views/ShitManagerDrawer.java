/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.util.Vector;
import models.Shit;
import models.ShitManager;

/**
 *
 * @author ADMIN
 */
public class ShitManagerDrawer extends BaseDrawer{
    Vector<Shit> shitVect = ShitManager.getInst().getShitVect();
    public ShitManagerDrawer() {
        shitVect = ShitManager.getInst().getShitVect();
    }

    @Override
    protected void loadSprite() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Graphics g) {
        for(int i =0; i<shitVect.size();i++){
            Shit shit = shitVect.get(i);
            ShitDrawer sd = new ShitDrawer(shit);
            sd.draw(g);
        }
    }
    
}
