import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class Bird extends GameObject {
    private int speed;
    private int direction; //0 <= direction << 7;
    public Bird() {
        this.x = 100; this.y = 150;
        speed = 40; this.direction = -1;
        try {
            this.sprite = ImageIO.read( new File("Resources/bird.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int count = 0;
    public void move() {
            Random rd = new Random();
            int x = rd.nextInt(8);
            this.direction = x;
            switch (this.direction) {
                case 0:
                    this.y -= this.speed;
                    break;
                case 1:
                    this.y -= this.speed;
                    this.x += this.speed;
                    break;
                case 2:
                    this.x += this.speed;
                    break;
                case 3:
                    this.y += this.speed;
                    this.x += this.speed;
                    break;
                case 4:
                    this.y += this.speed;
                    break;
                case 5:
                    this.y += this.speed;
                    this.x -= this.speed;
                    break;
                case 6:
                    this.x -= this.speed;
                    break;
                case 7:
                    this.x -= this.speed;
                    this.y -= this.speed;
                    break;
            }
            if (this.x < 0) this.x = 0;
            if (this.y < 0) this.y = 0;
            if (this.x >= 320) this.x = 320;
            if (this.y >= 570) this.y = 570;
    }
    public void update() {
        count++;
        if( count >= 30 ) {
            this.move();
            count = 0;
        }
    }
    public void draw(Graphics g) {
        super.draw(g);
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
