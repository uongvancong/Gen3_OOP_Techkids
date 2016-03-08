/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.util.Vector;
import models.ItemManager;
import models.Ultility;

/**
 *
 * @author ADMIN
 */
public class ItemManagerDrawer extends BaseDrawer {

    ItemManager itemManager;
    Vector<BufferedImage> spriteVect;

    public ItemManagerDrawer() {
//        itemManager = ItemManager.getInst();
//        spriteVect = new Vector<>();
//        for (int i = 1; i <= 4; i++) {
//            if (!models.Ultility.getCostAvai(i)){
//                loadSprite("res/blind"+".png");                
//            }
//            else
//            loadSprite("res/tower" + i + ".png");
//            spriteVect.add(sprite);
//        }
            itemManager = ItemManager.getInst();
        spriteVect = new Vector<>();
        loadSprite("res/Shit.png");
        spriteVect.add(sprite);
        for (int i = 1; i <= 4; i++) {
            if (!models.Ultility.getCostAvai(i)){
                loadSprite("res/blind"+".png");                
            }
            else
            loadSprite("res/tower" + i + ".png");
            spriteVect.add(sprite);
        }
    }

    @Override
    public void draw(Graphics g) {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (itemManager.getItemVect().size() != 0) {
            int type = itemManager.getItemVect().get(0).getType();
            int itemX = itemManager.getItemVect().get(0).getX() - ViewConfig.MAP_CELL_SIZE / 3;
            int itemY = itemManager.getItemVect().get(0).getY() - ViewConfig.MAP_CELL_SIZE / 3;
           // System.out.println("..."+Ultility.getCostAvai(type));
            if (Ultility.getCostAvai(type)) {
                g.drawImage(spriteVect.get(type), itemX, itemY, 32, 32, null);
            }
        }
    }

    @Override
    protected void loadSprite() {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
