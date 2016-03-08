import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class Dolphin extends Fish {
    public Dolphin() {
        super();
        this.name = "Dolphin";
        this.color = "Black and White";
        this.weight = 60;
        try {
            this.sprite = ImageIO.read( new File("Resources/Dolphin.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sound() {
        System.out.println("Hí Hí Hí");
    }

    @Override
    public void move() {
        System.out.println("Swimming");
    }
}
