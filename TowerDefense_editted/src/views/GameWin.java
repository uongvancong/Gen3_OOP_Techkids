/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author ADMIN
 */
public class GameWin extends BaseDrawer {

    @Override
    protected void loadSprite() {
        //     throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Graphics g) {
        //    throw new UnsupportedOperationException("Not supported yet.");
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 80));
        g.drawString("WINNER!", 200, 350);
    }
}
