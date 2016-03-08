import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class Shark extends Fish {
    public Shark() {
        this.name = "Shark";
        this.color = "White";
        this.weight = 200;
        try {
            this.sprite = ImageIO.read(new File("Resources/Shark.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void sound() {
        System.out.println("ahihi");
    }

    @Override
    public void move() {
        System.out.println("Boi");
    }
}
