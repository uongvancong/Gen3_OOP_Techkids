/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Enemy;

/**
 *
 * @author ADMIN
 */
public class Enemy4_Drawer extends EnemyDrawer{
    public Enemy4_Drawer(Enemy enemy) {
      //  System.out.println("oooo");
        this.enemy = enemy;
        for (int i = 0; i < 4; i++) {
            loadSprite("res/enemy3_" + i + ".png");          
            spriteVect.add(sprite);
        }
    }

    @Override
    public void loadSprite() {
        loadSprite("res/Object.png");
    }
}
