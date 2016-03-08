/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tuan anh le
 */
public class Tower1 extends Tower {

    public Tower1(int x, int y) {
        super(x, y);
        this.cost = 20;
        this.radius = 100;
    }

    @Override
    public void shoot() {
        //super.shoot(); //To change body of generated methods, choose Tools | Templates.
        BulletManager bulletmanager = BulletManager.getInst();
        count_test++;
        if (count_test >= 60) {
            if (findTarget() == null) {
                return;
            }

            Bullet bullet = new Bullet1(this.x + 4, this.y, 1);
            bullet.setTarget(findTarget());
            bulletmanager.addbullet(bullet);
            count_test = 0;
        }
    }
}