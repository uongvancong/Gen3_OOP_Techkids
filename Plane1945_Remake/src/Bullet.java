import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Bullet extends GameObject {
    private int bulletType;

    public Bullet(int positionX, int positionY, int speed, int bulletType) {
        super(positionX, positionY, speed);
        this.bulletType = bulletType;
        switch (this.bulletType) {
            case 1: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/DAN.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/DAN_ENEMY2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/DAN_ENEMY2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 4: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/DAN_ENEMY2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 5: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/DAN.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 6: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/DAN.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }


        }
    }

    private void move() {
        switch (this.bulletType) {
            //case 1 vs case 2 ban chat nhu nhau chi la speed - hay +
            //dan cua MyPlane : Ban Thang 1 dan
            case 1: {
                this.positionY -= this.speed;
                break;
            }
            // dan cua Enemy 1 dan ban thang
            case 2: {
                this.positionY += this.speed;
                break;
            }
            //dan cua Enemy ban 1 dan cheo sang phai
            case 3: {
                this.positionX += this.speed;
                this.positionY += this.speed;
                break;
            }
            //dan enemy 1 dan  ban cheo sang trai
            case 4: {
                this.positionX -= this.speed;
                this.positionY += this.speed;
                break;
            }
            //dan MyPlane 1 dan ban cheo sang phai
            case 5: {
                this.positionX += this.speed;
                this.positionY -= this.speed*3;
                break;
            }
            //dan MyPlane 1 dan ban cheo sang trai
            case 6: {
                this.positionX -= this.speed;
                this.positionY -= this.speed*3;
                break;
            }
            //dan enemy ban thang



        }
    }

    public void update() {
        this.move();
    }


    public int getBulletType() {
        return bulletType;
    }

    public void setBulletType(int bulletType) {
        this.bulletType = bulletType;
    }
}
