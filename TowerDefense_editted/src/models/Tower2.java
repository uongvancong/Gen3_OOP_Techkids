/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tuan anh le
 */
public class Tower2 extends Tower {

    public Tower2(int x, int y) {
        super(x, y);
        this.cost = 40;
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

            Bullet bullet = new Bullet2(this.x + 4, this.y);
            bullet.setTarget(findTarget());
            bulletmanager.addbullet(bullet);

            count_test = 0;
        }
    }
}
