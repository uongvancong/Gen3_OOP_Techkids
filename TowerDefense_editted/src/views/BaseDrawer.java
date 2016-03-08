/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

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
public abstract class BaseDrawer extends Drawer{
    protected BufferedImage sprite;
    protected abstract void loadSprite();
    public BaseDrawer(){
        loadSprite();
    }
    
    protected void loadSprite(String url){
        try {
            sprite = ImageIO.read(new File(url));
        } catch (IOException ex) {
            Logger.getLogger(BaseDrawer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
            
}
