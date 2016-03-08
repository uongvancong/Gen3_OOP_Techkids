/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Enemy;

/**
 *
 * @author tuan anh le
 */
public class Enemy2_Drawer extends EnemyDrawer {

    public Enemy2_Drawer(Enemy enemy) {
        this.enemy = enemy;
        for (int i = 0; i < 4; i++) {
            loadSprite("res/enemy1_" + i + ".png");
            //System.out.println("Enemy1_");
            spriteVect.add(sprite);
        }
    }

    @Override
    public void loadSprite() {
        loadSprite("res/Object.png");
    }
}
