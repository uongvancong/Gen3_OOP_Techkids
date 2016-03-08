/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import models.GameObject;
import models.Tower;

/**
 *
 * @author ADMIN
 */
public class TowerDrawer extends BaseDrawer {

    protected Tower tower;

    public TowerDrawer(Tower tower) {
        this.tower = tower;
    }

    @Override
    protected void loadSprite() {
        loadSprite("res/tower.png");
        Image i = sprite;           
    }

    @Override
    public void draw(Graphics g) {
        int posX = tower.getX();
        int posY = tower.getY();
        g.drawImage(sprite, posX+10, posY+10, ViewConfig.MAP_CELL_SIZE-20, ViewConfig.MAP_CELL_SIZE-20, null);
      //  g.drawOval(posX - tower.getRadius() + ViewConfig.MAP_CELL_SIZE / 2, posY - tower.getRadius() + ViewConfig.MAP_CELL_SIZE / 2, tower.getRadius() * 2, tower.getRadius() * 2);
    }

}
