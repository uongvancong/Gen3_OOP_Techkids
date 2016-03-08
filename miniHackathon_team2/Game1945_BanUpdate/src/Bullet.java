import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public class Bullet extends GameObject {
    private int typeBullet;

    Bullet(int x, int y, int speed, int typeBullet) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.typeBullet = typeBullet;
        if(typeBullet == 1) {
            try {
                sprite = ImageIO.read(new File("Resources/DAN.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                sprite = ImageIO.read(new File("Resources/DAN_DICH.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        switch (typeBullet) {
            case 1:
                y -= speed;
                break;
            case 2:
                y += speed;
                break;
            case 3:
                x += speed;
                y += speed;
                break;
            case 4:
                x -= speed;
                y += speed;
                break;
        }
    }

    public void update() {
        this.move();
    }

    public int getTypeBullet() {
        return typeBullet;
    }

    public void setTypeBullet(int typeBullet) {
        this.typeBullet = typeBullet;
    }
}
