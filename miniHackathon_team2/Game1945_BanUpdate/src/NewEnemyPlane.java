import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;


public class NewEnemyPlane {
    private int x;
    private int y;
    private BufferedImage sprite;
    Vector<Integer> Xa = new Vector<>();
    Vector<Integer> Xb = new Vector<>();





    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
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

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int i = 0;

    int count = 0;
    int check = 0;

    public void generateX() {
        double delta = 1;
        for (double i = 0; i < 1500; i += delta) {
            double y = 50 * Math.sin(i * (Math.PI / 180));
            Xa.add((int) i);
            Xb.add((int) y);
        }
    }

    public void move() {
        setX(Xa.get(i));
        setY(Xb.get(i));
        if (Xa.get(i) >= 344) {
            check = 1;
        }
        if (Xa.get(i) <= 0) {
            check = -1;
        }
        if (check == 1) i--;
        else if (check == -1 || check == 0) i++;
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, x, y + 100, null);
    }

    public void update() {
        count++;
        if (count >= 60) {
            count = 0;
            this.move();
        }

    }
}
