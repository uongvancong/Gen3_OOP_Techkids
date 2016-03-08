import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by DuongPTIT14 on 3/6/2016.
 */
public class Peng extends Bird {
    public Peng() {
        super();
        this.name = "Penguins";
        this.color = "Red";
        this.weight = 18;
        try {
            this.sprite = ImageIO.read( new File("Resources/Peng.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sound() {
        System.out.println("Bạch bạch");
    }

    @Override
    public void move() {
        System.out.println("Walking");
    }
}
