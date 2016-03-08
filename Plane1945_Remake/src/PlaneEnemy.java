import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class PlaneEnemy extends PlaneAbstract {
    private int planeEnemyType;
    private int timeStart ;
    private int shotType;
    private Vector<Bullet> bulletVector = new Vector<>();
    private int timeShot;
    private Vector<Integer> newPositionX = new Vector<>();
    private Vector<Integer> newPositionY = new Vector<>();

    //planeEnemyType 1 di ngang
    //planeEnemyType 2 di hinh sin
    // planeEnemyType 3 di chuyen hinh tron


    public PlaneEnemy(int positionX, int positionY, int speed, int planeEnemyType, int indexStart, int shotType, int timeShot,int timeStart) {
        super(positionX, positionY, speed);
        this.timeStart = timeStart;
        this.shotType = shotType;
        this.indexStart = indexStart;
        count = this.timeStart;
        this.planeEnemyType = planeEnemyType;
        try {
            this.sprite = ImageIO.read(new File("Resources/ENEMY.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.timeShot = timeShot;
    }



    public void generationCirle() {
        int  x;
        int y;
        int r = 100;
        for (float i = 0; i <= 360; i+=0.2) {
            x =100+ (int) (r * Math.sin(i));
            y = 100 + (int) (r*Math.cos(i));
            newPositionX.add(x);
            newPositionY.add(y);
        }
    }

    @Override
    protected void move() {
        switch (this.planeEnemyType) {
            case 1: {
                this.positionX += this.speed;
                if (this.positionX <= 0) {
                    this.speed = -this.speed;
                }
                if (this.positionX >= (1300 - this.sprite.getWidth())) {
                    this.speed = -this.speed;
                }
                break;
            }
            case 2: {
                generation();

                if (this.getPositionX() <= 0) {
                    check = true;
                }
                if (this.getPositionX() >= (1300 - this.sprite.getWidth())) {
                    check = false;
                }
                this.setPositionX(newPositionX.get(indexStart));
                this.setPositionY(newPositionY.get(indexStart));
                if (check) {
                    indexStart++;
                } else {
                    indexStart--;
                }
                break;
            }
            case 3: {
                rotation++;
                this.positionX +=  (int)(10 * Math.cos(rotation * 0.09));
                this.positionY +=  (int)(10 * Math.sin(rotation * 0.09));
                break;
            }
        }
    }

    private boolean check = true;
    // indexStart khoi tao gia tri dau tien cua enemy tuy thich
    private int indexStart = 0;


    private void generation() {
        int y;

        for (int x = 0; x <= (1500); x ++) {
            y = (int) (200 + 100 * Math.sin(4 * x * (Math.PI / 180)));
            newPositionX.add(x);
            newPositionY.add(y);
        }

    }

    private int count   ;
    @Override
    public void update() {

        // 2s ban 1 phat
        count++;
        if (count >= timeShot) {
            this.shot();
            count = 0;
        }
        bulletVector.forEach(Bullet::update);
        this.move();


    }
    private int rotation =0;

    @Override
    public void shot() {
        switch (this.shotType) {
            // ban 3 dan theo 3 huong
            case 1: {
                Bullet bullet = new Bullet(getPositionX() + 26, getPositionY() + 53, 1, 2);
                Bullet bullet2 = new Bullet(getPositionX() + 26, getPositionY() + 53, 1, 3);
                Bullet bullet3 = new Bullet(getPositionX() + 26, getPositionY() + 53, 1, 4);
                bulletVector.add(bullet);
                bulletVector.add(bullet2);
                bulletVector.add(bullet3);
                break;
            }
            // ban 2 dan lien tuc
            case 2: {
                Bullet bullet = new Bullet(getPositionX() + 26, getPositionY() + 53, 2, 2);
                Bullet bullet1 = new Bullet(getPositionX() + 26, getPositionY() + 53 + 30, 2, 2);
                bulletVector.add(bullet);
                bulletVector.add(bullet1);
                break;
            }
        }
    }


    public void draw(Graphics g) {
        g.drawImage(this.sprite, this.getPositionX(), this.getPositionY(), null);
        for (Bullet i : bulletVector) {
            i.draw(g);
        }
    }

    public int getPlaneEnemyType() {
        return planeEnemyType;
    }

    public void setPlaneEnemyType(int planeEnemyType) {
        this.planeEnemyType = planeEnemyType;
    }

    public int getIndexStart() {
        return indexStart;
    }

    public void setIndexStart(int indexStart) {
        this.indexStart = indexStart;
    }


}
