/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import models.Bullet;
import models.Tower;
import models.TowerManager;
import views.GameWindow;

/**
 *
 * @author tuan anh le
 */
public class TowerController {

    private final models.TowerManager towermanager;

    public TowerController(GameWindow gamewindow) {
        towermanager = TowerManager.getInst();
    }

    public void shoot() {
        for (Tower tower : towermanager.getTowerVect()) {
            tower.shoot();            
        }
        
        for (Tower tower : models.Enemy4.deadObject){
            models.TowerManager.getInst().getTowerVect().remove(tower);
        }
        models.Enemy4.deadObject.removeAllElements();
    }
    
}
