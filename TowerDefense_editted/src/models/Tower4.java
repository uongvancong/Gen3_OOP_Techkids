/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ADMIN
 */
public class Tower4 extends Tower {

    public Tower4(int x, int y) {
        super(x, y);
        this.cost = 50;
        this.radius = 200;
    }

    @Override
    public Enemy findTarget() {
        for (Enemy enemy : EnemyManager.getInst().getEnemyVect()) {
            if (checkIsInRadius(enemy)) {
                //   System.out.println("Co quai");
                if (enemy instanceof EnemyFly) {
                    return (enemy);
                }
            }
        }
        return null;
    }

    @Override
    public void shoot() {
        //    super.shoot(); //To change body of generated methods, choose Tools | Templates.
        BulletManager bulletmanager = BulletManager.getInst();
        count_test++;
        if (count_test >= 30) {
            if (findTarget() == null) {
                return;
            }

            Bullet bullet = new Bullet5(this.x + 4, this.y);
            bullet.setTarget(findTarget());
            bulletmanager.addbullet(bullet);

            count_test = 0;
        }
    }
}
