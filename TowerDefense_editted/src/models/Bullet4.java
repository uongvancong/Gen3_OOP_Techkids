/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import static models.Bullet.EXP;
import static models.Bullet.deadBullet;
import static models.Bullet.deadEnemy;

/**
 *
 * @author tuan anh le
 */
public class Bullet4 extends Bullet{
    public Tower towerTarget;

    public Tower getTowerTarget() {
        return towerTarget;
    }

    public void setTowerTarget(Tower towerTarget) {
        this.towerTarget = towerTarget;
    }
    public Bullet4(int x, int y) {
        super(x, y);
    }
    
    

    @Override
    public void move() {
    //    super.move(); //To change body of generated methods, choose Tools | Templates.
        if (this.isAlive == false) {
            return;
        }        
        int x = this.x - towerTarget.x;
        int y = this.y - towerTarget.y;
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
        int distance = (this.getX() - towerTarget.x) * (this.getX() - towerTarget.x) + (this.getY() - towerTarget.y) * (this.getY() - towerTarget.y);
        distance = (int) Math.sqrt(distance);
        if (distance <= EXP) {
            this.setIsAlive(false);
            deadBullet.add(this);        
        }
    }
    
}
