/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Tower;

/**
 *
 * @author ADMIN
 */
public class Tower1_Drawer extends TowerDrawer{
    
    public Tower1_Drawer(Tower tower) {
        super(tower);
    }
    
    
    @Override
    public void loadSprite(){
        loadSprite("res/tower1.png");
    }
    
}
