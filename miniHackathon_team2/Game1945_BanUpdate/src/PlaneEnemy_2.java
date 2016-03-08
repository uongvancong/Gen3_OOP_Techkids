import java.awt.*;
import java.util.Vector;

/**
 * Created by VinhNguyenDinh on 03/06/2016.
 */
public class PlaneEnemy_2 extends PlaneEnemyAbstract {
    private int count = 0;
    Vector<Bullet> vectorBullet = new Vector<>();


    public PlaneEnemy_2(int x, int y, int speed, int planeType) {
        super(x, y, speed, planeType);
    }

    public void move() {
        super.move();
    }

    public void shot() {
        Bullet bullet = new Bullet(x + 30, y, 2, 2);
        vectorBullet.add(bullet);
        bullet = new Bullet(x + 30, y + 40, 2, 2);
        vectorBullet.add(bullet);
    }
    public void update() {
        count++;
        if(count >= 120){
            this.shot();
            count = 0;
        }
        for(Bullet bul : vectorBullet) {
            bul.update();
        }
        this.move();
    }
    public void draw(Graphics g) {
        super.draw(g);
        for(Bullet bullet : vectorBullet) {
            bullet.draw(g);
        }
    }
}
