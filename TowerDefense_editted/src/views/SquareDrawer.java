/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;

/**
 *
 * @author ADMIN
 */
public class SquareDrawer extends BaseDrawer {

    @Override
    protected void loadSprite() {
        loadSprite("res/square.png");
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < ViewConfig.MAP_NUMBER_ROW; i++) {
            for (int j = 0; j < ViewConfig.MAP_NUMBER_COLUM; j++) {
                g.drawImage(sprite, ViewConfig.MAP_OFFSET_X + ViewConfig.MAP_CELL_SIZE * i,
                        ViewConfig.MAP_OFFSET_Y + ViewConfig.MAP_CELL_SIZE * j,
                        ViewConfig.MAP_CELL_SIZE, ViewConfig.MAP_CELL_SIZE, null);
            }
        }
    }

}
