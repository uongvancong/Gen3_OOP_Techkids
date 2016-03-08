/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tuan anh le
 */
public class Enemy1 extends Enemy {

    public Enemy1(int x, int y) {
        super(x, y);
        this.hp = 15;
        this.speed = 2;
        this.bonusPoint = 1;
        this.hpRemains = this.hp;
        this.moveBehavior = new EnemyMove();
    }
}
