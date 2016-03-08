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
public class Enemy1_Drawer extends EnemyDrawer {

    public Enemy1_Drawer(Enemy enemy) {
        this.enemy = enemy;
        for (int i = 0; i < 4; i++) {
            loadSprite("res/enemy" + i + ".png");
            //System.out.println("Enemy1_");
            spriteVect.add(sprite);
        }
    }

    @Override
    public void loadSprite() {
        loadSprite("res/Object.png");
    }
}
