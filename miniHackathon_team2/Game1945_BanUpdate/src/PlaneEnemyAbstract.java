import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by VinhNguyenDinh on 03/05/2016.
 */
public abstract class PlaneEnemyAbstract extends PlaneAbstract {

    public PlaneEnemyAbstract(int x, int y, int speed, int planeType) {
        super(x, y, speed, planeType);
        switch (planeType) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/DICH1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/DICH2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/DICH3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/DICH4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    public void move() {
        x += speed;
        if(x <= 0) {
            speed =- speed;
        }
        else if(x >= 330) {
            speed =- speed;
        }
    }
}
