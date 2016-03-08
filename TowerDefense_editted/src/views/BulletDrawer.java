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
 * @author tuan anh le
 */
public class BulletDrawer extends BaseDrawer {
    
    BulletManager bulletManager = BulletManager.getInst();
    
    @Override
    protected void loadSprite() {
        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //    BaseDrawer.loadSprite(url);
        loadSprite("res/bullet.png");
    }
    
    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < bulletManager.getBulletVect().size(); i++) {
            Bullet bullet = bulletManager.getBulletVect().get(i);
            if (bullet.isIsAlive() == false) {
                continue;
            }
            //ViewLocation viewlocation = ViewConfig.calculatemidViewLocation(enemy.getX(), enemy.getY());

            int posX = bullet.getX();//+ViewConfig.MAP_CELL_SIZE/3;
            int posY = bullet.getY();//+ViewConfig.MAP_CELL_SIZE/3;
            if (bullet instanceof Bullet5) {
                loadSprite("res/bullet5.png");
                g.drawImage(sprite, posX, posY, ViewConfig.MAP_CELL_SIZE / 2, ViewConfig.MAP_CELL_SIZE / 2, null);
            } else
            if (bullet instanceof Bullet4) {
                loadSprite("res/item0.png");
                g.drawImage(sprite, posX, posY, ViewConfig.MAP_CELL_SIZE / 2, ViewConfig.MAP_CELL_SIZE / 2, null);
            } else {
                loadSprite("res/bullet.png");
                g.drawImage(sprite, posX, posY, ViewConfig.MAP_CELL_SIZE / 3, ViewConfig.MAP_CELL_SIZE / 3, null);                
            }
            // int posX = ViewConfig.MAP_OFFSET + enemy.getX() * ViewConfig.MAP_CELL_SIZE;
            //int posY = ViewConfig.MAP_OFFSET + enemy.getY() * ViewConfig.MAP_CELL_SIZE;
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
