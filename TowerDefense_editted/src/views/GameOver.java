/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;

/**
 *
 * @author ADMIN
 */
public class GameOver extends BaseDrawer{

    @Override
    protected void loadSprite() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     g.setColor(Color.RED);
      g.setFont(new Font("Tahoma", Font.BOLD, 80));
      g.drawString("GAME OVER!",200,350 );
    }
    
}
