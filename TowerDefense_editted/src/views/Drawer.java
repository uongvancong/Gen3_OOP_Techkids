/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 *
 * @author ADMIN
 */
public abstract class Drawer {
    public abstract void draw(Graphics g);
    protected BufferedImage loadImage(String url){
        BufferedImage  sprite = null;
        try {
            sprite = ImageIO.read(new File(url));
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sprite;
    }
}
