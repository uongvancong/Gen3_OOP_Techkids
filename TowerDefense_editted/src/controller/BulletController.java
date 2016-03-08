/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import models.Bullet;
import models.BulletManager;
import models.Enemy;
import views.GameWindow;

/**
 *
 * @author tuan anh le
 */
public class BulletController {
    private final BulletManager bulletmanager ;
    public BulletController(GameWindow gamewindow){
        bulletmanager = BulletManager.getInst();
    }
    
    public void move(){
        for (Bullet bullet : bulletmanager.getBulletVect()) {
            bullet.move();
            //enemy.performMove();
        }
    }
}
