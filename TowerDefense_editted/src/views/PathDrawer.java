/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.util.Vector;
import models.Location;
import models.Path;

/**
 *
 * @author ADMIN
 */
public class PathDrawer extends BaseDrawer{
    Path path = Path.getInst();
    Vector<Location> pathLocationVect = path.getVector();

    public boolean checkIsPath(int x, int y) {
        for (Location location : pathLocationVect) {
            if (location.x == x && location.y == y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        for (int row = 0; row < ViewConfig.MAP_NUMBER_ROW; row++) {
            for (int colum = 0; colum < ViewConfig.MAP_NUMBER_COLUM; colum++) {
                if (checkIsPath(colum, row)) {
                    ViewLocation viewLocation = ViewConfig.calculateViewLocation(row, colum);
                    g.drawImage(sprite, viewLocation.posX, viewLocation.posY, ViewConfig.MAP_CELL_SIZE,
                            ViewConfig.MAP_CELL_SIZE, null);
                }
            }
        }
    }

    @Override
    protected void loadSprite() {
        loadSprite("res/path.png");
    }
}
