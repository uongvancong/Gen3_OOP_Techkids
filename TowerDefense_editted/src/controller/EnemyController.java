/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Vector;
import models.Bullet;
import models.Enemy;
import models.Enemy4;
import models.EnemyManager;
import models.Tower;
import models.TowerManager;
import views.GameWindow;

/**
 *
 * @author ADMIN
 */
public class EnemyController {

    private final EnemyManager enemyManager;
    private Vector<Enemy> deadEnemy = new Vector<>();

    public EnemyController(GameWindow gameWindow) {
        enemyManager = EnemyManager.getInst();
    }

    public void move() {
        for (Enemy enemy : enemyManager.getEnemyVect()) {
            enemy.performMove();

        }
        
        for (Enemy enemy : enemyManager.getEnemyVect()){
            if (enemy instanceof Enemy4){
                enemy = (Enemy4) enemy;
                enemy.shoot();
            }
        }
        for (Enemy enemy : enemyManager.getEnemyVect()) {
            if (enemy.isIsAlive() == false){
                deadEnemy.add(enemy);
            }       
           
       }
        for (Enemy enemy : deadEnemy){
            enemyManager.getEnemyVect().remove(enemy);
            //enemy.performMove();

        }


    }
}
