import javax.imageio.ImageIO;
import java.awt.*;
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

        }
    }


    public void draw(Graphics g) {
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }

    private void move() {
        switch (this.bulletType) {
            //dan cua MyPlane
            case 1: {
                this.positionY -= this.speed;
                break;
            }
            // dan cua enemy ban thang
            case 2: {
                this.positionY += this.speed;
                break;
            }
            //dan cua enemy ban cheo sang phai
            case 3: {
                this.positionX += this.speed;
                this.positionY += this.speed;
                break;
            }
            //dan enemy ban cheo sang trai
            case 4: {
                this.positionX -= this.speed;
                this.positionY += this.speed;
                break;
            }
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
