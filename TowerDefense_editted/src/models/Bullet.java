/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class Bullet extends GameObject {

    public static Vector<Enemy> deadEnemy = new Vector<Enemy>();
    public static Vector<Bullet> deadBullet = new Vector<Bullet>();
    public static int EXP = 20;
    protected int power;
    Enemy enemyTarget;
    
    public Bullet(int x, int y){
        super(x, y);
    }


    public void setTarget(Enemy enemy) {
        this.enemyTarget = enemy;
    }

    public void move() {
        if (this.isAlive == false) {
            return;
        }
        if (enemyTarget == null) {
            return;
        }        
        int x = this.x - enemyTarget.x;
        int y = this.y - enemyTarget.y;
        if (x < 0) {
            x = -1;
        } else if (x == 0) {
            x = 0;
        } else {
            x = 1;
        }
        if (y < 0) {
            y = -1;
        } else if (y == 0) {
            y = 0;
        } else {
            y = 1;
        }
        this.setX(this.getX() - 7 * x);
        this.setY(this.getY() - 7 * y);
        int distance = (this.getX() - enemyTarget.x) * (this.getX() - enemyTarget.x) + (this.getY() - enemyTarget.y) * (this.getY() - enemyTarget.y);
        distance = (int) Math.sqrt(distance);
        if (distance <= EXP) {
            this.setIsAlive(false);
            deadBullet.add(this);
            if (enemyTarget.hpRemains > 0) {
                //System.out.println("Va cham");
                enemyTarget.hpRemains -= this.power;
                if (enemyTarget.hpRemains <= 0) {

                    deadEnemy.add(enemyTarget);
                    enemyTarget = null;
                }
            }
        }
        for (Enemy enemy : Bullet.deadEnemy) {
            Game_State.point += enemy.bonusPoint;
            EnemyManager.getInst().getEnemyVect().remove(enemy);
        }
        deadEnemy.clear();
    }
}
