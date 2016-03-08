/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Enemy;

/**
 *
 * @author ADMIN
 */
public class EnemyDrawer1 extends EnemyDrawer{
    
    public EnemyDrawer1(Enemy enemy) {
        super(enemy);
    }
    @Override
    public void loadSprite(){
       loadSprite("res/Object.png");
    }
    
}
