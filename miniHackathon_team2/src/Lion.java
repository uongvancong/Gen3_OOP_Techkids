import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class Lion extends Cat {
    public Lion() {
        super();
        this.name = "Lion";
        this.color = "Yellow";
        this.weight = 50;
        try {
            this.sprite = ImageIO.read( new File("Resources/Lion.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void sound() {
        System.out.println("Gầm Gầm");
    }


    @Override
    public void move() {
        System.out.println("Chạy");
    }
}
