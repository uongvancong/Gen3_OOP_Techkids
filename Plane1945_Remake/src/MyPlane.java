import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class MyPlane extends PlaneAbstract {
    private int direction;
    private int planeType;
    Vector<Bullet> bulletVector = new Vector<>();


    public MyPlane(int positionX, int positionY, int speed, int planeType) {
        super(positionX, positionY, speed);
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

    @Override
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
//        int xMax = 1300 - this.sprite.getWidth();
//        int yMax = 700 - this.sprite.getHeight();
//        if(this.positionX <= 0 ) this.positionX = 0;
//        if(this.positionX >= xMax) this.positionX = xMax;
//        if(this.positionY <= 0 ) this.positionY = 0;
//        if(this.positionY >= yMax) this.positionY = yMax;
//


    }

    @Override
    public void update() {
        this.move();
        int xMax = 1300 - this.sprite.getWidth();
        int yMax = 700 - this.sprite.getHeight();
        if (this.positionX <= 0) this.positionX = 0;
        if (this.positionX >= xMax) this.positionX = xMax;
        if (this.positionY <= 0) this.positionY = 0;
        if (this.positionY >= yMax) this.positionY = yMax;


        bulletVector.forEach(Bullet::update);
    }

    @Override
    public void shot() {
        //bullet.positionX = plane.positionX.getWidth/2 - bullet.getWidth/2
        Bullet bullet = new Bullet(this.positionX + this.sprite.getWidth()/2 - 6 , this.positionY, 6, 1);
        Bullet bullet1 = new Bullet(this.positionX + this.sprite.getWidth()/2 - 6 , this.positionY, 2, 5);
        Bullet bullet2 = new Bullet(this.positionX + this.sprite.getWidth()/2 - 6 , this.positionY, 2, 6);

        bulletVector.add(bullet);
        bulletVector.add(bullet1);
        bulletVector.add(bullet2);
    }

    protected void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;
//        int xMax = 1300 - this.sprite.getWidth();
//        int yMax = 700 - this.sprite.getHeight();
//        if(this.positionX <= 0 ) this.positionX = 0;
//        if(this.positionX >= xMax) this.positionX = xMax;
//        if(this.positionY <= 0 ) this.positionY = 0;
//        if(this.positionY >= yMax) this.positionY = yMax;
//

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getPlaneType() {
        return planeType;
    }

    public void setPlaneType(int planeType) {
        this.planeType = planeType;
    }
}
