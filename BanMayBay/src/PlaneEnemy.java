import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class PlaneEnemy extends PlaneAbstract {
    private int planeEnemyType;
    private int count = 0;
    private Vector<Bullet> bulletVector = new Vector<>();


    public PlaneEnemy(int x, int y, int speed, int planeEnemyType) {
        super(x, y, speed);
        this.planeEnemyType = planeEnemyType;
        try {
            this.sprite = ImageIO.read(new File("Resources/ENEMY.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void move() {
        this.positionX += this.speed;
        if (this.positionX <= 0) {
            this.speed = -this.speed;
        }
        if (this.positionX >= 330) {
            this.speed = -this.speed;
        }

    }

    @Override
    public void update() {
        // 2s ban 1 phat
        count++;
        if (count >= 120) {
            this.shot();
            count = 0;
        }
        for (Bullet i : bulletVector) {
            i.update();
        }
        this.move();
    }

    @Override
    public void shot() {
        Bullet bullet = new Bullet(getPositionX() + 26, getPositionY() + 53, 1, 2);
        Bullet bullet2 = new Bullet(getPositionX() + 26, getPositionY() + 53, 1, 3);
        Bullet bullet3 = new Bullet(getPositionX() + 26, getPositionY() + 53, 1, 4);

        bulletVector.add(bullet);
        bulletVector.add(bullet2);
        bulletVector.add(bullet3);
    }

    public void shot2() {
        Bullet bullet = new Bullet((int) positionX + 10, (int) positionY + 59, 1, 2);
        Bullet bullet1 = new Bullet((int) positionX + 20, (int) positionY + 59, -1, 1);
        Bullet bullet2 = new Bullet((int) positionX + 30, (int) positionY + 59, -1, 2);
        bulletVector.add(bullet);
        bulletVector.add(bullet1);
        bulletVector.add(bullet2);
    }

    public void draw(Graphics g) {
        g.drawImage(this.sprite, this.getPositionX(), this.getPositionY(), null);
        for (Bullet i : bulletVector) {
            i.draw(g);
        }
    }
}
