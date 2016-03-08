/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.util.Vector;
import models.*;

/**
 *
 * @author ADMIN
 */
public class TowerManagerDrawer extends Drawer {

    Vector<TowerDrawer> tower_drawerVect;
    TowerManager towerManager;

    public TowerManagerDrawer() {
        tower_drawerVect = new Vector<>();
        towerManager = TowerManager.getInst();
    }

    @Override
    public void draw(Graphics g) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Tower t : towerManager.getTowerVect()) {
            TowerDrawer td;
            if (t instanceof Tower1) {
                td = new Tower1_Drawer(t);
            } else if (t instanceof Tower2) {
                td = new Tower2_Drawer(t);
            } else if (t instanceof Tower3) {
                td = new Tower3_Drawer(t);
            } else if (t instanceof Tower4) {
                td = new Tower4_Drawer(t);
            } else {
                td = new TowerDrawer(t);
            }
            td.draw(g);
        }
    }
}
