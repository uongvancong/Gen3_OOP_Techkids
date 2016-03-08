///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package views;
//
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//import java.util.Vector;
//import models.ItemManager;
//import models.TowerManager;
//
///**
// *
// * @author tuan anh le
// */
//public class ItemBarDrawer extends BaseDrawer {
//
//    Vector<BufferedImage> spriteVect;
//
//    public ItemBarDrawer() {
//
//        spriteVect = new Vector<>();
//        for (int i = 1; i <= 3; i++) {
//            if (!models.Ultility.getCostAvai(i)) {
//                loadSprite("res/blind" + ".png");
//            } else {
//                loadSprite("res/tower" + i + ".png");
//            }
//            spriteVect.add(sprite);
//        }
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        spriteVect.removeAllElements();
//        for (int i = 1; i <= 3; i++) {
//            if (!models.Ultility.getCostAvai(i-1)) {
//                loadSprite("res/tower"+(i)+"_blind.png");
//            } else {
//                loadSprite("res/tower" + i + ".png");
//            }
//            spriteVect.add(sprite);
//        }
//        int posX = ViewConfig.MAP_OFFSET_X + ViewConfig.MAP_CELL_SIZE * ViewConfig.MAP_NUMBER_COLUM + 3;
//        int posY = ViewConfig.MAP_OFFSET_Y;
//        for (int i = 0; i < spriteVect.size(); i++) {
//            sprite = spriteVect.get(i);
//            g.drawImage(sprite, posX, posY + ViewConfig.MAP_CELL_SIZE * (i + 2), ViewConfig.MAP_CELL_SIZE, ViewConfig.MAP_CELL_SIZE, null);
////            if (!models.Ultility.getCostAvai(i)){
////                continue;
////            }
//            g.setFont(new Font("Arial", Font.PLAIN, 15));
//            g.drawString("Cost :" + TowerManager.costTower[i], posX + ViewConfig.MAP_CELL_SIZE, posY + ViewConfig.MAP_CELL_SIZE * (i + 2) + ViewConfig.MAP_CELL_SIZE / 2);
//            g.drawString("Radius :" + TowerManager.radiusTower[i], posX + ViewConfig.MAP_CELL_SIZE, posY + ViewConfig.MAP_CELL_SIZE * (i + 2) + ViewConfig.MAP_CELL_SIZE / 2 + 15);
//
//        }
//    }
//
//    @Override
//    protected void loadSprite() {
//        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Vector;
import models.ItemManager;
import models.ShitManager;
import models.TowerManager;

/**
 *
 * @author tuan anh le
 */
public class ItemBarDrawer extends BaseDrawer {

    Vector<BufferedImage> spriteVect;

    public ItemBarDrawer() {

        spriteVect = new Vector<>();
        loadSprite("res/Shit.png");
        spriteVect.add(sprite);
        for (int i = 1; i <= 3; i++) {
            if (!models.Ultility.getCostAvai(i)) {
                loadSprite("res/blind" + ".png");
            } else {
                loadSprite("res/tower" + i + ".png");
            }
            spriteVect.add(sprite);
        }
    }

    @Override
    public void draw(Graphics g) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        spriteVect.removeAllElements();

        for (int i = 0; i <= 4; i++) {
            if (!models.Ultility.getCostAvai(i)) {
                loadSprite("res/Shit_blind.png");
                if (i != 0) {
                    loadSprite("res/tower" + i + "_blind.png");
                }
            } else {
                loadSprite("res/Shit.png");
                if (i != 0) {
                    loadSprite("res/tower" + i + ".png");
                }
            }
            spriteVect.add(sprite);
        }

        int posX = ViewConfig.MAP_OFFSET_X + ViewConfig.MAP_CELL_SIZE * ViewConfig.MAP_NUMBER_COLUM + 3;
        int posY = ViewConfig.MAP_OFFSET_Y;
        for (int i = 0; i < spriteVect.size(); i++) {
            sprite = spriteVect.get(i);
            g.drawImage(sprite, posX, posY + ViewConfig.MAP_CELL_SIZE * (i + 2), ViewConfig.MAP_CELL_SIZE, ViewConfig.MAP_CELL_SIZE, null);
//            if (!models.Ultility.getCostAvai(i)){
//                continue;
//            }


            //ve info

            g.setFont(new Font("Arial", Font.PLAIN, 15));
            if (i > 0) {
                g.drawString("Cost :" + TowerManager.costTower[i - 1], posX + ViewConfig.MAP_CELL_SIZE, posY + ViewConfig.MAP_CELL_SIZE * (i + 2) + ViewConfig.MAP_CELL_SIZE / 2);
                g.drawString("Radius :" + TowerManager.radiusTower[i - 1], posX + ViewConfig.MAP_CELL_SIZE, posY + ViewConfig.MAP_CELL_SIZE * (i + 2) + ViewConfig.MAP_CELL_SIZE / 2 + 15);
            } else {// ve item's info
                g.drawString("Cost :"+ShitManager.ShitCost, posX + ViewConfig.MAP_CELL_SIZE, posY + ViewConfig.MAP_CELL_SIZE * (i + 2) + ViewConfig.MAP_CELL_SIZE / 2);
          //      g.drawString("Radius :" + TowerManager.radiusTower[i - 1], posX + ViewConfig.MAP_CELL_SIZE, posY + ViewConfig.MAP_CELL_SIZE * (i + 2) + ViewConfig.MAP_CELL_SIZE / 2 + 15);
            }
        }
    }

    @Override
    protected void loadSprite() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
