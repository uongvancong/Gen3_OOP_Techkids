import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int speed;
    BufferedImage sprite;

    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
