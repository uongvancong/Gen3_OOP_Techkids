/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class Enemy4 extends Enemy {
    public static Vector<Tower> deadObject = new Vector<>();
    public int counttime = 0;

    public Enemy4(int x, int y) {
        super(x, y);
        this.hp = 10;
        this.speed = 1;
        this.bonusPoint = 50;
        this.hpRemains = this.hp;
        this.moveBehavior = new EnemyMove();
    }

    @Override
    public void shoot() {
        counttime++;
        if (counttime >= 50) {
            if (findTarget() != null) {
                BulletManager bulletmanager = BulletManager.getInst();
                Bullet4 bullet = new Bullet4(this.x + 4, this.y);
                bullet.setTowerTarget(findTarget());
                bulletmanager.addbullet(bullet);

            }
            //TowerManager.getInst().getTowerVect().remove(findTarget());
            deadObject.add(findTarget());
            counttime = 0;
        }

    }

    public Tower findTarget() {
        Tower result = null;
        views.ViewLocation viewlocation = models.Ultility.covertpixeltocelrow(this.x, this.y);
        int posX = viewlocation.posX;
        int posY = viewlocation.posY;
        //8 huong
        int direcX[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int direcY[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        //  int pos = models.Ultility.convertcelltow2stt(posX , posY);
        for (Tower tower : TowerManager.getInst().getTowerVect()) {
            viewlocation = models.Ultility.covertpixeltocelrow(tower.x, tower.y);
            if ((Math.abs(posX - viewlocation.posX) <= 1) && (Math.abs(posY - viewlocation.posY) <= 1)) {
                return (tower);
            }
            //                if (pos == tower.getPosition())
//                    return(tower);
        }
        return (result);
    }
}
