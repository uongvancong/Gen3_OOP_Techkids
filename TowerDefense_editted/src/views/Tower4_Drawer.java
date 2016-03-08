/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Tower;

/**
 *
 * @author ADMIN
 */
public class Tower4_Drawer extends TowerDrawer{
       public Tower4_Drawer(Tower tower) {
        super(tower);
    }

    @Override
    public void loadSprite() {
        loadSprite("res/tower4.png");
    }
}
