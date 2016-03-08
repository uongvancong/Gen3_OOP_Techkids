/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tuan anh le
 */
public class Enemy2 extends Enemy {

    public Enemy2(int x, int y) {
        super(x, y);        
        this.hp = 20;
        this.speed = 3;
        this.bonusPoint = 5;
        this.hpRemains = this.hp;
        this.moveBehavior = new EnemyMove();
    }
    
}
