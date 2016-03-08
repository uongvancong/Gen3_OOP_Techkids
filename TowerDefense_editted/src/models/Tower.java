/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import views.ViewConfig;

/**
 *
 * @author ADMIN
 */
public class Tower extends GameObject {

    protected int cost;
    protected int radius;
    public int count_test = 0;
    protected int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Tower(int x, int y) {
        super(x, y);

    }

    public Tower(int x, int y, int cost, int radius) {
        super(x, y);
        this.cost = cost;
        this.radius = radius;
    }

    public void shoot() {
        //code at here :)
        //bulletmanager.addbullet(new Bullet(this.x-4, this.y, speed));
    }

    public boolean checkIsInRadius(GameObject gameObject) {
        //code at here :)
        int goX = gameObject.x + views.ViewConfig.MAP_CELL_SIZE / 2;
        int goY = gameObject.y + views.ViewConfig.MAP_CELL_SIZE / 2;
        int thisX = this.x + ViewConfig.MAP_CELL_SIZE / 2;
        int thisY = this.y + ViewConfig.MAP_CELL_SIZE / 2;
        int d = (goX - thisX) * (goX - thisX) + (goY - thisY) * (goY - thisY);
        int distance = (int) Math.sqrt(d);
        if (distance <= this.radius) {
            return (true);
        }
        return false;
    }

    public Enemy findTarget() {
        //code at here :)
        for (Enemy enemy : EnemyManager.getInst().getEnemyVect()) {
            if (checkIsInRadius(enemy)) {
                //   System.out.println("Co quai");
                if (!(enemy instanceof EnemyFly)) {
                    return (enemy);
                }
            }
        }
        return null;
    }
}
