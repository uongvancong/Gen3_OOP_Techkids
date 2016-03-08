/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ADMIN
 */
public class Enemy extends GameObject {
   
    protected int hp;
    protected int hpRemains;
    protected int bonusPoint;
    protected int type;
    public void shoot(){
        
    }
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpRemains() {
        return hpRemains;
    }

    public void setHpRemains(int hpRemains) {
        this.hpRemains = hpRemains;
    }

    public Enemy(int x, int y) {
        //, int speed, int hp, int bonusPoint,
        super(x, y);
        

    }

    public Enemy(int x, int y, int speed, int hp, int bonusPoint) {
        super(x, y);
        this.hp = hp;
        this.speed = speed;
        this.moveBehavior = new EnemyMove();
        this.hpRemains = hp;
        this.bonusPoint = bonusPoint;
        position = 0;
    }

}
