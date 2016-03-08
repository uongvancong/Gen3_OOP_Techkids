import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class MyPlane extends PlaneAbstract {
    private int direction;
    private int planeType;
    Vector<Bullet> bulletVector = new Vector<>();

    public MyPlane(int x, int y, int speed, int planeType) {
        super(x, y, speed);

        this.direction = 0;

        this.planeType = planeType;
        switch (this.planeType) {
            case 1: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 4: {
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }

        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
        for (Bullet i : bulletVector) {
            i.draw(g);
        }
    }

    @Override
    protected void move() {
        switch (this.direction) {
            case 0:
                break;
            case 1:
                this.positionY -= this.speed;
                break;
            case 2:
                this.positionY += this.speed;
                break;
            case 3:
                this.positionX -= this.speed;
                break;
            case 4:
                this.positionX += this.speed;
                break;
        }
    }


    @Override
    public void update() {
        this.move();
        for (Bullet i : bulletVector) {
            i.update();
        }
    }
//    https://github.com/chtnnnmtgkyp/ManhTri.git

    @Override
    public void shot() {
        Bullet bullet = new Bullet(this.positionX + 30, this.positionY, 5, 1);

        bulletVector.add(bullet);
    }

    protected void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

}
