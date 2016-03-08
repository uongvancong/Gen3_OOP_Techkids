/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import models.EnemyManager;
import models.Game_State;

/**
 *
 * @author ADMIN
 */
public class GameControllerBarDrawer extends Drawer {

    @Override
    public void draw(Graphics g) {
        int posX = ViewConfig.MAP_OFFSET_X + ViewConfig.MAP_CELL_SIZE * ViewConfig.MAP_NUMBER_COLUM + 3;
        int posY = ViewConfig.MAP_OFFSET_Y;

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("res/scoreBar.png"));
        } catch (IOException ex) {
            Logger.getLogger(GameControllerBarDrawer.class.getName()).log(Level.SEVERE, null, ex);
        }
        int sizeX = 80;
        int sizeY = 80;
        int saiSo = 30;
        if (Game_State.point >= 10000) {
            sizeX += ViewConfig.MAP_CELL_SIZE / 2;
        }
        g.drawImage(img, posX, posY , 80, 80, null);

        g.setFont(new Font("Arcade Classic", Font.BOLD, 20));
        g.setColor(Color.BLUE);
        g.drawString(Game_State.live + "", posX + 20, posY  +saiSo);
        g.setColor(Color.red);
        g.drawString(Game_State.point + " ", posX + 20, posY +saiSo   + 35);
        g.drawString(Game_State.NO_EN+"", posX + 20, posY +saiSo   + 70);

    }

}
