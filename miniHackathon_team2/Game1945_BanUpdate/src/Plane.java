import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public abstract class Plane extends PlaneAbstract {
    protected int direction;
    Vector<Bullet> vectorBullet = new Vector<>();

    public Plane(int x, int y, int speed, int planeType) {
        super(x, y, speed, planeType);
        switch (planeType) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    public void update() {
        for(Bullet bullet : vectorBullet) {
            bullet.update();
        }
    }

    public void shot(int speed, int bulletType) {
        Bullet bullet = new Bullet(x + 30, y, speed, bulletType);
        vectorBullet.add(bullet);
    }

    public void draw(Graphics g) {
        super.draw(g);
        for(Bullet bullet : vectorBullet) {
            bullet.draw(g);
        }
    }


    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
