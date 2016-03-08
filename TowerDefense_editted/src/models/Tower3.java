/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tuan anh le
 */
public class Tower3 extends Tower {

    public Tower3(int x, int y) {
        super(x, y);
        this.cost = 60;
        this.radius = 100;
    }

    @Override
    public void shoot() {
        //    super.shoot(); //To change body of generated methods, choose Tools | Templates.
        BulletManager bulletmanager = BulletManager.getInst();
        count_test++;
        if (count_test >= 60) {
            if (findTarget() == null) {
                return;
            }

            Bullet bullet = new Bullet3(this.x + 4, this.y);
            bullet.setTarget(findTarget());
            bulletmanager.addbullet(bullet);

            count_test = 0;
        }
    }
}
