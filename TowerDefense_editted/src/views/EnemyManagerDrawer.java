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
public class EnemyManagerDrawer extends Drawer {

    private Vector<EnemyDrawer> eDVect;
    private EnemyManager eManager;

    public EnemyManagerDrawer() {
        eDVect = new Vector<>();
        eManager = EnemyManager.getInst();
    }

    @Override
    public void draw(Graphics g) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < eManager.getEnemyVect().size(); i++) {
            Enemy enemy = eManager.getEnemyVect().get(i);
            if (enemy.isIsAlive() == false) {
                continue;
            }
            EnemyDrawer ed;
            if (enemy instanceof Enemy1) {
                ed = new Enemy1_Drawer(enemy); //EnemyDrawer
            } else if (enemy instanceof Enemy2) {
                ed = new Enemy2_Drawer(enemy);         //Enemy1_Drawer       
            } else if(enemy instanceof Enemy3){
                ed = new Enemy3_Drawer(enemy);
            }
            else
            {
                ed = new Enemy4_Drawer(enemy);
            }
            ed.draw(g);
        }
    }
}
