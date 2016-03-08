/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;
import views.ViewConfig;
import views.ViewLocation;

/**
 *
 * @author ADMIN
 */
public class EnemyManager {
    private Vector<Enemy> enemyVect;

    private EnemyManager() {
        enemyVect = new Vector<>();
    }

    public Vector<Enemy> getEnemyVect() {
        return enemyVect;
    }
    
    public void addEnemyType(int posX, int posY, int type){
      //  enemyVect.add(new Enemy(posX, posY, type));
    }

    public void addEnemy(Enemy enemy) {
        enemyVect.add(enemy);
        Game_State.NO_EN--;
    }
    private static EnemyManager inst;

    public static EnemyManager getInst() {
        if (inst == null) {
            inst = new EnemyManager();
            ViewLocation viewlocation =  ViewConfig.calculateViewLocation(6, 0);
          // inst.addEnemy(new Enemy(viewlocation.posX  , viewlocation.posY, 2  ,1, 50));           
        }
        return inst;
    }
    
}
