/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tuan anh le
 */
public class EnemyFly extends Enemy {

    public EnemyFly(int x, int y) {
        super(x, y);
        this.hp = 25;
        this.speed = 5;
        this.bonusPoint = 10;
        this.hpRemains = this.hp;
        this.moveBehavior = new EnemyMoveFly();
    }
}
