/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;
import views.ViewConfig;
import views.ViewLocation;

/**
 *
 * @author tuan anh le
 */
public class BulletManager {
    private Vector<Bullet> bulletVect;

    private BulletManager() {
        bulletVect = new Vector<Bullet>();
    }

    public Vector<Bullet> getBulletVect() {
        return bulletVect;
    }

    public void addbullet(Bullet bullet) {
        bulletVect.add(bullet);
    }
    private static BulletManager inst;

    public static BulletManager getInst() {
        if (inst == null) {
            inst = new BulletManager();            
        }
        return inst;
    }
}
